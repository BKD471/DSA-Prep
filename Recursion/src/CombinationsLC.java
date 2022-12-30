import java.util.ArrayList;
import java.util.List;

class Solution23 {

    public static void solveIt(List<List<Integer>> res,List<Integer> temp,int[] combo,int k,int index){

        if(temp.size()==k){
            System.out.print(temp);
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<combo.length;i++){
            temp.add(combo[i]);
            solveIt(res,temp,combo,k,i+1);
            temp.remove(temp.size()-1);
        }

    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int[] combo=new int[n];
        for(int i=1;i<=n;i++){
            combo[i-1]=i;
        }
        solveIt(res,temp,combo,k,0);
        return res;
    }
}


public class CombinationsLC {
    public static void main(String[] args) {
        List<List<Integer>> res=Solution23.combine(4,2);
        res.forEach(t-> System.out.print(t));
    }
}
