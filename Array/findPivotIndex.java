class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int sum=0, lSum = 0;
        for(int i: arr)
            sum += i;
        
        // right Sum = sum - arr[i]-lSum
        for(int i=0; i<n; i++){
            if(lSum == sum-arr[i]-lSum)
                return i;
            lSum += arr[i];
        }
        
        return -1;
    }
}
