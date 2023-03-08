public class NextPermutationEasyApproach {
        public void swap(int[] A,int l,int h){
            int t=A[l];
            A[l]=A[h];
            A[h]=t;
        }
        public void reverse(int[] A,int l,int h){

            while(l<=h){
                swap(A,l,h);
                l++;
                h--;
            }
        }
        public int[] nextPermutation(int[] A)
        {
            int n=A.length,index=-1;
            for(int i=n-2;i>=0;i--){
                if(A[i]<A[i+1]) {
                    index=i;
                    break;
                }
            }

            if(index==-1){
                reverse(A,0,n-1);
                return A;
            }

            int v=A[index];
            int mindiff=Integer.MAX_VALUE,idx=-1;
            for(int i=n-1;i>index;i--){
                int diff=Math.abs(A[i]-v);
                if(A[i]>v && diff<mindiff){
                    idx=i;
                    mindiff=diff;
                }
            }
            swap(A,index,idx);
            reverse(A,index+1,n-1);
            return A;

        }
}
