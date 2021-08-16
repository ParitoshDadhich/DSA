// method 1
// brute force
// time o(n2) and space o(1)


class Solution
{
    static long inversionCount(long arr[], long n)
    {
        long ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j])
                    ans++;
            }
        }
        
        return ans;
    }
}



// method 2
// using merge sort idea
// time o(nlogn) and space o(n)



