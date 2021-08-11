class Solution
{
    public static int shortestCommonSupersequence(String s1,String s2,int m,int n)
    {
        int t[][] = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
        
        int max = -1;
        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++)
                if(max < t[i][j])
                    max = t[i][j];
        
        return m + n - max;
    }
}
