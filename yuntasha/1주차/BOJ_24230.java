package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
음음...
루트에서 출발해서 색이 몇번 바뀌는지 dfs하면 될듯?
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] colors = new int[N + 1];
        StringTokenizer input = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            colors[i] = Integer.parseInt(input.nextToken());
        }

        List<List<Integer>> connects = new ArrayList<>();
        for (int i = 0; i <= N; i++) connects.add(new ArrayList<>());

        for (int i = 1; i < N; i++) {
            input = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(input.nextToken());
            int b = Integer.parseInt(input.nextToken());
            connects.get(a).add(b);
            connects.get(b).add(a);
        }

        System.out.println(solution(N, colors, connects));
    }

    private static int solution(int N, int[] colors, List<List<Integer>> connects) {
        return find(1, 0, new boolean[N + 1], colors, connects);
    }

    private static int find(int n, int prevColor, boolean[] visited, int[] colors,  List<List<Integer>> connects) {
        visited[n] = true;
        int result = 0;

        if (colors[n] != prevColor) result++;

        for (int next : connects.get(n)) {
            if (visited[next]) continue;
            result += find(next, colors[n],  visited, colors, connects);
        }

        return result;
    }

}