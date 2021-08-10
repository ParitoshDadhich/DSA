// method 1
// recursive


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        if(n == 0 || W == 0)
            return 0;
        
        if(wt[n-1] <= W){
            return Math.max(val[n-1]+ knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
        } else
            return knapSack(W, wt, val, n-1);
    } 
}


// method 2
// memoization

class Solution 
{ 
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
        int t[][] = new int[n+1][w+1];
        for(int i=0; i<n+1; i++)
            for(int j=0; j<w+1; j++)
                t[i][j] = -1;
                
        return helper(w, wt, val, n, t);
    } 
    
    static int helper(int w, int wt[], int val[], int n, int t[][]){
        if(n == 0 || w == 0)
            return 0;
        
        if(t[n][w] != -1)
            return t[n][w];
        
        // including 
        if(wt[n-1] <= w)
            t[n][w] = Math.max(val[n-1] + helper(w-wt[n-1], wt, val, n-1, t),
                                helper(w, wt, val, n-1, t));
        
        // not including
        else if(wt[n-1] > w)
            t[n][w] = helper(w, wt, val, n-1, t);
            
    
        return t[n][w];
    }
    
}


// method 3 tabular form

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int t[][] = new int[n+1][W+1];
         
         for(int i=0; i<n+1; i++)
            for(int j=0; j<W+1; j++)
                t[i][j] = 0;
                
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                if(wt[i-1] <= j)
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        
        return t[n][W];
    } 
}
