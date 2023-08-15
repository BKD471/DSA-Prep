package tries;

class TrieNodes{
    int data;
    TrieNodes[] children=new TrieNodes[2];
    TrieNodes(int data){
        this.data=data;
        for(int i=0;i<2;i++) children[i]=null;
    }
}

public class MaxXorPair {
    private boolean checkBits(int nums,int index){
        return (((nums>>index)&1)==1);
    }

    private void insert(TrieNodes root,int nums){
        TrieNodes curr=root;
        for(int i=31;i>=0;i--){
            if(checkBits(nums,i)){
                TrieNodes temp=new TrieNodes(1);
                if(curr.children[1]==null) curr.children[1]=temp;
                curr=curr.children[1];
            }else{
                TrieNodes temp=new TrieNodes(0);
                if(curr.children[0]==null) curr.children[0]=temp;
                curr=curr.children[0];
            }
        }
    }
    public int solve(int[] nums) {
        int n=nums.length;
        TrieNodes root=new TrieNodes(-1);
        for(int i=0;i<n;i++){
            insert(root,nums[i]);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            TrieNodes curr=root;
            int xor=0;
            for(int j=31;j>=0;j--){
                if(checkBits(nums[i],j)){
                    if(curr.children[0]!=null){
                        curr=curr.children[0];
                        xor=(xor| (1<<j));
                    }else{
                        curr=curr.children[1];
                    }
                }else{
                    if(curr.children[1]!=null){
                        curr=curr.children[1];
                        xor=(xor | (1<<j));
                    }
                    else{
                        curr=curr.children[0];
                    }
                }
            }
            ans=Math.max(ans,xor);
        }
        return ans;
    }
}
