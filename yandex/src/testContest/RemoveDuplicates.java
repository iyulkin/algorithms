package testContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(r.readLine());
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(r.readLine());
            if(result.size() == 0 || result.get(result.size() - 1) < num) {
                result.add(num);
            }
        }

        for(int i : result) {
            w.write(String.valueOf(i));
            w.newLine();
        }

        r.close();
        w.close();
    }
}
