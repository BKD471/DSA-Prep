package revision.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FactorialOfLargeNum {
    public static String factOfLargeN(int n){
            //Write your code here
            List<Integer> res=new ArrayList<>();
            String op="";
            res.add(1);
            int carry=0;
            for(int i=2;i<=n;i++){
                for(int j=0;j<res.size();j++){
                    int x=res.get(j)*i+carry;
                    res.set(j,x%10);
                    carry=x/10;
                }
                while(carry>0){
                    res.add(carry%10);
                    carry/=10;
                }
                carry=0;
            }

            Collections.reverse(res);
            for(int i=0;i<res.size();i++) op+=res.get(i);
            return op;
        }

}
