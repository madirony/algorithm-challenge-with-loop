/*
  link : https://www.acmicpc.net/problem/1021
  tier : S3
  type : deque
*/
import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) dq.addLast(i);

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = 0;
            for (int x : dq) {
                if (x == target) break;
                idx++;
            }

            int left = idx;
            int right = dq.size() - idx;

            if (left <= right) {
                for (int i = 0; i < left; i++) dq.addLast(dq.pollFirst());
                ans += left;
            } else {
                for (int i = 0; i < right; i++) dq.addFirst(dq.pollLast());
                ans += right;
            }

            dq.pollFirst();
        }

        System.out.println(ans);
    }
}
