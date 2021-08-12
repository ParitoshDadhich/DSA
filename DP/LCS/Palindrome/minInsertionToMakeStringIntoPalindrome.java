class Solution{
    static int countMin(String str1)
    {
        int n = str1.length();
        String str2 = "";
        
        // reverse str1;
        for(int i=n-1; i>=0; i--)
            str2 += str1.charAt(i);
        
        
        int t[][] = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++)
            for(int j=0; j<=n; j++)
                t[i][j] = -1;
        
        // length of lps -> lcs(str1, reverse(str1))
        // # of deletion = # of insertion
        return n - lcs(str1, str2, n, n, t);
    }
    
    private static int lcs(String str1, String str2, int n, int m, int t[][]){
        if(n == 0 || m == 0)
            return 0;
        
        if(t[n][m] != -1)
            return t[n][m];
            
        if(str1.charAt(n-1) == str2.charAt(m-1))
            return t[n][m] = 1 + lcs(str1, str2, n-1, m-1, t);
        else
            return t[n][m] = Math.max(lcs(str1, str2, n-1, m, t), lcs(str1, str2, n, m-1, t));
    }
    
}
