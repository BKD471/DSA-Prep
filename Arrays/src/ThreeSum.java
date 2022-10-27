import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum extends Utility{

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res=new LinkedList<>();

        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int h=n-1;
            while(l<h){
                int key=nums[l]+nums[h]+nums[i];
                if(key==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    int lv=nums[l];
                    while(l<h && nums[l]==lv) l++;
                    int rv=nums[h];
                    while(l<h && nums[h]==rv) h--;
                }else if(key>0){
                    h--;
                }else{
                    l++;
                }
            }
            while(i+1<n && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
}
