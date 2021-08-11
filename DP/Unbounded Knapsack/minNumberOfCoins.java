class Solution {
    public int coinChange(int[] coins, int amount) {
        int sum = amount;
        int n = coins.length;
        int t[][] = new int[n+1][sum+1];
        
        // initialization first row and column
        for(int i=0; i<=sum; i++)
            t[0][i] = Integer.MAX_VALUE - 1;
        for(int j=1; j<=n; j++)
            t[j][0] = 0;
        
        
        // initialize second row
        for(int j=1; j<=sum; j++){
            if(j%coins[0] == 0)
                t[1][j] = coins[0]/j;
            else
                t[1][j] = Integer.MAX_VALUE-1;
        }
        
        // logic
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(coins[i-1] <= j)
                    t[i][j] = Math.min(1 + t[i][j-coins[i-1]], t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        
        return t[n][sum] != Integer.MAX_VALUE-1 ? t[n][sum] : -1;
    }
}
