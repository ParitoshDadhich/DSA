class Solution
{
    public int LongestRepeatingSubsequence(String str1)
    {
        String str2 = str1;
        int n = str1.length();
        int m = n;
        
        int t[][] = new int[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
                else if(i != j && str1.charAt(i-1) == str2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        
        return t[n][m];
    }
}
