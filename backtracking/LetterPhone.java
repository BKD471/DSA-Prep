package backtracking;

import java.util.ArrayList;

public class LetterPhone {
    ArrayList<String> res=new ArrayList<>();
    String[] hash={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private void combo(String n,int index,String temp){
        if(index>=n.length()){
            res.add(temp);
            return ;
        }

        int  num=Character.getNumericValue(n.charAt(index));
        System.out.println(num);
        String t=hash[num];
        for(char i:t.toCharArray()){
            temp+=i;
            combo(n,index+1,temp);
            temp=temp.substring(0,temp.length()-1);
        }
    }
    public ArrayList<String> letterCombinations(String n) {
        int s=n.length();
        res.clear();
        if(s==0) return res;
        combo(n,0,"");
        return res;
    }

    public static void main(String[] args) {
        LetterPhone lp=new LetterPhone();
        ArrayList<String> a=lp.letterCombinations("23");
        System.out.println(a);
    }
}
