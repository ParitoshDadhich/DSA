
class Solution 
{ 
	static int[] SortBinaryArray(int arr[], int n) 
	{ 
	    int i=-1;
        int pivot = 0;
        
	    for(int j=0; j<n; j++){
	        if(arr[j] <= pivot){
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    
	    return arr;
	} 
	
	private static void swap(int arr[], int i, int j){
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
} 
