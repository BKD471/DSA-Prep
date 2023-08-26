package backtracking;

import java.util.*;

public class Subsets {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Set<ArrayList<Integer>> set=new HashSet<>();
        private void genSubSets(ArrayList<Integer> arr,int index,ArrayList<Integer> temp){
            if(index>=arr.size()){
                if(!set.contains(temp)){
                    set.add(temp);
                    res.add(new ArrayList<>(temp));
                }
                return;
            }
            genSubSets(arr,index+1,temp);
            temp.add(arr.get(index));
            genSubSets(arr,index+1,temp);
            temp.remove(temp.size()-1);
        }

        private static int  sort(ArrayList<Integer> a,ArrayList<Integer> b){
            int m=a.size();
            int n=b.size();
            int i=0,j=0;
            while(i<m && j<n){
                if(a.get(i)<b.get(j)) return -1;
                else if(a.get(i)>b.get(j)) return 1;
                i++;
                j++;
            }
            if(a.size()<b.size()) return -1;
            else if(a.size()>b.size()) return 1;
            return 0;
        }
        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
            Collections.sort(arr);
            genSubSets(arr,0,new ArrayList<>());

            Collections.sort(res,(a,b)->sort(a,b));
            return res;
        }
}
