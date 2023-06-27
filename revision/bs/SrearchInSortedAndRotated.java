package revision.bs;

public class SrearchInSortedAndRotated {
        public int findPivot(int[] nums,int l,int h){
            while(l<=h){
                int mid=l+(h-l)/2;
                if(nums[mid]>nums[h]) l=mid+1;
                else h=mid;
            }
            return h;
        }

        public int bin_search(int[] nums,int l,int h,int target){
            while(l<=h){
                int mid=l+(h-l)/2;
                if(nums[mid]==target) return mid;
                if(nums[mid]>target) h=mid-1;
                else l=mid+1;
            }
            return -1;
        }
        public int search(int[] nums, int target) {
            int l=0,h=nums.length-1;
            int k=findPivot(nums,0,h);
            System.out.print(k);
            if(k==0) return bin_search(nums,0,h,target);
            if(target>=nums[k] && target<=nums[h]){
                return bin_search(nums,k,h,target);
            }else{
                return bin_search(nums,0,k-1,target);
            }
        }
}
