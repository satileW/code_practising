/**
 * Created by user on 2/1/17.
 */
public class Stairs {
    //two dimensions dp need to be constructed this problem
    public static void main(String[] args) {
        int n = 200;
        if(n<=2) System.out.println(0);
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        boolean[] visited = new boolean[n+1];
        visited[0] = true;
        visited[1] = true;
        visited[2] = true;
        //System.out.println(findStairs(n, dp, visited, Integer.MAX_VALUE));
        countStairs(n, Integer.MAX_VALUE, 0);
        System.out.println(count);
    }
    static long count = 0;
    static void countStairs(int n ,int before, int sum){
        if(sum == n ){
            count++;
        }
        if(sum > n) return ;
        int k = findK(n-sum);
        int max;
        if(sum == 0){
            max = n-1;
        }else{
            max = before-1;
        }
        //if(k == max){ count++; return;}
        for(int i = k ; i <= max; i++){
            if(i * i + i == n-sum){
                count++;
            }else{
                sum += i;
                countStairs(n, i, sum);
                sum -= i;
            }

        }
    }
    static long findStairs(int n, long[] dp, boolean[] visited, int bottom){
        if(visited[n]){
            return dp[n];
        }
        int k = findK(n);
        //System.out.println(k);
        for(int i = k ; i <= n-1; i++){
            if( i < bottom){
                dp[n] += findStairs(n-i, dp, visited, i);
            }else{
                int nextK = findK(n-i);
                dp[n] += dp[nextK-i];
            }

        }
        visited[n] = true;
        //System.out.println(dp[n]);
        return dp[n];
    }
    static int findK(int n){
        int k = 1;
        while(k*k + k < 2*n){
            k++;
        }
        return k;
    }
}
