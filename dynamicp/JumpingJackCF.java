package dynamicp;

import java.util.Arrays;

public class JumpingJackCF {
    private static int minJumps(int[] jumps,int index,int[] memo){
        if(index==jumps.length-1) return 0;
        if(memo[index]!=-1) return memo[index];
        int jump1=Integer.MAX_VALUE,jump2=Integer.MAX_VALUE;
        if(index+1<jumps.length) jump1=Math.abs(jumps[index]-jumps[index+1])+minJumps(jumps,index+1,memo);
        if(index+2<jumps.length) jump2=Math.abs(jumps[index]-jumps[index+2])+minJumps(jumps,index+2,memo);
        memo[index]=Math.min(jump1,jump2);
        return memo[index];
    }
    public static void main(String[] args) {
        int[] jumps={10,20,30,10};
        int[] memo=new int[jumps.length];
        Arrays.fill(memo,-1);
        System.out.println(minJumps(jumps,0,memo));
    }
}
