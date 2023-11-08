package dynamicp.lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
public class LongestDivisible {
        public static List< Integer > divisibleSet(int []nums) {
            // Write your code here.
            int n=nums.length;
            Arrays.sort(nums);
            int[] lis=new int[n];
            int[] hash=new int[n];

            for(int i=0;i<n;i++){
                lis[i]=1;
                hash[i]=i;
            }


            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]%nums[j]==0){
                        if(1+lis[j]>lis[i]){
                            lis[i]=1+lis[j];
                            hash[i]=j;
                        }

                    }
                }
            }

            int mxIndex=-1,size=-1;
            for(int i=0;i<n;i++){
                if(lis[i]>size){
                    size=lis[i];
                    mxIndex=i;
                }
            }


            List<Integer> res=new ArrayList<>();
            int indx=size-1;

            while(indx>=0){
                res.add(nums[mxIndex]);
                indx--;
                mxIndex=hash[mxIndex];
            }
            Collections.reverse(res);
            return res;
        }
}
