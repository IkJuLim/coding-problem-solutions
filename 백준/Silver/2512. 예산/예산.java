import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        list.sort((a, b) -> a - b);

        int m = in.nextInt();

        int idx = 0, sum = 0, curr = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (list.get(i) - curr) * (list.size() - i);
            curr = list.get(i);
            if(sum > m) {
                while (sum > m) {
                    sum -= (list.size() - i);
                    curr--;
                }
                break;
            }
        }
        System.out.println(curr);
    }
}