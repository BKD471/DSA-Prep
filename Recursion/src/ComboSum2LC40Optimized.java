import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static helper.CodeHelper.displayListOfList;

class Solution3 {
    public static void comboSum(int[] arr,List<List<Integer>> res, List<Integer> temp,int index,int target){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;

            temp.add(arr[i]);
            comboSum(arr,res,temp,i+1,target-arr[i]);
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        comboSum(candidates,res,temp,0,target);
        return res;
    }
}

public class ComboSum2LC40Optimized {
    public static void main(String[] args) {
        int[] arr={2,5,2,1,7,1};
        int target=8;
        List<List<?>> res1= Collections.singletonList(Solution3.combinationSum2(arr, target));
        displayListOfList(res1);
    }
}
