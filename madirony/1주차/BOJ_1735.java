import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int numerator = A*D + B*C;
        int denominator = B*D;

        int g = gcd(numerator, denominator);

        numerator /= g;
        denominator /= g;

        System.out.println(numerator + " " + denominator);
    }
}
