package BinarySearch;

public class Bounds {
     public static int upper_bound(int[] nums,int l,int h,int target){
         while(l<h){
             int mid=l+(h-l)/2;
             if(nums[mid]<=target) l=mid+1;
             else h=mid;
         }
         if(nums[l]>target) return l;
         if(nums[h]>target) return h;
         return nums.length;
     }
    public static int lower_bound(int[] nums,int l,int h,int target){
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=target) h=mid;
            else l=mid+1;
        }
        if(nums[l]>=target) return l;
        if(nums[h]>=target) return h;
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums={10,20,30,40,50,60,70,80,90};
        int target=69;
        System.out.println(upper_bound(nums,0,nums.length,target));
        System.out.println(lower_bound(nums,0,nums.length,target));
    }
}
