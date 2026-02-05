import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] channels = new String[n];
        int ch1 = -1, ch2 = -1;
        for (int i = 0; i < n; i++) {
            channels[i] = scanner.nextLine();
            if (channels[i].equals("KBS1")) {
                ch1 = i;
            } else if (channels[i].equals("KBS2")) {
                ch2 = i;
            }
        }

        if (ch1 > ch2) {
            ch2++;
        }

        for (int i = 0; i < ch1; i++) {
            System.out.print('1');
        }
        for (int i = 0; i < ch1; i++) {
            System.out.print('4');
        }
        for (int i = 0; i < ch2; i++) {
            System.out.print('1');
        }
        for (int i = 0; i < ch2 - 1; i++) {
            System.out.print('4');
        }

        System.out.println();
    }
}