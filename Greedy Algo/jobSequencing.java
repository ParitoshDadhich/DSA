class Solution
{
 
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job a, Job b){
                if(b.profit > a.profit)
                    return 1;
                else if(b.profit < a.profit)
                    return -1;
                else
                    return 0;
            } 
        });
        
   
        // 3 1 40
        // 4 1 30
        // 1 4 20
        // 2 1 10
         
        // array for storing all profits
        int ans[] = new int[n];
        int job = 0;
        int profit = 0;
        
        for(int i=0; i<ans.length; i++){
            for(int j= Math.min(n, arr[i].deadline); j>=1; j--){    // second loop for back traversing in the ans array;
                if(ans[j-1] == 0){
                    ans[j-1] = 1;
                    profit += arr[i].profit;
                    job++;
                    break;
                }
            }
        }
        
        ans = new int[2];
        ans[0] = job;
        ans[1] = profit;
        
        
        return ans;
    }
}
