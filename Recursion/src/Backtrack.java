import static helper.CodeHelper.*;

class BasicRecursion  {
    public static void print1ToNRec(int n, int i) {
        if (i == n + 1) return;
        System.out.print(i + " ");
        i++;
        print1ToNRec(n, i);
    }

    public static void printNTo1Rec(int i) {
        if (i == 0) return;
        System.out.print(i);
        i--;
        printNTo1Rec(i);
    }

    public static void print1ToNBackTrack(int i) {
        if (i == 0) return;
        print1ToNBackTrack(--i);
        System.out.print(i + 1 + " ");
    }

    public static void printNTo1BackTrack(int n, int i) {
        if (i > n) return;
        printNTo1BackTrack(n, ++i);
        System.out.print(i - 1 + " ");
    }

    public static void sumOfNParam(int n, int sum) {
        if (n <= 0) {
            System.out.print(String.format("Sum of first %s numbers is %s", n, sum));
            return;
        }
        sum += n;
        sumOfNParam(--n, sum);
    }

    public static int sumOfNFunctional(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumOfNFunctional(n - 1);
    }

    public static int[] reverseRec(int[] nums, int l, int h) {
        if (l >= h) {
            return nums;
        }
        swapHelper(nums, l, h);
        return reverseRec(nums, ++l, --h);
    }

    public static int[] reverseRecOpt(int[] nums, int l,int n) {
        if (l > (n-l)) {
            return nums;
        }
        swapHelper(nums, l, n-l);
        return reverseRecOpt(nums, ++l, n);
    }

    public static boolean pallindrome(int[] nums,int l,int n){
        if(l>(n-l)){
            return true;
        }
        if(nums[l]!=nums[n-l]) return false;
        return pallindrome(nums,++l,n);
    }
}

public class Backtrack {
    public static void main(String[] args) {
        BasicRecursion.print1ToNRec(9, 1);
        System.out.println();
        BasicRecursion.printNTo1Rec(9);
        System.out.println();
        BasicRecursion.print1ToNBackTrack(9);
        System.out.println();
        BasicRecursion.printNTo1BackTrack(9, 1);
        System.out.println();
        BasicRecursion.sumOfNParam(9, 0);
        System.out.println();
        System.out.println(BasicRecursion.sumOfNFunctional(9));
        System.out.println();
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] res = BasicRecursion.reverseRec(arr, 0, arr.length - 1);
        displayArrHelper(res);
        int[] arr1={56,78,89,90};
        int[] res1=BasicRecursion.reverseRecOpt(arr1,0,arr1.length-1);
        displayArrHelper(res1);
        int[] arr2={7,8,8,8,7};
        System.out.println(BasicRecursion.pallindrome(arr2,0,arr2.length-1));
    }
}