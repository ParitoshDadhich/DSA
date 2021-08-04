class Solution {
    public int minFlips(int a, int b, int c) {
        int totalCount = 0;
        
        for(int i=0; i<32; i++){
            int x = a & (1<<i);
            int y = b & (1<<i);
            int z = c & (1<<i);
            
            // if x & y both are !=0 and z == 0
            if(z==0 && x != 0 && y != 0)
                totalCount+=2;
            // if x !=0 and z = 0, z = 0
            else if(z==0 && x !=0 && y == 0)
                totalCount++;
            // x = 0 and y !=0, z = 0;
            else if(z==0 && x==0 && y!=0)
                totalCount++;
            // x and y both are =0, z != 0
            else if(z!=0 && x == 0 && y == 0)
                totalCount++;
        }
        
        return totalCount;
    }
}
