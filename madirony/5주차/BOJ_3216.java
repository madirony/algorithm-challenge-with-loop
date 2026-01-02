/*
  link : https://www.acmicpc.net/problem/3216
  tier : S1
  type : greedy
*/
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long playSum = Long.parseLong(st.nextToken()), downSum = Long.parseLong(st.nextToken());
        long start = downSum;

        for(int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            downSum += v;
            start = Math.max(start, downSum-playSum);
            playSum += d;
        }
        System.out.println(start);
    }
}
