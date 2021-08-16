// Insert an element from an unsorted array to its correct position in sorted array

// Here we start with index 1, assuming element with index 0 is already sorted.

class Solution
{
  public void insertionSort(int arr[], int n)
  {
      for(int i=1; i<n; i++){
          int currentElement = arr[i];
          int j = i - 1;
          while(j >=0 && arr[j] > currentElement){
              arr[j+1] = arr[j];
              j--;
          }
          arr[j+1] = currentElement;
      }
  }
}
