/*
 Find greatest m such that a%m=b%m
 a%m=b%m
 a%m-b%m=0
 a%m-b%m+m=m
 (a%m-b%m+m)%m=m%m
 (a-b)%m=m%m   m%m=0
 (a-b)%m=0

 i.e m divides (a-b) so its greates val
*/
public class AModBSame {
   public int amodb(int a,int b){
       if(a>b) return a-b;
       return b-a;
   }
}
