import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helper.CodeHelper.displayListOfList;

class Solution11 {
    public static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        solve(s,res,temp,0);
        return res;
    }

    public static void solve(String s,List<List<String>> res,List<String> temp,int index){
        if(index==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            String s1=s.substring(index,i+1);
            if(isPallin(s1)){
                temp.add(s1);
                solve(s,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean isPallin(String s2){
        int n=s2.length();
        int l=0,h=n-1;
        while(l<=h){
            if(s2.charAt(l)!=s2.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}

public class PallinDromePartitioningLC131 {
    public static void main(String[] args) {
        List<List<?>> res= Collections.singletonList(Solution11.partition("aabb"));
        displayListOfList(res);
    }
}
