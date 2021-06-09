// VARIANT OF NEXT SMALLER ELEMENT
// LEETCODE 1475



// method 1
// brute force 
// time o(n2) && space o(1)

class Solution {
    public int[] finalPrices(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        int j = 0;
        for(int i=0; i<n; i++){
            for(j=i+1; j<n; j++){
                if(arr[j] <= arr[i])
                    break;
            }
            if(j <n && arr[i] >= arr[j])
                ans[i] = arr[i] - arr[j];
            else
                ans[i] = arr[i];
        }
        
        return ans;
    }
}





// method 2
// using stack
// time o(n) && space o(n)

class Solution {
    public int[] finalPrices(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        int pseudoValue = 0;
        
        int k = n-1;
        for(int i=n-1; i>=0; i--){
            if(st.size() == 0)
                ans[k--] = arr[i];
            
            else if(st.size() > 0 && st.peek() < arr[i])
                ans[k--] = arr[i] - st.peek();
            else if(st.size() > 0 && st.peek() >= arr[i]){
                while(st.size() > 0 && st.peek() > arr[i])
                    st.pop();
                
                if(st.size() == 0)
                    ans[k--] = arr[i];
                else
                    ans[k--] = arr[i] - st.peek();
            }
            st.add(arr[i]);
        }
        
        return ans;
    }
}
