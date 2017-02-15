import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 12/18/16.
 */
public class DecodeTweet {
    public static void main(String[] args) {
        String encrypted_msg = "Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
        String hook = "-Your friend, Alice";

        int elength = encrypted_msg.length();
        int hlength = hook.length();
        String hook_msg = encrypted_msg.substring(elength-hlength, elength);
        String before_hook = encrypted_msg.substring(0, elength-hlength);
        System.out.println(hook_msg);
        System.out.println(before_hook);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < before_hook.length() ; i++) {
            int check = before_hook.charAt(i);
            if(  (check <= 90 && check >= 65) || (check >= 97 && check <= 122) ){
                sb.append(before_hook.charAt(i));
            }
        }
        System.out.println(sb);
        int length_before_hook = sb.length();
        System.out.println(length_before_hook);

        ArrayList<Integer> key_test = new ArrayList<>();

        //punctuation mask is not encode, so skip the '-'
        for (int i = 0; i < hlength; i++) {
            int check = hook_msg.charAt(i);
            if( (check <= 90 && check >= 65) || (check >= 97 && check <= 122) ){
                int diff = hook_msg.charAt(i) - hook.charAt(i);
                if( diff < 0 ){
                    diff += 26;
                }
                key_test.add( diff );
            }

        }
        System.out.println(key_test.toString());
        HashMap<Integer,ArrayList<Integer>> ststc = new HashMap<>();
        for (int i = 0, j = i+1; i < key_test.size(); i++, j++) {
            ArrayList<Integer> pos_list;
            if(ststc.containsKey(key_test.get(i)) ){
                pos_list = ststc.get( key_test.get(i) );
                pos_list.add(i);
                ststc.put(key_test.get(i), pos_list);
            }else{
                pos_list = new ArrayList<>();
                pos_list.add(i);
                ststc.put(key_test.get(i), pos_list);
            }
        }
        int keySize = 0;
        for (Integer integer : ststc.keySet()) {
            // here find the smallest size of position array and calculate gap
            //need fix
            if(keySize == 0 && ststc.get(integer).size()==2){
                keySize = ststc.get(integer).get(1) - ststc.get(integer).get(0);
            }
        }
        System.out.println(keySize);
        int pos_over = length_before_hook % keySize;
        int pos_start = keySize - pos_over;
        int[] key = new int[keySize];
        ArrayList<Character> ans = new ArrayList<>();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < keySize; i++) {
            key[i] = key_test.get(pos_start + i);
            System.out.print(key[i]);
        }
        for (int i = 0, j = 0; i < encrypted_msg.length() ; i++) {
            char org = encrypted_msg.charAt(i);
            int key_pos = j % keySize;
            if( org <= 90 && org >= 65 ){
                int ecd = org - key[key_pos];
                if( ecd < 65)
                    ecd += 26;
                ans.add((char)ecd);
                stb.append((char)ecd);
                j++;
            }
            else if( org <= 122 && org >= 97){
                int encode = org - key[key_pos];
                if( encode < 97 )
                    encode += 26;
                ans.add((char)encode);
                stb.append((char)encode);
                j++;
            }else{
                ans.add(org);
                stb.append(org);
            }
        }
        System.out.println(ans.toString());
        System.out.print(stb.toString());
    }
}
