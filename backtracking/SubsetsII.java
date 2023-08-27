package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsII {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        private void combo(ArrayList<Integer> arr,int index,ArrayList<Integer> temp){
            if(index>=arr.size()){
                res.add(new ArrayList<>(temp));
                return;
            }
            temp.add(arr.get(index));
            combo(arr,index+1,temp);
            temp.remove(temp.size()-1);
            while(index+1<arr.size() && arr.get(index)==arr.get(index+1)) index++;
            combo(arr,index+1,temp);
        }

        private int sort(ArrayList<Integer> l1,ArrayList<Integer> l2){
            int m=l1.size();
            int n=l2.size();

            int i=0,j=0;
            while(i<m && j<n){
                if(l1.get(i)<l2.get(j)) return -1;
                else if(l1.get(i)>l2.get(j)) return 1;
                i++;
                j++;
            }
            if(l1.size()<l2.size()) return -1;
            else if(l1.size()>l2.size()) return 1;
            return 0;
        }
        public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
            Collections.sort(A);
            combo(A,0,new ArrayList<>());
            Collections.sort(res,(a,b)->sort(a,b));
            return res;
        }
}
