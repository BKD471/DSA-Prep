public class SerachInsertInPosition {
    public int lower_bound(int[] nums,int l,int h,int key){
        while(h-l>1){
            int mid=l+(h-l)/2;

            if(nums[mid]<key) l=mid+1;
            else h=mid;
        }

        if(nums[l]>=key)  return l;
        if(nums[h]>=key) return h;
        return nums.length;
    }
    public int searchInsert(int[] nums, int target) {
        return lower_bound(nums,0,nums.length-1,target);
    }
}
