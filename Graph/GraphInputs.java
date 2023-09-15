import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class PairV {
    private int v;
    private int weight;

    PairV(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PairV{" +
                "v=" + v +
                ", weight=" + weight +
                '}';
    }
}

class Input {

    //lost of wastage
    public static void takeInputNoobWay(int[][] matrix,int n) {
        //edges and vertices (1 based indexing)
        int m=matrix.length;
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = matrix[i][0];
            int v = matrix[i][1];
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }

        //display
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //better
    public static void takeInputBetterWay(int[][] matix, int n) {
        Scanner sc = new Scanner(System.in);
        //edges & vertices (1 based indexing)
        int m = matix.length;
        List<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = matix[i][0];
            int v = matix[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for (int i = 0; i <= n; i++) {
            if(i==0) continue;
            System.out.print(i + "--> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void takeInputForWeightedGraph(int[][] matrix, int nodes) {
        Scanner sc = new Scanner(System.in);

        //edges & vertices (1 based indexing)
        int m = matrix.length;
        List<List<PairV>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i <m; i++) {
            int u = matrix[i][0];
            int v = matrix[i][1];
            int w = matrix[i][2];
            PairV p = new PairV(u, w);
            PairV p1 = new PairV(v, w);
            adjList.get(u).add(p1);
            adjList.get(v).add(p);
        }

        //display
        for (int i = 0; i < m; i++) {
            if(i==0) continue;
            System.out.print(i+"---> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class GraphInputs {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 5}};
        int[][] matrix1 = {{1, 2, 9}, {1, 3, 6}, {2, 4, 18}, {3, 4, 7}, {3, 5, 1}, {4, 5, 12}};
        Input.takeInputNoobWay(matrix,5);
        Input.takeInputBetterWay(matrix, 5);
        Input.takeInputForWeightedGraph(matrix1, 5);
    }
}
