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
}

class Input {

    //lost of wastage
    public static void takeInputNoobWay() {
        Scanner sc = new Scanner(System.in);

        //edges and vertices (1 based indexing)
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] adjMatrix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjMatrix[u][v] = 1;
        }

        //display
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(adjMatrix[i][j] + "");
            }
            System.out.println();
        }

    }

    //better
    public static void takeInputBetterWay() {
        Scanner sc = new Scanner(System.in);

        //edges & vertices (1 based indexing)
        int m = sc.nextInt();
        int n = sc.nextInt();

        List<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= m; i++) adjList.add(new ArrayList<Integer>());

        for (int i = 0; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //display
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void takeInputForWeightedGraph() {
        Scanner sc = new Scanner(System.in);

        //edges & vertices (1 based indexing)
        int m = sc.nextInt();
        int n = sc.nextInt();

        List<List<PairV>> adjList = new ArrayList<>();
        for (int i = 0; i <= m; i++) adjList.add(new ArrayList<PairV>());

        for (int i = 0; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            PairV p = new PairV(u, w);
            PairV p1 = new PairV(v, w);
            adjList.get(u).add(p);
            adjList.get(v).add(p1);
        }

        //display
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

public class GraphInputs {
    public static void main(String[] args) {
        Input.takeInputNoobWay();
        Input.takeInputBetterWay();
        Input.takeInputForWeightedGraph();
    }
}
