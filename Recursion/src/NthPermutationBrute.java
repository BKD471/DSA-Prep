import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helper.CodeHelper.swapHelper;

class Solution13{

    public static void permutation(List<List<Integer>> res,int[] temp,int n,int index){
        if(index==n){
            List<Integer> arr=new ArrayList<>();
            for(int i:temp){
                arr.add(i);
            }
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i=index;i<n;i++){
             swapHelper(temp,index,i);
             permutation(res,temp,n,index+1);
             swapHelper(temp,index,i);
        }
    }
    public  static String kthPermutation(int n,int k){
        int[] temp=new int[n];
        int j=0;
        for(int i=1;i<=n;i++){
            temp[j]=i;
            j++;
        }
        List<List<Integer>> res=new ArrayList<>();
        permutation(res,temp,n,0);

        List<String> a=new ArrayList<>();
        for(List<Integer> t:res){
            String s="";
            for(Integer i:t){
                s+=i;
            }
            a.add(s);
        }
        Collections.sort(a);
        return a.get(k-1);
    }
}


public class NthPermutationBrute {
    public static void main(String[] args) {
        System.out.println(Solution13.kthPermutation(4,9));
    }
}

//TC--> n!Xn