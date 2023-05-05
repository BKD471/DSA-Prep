package org.example.Day15;

import java.util.*;


class CompareSort<String extends Comparable<String>> implements Comparator<List<String>>{
    public  static  Map<ArrayList<java.lang.String>,Integer> hash=new HashMap();
    @Override
    public int compare(List<String> o1, List<String> o2) {
            if(Character.isLowerCase(o1.get(1).toString().charAt(0)) &&
                    Character.isLowerCase(o2.get(1).toString().charAt(0)) ){
                int v= o1.get(1).compareTo(o2.get(1));
                if(v==1 || v==-1) return v;

                return o1.get(0).compareTo(o2.get(0));

            }else if(Character.isLowerCase(o1.get(1).toString().charAt(0))) return -1;
            else if(Character.isLowerCase(o2.get(1).toString().charAt(0))) return 1;
            else{
                 if(hash.get(o1) <hash.get(o2)) return -1;
                 return 1;
            }
    }
}

public class
SortOrders {
    public static  ArrayList<ArrayList<String>> solve(ArrayList<ArrayList<String>> A) {
        int n=A.size();



        for(int i=0;i<n;i++){
            CompareSort.hash.put(A.get(i),i);
        }
        Collections.sort(A,new CompareSort());
       return A;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String> > aList =
                new ArrayList<ArrayList<String> >();

        // Create n lists one by one and append to the
        // master list (ArrayList of ArrayList)
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("greg");
        a1.add("wgwg");
        aList.add(a1);

        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("gerh");
        a2.add("xvdfbd");
        aList.add(a2);

        ArrayList<String> a3 = new ArrayList<String>();
        a3.add("rgerge");
        a3.add("cvbdfb");

        aList.add(a3);
        solve(aList);
    }

}
