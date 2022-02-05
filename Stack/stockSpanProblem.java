class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int arr[], int n)
    {
        Stack <int []> st = new Stack<>();
        
        int ans[] = new int[n];
        int k = 0;
        
        for(int i=0; i<n; i++){
            if(st.size() == 0)
                ans[k++] = -1;
                
            else if(st.size()>0 && st.peek()[0] > arr[i])
                ans[k++] = st.peek()[1];
            
            else if(st.size()>0 && st.peek()[0] <= arr[i]){
                while(st.size()>0 && st.peek()[0] <= arr[i])
                    st.pop();
                
                if(st.size() == 0)
                    ans[k++] = -1;
                else 
                    ans[k++] = st.peek()[1];
            }
            
            st.add(new int[]{arr[i], i});
        }
        
        for(int i=0; i<n; i++)
            ans[i] = i - ans[i];
            
        return ans;
    }
    
}
