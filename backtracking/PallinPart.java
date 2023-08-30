package backtracking;
import java.util.ArrayList;
public class PallinPart {
    ArrayList<ArrayList<String>> res=new ArrayList<>();
    private boolean checkPallin(String t){
        int l=0,h=t.length()-1;
        while(l<=h){
            if(t.charAt(l)!=t.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
    private void combo(String n,int index,ArrayList<String> temp){
        if(index>=n.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<n.length();i++){
            String t=n.substring(index,i+1);
            if(checkPallin(t)){
                temp.add(t);
                combo(n,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }

    }
    public ArrayList<ArrayList<String>> partition(String a) {
        if(a.length()==0) return res;
        combo(a,0,new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        PallinPart pp=new PallinPart();
        System.out.println(pp.partition("aabb"));
    }
}
