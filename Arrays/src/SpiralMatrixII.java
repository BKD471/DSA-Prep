public class SpiralMatrixII {

    public int[][] SpMtxII(int n) {

        int[][] res = new int[n][n];
        if (n == 0) return res;

        int begRow = 0, endRow = n - 1;
        int begCol = 0, endCol = n - 1;
        int dir = 0, maxDir = 4;

        int num = 1;
        while (begRow <= endRow && begCol <= endCol) {

            dir = dir % maxDir;
            if (dir == 0) {
                for (int i = begCol; i <= endCol; i++) {
                    res[begRow][i] = num;
                    num++;
                }
                begRow++;
            }

            if (dir == 1) {
                for (int i = begRow; i <= endRow; i++) {
                    res[i][endCol] = num;
                    num++;
                }
                endCol--;
            }


            if (dir == 2) {
                for (int i = endCol; i >= begCol; i--) {
                    res[endRow][i] = num;
                    num++;
                }
                endRow--;
            }

            if (dir == 3) {
                for (int i = endRow; i >= begRow; i--) {
                    res[i][begCol] = num;
                    num++;
                }
                begCol++;
            }

            dir++;
        }

        return res;
    }
}
