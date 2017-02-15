import java.util.Scanner;

/**
 * Created by user on 11/15/16.
 */
public class FlipBits {
    //shortcut: psvm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while(true){
//            int a = Integer.parseInt(scanner.nextLine());
//            // int b = Integer.parseInt(scanner.nextLine());
//            double ans =  Math.log(a)/ Math.log(2);
//            //int ans = a >>1;
//            if( Math.pow(2, ans) == a){
//                System.out.print("this is result is yes");
//            }
//        }
        int a = Integer.parseInt(scanner.nextLine());
        int shift= Integer.parseInt(scanner.nextLine());
        int b = a<<(32-shift);//>>(33-shift);
        System.out.println("this is b:"+b);

    }
}
