/*
  link : https://www.acmicpc.net/problem/9417
  tier : S4
  type : math
*/
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = st.countTokens();
            long[] a = new long[m];

            for (int i = 0; i < m; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            long ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    long g = gcd(abs(a[i]), abs(a[j]));
                    if (g > ans) ans = g;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static long abs(long x) { return x < 0 ? -x : x; }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
