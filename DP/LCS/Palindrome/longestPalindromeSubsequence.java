class Solution
{
    public int longestPalinSubseq(String str1)
    {
        String str2 =  "";
        int len = str1.length();
        for(int i=len-1; i>=0; i--)
            str2 += str1.charAt(i);
            
        return lcs(str1, str2);
    }
    
    private static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        
        int t[][] = new int[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i==0 || j==0)
                    t[i][j] = 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else 
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
        
        return t[n][m];
    }
    
}
