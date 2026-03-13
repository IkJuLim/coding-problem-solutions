import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tall = new int[9];
        for (int i = 0; i < 9; i++) {
            tall[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tall);
        for (int a = 0; a < 3; a++) {
            for (int b = a + 1; b < 4; b++) {
                for (int c = b + 1; c < 5; c++) {
                    for (int d = c + 1; d < 6; d++) {
                        for (int e = d + 1; e < 7; e++) {
                            for (int f = e + 1; f < 8; f++) {
                                for (int g = f + 1; g < 9; g++) {
                                    if (tall[a] + tall[b] + tall[c] + tall[d] + tall[e] + tall[f] + tall[g] == 100) {
                                        System.out.println(tall[a] + "\n" + tall[b] + "\n" + tall[c] + "\n" + tall[d] + "\n" + tall[e] + "\n" + tall[f] + "\n" + tall[g]);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}