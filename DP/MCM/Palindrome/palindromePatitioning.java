// method 1
// recursive solution
// time o(2^N) and space o(1)

class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();
        int i = 0;
        int j = n - 1;
        
        return helper(str, i, j);
    }
    
    private static int helper(String str, int i, int j){
        // base case
        if(i >= j)
            return 0;
        if(isPalindrome(str, i, j))
            return 0;
            
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int tempAns = 1 + helper(str, i, k) + helper(str, k+1, j);
            
            if(ans > tempAns)
                ans = tempAns;
        }  
        return ans;
    }
    
    
    private static boolean isPalindrome(String str, int i, int j){
        
        if(i == j)
            return true;
        
        if(i>j || str.charAt(i) != str.charAt(j))
            return false;
        
        if(i + 1 < j)
            return isPalindrome(str, i+1, j-1);
            
        return true;
    }
    
}


// method 2
// memoization
// time o(n2) and space o(n2)

class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();
        
        int t[][] = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                t[i][j] = -1;
        
        return helper(str, 0, n-1, t);
    }
    
    private static int helper(String str, int i, int j, int t[][]){
        // base case
        if(i >= j)
            return 0;
        if(isPalindrome(str, i, j))
            return 0;
            
        if(t[i][j] != -1)
            return t[i][j];
            
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int tempAns = 1 + helper(str, i, k, t) + helper(str, k+1, j, t);
            
            if(ans > tempAns)
                ans = tempAns;
        }  
        return t[i][j] = ans;
    }
    
    
    private static boolean isPalindrome(String str, int i, int j){
        
        if(i == j)
            return true;
        
        if(i>j || str.charAt(i) != str.charAt(j))
            return false;
        
        if(i + 1 < j)
            return isPalindrome(str, i+1, j-1);
            
        return true;
    }
    
}


// method 3
// optimized memoized
// here we check recursive sub calls also

class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();
        int t[][] = new int[n][n];
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                t[i][j] = -1;
        
        return solve(str, 0, n-1, t);
    }
    
    private static int solve(String str, int i, int j, int t[][]){
        if(i>=j)
            return 0;
        if(isPalindrome(str, i, j))
            return 0;
            
        if(t[i][j] != -1)
            return t[i][j];
         
        int left = -1;
        int right = -1;
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            // checking for solve(i, k)
            if(t[i][k] != -1)
                left = t[i][k];
            else{
                left = solve(str, i, k, t);
                t[i][k] = left;
            }
            
            // checking for solve(k+1, j)
            if(t[k+1][j] != -1)
                right = t[k+1][j];
            else{
                right = solve(str, k+1, j, t);
                t[k+1][j] = right;
            }
            
            // int tempAns = 1 + helper(str, i, k, t) + helper(str, k+1, j, t);
            int tempAns = 1 + left + right;
            if(ans > tempAns)
                ans = tempAns;
        }
        
        return t[i][j] = ans;
    }
    
    
    private static boolean isPalindrome(String s, int i, int j){
        if(i == j)
            return true;
        
        if(s.charAt(i) != s.charAt(j))
            return false;
            
        if(i+1 < j)
            return isPalindrome(s, i+1, j-1);
        
        return true;
    }
    
}


