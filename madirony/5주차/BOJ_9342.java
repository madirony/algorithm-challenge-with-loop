/*
  link : https://www.acmicpc.net/problem/9342
  tier : S3
  type : regex
*/
import java.io.*;

class Main {
    static final String REG = "^[A-F]?A+F+C+[A-F]?$";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            sb.append(s.matches(REG) ? "Infected!" : "Good").append('\n');
        }

        System.out.print(sb);
    }
}
