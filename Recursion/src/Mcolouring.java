import java.util.Arrays;
import java.util.Scanner;

class Solve {
    public static boolean isPossible(boolean[][] graph,int[] colors,int color,int node,int n){
        for(int col=0;col<n;col++){
            if(graph[node][col]==true){
                if(colors[col]==color) return false;
            }
        }
        return true;
    }

    public static boolean solve(boolean graph[][],int[] colors,int node,int m,int n){
        if(node==n) return true;

        for(int i=1;i<=m;i++){
            if(isPossible(graph,colors,i,node,n)){
                colors[node]=i;
                if(solve(graph,colors,node+1,m,n)==true) return true;
                else{
                    colors[node]=0;
                }
            }
        }
        return false;
    }


    public static boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colors=new int[n];
        Arrays.fill(colors,0);

        boolean res= solve(graph,colors,0,m,n);

        System.out.println("Printing the color sequence ----->");
        for(int i=0;i<n;i++){
            System.out.print("--->"+colors[i]);
        }
        System.out.println();
        return res;
    }
}

public class Mcolouring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCases= sc.nextInt();

        while(testCases-->0){
            int n= sc.nextInt();//#Nodes
            int m= sc.nextInt();//#colors
            int e=sc.nextInt();//#edges

            boolean[][] graph=new boolean[n][n];

            // Building the adjacency matrix to represent the connected  edges present bween node
            for(int i=0;i<e;i++){
                int u= sc.nextInt()-1;// Node1
                int v= sc.nextInt()-1;// Node2
                graph[u][v]=true;// give it true on both u->v & v->u
                graph[v][u]=true;// denoting edge exists between the node 1 & 2
            }
            System.out.println(new Solve().graphColoring(graph,m,n)? "Yes the graph can be coloured": "No graph cant be coloured");
        }
    }
}
// Tc -> O(N^m)   for every nodes N we are trying m colors
// Sc-> O(#nodes)