package prog_706_designHashmap;

class Try {
    static int knapSack(int maxVal, int weight[], int profit[], int n)
    {
        int[][] bag = new int[n + 1][maxVal + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxVal; j++) {
                if (i == 0 || j == 0)
                    bag[i][j] = 0;
                else if (j < weight[i-1])
                    bag[i][j] = bag[i - 1][j];
                else
                    bag[i][j] = Math.max(
                            bag[i - 1][j],
                            profit[i - 1] + bag[i - 1][j - weight[i - 1]]
                    );
            }
        }

        return bag[n][maxVal];
    }

    // Driver Code
    public static void main(String[] args)
    {
        int profit[] = { 1, 2, 3 };
        int weight[] = { 4, 5, 1 };
        int W = 4;
        int n = profit.length;

        System.out.print(knapSack(W, weight, profit, n));
    }
}
