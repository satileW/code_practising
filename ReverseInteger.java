/**
 * Created by user on 12/21/16.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger(10));
        long nl = 961534236 * 10;
        System.out.println((int) nl);
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
    }
    public static String reverseInteger(int n) {
        boolean nagtive = false;
        System.out.println(-n);
        n = -n;
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            int carry = n % 10;
            sb.append(carry);
            n /= 10;
        }
        return sb.reverse().toString();
    }
}
