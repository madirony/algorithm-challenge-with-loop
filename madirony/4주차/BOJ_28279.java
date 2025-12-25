/*
  link : https://www.acmicpc.net/problem/28279
  tier : S4
  type : deque
*/
import java.util.*;
import java.io.*;

class Main {
    static int N;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                dq.addFirst(x);
            } else if (cmd == 2) {
                int x = Integer.parseInt(st.nextToken());
                dq.addLast(x);
            } else if (cmd == 3) {
                sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
            } else if (cmd == 4) {
                sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
            } else if (cmd == 5) {
                sb.append(dq.size()).append('\n');
            } else if (cmd == 6) {
                sb.append(dq.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd == 7) {
                sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
            } else { // cmd == 8
                sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
