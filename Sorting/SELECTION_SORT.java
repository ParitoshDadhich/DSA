// Find the min element from the sorted array and swap it with the element at the 
// begining of the array

class Solution
{ 
	void selectionSort(int arr[], int n)
	{
	    for(int i=0; i<n-1; i++){
	        for(int j=i+1; j<n; j++){
	            if(arr[j] < arr[i]){
	                int temp = arr[j];
	                arr[j] = arr[i];
	                arr[i] = temp;
	            }
	        }
	    }
	}
}
