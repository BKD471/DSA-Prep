package backtracking;

import java.util.ArrayList;

public class NdigitWith1orTwo {
    static ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    private static void combo(ArrayList<Integer> temp,int index,int n){
        if(index>=n){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(1);
        combo(temp,index+1,n);
        temp.remove(temp.size()-1);
        temp.add(2);
        combo(temp,index+1,n);
        temp.remove(temp.size()-1);
    }
    private static ArrayList<ArrayList<Integer>> genCombo(int n){
        combo(new ArrayList<>(),0,n);
        return res;
    }
    public static void main(String[] args) {
        NdigitWith1orTwo.genCombo(3);
        System.out.println(res);
    }
}
