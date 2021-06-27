
// brute force

    int plat_needed = 1, result = 1;

    // run a nested  loop to find overlap
    for (int i = 0; i < n; i++) {
        // minimum platform
        plat_needed = 1;

        for (int j = i + 1; j < n; j++) {
            // check for overlap
            if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i]))
                plat_needed++;
        }

        // update result
        result = Math.max(result, plat_needed);
    }

    return result;



// method 2;

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 1, j = 0;
        
        int platform_needed = 1;
        int res = 0;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                platform_needed++;
                i++;
            } else if(arr[i] > dep[j]){
                platform_needed--;
                j++;
            }
            
            if(platform_needed > res)
                res = platform_needed;
        }
        
        return res;
    }
    
}

