import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by user on 12/21/16.
 */
public class TweetRecommandation {
    public static void main(String[] args) {
        int[][] followGraph_edges = {{4,3},{1,2},{1,3},{1,4},{5,6}};
        int[][] likeGraph_edges = {{2,10},{3,10},{4,10},{2,11},{3,12},{4,11}};
        int targetUser = 1;
        int minLikeThreshold = 3;
        getRecommendedTweets(followGraph_edges, likeGraph_edges, targetUser, minLikeThreshold);

    }
    public  static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges,
                                      int targetUser, int minLikeThreshold) {
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<Integer> followedGuys = new ArrayList<>();
        for(int i = 0; i < followGraph_edges.length; i++){
            if(followGraph_edges[i][0] == targetUser ){
                followedGuys.add(followGraph_edges[i][1]);
                System.out.println( followGraph_edges[i][1] );
            }
        }

        HashMap<Integer, ArrayList<Integer>> likeTweetMap = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < likeGraph_edges.length; i ++){
            if( !followedGuys.contains(likeGraph_edges[i][0]) ){
                System.out.println(likeGraph_edges[i][0]);
                continue;
            }
            if(likeTweetMap.containsKey( likeGraph_edges[i][1]) ){
                ArrayList<Integer> org = likeTweetMap.get(likeGraph_edges[i][1]);
                org.add(likeGraph_edges[i][0]);
                likeTweetMap.put(likeGraph_edges[i][1], org);
            }else{
                ArrayList<Integer> org = new ArrayList<>();
                org.add(likeGraph_edges[i][0]);
                likeTweetMap.put(likeGraph_edges[i][1], org);
            }
        }
        for (HashMap.Entry<Integer, ArrayList<Integer>> entry : likeTweetMap.entrySet()) {
            if(entry.getValue().size() >= minLikeThreshold){
                ans.add(entry.getKey());
            }
            //System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        Collections.sort(ans);
        int[] intAns = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            intAns[i] = ans.get(i);
            System.out.print(intAns[i]);
        }
        return intAns;
    }



}
