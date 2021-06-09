class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int nsr[] = new int[n];     // nearest samller to right
        int nsl[] = new int[n];     // nearest smaller to left
        int wt[] = new int[n];      // widht array;
        int area[] = new int[n];    // area array;
        Stack<int []> st = new Stack<>();
     
        // finding nearest samller to right indices;
        nearestSmallerRight(arr, nsr, st);
        // finding nearest smaller to left indices;
        st.clear();
        nearestSmallerLeft(arr, nsl, st);
        
        
        // finding width of each building;
        for(int i=0; i<n; i++)
            wt[i] = nsr[i] - nsl[i] - 1;
        
        // finding area
        for(int i=0; i<n; i++)
            area[i] = arr[i] * wt[i];
        
        // finding the max area of histogram;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            if(max < area[i])
                max = area[i];
        
        return max;
        
    }
    
    
    private void nearestSmallerRight(int arr[], int nsr[], Stack<int []> st){
        int k = 0;
        int n = arr.length;
        int pseudoIndex = n;
        for(int i=n-1; i>=0; i--){
            if(st.size() == 0)
                nsr[k++] = pseudoIndex;
            
            else if(st.size()>0 && st.peek()[0]<arr[i])
                nsr[k++] = st.peek()[1];
            
            else if(st.size()>0 && st.peek()[0]>=arr[i]){
                while(st.size()>0 && st.peek()[0]>=arr[i])
                    st.pop();
                
                if(st.size() == 0)
                    nsr[k++] = pseudoIndex;
                else
                    nsr[k++] = st.peek()[1];
            }
            
            st.push(new int[]{arr[i], i});
        }
        
        // reverseing nsr
        for(int i=0, j=n-1; i<j; i++,j--){
            int t = nsr[i];
            nsr[i] = nsr[j];
            nsr[j] = t;
        }
    }
    
    
    private void nearestSmallerLeft(int arr[], int nsl[], Stack<int []> st){
        int k = 0;
        int n = arr.length;
        int pseudoIndex = -1;
        for(int i=0; i<n; i++){
            if(st.size() == 0)
                nsl[k++] = pseudoIndex;
            
            else if(st.size()>0 && st.peek()[0]<arr[i])
                nsl[k++] = st.peek()[1];
            
            else if(st.size()>0 && st.peek()[0]>=arr[i]){
                while(st.size()>0 && st.peek()[0]>=arr[i])
                    st.pop();
                
                if(st.size() == 0)
                    nsl[k++] = pseudoIndex;
                else 
                    nsl[k++] = st.peek()[1];
            }
            
            st.push(new int[]{arr[i], i});
        }
    }
    
}
