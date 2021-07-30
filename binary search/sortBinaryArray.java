class Solution {
    public int findExtra(int a[], int b[], int n) {
        int left = 0;
        int right = n-1;
        int ans = -1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            
        // If middle element is same 
        // of both arrays, it means 
        // that extra element is after 
        // mid so we update left to mid+1
            if(mid < b.length && a[mid] == b[mid])
                left = mid + 1;
                
        // If middle element is different 
        // of the arrays, it means that 
        // the index we are searching for 
        // is either mid, or before mid. 
        // Hence we update right to mid-1.    
            else{
                ans = mid;
                right = mid-1;
            }
        }
        
        return ans;
    }
}
