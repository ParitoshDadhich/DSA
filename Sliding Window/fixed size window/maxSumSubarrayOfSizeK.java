// method 1
// time o(n2), space o(1)

class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N-K+1; i++){
            int sum = 0;
            for(int j=i; j<i+K; j++){
                sum += Arr.get(j);
            }
            max = Math.max(sum, max);
        }
        
        return max;
    }
}

// method 2
// time o(n), space o(1)

class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i=0, j=0;
        while(j<n){
            // adding all the elements
            sum += arr.get(j);
            
            // attaining window size
            if(j-i+1 < k)
                j++;
                
            else if(j-i+1 == k){
                max = Math.max(max, sum);
                // removing element at ith index
                sum -= arr.get(i);
                // slide the window by one step forward
                i++;
                j++;
            }
            
        }
        
        return max;
    }
}
