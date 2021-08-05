class Solution
{
    static void quickSort(int arr[], int low, int high)
    {
         if(low < high){
             int pit = partition(arr, low, high);
             quickSort(arr, low, pit-1);
             quickSort(arr, pit+1, high);
         }
    }
    static int partition(int arr[], int low, int high)
    {
        int i = low-1;
        int pivot = arr[high];
        for(int j=low; j<=high; j++){
            
            // swap(arr[i], arr[j])
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        
        // swap(arr[high], swap[i+1])
        swap(arr, high, i+1);
        
        return i+1;
    } 
    
    private static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}
