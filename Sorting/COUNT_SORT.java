// Time o(n)
// space o(max(arr)) -> o(n)

class Solution {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i: arr){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        
        int range = max - min + 1;
        int countArray[] = new int[range];
        int output[] = new int[n];
        
        // find the count of every element from the original array
        /*
            Note:
            Here I am subtracting with min, in order to deal with all -ve values
        */
        for(int i: arr)
            countArray[i-min]++;    
        
        
        // modify the countArray by adding current index value with its previous index vlaues
        for(int i=1; i<range; i++)
            countArray[i] += countArray[i-1];
        
        
        // filling values in output array using original array by traversing it from the end
        for(int i=n-1; i>=0; i--){
            // int val = countArray[arr[i]-min]-1;
            output[countArray[arr[i]-min]-1] = arr[i];
            countArray[arr[i]-min]--;
        }
        
       
        // copying output array to arr
        for(int i=0; i<n; i++)
            arr[i] = output[i];
        
        return arr;
    }
}
