/*
  link : https://www.acmicpc.net/problem/2578
  tier : S4
  type : simulation
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];
        boolean[][] marked = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] call = new int[25];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) call[i * 5 + j] = Integer.parseInt(st.nextToken());
        }

        int countCall = 0;
        for (int num : call) {
            countCall++;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == num) marked[i][j] = true;
                }
            }
            if (isBingo(marked) >= 3) {
                System.out.println(countCall);
                break;
            }
        }
    }

    static int isBingo(boolean[][] m) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean ok = true;
            for (int j = 0; j < 5; j++) {
                if (!m[i][j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) cnt++;
        }
        for (int j = 0; j < 5; j++) {
            boolean ok = true;
            for (int i = 0; i < 5; i++) {
                if (!m[i][j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) cnt++;
        }
        boolean ok = true;
        for (int i = 0; i < 5; i++) {
            if (!m[i][i]) {
                ok = false;
                break;
            }
        }
        if (ok) cnt++;
        ok = true;
        for (int i = 0; i < 5; i++) {
            if (!m[i][4 - i]) {
                ok = false;
                break;
            }
        }
        if (ok) cnt++;
        return cnt;
    }
}
