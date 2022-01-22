// method 1
// time o(n2), space o(1)


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        long ans[] = new long[n-k+1];
        
        int t=0;
        for(int i=0; i<n-k+1; i++){
            boolean flag = true;
            for(int j=i; j<i+k; j++){
                if(flag && arr[j]<0){
                    ans[t++] = arr[j];
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans[t++] = 0;
        }
        
        return ans;
    }
}

// method 2
// time o(n), space o(1)

class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        long ans[] = new long[n-k+1];
        Queue<Long> queue = new LinkedList<>();
        
        int i=0, j=0, t=0;
        long nonNeg = 0;
        while(j<n){
            // calculation part
            if(arr[j] < nonNeg)
                queue.add(arr[j]);
            
            // attaining window size of k
            if(j-i+1 < k)
                j++;
            
            else if(j-i+1 == k){
                // finding answer from the calculation;
                if(queue.size() == 0)
                    ans[t++] = 0;
                else
                    ans[t++] = queue.peek();
                if(queue.size() != 0 && arr[i] == queue.peek()){
                    queue.poll();
                }
                
                // slide the window
                i++;
                j++;
            }
        }
         
        return ans;
    }
}

