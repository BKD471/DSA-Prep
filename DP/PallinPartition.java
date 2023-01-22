import java.util.ArrayList;
import java.util.List;

public class PallinPartition {
    public boolean isPallin(String s){
        int l=0,h=s.length()-1;
        while(l<=h){
            if(s.charAt(l)!=s.charAt(h)) return false;
            l++;
            h--;
        }

        return true;
    }

    public void pallinDrome(String s,List<List<String>> res,List<String> temp,int index){
        if(index==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            String tempString=s.substring(index,i+1);
            if(isPallin(tempString)){
                temp.add(tempString);
                pallinDrome(s,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        pallinDrome(s,res,temp,0);
        return res;

    }
}
