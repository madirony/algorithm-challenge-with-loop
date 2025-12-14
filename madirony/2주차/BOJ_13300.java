import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] count = new int[2][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade  = Integer.parseInt(st.nextToken());
            count[gender][grade - 1]++;
        }

        int rooms = 0;
        for (int g = 0; g < 2; g++) {
            for (int y = 0; y < 6; y++) {
                if (count[g][y] > 0) {
                    rooms += (count[g][y] + K - 1) / K;
                }
            }
        }

        System.out.println(rooms);
    }
}
