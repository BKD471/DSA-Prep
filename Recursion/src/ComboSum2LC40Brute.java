import java.util.*;
import static helper.CodeHelper.displayListOfList;

class Solution1 {
    public static void comboSum(int[] arr,Set<List<Integer>> res, List<Integer> temp,int index,int target){
        if(index==arr.length){
            if(target==0){
                List<Integer> cpy=new ArrayList(temp);
                Collections.sort(cpy);
                res.add(new ArrayList(cpy));
            }
            return;
        }
        temp.add(arr[index]);
        comboSum(arr,res,temp,index+1,target-arr[index]);
        temp.remove(temp.size()-1);
        comboSum(arr,res,temp,index+1,target);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res=new LinkedHashSet<>();
        List<Integer> temp=new ArrayList();
        comboSum(candidates,res,temp,0,target);
        List<List<Integer>> result=new ArrayList();
        Iterator itr=  res.iterator();
        while(itr.hasNext()){
            List tempSet= (List) itr.next();
            result.add(tempSet);
        }
        return result;
    }
}


public class ComboSum2LC40Brute {
    public static void main(String[] args) {

        int[] arr={2,5,2,1,2};
        int target=5;
        List<List<Integer>> res1=Solution1.combinationSum2(arr,target);
        displayListOfList(res1);
    }
}
