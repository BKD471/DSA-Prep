package revision.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElements {
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        Map<Integer,Integer> hash=new HashMap<>();

        int min_index=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int v=A.get(i);
            if(hash.containsKey(v)){
                min_index=Math.min(min_index,hash.get(v));
            }else hash.put(v,i);
        }
        return min_index==Integer.MAX_VALUE?-1:A.get(min_index);
    }
}
