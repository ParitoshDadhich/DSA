// method 1
// recursive soltuion
// time o(2^N) and space o(1)


class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        int i = 1;
        int j = n-1;
        
        return helper(arr, i, j);
    }
    
    private static int helper(int arr[], int i, int j){
        if(i >= j)
            return 0;
            
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int tempAns = helper(arr, i, k) + helper(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            
            if(tempAns < ans)
                ans = tempAns;
        }
        
        return ans;
    }
    
}



// method 2
// memoized approach
// time o(n^3) and space o(n^2)



lass Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        int t[][] = new int[n][n];
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                t[i][j] = -1;
        
        return helper(arr, 1, n-1, t);
    }
    
    private static int helper(int arr[], int i, int j, int t[][]){
        if(i>=j)
            return 0;
        
        if(t[i][j] != -1)
            return t[i][j];
            
        int min = Integer.MAX_VALUE;    
        for(int k=i; k<=j-1; k++){
            int tempAns = helper(arr, i, k, t) + helper(arr, k+1, j, t) + arr[i-1]*arr[k]*arr[j];
            
            if(min > tempAns)
                min = tempAns;
        }
        
        return t[i][j] = min;
    }
    
}
