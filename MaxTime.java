import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * Created by user on 2/8/17.
 */
public class MaxTime {
    public static void main(String[] args) {
        //System.out.println(getMaxTime(5,6,4,2));
        System.out.println(getMaxTimeTwo(2,0,4,0));
    }
    public static String getMaxTimeTwo(int a , int b , int c, int d){
        StringBuilder ans = new StringBuilder();
        int[] nums = {a, b, c, d};
        Arrays.sort(nums);
        boolean[] used = new boolean[4];
        List<Integer> permutation = new ArrayList<>();
        getPermutationsTwo(permutation, nums, used, ans);
        if(ans.length()==0){
            ans.append("NOT POSSIBLE");
        }
        return ans.toString();
    }
    public static void getPermutationsTwo( List<Integer> permutation, int[] nums, boolean[] used, StringBuilder ans){
        if(ans.length()!=0){
            return;
        }
        if(permutation.size()==4){
            //System.out.println(permutation.toString());
            int hh = permutation.get(0)*10+permutation.get(1);
            int mm = permutation.get(2)*10+permutation.get(3);
            if(isValidHour(hh)&&isValidMinute(mm)){
                ans.append(permutation.get(0).toString()+permutation.get(1).toString()+":"+permutation.get(2).toString()+permutation.get(3).toString());
            }
            return;
        }

        for (int i = 3; i >= 0; i--){
            if( !used[i]){
                used[i] = true;
                permutation.add(nums[i]);
                getPermutationsTwo(permutation, nums, used, ans);
                if(ans.length()!=0){
                    return;
                }
                permutation.remove(permutation.size()-1);//remove last one
                used[i] = false;
            }
        }
    }

    public static String getMaxTime(int a , int b , int c, int d){
        StringBuilder ans = new StringBuilder();
        int[] nums = {a, b, c, d};
        Arrays.sort(nums);
        boolean[] used = new boolean[4];
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        List<Integer> permutation = new ArrayList<>();
        getPermutations(permutations, permutation, nums, used);
        System.out.println(permutations.size());
        for(int i = 0; i < permutations.size(); i++){
            permutation = permutations.get(i);
            System.out.println(permutation.toString());
            int hh = permutation.get(0)*10+permutation.get(1);
            int mm = permutation.get(2)*10+permutation.get(3);
            if(isValidHour(hh)&&isValidMinute(mm)){
                ans.append(permutation.get(0).toString()+permutation.get(1).toString()+":"+permutation.get(2).toString()+permutation.get(3).toString());
                break;
            }
        }
        if(ans.length()==0){
            ans.append("NOT POSSIBLE");
        }
        return ans.toString();
    }
    static void getPermutations(List<List<Integer>> permutations, List<Integer> permutation, int[] nums, boolean[] used){
        if(permutation.size()==4){
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 3; i >= 0; i--){
            if( !used[i]){
                used[i] = true;
                permutation.add(nums[i]);
                getPermutations(permutations, permutation, nums, used);
                permutation.remove(permutation.size()-1);//remove last one
                used[i] = false;
            }
        }
    }
    public static boolean isValidHour(int num){
    //00-23
        boolean isOK = false;
        if(num<24){
            isOK = true;
        }
        return isOK;

    }
    public static boolean isValidMinute(int num){
    //00-59
        boolean isOK = false;
        if (num<60){
            isOK = true;
        }
        return isOK;
    }
}
