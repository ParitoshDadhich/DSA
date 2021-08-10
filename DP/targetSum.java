 
class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        
        if(arr.length == 1)
            if(arr[0] < target)
                return 0;
    
        
        int n = arr.length;
        int sum = 0;
        int zero = 0;
        for(int i: arr){
            sum += i;
            if(i == 0)
                zero++;
        }
        
        if(target > sum)
            return 0;
        else if((target+sum)%2 != 0)
            return 0;
        
        int key = (sum + target)/2;
        int t[][] = new int[n+1][key+1]; 
        
        for(int i=0; i<n+1; i++)
            t[i][0] = 1;
        
        for(int i=1; i<key+1; i++)
            t[0][i] = 0;
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<key+1; j++){
                
                if(arr[i-1] == 0)
                    t[i][j] = t[i-1][j];
                else if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        
        return (int)Math.pow(2, zero)*t[n][key];
    }
}
