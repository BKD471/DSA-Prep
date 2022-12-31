import java.util.ArrayList;
import java.util.List;

class Solution28
{
    public static void solve(List<String> arr,List<String> res,int index,String s){

        if(index==arr.size()){
            res.add(s);
            return;
        }

        s=s+arr.get(index);
        int sz=arr.get(index).length();
        solve(arr,res,index+1,s);
        s=s.substring(0,s.length()-sz);
        solve(arr,res,index+1,s);


    }
    public static int maxLength(List<String> arr) {
        List<String> res=new ArrayList<>();
        solve(arr,res,0,"");

        int mx=Integer.MIN_VALUE;
        for(int i=0;i<res.size();i++){
            char[] temp=res.get(i).toCharArray();
            boolean flag=true;
            int[] hash=new int[26];
            for(int j=0;j<temp.length;j++){
                int r=temp[j]-'a';
                hash[r]++;
                if(hash[r]>=2) flag=false;

            }
            // for(int k=0;k<26;k++){
            //     if(hash[k]>=2) flag=false;
            // }

            if(flag){
                mx=Math.max(temp.length,mx);
            }

        }

        //System.out.println(res);
        return mx;
    }
}



public class MaxLengthOfConcString {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("un");arr.add("iq");arr.add("ue");
        System.out.println(Solution28.maxLength(arr));
    }
}
