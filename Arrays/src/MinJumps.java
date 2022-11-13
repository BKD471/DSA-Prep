public class MinJumps {
    public int minJumps(int[] nums){
       int n=nums.length;
       if(nums[0]==0) return -1;
       if(n<=1) return 0;

       int steps=nums[0];
       int maxReach=nums[0];
       int count=1;
       for(int i=1;i<n;i++){

           if(nums.length-1==i) return count;
           maxReach=Math.max(maxReach,i+nums[i]);
           steps--;

           if(steps==0){
               count++;
               steps=maxReach-i;
           }
       }

       return count;
    }
}
