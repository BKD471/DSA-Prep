package dynamicp.lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LisBin {
    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int n=arr.length;
        List<Integer> res=new ArrayList<>();

        if(n==0) return 0;
        res.add(arr[0]);
        int len=1;
        for(int i=1;i<n;i++){
            if(arr[i]>res.get(res.size()-1)){
                res.add(arr[i]);
                len++;
            }else{

                int indx= Collections.binarySearch(res,arr[i]);
                if(indx<0){
                    indx=-indx-1;
                }
                res.set(indx,arr[i]);
            }

        }
        return len;
    }
}
