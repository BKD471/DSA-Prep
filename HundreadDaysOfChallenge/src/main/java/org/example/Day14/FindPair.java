package org.example.Day14;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindPair {

    public static int count(int [] nums,int k){
        int cnt=0;
        HashMap<Integer,Integer> has=new HashMap<>();
        for(int i:nums){
            if(has.containsKey(i)) has.put(i,has.get(i)+1);
            else has.put(i,1);
        }

       if(k==0) {
           for(Map.Entry<Integer,Integer> i:has.entrySet()){
              if(i.getValue()>1) cnt++;
           }
           return cnt;
       }

        for(int i:nums){
            int key=i-k;
            if(has.containsKey(key)){
                cnt++;
                has.remove(key);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums={8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3,
                8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9,
                10, 3, 8, 10, 6, 5, 4, 2, 3};

        int[] nums1={5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10,
                4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5};
        int[] arr={1,2};
        int n=0;
        System.out.println(count(arr,n));
    }
}
