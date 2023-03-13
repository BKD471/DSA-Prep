    public class StrangeEquality {
        public boolean checkSetBits(int n,int index){

            while(index>0){
                n=n>>1;
                index--;
            }

            return ( (n&1)==1) ? true: false;
        }
        public int solve(int A) {
            int x=0,y=0,indexOfSetBits=-1;

            // A+x= A^x + 2(A&x)
            // since a+x=a^x  then 2(a&x)=0 ==> a&x=0

            //check the rightmost set bit
            //for x<a and x&a=0    a=5 (101) then b must be reverse 010
            //chech the right most set bit, reverse everything
            for(int i=0;i<=31;i++){
                if(checkSetBits(A,i)) indexOfSetBits=i;
            }

            for(int i=0;i<=indexOfSetBits;i++){
                if(!checkSetBits(A,i)){
                    x=(x | (1<<i));
                }
            }

            // for y>a, if a= 101 then y needs to be all 0 and add 1
            // a=101 , y=1000 i.e 2^(total bit count from rightmost set bits in A to end)
            int lastBit=indexOfSetBits+1;
            y=(int)Math.pow(2,lastBit);

            return x^y;
        }
    }

