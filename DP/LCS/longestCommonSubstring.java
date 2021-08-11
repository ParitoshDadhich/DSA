// tabulation
// time o(n2) and space o(n2)
class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        int t[][] = new int[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
                
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else 
                    t[i][j] = 0;
            }
        }
        
        int max = -1;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++)
                if(t[i][j] > max)
                    max = t[i][j];
        }
        
        return max;
    }
}


// memoized code
// time o(n2) and space o(n2)

class Solution{
    int longestCommonSubstr(String s1, String s2, int x, int y){
        
        int t[][] = new int[x+1][y+1];
        for(int i=0; i<=x; i++)
            for(int j=0; j<=y; j++)
                t[i][j] = -1;
        
        helper(x, y, s1, s2, t);
        
        int max = -1;
        for(int i=0; i<=x; i++)
            for(int j=0; j<=y; j++)
                if(max < t[i][j])
                    max = t[i][j];
                    
        return max;
    }
    
    private static int helper(int x, int y, String s1, String s2, int t[][]){
        if(x == 0 || y == 0)
            return 0;
        
        if(t[x][y] != -1)
            return t[x][y];
        
        helper(x-1, y, s1, s2, t);
        helper(x, y-1, s1, s2, t);    
        
        if(s1.charAt(x-1) == s2.charAt(y-1))
            return t[x][y] = 1 + helper(x-1, y-1, s1, s2, t);
            
        return t[x][y] = 0;
        
    }
    
}

