import java.util.*;

public class ComboSUm {
    public static void comboSum(int[] nums, int index,ArrayList<Integer> temp,int target,int sum){
        if(index==nums.length){
            if(sum==target){
                for(int e:temp){
                    System.out.print(e+" ");
                }
                System.out.println("----------------------------------->");
                List<Integer> cpy=new ArrayList<>(temp);
                Collections.sort(cpy);
                for(int e:cpy){
                    System.out.print(e+" ");
                }
                System.out.println();
            }
            return;
        }

        temp.add(nums[index]);
        sum+=nums[index];
        comboSum(nums,index+1,temp,target,sum);
        temp.remove(temp.size()-1);
        sum-=nums[index];
        comboSum(nums,index+1,temp,target,sum);
    }



    public static int countComboSum(int[] nums, int index,int target,int sum){
        if(index==nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }
        sum+=nums[index];
        int l=countComboSum(nums,index+1,target,sum);
        sum-=nums[index];
        int r=countComboSum(nums,index+1,target,sum);
        return l+r;
    }

    public  static void main(String[] args){
        int[] arr={2,5,2,1,2};
        int target=5;
        ArrayList<Integer> temp=new ArrayList();
        comboSum(arr,0,temp,target,0);
        //System.out.println(countComboSum(arr,0,target,0));

        ArrayList<Integer> arrays=new ArrayList<Integer>();

        Set<List<Integer>> s=new HashSet<>();

       // s.toArray()

    }
}