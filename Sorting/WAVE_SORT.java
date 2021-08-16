
class Solution{
    
    public static void convertToWave(int arr[], int n){
        for(int i=1; i<n; i+=2){
            if(arr[i] > arr[i-1])
                swap(arr, i, i-1);
            
            if(i <= n-2 && arr[i] > arr[i+1])
                swap(arr, i, i+1);
        }
        
    }
    
    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
