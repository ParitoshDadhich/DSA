class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        if(arr == null || n<=1) return;
 
        int i = n-2;
        while(i>=0 && arr[i] >= arr[i+1]) i--;
            
        if(i>=0){
            int j = n-1;
            while(arr[i] >= arr[j]) j--;
            
            swap(arr, i, j);
 
        }
 
        reverse(arr, i+1, n-1);
    }
    
    private void reverse(int arr[], int sI, int eI){
        // for(int i=sI, j=eI; i<eI; i++, j--){
        //     int temp = arr[eI];
        //     arr[eI] = arr[sI];
        //     arr[sI] = temp;
        // }
        while(sI < eI)
            swap(arr, sI++, eI--);
    }
    
    private void swap(int arr[], int sI, int eI){
        int temp = arr[eI];
        arr[eI] = arr[sI];
        arr[sI] = temp;
    }
    
}
