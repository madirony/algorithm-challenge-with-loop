import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n, k;
    static String[] cards;
    static boolean[] visited;
    static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        cards = new String[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }
        
        dfs(0, "");
        
        System.out.println(result.size());
    }

    static void dfs(int depth, String currentStr) {
        if (depth == k) {
            result.add(currentStr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, currentStr + cards[i]);
                visited[i] = false;
            }
        }
    }
}
