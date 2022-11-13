import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Reverse r = new Reverse();
        int[] res1 = r.reverse(arr, arr.length);
        r.display(res1);

        MaxMin m = new MaxMin();
        int[] res2 = m.maxmin(arr, arr.length);
        m.display(res2);

        //int arr1[]={7,10,4,3,20,15};
        //KthLargest k=new KthLargest();
        //k.kthmax(arr1,6,3);


        int[] arr2 = {1, 0, 0};
        Sort012 st = new Sort012();
        int[] res3 = st.sort(arr2, arr2.length);
        st.display(res3);

        int[] arr3 = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        MoveNegToBegin mv = new MoveNegToBegin();
        int[] res4 = mv.moveIt(arr3, arr3.length);
        mv.display(res4);

        int[] arr4 = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        MoveNegToBeginOrderMatters mvn = new MoveNegToBeginOrderMatters();
        int[] res5 = mvn.reArrangePosNeg(arr4, arr4.length);
        mvn.display(res5);


        int[] arr5 = {2, 3, 1, 2, 3};
        MultiDuplicates md = new MultiDuplicates();
        ArrayList<Integer> res6 = md.duplicates(arr5, arr5.length);
        md.displayArr(res6);

        int[] arr6={8,4,2,1};
        CountInversion ci=new CountInversion();
        System.out.println(ci.inversion(arr6, arr6.length));

        int[] arr8={-2, -3, 4, -1, -2, 1, 5, -3};
        Kadane kd=new Kadane();
        System.out.println(kd.largestSumContiguousSubarray(arr8));


        int[] arr10={-1,0,1,2,-1,-4};
        ThreeSum tsm=new ThreeSum();
        List<List<Integer>> res=tsm.threeSum(arr10);
        tsm.displayListOfList(res);


        int[] arr11={1,2,3,4,5};
        Rotate rt=new Rotate();
        int[] res7=rt.rotate(arr11,2);
        rt.display(res7);


        int[] arr12={1, 3, 2, 3, 3,9, 4, 5, 5, 6 ,8,8};
        int[] arr13={3,3,5,6,7,6,7,9};
        UnionAndIntersection us=new UnionAndIntersection();
        ArrayList<Integer> res8=us.interSection(arr12,arr13);
        ArrayList<Integer> res9=us.union(arr12,arr13);
        us.displayArr(res8);
        us.displayArr(res9);


        int[] arr14={1 ,4 , 3 ,7 , 1 , 2 , 6 ,7, 6, 10};
        MinJumps mj=new MinJumps();
        System.out.println(mj.minJumps(arr14));

    }
}