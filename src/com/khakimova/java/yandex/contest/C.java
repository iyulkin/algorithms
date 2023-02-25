package com.khakimova.java.yandex.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
Планировщик 100 баллов

Имеется m исполнителей, пронумерованных числами от 1 до m, и k очередей задач, пронумерованных числами от 1 до k.
Изначально очереди пусты. Системе предстоит выполнить n задач: i-я задача встанет в очередь с номером q(i) на s(i)-й секунде и потребует t(i) секунд на выполнение.

Каждую секунду происходит следующее:

- В конец некоторых очередей могут добавиться новые задачи (но не более одной задачи в каждую очередь)
- Пока это возможно, выбирается незанятый исполнитель с наименьшим номером и непустая очередь, из которой дольше всего не забирались задачи.
  Если таких очередей несколько, то выбирается очередь с наименьшим номером. Исполнитель забирает задачу из очереди и становится занятым на время ее выполнения.

Для каждой задачи определите, когда и какой исполнитель начнет ее выполнять.

//////////////////////////////
Ввод:
5 1 2
1 1 5
1 2 3
2 2 1
3 1 2
4 1 3

Вывод:
1 1
1 6
1 11
1 9
1 12

//////////////////////////////
Ввод:
5 2 2
1 1 5
1 2 3
2 2 1
3 1 2
4 1 3

Вывод:
1 1
2 1
1 6
2 4
2 6

//////////////////////////////
Ввод:
5 2 2
1 1 1
1 2 5
2 2 1
5 1 3
6 1 3

Вывод:
1 1
2 1
1 2
1 5
2 6

 */
public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmk = reader.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);
        int[][] sqt = new int[n][3];

        for(int i = 0; i < n; i++) {
            String[] str = reader.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                sqt[i][j] = Integer.parseInt(str[j]);
            }
        }

        int[][] result = calculate(m, k, sqt);
        for(int i = 0; i < n; i++) {
            writer.write(result[0] + " " + result[1]);
        }

        reader.close();
        writer.close();
    }

    private static int[][] calculate(int m, int k, int[][] sqt) {
        return new int[0][];
    }
}
