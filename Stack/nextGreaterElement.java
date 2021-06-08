// method 1
// brute force
// time o(n2) && space o(1)

class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long ans[] = new long[n];
	
	for(int i=0; i<n; i++){
		long max = -1;
		for(int j=i+1; j<n; j++){
	        if(arr[i] < arr[j]){
		        max = arr[j];
		        break;
            }
        }
	    ans[i] =  max;
    }

        return ans;

    } 
}








// method 2
// used stack 
// time o(n) && space o(n)


class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long ans[] = new long[n];
        int k = n-1;
        Stack<Long> st = new Stack<>();
        
        for(int i = n-1; i >= 0 ; i--){
            if(st.size() == 0)
                ans[k--] = -1;
                
            else if(st.size() > 0 && st.peek() > arr[i])
                ans[k--] = st.peek();
                
            else if(st.size() > 0 && st.peek() <= arr[i]){
                while(st.size() > 0 && st.peek() <= arr[i]){
                    st.pop();
                }
                
                if(st.size() == 0)
                    ans[k--] = -1;
                else
                    ans[k--] = st.peek();
            }
            
            st.push(arr[i]);
        }
        
        return ans;
        
    } 
}
