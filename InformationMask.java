/**
 * Created by user on 12/18/16.
 */
public class InformationMask {
    public static void main(String[] args) {
        String[] test_email = {"satileW@gmail.com","nicol213@gmail.com"};
        String[] test_phoneNumber = {"+13334445678","+111(333)444-5678","333 444 5678","(333)444-5678","+1(333)444-5678","+91(333)444-5678"};
        for (String str: test_email
             ) {
            System.out.println( process_email(str) );

        }
        for ( String str : test_phoneNumber
             ) {
            System.out.println( process_phoneNum(str) );
        }
    }
    static  String process_phoneNum(String phoneNum){
        StringBuilder sb = new StringBuilder();

        for(int i = phoneNum.length()-1, j = 0; i >= 0; i--, j ++){
            if(sb.length() < 4){
                sb.append(phoneNum.charAt(i));
            }else{
                if(j == 4 || j == 8 || j == 12){
                    if(phoneNum.charAt(i) >= 48 && phoneNum.charAt(i) <= 57){
                        sb.append('-');
                        j++;//solve +13334445678
                        sb.append('*');

                    }else if (phoneNum.charAt(i) == '('||phoneNum.charAt(i) == ')'||phoneNum.charAt(i) == '-'||phoneNum.charAt(i) == ' '){
                        if(i != 0){
                            sb.append('-');
                        }
                    }
                }else {
                    if(phoneNum.charAt(i) >= 48 && phoneNum.charAt(i) <= 57){
                        sb.append('*');
                    }else {
                        sb.append(phoneNum.charAt(i));
                    }
                }

//                if(phoneNum.charAt(i) >= 48 && phoneNum.charAt(i) <= 57){
//                    sb.append('*');
//                }

//                else if (phoneNum.charAt(i) ==')'){
//                    sb.append('-');
//                }
//                else if (phoneNum.charAt(i) =='('){
//                    if(i != 0){
//                        sb.append('-');
//                    }
//                }
//                else if (phoneNum.charAt(i) == ' '){
//                    sb.append('-');
//                }
//                else{
//                    sb.append(phoneNum.charAt(i));
 //               }
            }
        }
        return  sb.reverse().toString();
    }
    static  String process_email(String email){
        char first = email.charAt(0);
        StringBuilder sb = new StringBuilder(email);
        int idx = sb.indexOf("@");
        int length = 7 + email.length()-idx;
        char[] ans = new char[length];
        ans[0] = first;
        for (int i = 1; i <= 5; i++) {
            ans[i] = '*';
        }
        sb.getChars(idx-1, sb.length(), ans,6);

        String str = new String(ans);
        return str;
    }
}
