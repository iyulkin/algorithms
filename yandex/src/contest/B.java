package contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
Лента фотографий 50 баллов

Для разработки модуля отображения фотографий в виде вертикальной ленты решено использовать следующий алгоритм:

- выбрать k фотографий из имеющейся коллекции;
- отмасштабировать все фотографии до ширины w;
- отображать полученные фотографии в вертикальном формате одна над одной без отступов.

Определите, какую наибольшую и наименьшую высоту может иметь полученная лента из k фотографий.

Будем считать, что при масштабировании фотографии размера w' x ℎ' до ширины w, новая высота вычисляется по следующей формуле:
ℎ = Потолок(h' * w / w')
 */
public class B {

    // падает 1 тест в Яндекс.Контест

    @Test
    public void test() {
        assertThat(calculate(new int[][]{
                {1000, 1000},
                {1000, 1500},
                {640, 930},
                {640, 1500},
                {3000, 1000},
        },2000, 3), is(new int[]{5574, 10595}));

        assertThat(calculate(new int[][]{
                {1404, 1386},
                {1132, 1110},
                {1061, 1801},
                {1022, 1519},
                {1529, 1003},
        }, 1000, 5), is(new int[]{5810, 5810}));

        assertThat(calculate(new int[][]{
                {640, 4096},
                {4096, 640}
        }, 4096, 1), is(new int[]{640, 26215}));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int w = Integer.parseInt(reader.readLine());
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] dimensions = new int[n][2];

        for(int i = 0; i < n; i++) {
            String[] dim = reader.readLine().split("x");
            dimensions[i][0] = Integer.parseInt(dim[0]);
            dimensions[i][1] = Integer.parseInt(dim[1]);
        }

        int[] minMax = calculate(dimensions, w, k);
        writer.write(String.valueOf(minMax[0]));
        writer.newLine();
        writer.write(String.valueOf(minMax[1]));

        reader.close();
        writer.close();
    }

    private static int[] calculate(int[][] dimensions, int w, int k) {
        int n = dimensions.length;
        int[] hArray = new int[n];

        for(int i = 0; i < n; i++) {
            hArray[i] = (int) Math.ceil(1.0 * dimensions[i][1] * w / dimensions[i][0]);
        }

        Arrays.sort(hArray);
        int[] result = new int[2];

        for(int i = 0; i < k; i++) {
            result[0] += hArray[i];
            result[1] += hArray[n - 1 - i];
        }

        return result;
    }
}
