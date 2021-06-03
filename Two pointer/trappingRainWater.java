// method 1 
// brute force
// time o(n2) && time o(1)

class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        
        int ans = 0;
        for(int i=1; i<n; i++){
            // find max from left
            int leftMax = Integer.MIN_VALUE;
            for(int j=i; j>=0; j--)
                leftMax = Math.max(leftMax, arr[j]);
            
            // find max from right;
            int rightMax = Integer.MIN_VALUE;
            for(int j=i; j<n; j++)
                rightMax = Math.max(rightMax, arr[j]);
            
            ans += Math.min(rightMax, leftMax) - arr[i];
        }
        
        return ans;
    }
}


// method 2
// by prefix and suffix array
// time o(n) && space o(n)

class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        if(n == 0)
            return 0;
        
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        
        leftMax[0] = arr[0];
        rightMax[n-1] = arr[n-1];
        
        // finding left max
        for(int i=1; i<n; i++)
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        
        // finding right max
        for(int j=n-2; j>=0; j--)
            rightMax[j] = Math.max(arr[j], rightMax[j+1]);
        
        // calculating the total water tapped
        int ans = 0;
        for(int i=0; i<n; i++)
            ans += Math.min(rightMax[i], leftMax[i]) - arr[i];
        
        return ans;
    }
}


// method 3
// two pointer
// space o(1) && time o(n)

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
