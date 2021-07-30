class Solution{
    
    
    public static void rearrange(int arr[], int n){
        
        int maxIndex = n-1;
        int minIndex = 0;
        
        int me = arr[n-1] + 1;
        
        for(int i=0; i<n; i++){
            if(i%2 == 0){
                arr[i] = arr[i] + (arr[maxIndex]%me)*me;
                maxIndex--;
            } else{
                arr[i] = arr[i] + (arr[minIndex]%me)*me;
                minIndex++;
            }
        }
        
        
        // to get the original array
        for(int i=0; i<n; i++)
            arr[i] = arr[i]/me;
    
    /*        
        // to get the original one
        for(int i=0; i<n; i++)
            arr[i] = arr[i]%me;
    */
        
    }
    
}
