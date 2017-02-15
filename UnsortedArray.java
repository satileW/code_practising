/**
 * Created by user on 2/8/17.
 */
public class UnsortedArray {
    public static void main(String[] args) {
        int[] a = {2,3,4,7,1,3,5,6,11,12,14,16,17,20};
        System.out.println(unsortedArray(a));
    }
    public static int unsortedArray(int[] array){
        int n = array.length;
        int i = Integer.MIN_VALUE, j = Integer.MAX_VALUE;
        for (int s = 0; s < n-1; s++){
            //from 0 ~ n-2
            if(array[s]>array[s+1]){
                i = s;
                break;
            }
        }
        if (i == Integer.MIN_VALUE){
            return 0;
        }
        for (int e = n-1; e > 0; e--){
            //from n-1 ~ 1
            if (array[e] < array[e-1]){
                j = e;
                break;
            }
        }
        int MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
        for (int s = i; s <= j; s++){
            if(array[s]<MIN){
                MIN = array[s];
            }
            if(array[s]>MAX){
                MAX = array[s];
            }
        }
        for(int x = i-1; x >= 0; x--){
            if (x == 0 && array[x] > MIN){
                i = 0;
            }
            if(array[x]>MIN){
                continue;
            }else{
                //array[x] <= MIN
                i = x+1;
                break;
            }

        }
        for (int y = j+1; y < n; y++){
            if (y == n-1 && array[y] < MAX){
                j = n-1;
            }
            if (array[y] < MAX){
                continue;
            }else{
                //array[y] >= MAX
                j = y - 1;
                break;
            }
        }
        return j-i+1;
    }
}
