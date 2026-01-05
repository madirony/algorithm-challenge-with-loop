import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long cnt = 0;
        String bestName = "";
        long best = -1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            long k = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long candy = m;
            long tmp = 0;

            if (candy >= k) tmp = (candy - k) / (k - 2) + 1;
            cnt += tmp;
            if (tmp > best) {
                best = tmp; bestName = str;
            }
        }

        System.out.println(cnt);
        System.out.println(bestName);
    }
}
