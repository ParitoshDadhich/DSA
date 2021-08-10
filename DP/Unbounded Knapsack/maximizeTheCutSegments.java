class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       int size = n; 
       n = 3;    // denoting the count of cuts which we can do ,  like x, y and z total -> 3
       int arr[] = new int[3];
       arr[0] = x;
       arr[1] = y;
       arr[2] = z;
       
       int t[][] = new int[n+1][size+1];
       
       for(int i=0; i<=n; i++){
           for(int j=0; j<=size; j++){
               if(i == 0 || j == 0){
                    if(i == 0)
                        t[i][j] = Integer.MIN_VALUE;
                    else if(j == 0)
                        t[i][j] = 0;
               }
               else if(arr[i-1] <= j)
                    t[i][j] = Math.max(1+t[i][j-arr[i-1]], t[i-1][j]);
               else
                t[i][j] = t[i-1][j];
           }
       }
       
       return t[n][size] <0?0:t[n][size];
    }
}
