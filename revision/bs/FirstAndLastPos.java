package revision.bs;

public class FirstAndLastPos {
    public int firstPosition(int[] nums,int l,int h,int target){
        int best=-1,found=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target) found=1;
            if(nums[mid]>=target){
                best=mid;
                h=mid-1;
            }else l=mid+1;
        }
        return (found==0)?-1:best;
    }

    public int lastPosition(int[] nums,int l,int h,int target){
        int best=-1,found=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target) found=1;
            if(nums[mid]<=target){
                best=mid;
                l=mid+1;
            }else h=mid-1;
        }
        return (found==0)?-1:best;
    }

    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int l=0,h=n-1;
        int first=firstPosition(nums,l,h,target);
        int last=lastPosition(nums,l,h,target);
        return new int[]{first,last};
    }
}
