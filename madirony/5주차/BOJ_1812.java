/*
  link : https://www.acmicpc.net/problem/1812
  tier : S4
  type : math
*/
import java.util.*;
import java.io.*;

class Main {
    static int N;
    static long[] S;
    static long[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new long[N + 1];
        A = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            S[i] = Long.parseLong(br.readLine());
        }

        long alt = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1) alt += S[i];
            else alt -= S[i];
        }

        A[1] = alt / 2;

        for (int i = 2; i <= N; i++) {
            A[i] = S[i - 1] - A[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append('\n');
        }
        System.out.print(sb);
    }
}
