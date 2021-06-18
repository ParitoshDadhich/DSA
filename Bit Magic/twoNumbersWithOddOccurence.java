class Solution
{
    public int[] twoOddNum(int arr[], int n)
    {
        int res1 = 0;
        int res2 = 0;
        int xor = 0;
        
        for(int i: arr)
            xor = xor^i;
        
        int set = xor & ~(xor-1);   // finding the right most set bit;
        
        for(int i=0; i<n; i++){
            if((arr[i] & set) != 0)
                res1 ^= arr[i];
            else
                res2 ^= arr[i];
        }
        
        int ans[] = new int[2];
        ans[0] = Math.max(res1, res2);
        ans[1] = Math.min(res1, res2);
        
        return ans;
        
    }
}
