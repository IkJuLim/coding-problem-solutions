import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = -1, b = -1, c = -1;
        while (true) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            if (a == 0 && b == 0 && c == 0) break;
            else if (a >= b + c || b >= a + c || c >= a + b) System.out.println("Invalid");
            else if (a == b && b == c) System.out.println("Equilateral");
            else if (a == b || b == c || a == c) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}