class Solution {
    public void sortColors(int[] arr) {
        int l = 0, m = 0, h = arr.length - 1;
        
        while(m<=h)
        {
            if(arr[m] == 0){
                swap(arr, m, l);
                m++;
                l++;
            }
            else if(arr[m] == 1)
                m++;
            else if(arr[m] == 2){
                swap(arr, m, h);
                h--;
            }
        }  
    }
    
    private void swap(int arr[], int m, int n){
        int t = arr[m];
        arr[m] = arr[n];
        arr[n] = t;
    }
}
