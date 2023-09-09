package dynamicp;

import java.util.Arrays;

public class JumpingJackII {
    private static int minJumps(int[] jumps,int index,int k){
        if(index==jumps.length-1) return 0;
        int jump=Integer.MAX_VALUE,minJump=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(index+i<jumps.length) jump=Math.abs(jumps[index]-jumps[index+i])+minJumps(jumps,index+i,k);
            minJump=Math.min(minJump,jump);
        }
        return minJump;
    }
    public static void main(String[] args) {
        int[] jumps={2,5,2};
        int k=1;
        int[] memo=new int[jumps.length+1];
        Arrays.fill(memo,-1);
        System.out.println(minJumps(jumps,0,k));
    }
}
