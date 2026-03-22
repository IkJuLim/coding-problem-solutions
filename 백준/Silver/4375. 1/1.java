import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int target = sc.nextInt();
            func(target);
        }
    }
    public static void func(int target){
        if(target == 1) {
            System.out.println(1);
            return;
        }
        int num = 1;
        for(int i = 2; true; i++){
            num = (num * 10 + 1) % target;
            if (num % target == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}