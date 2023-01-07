import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution7 {
    public static boolean canCross(int[] stones) {
        int n=stones.length;

        //Set is for handling duplicates
        Map<Integer, HashSet<Integer>> hash=new HashMap<>();

        //inserting all elements in hash
        //mapped  value for a particular stone in hash is a set
        //this set will contain all the possible jumps made to get to that stone
        for(int i=0;i<n;i++){
            //intializing  every stones with an empty set
            hash.put(stones[i],new HashSet<Integer>());
        }

        //jump to get to first stone is always 0
        hash.get(0).add(0);


        for(int i=0;i<n;i++){
            HashSet<Integer> temp=hash.get(stones[i]);
            for(int v:temp){
                //checking for k-1
                if( hash.containsKey(stones[i]+v-1) && v-1>0){
                    hash.get(stones[i]+v-1).add(v-1);
                }
                //checking for k
                if(hash.containsKey(stones[i]+v) && v>0){
                    hash.get(stones[i]+v).add(v);
                }
                //checking for k+1
                if(hash.containsKey(stones[i]+v+1)){
                    hash.get(stones[i]+v+1).add(v+1);
                }
            }
        }

        //If the corresponding set for last stone is empty,
        //that means  we havent manage to get to this stone,
        //meaning its unreachable
        if(hash.get(stones[n-1]).size()>0){
            return true;
        }
        return false;
    }
}
public class FrogJump {
    public static void main(String[] args) {
        int stones[]={0,1,3,5,6,8,12,17};
        System.out.println(Solution7.canCross(stones));
    }
}
