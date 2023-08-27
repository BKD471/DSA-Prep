package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComboSumII {
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    private void comboSumII(List<Integer> arr,int index,int target,ArrayList<Integer> temp){
        if(index>=arr.size()){
            //System.out.println(temp+" "+target);
            if(target==0) res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr.get(index));
        comboSumII(arr,index+1,target-arr.get(index),temp);
        temp.remove(temp.size()-1);
        while (index+1<arr.size() && arr.get(index)==arr.get(index+1)) index++;
        comboSumII(arr,index+1,target,temp);
    }
    public ArrayList<ArrayList<Integer>> combinationSum(List<Integer> arr, int B) {
        Collections.sort(arr);
        res.clear();
        comboSumII(arr,0,B,new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        ComboSumII cs=new ComboSumII();
        List<Integer> a= Arrays.asList(10, 1, 2, 7, 6, 1, 5);
        cs.combinationSum(a,8);
        System.out.println(cs.res);
    }
}
