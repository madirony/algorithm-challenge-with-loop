/*
  link : https://www.acmicpc.net/problem/5567
  tier : S2
  type : graph/bfs
*/
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());

        boolean[] friends = new boolean[n+1]; friends[1] = true;
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b); list.get(b).add(a);
            if(a == 1) friends[b] = true;
        }

        int answer = 0;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            for(Integer i : list.get(node)) {
                if(!visited[i]) {
                    visited[i] = true;
                    if(friends[node]) {
                        answer++;
                        q.add(i);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
