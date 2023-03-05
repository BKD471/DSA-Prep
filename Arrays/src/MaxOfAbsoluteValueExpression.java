public class MaxOfAbsoluteValueExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n=arr1.length,optimal=0;
        int[] sign={1,-1};

        for(int e1:sign){
            for(int e2:sign){
                int mx=Integer.MIN_VALUE;
                int mn=Integer.MAX_VALUE;
                for(int i=0;i<n;i++){
                    int expression=e1*arr1[i]+e2*arr2[i]+i;
                    mx=Math.max(mx,expression);
                    mn=Math.min(mn,expression);
                }
                optimal=Math.max(mx-mn,optimal);
            }
        }

        return optimal;
    }
}


//|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
//
//
//        |arr1[i] - arr1[j]|=|A|
//        |arr2[i] - arr2[j]|=|B|
//
//
//        1  A+B  =  arr1[i] - arr1[j] + arr2[i] - arr2[j] +  i - j =  (arr1[i]+arr2[i]+i)-(arr1[j]+arr2[j]+j)
//        2  A+B  =  arr1[i] - arr1[j] + arr2[i] - arr2[j] -  i + j =  (arr1[i]+arr2[i]-i)-(arr1[j]+arr2[j]-j)
//        3  A-B  =  arr1[i] - arr1[j] - arr2[i] + arr2[j] +  i - j =  (arr1[i]-arr2[i]+i)-(arr1[j]-arr2[j]+j)
//        4  A-B  =  arr1[i] - arr1[j] - arr2[i] + arr2[j] -  i + j =  (arr1[i]-arr2[i]-i)-(arr1[j]-arr2[j]-j)
//        5 -A+B  = -arr1[i] + arr1[j] + arr2[i] - arr2[j] +  i - j = -(arr1[i]-arr2[i]-i)+(arr1[j]-arr2[j]-j)
//        6 -A+B  = -arr1[i] + arr1[j] + arr2[i] - arr2[j] -  i + j = -(arr1[i]-arr2[i]+i)+(arr1[j]-arr2[j]+j)
//        7 -A-B  = -arr1[i] + arr1[j] - arr2[i] + arr2[j] +  i - j = -(arr1[i]+arr2[i]-i)+(arr1[j]+arr2[j]-j)
//        8 -A-B  = -arr1[i] + arr1[j] - arr2[i] + arr2[j] -  i + j = -(arr1[i]+arr2[i]+i)+(arr1[j]+arr2[j]+j)
//
//
//
//        (1 & 8) (2&7) (3&6) (4&5) are same
//
//
//        (arr1[i]+arr2[i]+i)-(arr1[j]+arr2[j]+j) =  ( arr1[i]+arr2[i]+i)-( arr1[j]+arr2[j]+j)
//        (arr1[i]+arr2[i]-i)-(arr1[j]+arr2[j]-j) =  (-arr1[j]-arr2[j]+j)-(-arr1[i]-arr2[i]+i)
//        (arr1[i]-arr2[i]+i)-(arr1[j]-arr2[j]+j) =  ( arr1[i]-arr2[i]+i)-( arr1[j]-arr2[j]+j)
//        (arr1[i]-arr2[i]-i)-(arr1[j]-arr2[j]-j) =  (-arr1[j]+arr2[j]+j)-(-arr1[i]+arr2[i]+i)
//
//
//        Observation we have always +i +j so ignore their sign
//
//
//        ( arr1[i]+arr2[i]+i)-( arr1[j]+arr2[j]+j)
//        (-arr1[j]-arr2[j]+j)-(-arr1[i]-arr2[i]+i)
//        ( arr1[i]-arr2[i]+i)-( arr1[j]-arr2[j]+j)
//        (-arr1[j]+arr2[j]+j)-(-arr1[i]+arr2[i]+i)
//
//
//        ( arr1[i]+arr2[i]+i)-( arr1[j]+arr2[j]+j) ==>( 1* arr1[i] +1* arr2[i]+i)-(  1* arr1[j] +1* arr2[j]+j)    1   1
//        (-arr1[j]-arr2[j]+j)-(-arr1[i]-arr2[i]+i) ==>(-1* arr1[j] -1* arr2[j]+j)-( -1* arr1[i] -1* arr2[i]+i)   -1  -1
//        ( arr1[i]-arr2[i]+i)-( arr1[j]-arr2[j]+j) ==>( 1* arr1[i] -1* arr2[i]+i)-(  1* arr1[j] -1* arr2[j]+j)    1  -1
//        (-arr1[j]+arr2[j]+j)-(-arr1[i]+arr2[i]+i) ==>(-1* arr1[j] +1* arr2[j]+j)-( -1* arr1[i] +1* arr2[i]+i)   -1   1
