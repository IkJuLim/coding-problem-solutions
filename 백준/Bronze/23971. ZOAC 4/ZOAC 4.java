import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int ret = h / (n + 1) + w / (m + 1);
        System.out.println(((h - 1) / (n + 1) + 1) * ((w - 1) / (m + 1) + 1));
    }
}