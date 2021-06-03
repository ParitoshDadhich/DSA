class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 1;
 
        for(j=1; j<n; j++){
            if(arr[i] != arr[j])
                arr[++i] = arr[j];
        }
        
        
        return i+1;
    }
}
