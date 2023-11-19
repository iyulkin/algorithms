package testContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Brackets {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(r.readLine());
        StringBuilder builder = new StringBuilder("(");
        generate(w, builder, n - 1, n);

        r.close();
        w.close();
    }

    private static void generate(BufferedWriter w, StringBuilder builder, int openBr, int closeBr) throws Exception {
        if(openBr > closeBr) return;
        if(openBr == 0 && closeBr == 0) {
            w.write(builder.toString());
            w.newLine();
        }
        if(openBr > 0) {
            generate(w, builder.append("("), openBr - 1, closeBr);
            builder.deleteCharAt(builder.length() - 1);
        }
        if(closeBr > 0) {
            generate(w, builder.append(")"), openBr, closeBr - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
