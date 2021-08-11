// method 1
// recursive solution
// time o(2^N) and Aux space o(1)
class Solution
{
    static int lcs(int x, int y, String s1, String s2)
    {
        if(x == 0 || y == 0)
            return 0;
            
        if(s1.charAt(x-1) == s2.charAt(y-1))
            return 1 + lcs(x-1, y-1, s1, s2);
        else{
            return Math.max(lcs(x, y-1, s1, s2), lcs(x-1, y, s1, s2));
        }
    }
    
}


// method 2
// memoization
// time o(n2) and space o(n2)


class Solution
{
    static int lcs(int x, int y, String s1, String s2)
    {
        int t[][] = new int[x+1][y+1];
        for(int i=0; i<=x; i++)
            for(int j=0; j<=y; j++)
                t[i][j] = -1;
        
        return lcs(x, y, s1, s2, t);
    }
    
    private static int lcs(int x, int y, String s1, String s2, int t[][]){
        if(x == 0 || y == 0)
            return 0;
            
        if(t[x][y] != -1)
            return t[x][y];
            
        if(s1.charAt(x-1) == s2.charAt(y-1))
            return t[x][y] = 1 + lcs(x-1, y-1, s1, s2, t);
        else{
            return t[x][y] = Math.max(lcs(x-1, y, s1, s2, t), lcs(x, y-1, s1, s2, t));
        }
    }
    
}


// tabulation
// time o(n2) and space o(n2)

class Solution
{
    static int lcs(int x, int y, String s1, String s2)
    {
        int t[][] = new int[x+1][y+1];
        
        for(int i=0; i<=x; i++){
            for(int j=0; j<=y; j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
        
        return t[x][y];
    }
    
}




