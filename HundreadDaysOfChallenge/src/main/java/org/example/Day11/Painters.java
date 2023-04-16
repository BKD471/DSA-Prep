package org.example.Day11;

public class Painters {
    private static final int LIMIT=(int)Math.pow(10,7)+3;
    public int countPainters(int[] nums,int pages){

        int page=0,painters=1;
        for(int i=0;i<nums.length;i++){
            page+=nums[i];
            if(page>pages){
                painters++;
                page=nums[i];
            }
        }
        return painters;
    }
    public int paint(int p, int t, int[] nums) {
        int n=nums.length,res=0;
        int l=0,h=0;
        for(int i=0;i<n;i++){
            h+=nums[i];
            l=Math.max(l,nums[i]);
        }

        while(l<=h){
            int pages=(l+h)>>1;
            int painters=countPainters(nums,pages);
            if(painters<=p){
                res=pages;
                h=pages-1;
            }else l=pages+1;
        }
        return ((res%LIMIT)*(t%LIMIT))%LIMIT;
    }
}
