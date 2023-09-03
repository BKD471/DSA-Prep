package dynamicp;

import java.util.*;


public class CoinChangeBruteI {
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    Set<ArrayList<Integer>> hash=new HashSet<>();
    private void solve(int[] nums,int target,ArrayList<Integer> temp){
        if(target<0) return;

        if(target==0){
            ArrayList<Integer> t=new ArrayList<>(temp);
            Collections.sort(t);
           if(!hash.contains(t)){
                hash.add(t);
                res.add(new ArrayList<>(t));
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
            solve(nums,target-nums[i],temp);
            temp.remove(temp.size()-1);
        }
    }
    private ArrayList<ArrayList<Integer>> combo(int[] nums,int k){
        Arrays.sort(nums);
        boolean[] dp=new boolean[k+1];
         solve(nums,k,new ArrayList<>());
         return  res;
    }
    public static void main(String[] args) {
        int[] nums={9,6,5,1};
        CoinChangeBruteI coinChangeI=new CoinChangeBruteI();
        ArrayList<ArrayList<Integer>> op=coinChangeI.combo(nums,11);
        System.out.println(op);
    }
}
