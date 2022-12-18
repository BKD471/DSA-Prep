import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helper.CodeHelper.displayList;

public class SubSetSums {
    public static void sumSet(int[] nums, List<Integer> res,int index,int sum){
           if(index==nums.length){
               res.add(sum);
               return;
           }
           sumSet(nums,res,index+1,sum+nums[index]);
           sumSet(nums,res,index+1,sum);
    }

    public static void main(String[] args) {
        int[] arr={2,3};
        List<Integer> res=new ArrayList<>();
        sumSet(arr,res,0,0);
        Collections.sort(res);
        displayList(res);
    }

}
