class Solution
{
    // This is called bubble sort because max elements comes up at the top just like a bubble
    
    // Repeately swap two adajcent elements when they are in wrong order
    // for N numbers we do N-1 iterations before we get our sorted array
    //1st iteration -> n-1 checks
    // 2nd iteration -> n-2 checks
    // 3rd iteration -> n-3 checks
    // so on....
    // ith iteration -> n-i checks
	public static void bubbleSort(int arr[], int n)
    {
        int counter = 1;
        while(counter < n){
            for(int i=0; i<n-counter; i++){
                if(arr[i] > arr[i+1])
                    swap(arr, i, i+1);
            }
            counter++;
        }
    }
    
    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
