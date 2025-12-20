import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[][] map;
    static int ansR, ansC;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        fill();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
                if (j + 1 < N) sb.append(' ');
            }
            sb.append('\n');
        }
        sb.append(ansR).append(' ').append(ansC);
        System.out.print(sb.toString());
    }

    static void fill() {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int r = N / 2;
        int c = N / 2;

        int val = 1;
        map[r][c] = val;
        if (val == K) {
            ansR = r + 1;
            ansC = c + 1;
        }

        int dir = 0;
        int len = 1;
        int limit = N * N;

        while (val < limit) {
            for (int t = 0; t < 2; t++) {
                for (int s = 0; s < len; s++) {
                    r += dr[dir];
                    c += dc[dir];
                    val++;
                    map[r][c] = val;

                    if (val == K) {
                        ansR = r + 1;
                        ansC = c + 1;
                    }
                    if (val == limit) return;
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }
    }
}
