class Solution
{
    public long count(int S[], int m, int n) 
    { 
        int sum = n;
        n = m;
        long t[][] = new long[n+1][sum+1];
        
        for(int i=0; i<=n; i++)
            t[i][0] = 1;
        for(int i=1; i<=sum; i++)
            t[0][i] = 0;
            
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(S[i-1] <= j)
                    t[i][j] = t[i][j-S[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
             }
        }
        
        return t[n][sum];
    } 
}
