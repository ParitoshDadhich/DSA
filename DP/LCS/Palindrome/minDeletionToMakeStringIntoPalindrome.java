class Solution{
    static int minimumNumberOfDeletions(String str1) {
        int len = str1.length();
        String str2 = "";
        for(int i=len-1; i>=0; i--)
            str2 += str1.charAt(i);
        
        // length of lps = lcs(str1, str2);
        
        int lpsLength = lcs(str1, str2);
        return  len - lpsLength;
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
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        
        return t[n][m];
        
    }
    
}
