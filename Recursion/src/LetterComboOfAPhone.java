import java.util.ArrayList;
import java.util.List;

class Solution19{
    public static void solve(List<String> res,String[] mp,String digits,String temp,int index){
        if(digits.length()==temp.length()){
            res.add(temp);
            return;
        }

        String seq=mp[Character.getNumericValue(digits.charAt(index))];
        for(char t:seq.toCharArray()){
            temp+=t;
            solve(res,mp,digits,temp,index+1);
            temp=temp.substring(0,temp.length()-1);
        }

    }
    public static List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        String[] mp={"","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0) return res;
        solve(res,mp,digits,"",0);
        return res;
    }
}



public class LetterComboOfAPhone {
    public static void main(String[] args) {
        String digit="2345";
        List<String> res=Solution19.letterCombinations(digit);

        res.forEach( r-> System.out.print(r+" "));
    }
}
