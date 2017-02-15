import java.util.ArrayList;

/**
 * Created by user on 12/21/16.
 */


public class GeneticMutation {
    public static void main(String[] args) {
        String s = "AACCGGTT";
        String e = "AAACGGTA";
        String[] bank = {"AACCGATT", "AACCGATA", "AAACGGTA"};

        System.out.print(minMutation(s, e, bank));
    }
    public static int minMutation(String start, String end, String[] bank) {
        int diffStartEnd = calculateDiff(start, end);
        if(diffStartEnd == 0){
            return 0;
        }
        //System.out.println(diffStartEnd);
        if( diffStartEnd > bank.length ){
            return -1;
        }
        if(diffStartEnd == 1){
            for(int i = 0; i < bank.length; i++){
                //use equals more than == ,this is really =_=!
                if(bank[i].equals(end)){
                    //System.out.println("!!!!!");
                    return 1;
                }
            }
            return -1;
        }
        ArrayList<String> newBank = new ArrayList<String>();
        for(int i = 0; i < bank.length; i++){
            newBank.add(bank[i]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < bank.length; i++){
            if(calculateDiff(start, bank[i]) == 1){
                newBank.remove(bank[i]);
                String[] banks = new String[newBank.size()];
                for(int k = 0; k < newBank.size(); k++){
                    banks[k] = newBank.get(k);
                }
                int recur = minMutation(bank[i], end, banks);
                newBank.add(bank[i]);
                if(recur == -1){
                    continue;
                }else{
                    if(ans > recur + 1){
                        ans = recur +1;
                    }
                }
            }
        }
        if(ans!=Integer.MAX_VALUE){return ans;}
        return -1;
    }
    public  static int calculateDiff(String start, String end){
        int diff = 0;
        for(int i = 0; i < start.length(); i ++){
            if( (start.charAt(i) - end.charAt(i)) != 0 ){
                diff+=1;
            }
        }
        //System.out.println(diff);
        return diff;
    }
}
