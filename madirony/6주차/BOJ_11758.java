/*
  link : https://www.acmicpc.net/problem/11758
  tier : G5
  type : geometry
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken()), y3 = Integer.parseInt(st.nextToken());
        int val = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        System.out.println(val > 0 ? 1 : val < 0 ? -1 : 0);
    }
}
