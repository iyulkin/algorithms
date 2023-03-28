package com.khakimova.java.yandex.contest.a47007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] quarters = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};

        double[] result = new double[4];

        int n = Integer.parseInt(reader.readLine());
        int[] sums = new int[n];
        int[][] days = new int[n][4]; // в каждой строке: количество дней по кварталам

        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            sums[i] = Integer.parseInt(s[0]);
            int dayFrom = Integer.parseInt(s[1].substring(0, 2));
            int monthFrom = Integer.parseInt(s[1].substring(3));
            int dayTo = Integer.parseInt(s[2].substring(0, 2));
            int monthTo = Integer.parseInt(s[2].substring(3));

            if (monthFrom == monthTo) {
                days[i][quarters[monthFrom - 1]] += dayTo - dayFrom + 1;
            } else {
                days[i][quarters[monthFrom - 1]] += months[monthFrom - 1] - dayFrom + 1;
                monthFrom++;
                while (monthFrom < monthTo) {
                    days[i][quarters[monthFrom - 1]] += months[monthFrom - 1];
                    monthFrom++;
                }
                days[i][quarters[monthFrom - 1]] += dayTo;
            }
        }
        for(int i = 0; i < n; i++) {
            int perDay = 100 * sums[i] / (days[i][0] + days[i][1] + days[i][2] + days[i][3]);
            for(int j = 0; j < 4; j++) {
                if(days[i][j] > 0) {
                    result[j] += days[i][j] * perDay;
                }
            }
        }

        for(double d : result) {
            writer.write(String.format("%.2f", 1.0 * d / 100));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

//    private static double format(double d) {
//        return BigDecimal.valueOf(d).setScale(2, RoundingMode.DOWN).doubleValue();
//    }
}
