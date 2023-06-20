package revision.arrays;

import java.util.Arrays;

import static revision.arrays.Util.swap;

public class MoveNegToLeft {
    public static int[] moveIt(int[] nums,int n){
        int l=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                swap(nums,i,l);
                l++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums={1,-2,3,-4,5,-6,7,-8,9};
        Arrays.stream(moveIt(nums,nums.length)).forEach( System.out::print);
    }
}
