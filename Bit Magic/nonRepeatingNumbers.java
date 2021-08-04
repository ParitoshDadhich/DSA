class Solution
{
    public int[] singleNumber(int[] arr)
    {
        int n = arr.length;
        int res = 0;
        for(int i: arr)
            res ^= i;
        
        int set = res & ~(res-1);
        int gp1=0, gp2=0;
        
        for(int i=0; i<n; i++)
            if((arr[i]&set) != 0)
                gp1 = gp1 ^ arr[i];
            else
                gp2 = gp2 ^ arr[i];
                
        
        // System.out.println(gp1 + " " + gp2);
        
        int ans[] = {Math.min(gp1, gp2), Math.max(gp1, gp2)};
        return ans;
    }
}
