package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountSubsets {
    static ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    private void comboSum(List<Integer> arr,int k,int index,List<Integer> temp){
        if(index>=arr.size()){
            if(k==0) res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(arr.get(index));
        comboSum(arr,k-arr.get(index),index+1,temp);
        temp.remove(temp.size()-1);
        comboSum(arr,k,index+1,temp);
    }
    public static void main(String[] args) {
        CountSubsets countSubsets=new CountSubsets();
        List<Integer> a= Arrays.asList(4,3,2,1);
        countSubsets.comboSum(a,5,0,new ArrayList<>());
        System.out.println(res);
    }
}
