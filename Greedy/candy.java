package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
public class candy {
    public int candy(ArrayList<Integer> A) {
        int n=A.size();
        int[] left=new int[n];
        Arrays.fill(left,1);

        int[] right=new int[n];
        Arrays.fill(right,1);

        for(int i=1;i<n;i++){
            if(A.get(i)>A.get(i-1)) left[i]=left[i-1]+1;
        }

        for(int i=n-2;i>=0;i--){
            if(A.get(i)>A.get(i+1)) right[i]=right[i+1]+1;
        }


        int candy=0;
        for(int i=0;i<n;i++) candy+=Math.max(left[i],right[i]);
        return candy;
    }
}
