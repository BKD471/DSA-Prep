import java.util.ArrayList;
import java.util.List;

import static helper.CodeHelper.displayList;

public class SubSetSums {
    public static void sumSet(int[] nums, List<Integer> res,List<Integer> temp,int index){
           if(index==nums.length){
               int sum=0;
               for(int e:temp){
                   sum+=e;
               }
               res.add(sum);
               return;
           }

           temp.add(nums[index]);
           sumSet(nums,res,temp,index+1);
           temp.remove(temp.size()-1);
           sumSet(nums,res,temp,index+1);
    }

    public static void main(String[] args) {
        int[] arr={2,3};
        List<Integer> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        sumSet(arr,res,temp,0);
        displayList(res);
    }

}
