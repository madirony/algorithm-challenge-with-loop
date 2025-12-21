import java.io.*;
import java.util.*;

class Main {
    static int W, H, N;
    static List<Integer> verticalCuts = new ArrayList<>();
    static List<Integer> horizontalCuts = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        verticalCuts.add(0);
        verticalCuts.add(W);
        horizontalCuts.add(0);
        horizontalCuts.add(H);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (dir == 0) horizontalCuts.add(pos);
            else verticalCuts.add(pos);
        }

        Collections.sort(verticalCuts);
        Collections.sort(horizontalCuts);

        int maxW = getMaxGap(verticalCuts);
        int maxH = getMaxGap(horizontalCuts);

        System.out.println(maxW * maxH);
    }

    static int getMaxGap(List<Integer> cuts) {
        int max = 0;
        for (int i = 1; i < cuts.size(); i++) {
            int gap = cuts.get(i) - cuts.get(i - 1);
            if (gap > max) max = gap;
        }
        return max;
    }
}
