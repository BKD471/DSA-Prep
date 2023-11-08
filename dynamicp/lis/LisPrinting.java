package dynamicp.lis;

public class LisPrinting {
    public static int[] getLis(int[] nums){
        int n=nums.length;
        int[] lis=new int[n];
        int[] hash=new int[n];

        for(int i=0;i<n;i++){
            lis[i]=1;
            hash[i]=i;
        }

        int mx=1,mxIndex=-1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev]){
                    if(lis[i]<1+lis[prev]){
                        lis[i]=1+lis[prev];
                        hash[i]=prev;
                    }

                    if(mx<lis[i]){
                        mxIndex=i;
                        mx=lis[i];
                    }
                }
            }
        }
        if(mxIndex==-1) {
            System.out.println("Everey element is equal and lis is 1");
            return new int[]{};
        }
        int[] res=new int[mx];
        int indx=mx-1;

        while(indx>=0){
            res[indx--]=nums[mxIndex];
            mxIndex=hash[mxIndex];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={5,4,11,1,16,8};
        int[] res=getLis(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
