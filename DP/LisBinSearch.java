import java.util.ArrayList;
import java.util.List;

public class LisBinSearch {
        public int upperBound(int v,List<Integer> temp){
            int l=0,h=temp.size()-1;

            while(l<h){
                int mid=l+(h-l)/2;
                if(v>temp.get(mid)) l=mid+1;
                else h=mid;
            }
            return h;
        }
        public int lengthOfLIS(int[] nums) {
            int n=nums.length;
            List<Integer> temp=new ArrayList<>();
            temp.add(nums[0]);

            for(int i=1;i<n;i++){
                int index=upperBound(nums[i],temp);
                if(nums[i]>temp.get(temp.size()-1)){
                    temp.add(nums[i]);
                }else{
                    temp.set(index,nums[i]);
                }
            }
            return temp.size();
        }
}
