import java.util.HashSet;

public class UniqueBitwsieOrsOfSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        HashSet<Integer> previous=new HashSet<>();
        HashSet<Integer> uniqueResult=new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> current=new HashSet<>();
            uniqueResult.add(arr[i]);
            current.add(arr[i]);
            for(Integer t:previous){
                current.add(arr[i]|t);
                uniqueResult.add(arr[i]|t);
            }
            previous=current;
        }
        return uniqueResult.size();
    }
}
