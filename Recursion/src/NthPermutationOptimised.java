import java.util.ArrayList;
import java.util.List;

class Solution14 {
    public static String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> numbers=new ArrayList<>();
        for(int i=1;i<n;i++){
            fact*=i;
            numbers.add(i);
        }
        numbers.add(n);
        String res="";
        k=k-1;
        while(true){
            res=res+numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size()==0) break;
            k=k%fact;
            fact=fact/numbers.size();
        }
        return res;
    }
}

public class NthPermutationOptimised {
    public static void main(String[] args) {
        int n=4, k=15;
        System.out.println(Solution14.getPermutation(n,k));
    }
}

//TC -> O(n^2)