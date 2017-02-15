/**
 * Created by user on 12/22/16.
 */
public class Palindrome {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        // Write your code here
        String newstr = s.toLowerCase();
        for(int i = 0; i < newstr.length(); i++){
            if(newstr.charAt(i) > 122 || newstr.charAt(i) < 97){
                newstr.replaceAll(String.valueOf(newstr.charAt(i)),"");
            }
        }
        newstr.trim();
        System.out.print(newstr);
        // String exp = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        // Pattern p = Pattern.compile(exp);
        // Matcher m = p.mathcher(s);
        // String newStr = m.replaceAll("").trim();
        int j = s.length()-1;
        int i = 0;
        while( i < j ){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
