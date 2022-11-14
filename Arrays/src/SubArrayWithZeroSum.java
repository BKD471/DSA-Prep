import java.util.HashMap;

public class SubArrayWithZeroSum {

    public int zeroSum(int[] nums){
        int n=nums.length;
        HashMap<Integer,Integer> hash=new HashMap<>();
        int count=0;
        hash.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(hash.containsKey(sum)){
                count++;
            }else{
                hash.put(sum,i);
            }
        }
        return count;
    }
}
