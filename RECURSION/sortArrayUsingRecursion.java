class Solution 
{ 
    int[] sortArr(int[] arr, int n) 
    { 
        sort(arr, n);
        return arr;
    }
    
    private static void sort(int arr[], int n){
        if(n == 1)
            return;
        
        int val = arr[n-1];
        
        sort(arr, n-1);
        insert(arr, val, n-1);
    }
    
    private static void insert(int arr[], int val, int n){
        if(n == 0 || arr[n-1] <= val){
            arr[n] = val;
            return;
        }
        
        int temp = arr[n-1];

        insert(arr, val, n-1);
        
        arr[n] = temp;
        return;
    }
    
} 
