import java.util.ArrayList;

public class SubSequence {

    public static void printSeq(int[] nums,ArrayList<Integer> temp,int ind){
        if(ind==nums.length){
            if(temp.size()==0) {
                System.out.println("Null");
                return;
            }
            for(int e:temp){
                System.out.print(e+" ");
            }
            System.out.println();
            return;
        }

        //Take
        //temp.add(nums[ind]);
        //printSeq(nums,temp,ind+1);
        //temp.remove(temp.size()-1);
        //printSeq(nums,temp,ind+1);


        //Not take
        printSeq(nums,temp,ind+1);
        temp.add(nums[ind]);
        printSeq(nums,temp,ind+1);
        temp.remove(temp.size()-1);
    }

    public  static  void main(String[] args){
        int[] arr={3,2,1};
        ArrayList<Integer> temp=new ArrayList<>();
        printSeq(arr,temp,0);
    }
}
