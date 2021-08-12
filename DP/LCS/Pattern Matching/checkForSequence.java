// method 1
// using LCS
// time o(n2) and space o(n2)

class Solution{
    boolean isSubSequence(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        
        int t[][] = new int[n+1][m+1];
        
        for(int i=0; i<=n; i++)
            for(int j=0; j<=m; j++)
                t[i][j] = -1;
        
        int val = lcs(str1, str2, n, m, t);
        // System.out.println(val);
        return val == n;
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
  
  
// method 2
// using two pointers
// time o(n) and space o(1)

class Solution{
    boolean isSubSequence(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        
        int i=0, j=0;
        int count = 0;
        while(i<n && j<m){
            if(str1.charAt(i) == str2.charAt(j)){
                count++;
                i++;
            }
            j++;
        }
        
        return count == n;
    }
}
