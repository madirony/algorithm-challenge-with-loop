import java.util.*;
import java.io.*;
/*
  link : https://www.acmicpc.net/problem/1476
  tier : S5
  type : math/brute-force/number-theory
*/

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 7980; i++) {
            if ((i - e) % 15 == 0 && (i - s) % 28 == 0 && (i - m) % 19 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
