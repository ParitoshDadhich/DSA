class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        int t[][] = new int[n+1][w+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
                else if(wt[i-1] <= j)
                    t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]], t[i-1][j]);
                else 
                    t[i][j] = t[i-1][j];
            }
        }
        
        return t[n][w];
    }
}
