/*
  link : https://www.acmicpc.net/problem/20291
  tier : S5
  type : map
*/
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> extensions = new TreeMap<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String name = st.nextToken(), extension = st.nextToken();
            if(extensions.getOrDefault(extension, 0) == 0) extensions.put(extension, 1);
            else extensions.put(extension, extensions.get(extension)+1);
        }

        for(String key : extensions.keySet()) {
            System.out.println(key + " " + extensions.get(key));
        }
    }
}
