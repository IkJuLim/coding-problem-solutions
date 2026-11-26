import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    static char[][] board;
    static Set<Character> set = new HashSet<>();
    static int r, c;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String chars = br.readLine();
            for (int j = 0; j < chars.length(); j++) {
                board[i][j] = chars.charAt(j);
            }
        }

        bw.write(String.valueOf(dfs(0, 0)));

        bw.flush();
        bw.close();
        br.close();
        return;
    }

    private static int dfs(int posx, int posy) {
        if (posx < 0 || posx >= r || posy < 0 || posy >= c) return 0;
        if (set.contains(board[posx][posy])) return 0;

        set.add(board[posx][posy]);
        int ret = Math.max(
                Math.max(dfs(posx, posy + 1), dfs(posx + 1, posy)),
                Math.max(dfs(posx, posy - 1), dfs(posx - 1, posy))
        ) + 1;

        set.remove(board[posx][posy]);

        return ret;
    }
}