class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;
        
        int l = 0, r = n-1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        
        while(l <= r){
            if(arr[l] <= arr[r]){
                if(arr[l] >= leftMax)
                    leftMax = arr[l];
                else
                    ans += leftMax - arr[l];
                
                l++;
            }
            else{
                if(arr[r] >= rightMax)
                    rightMax = arr[r];
                else
                    ans += rightMax - arr[r];
                
                r--;
            }
        }
        
        return ans;
    }
}
