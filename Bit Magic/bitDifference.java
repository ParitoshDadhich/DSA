class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        
        int count = 0;
        while(a>0 || b>0){
            if((a&1) == 1 || (b&1) == 1)
                count++;
            
            if((a&1) == 1 && (b&1) == 1)
                count--;
            
            a = a>>1;
            b = b>>1;
        }
        return count;
    }
    
    
}
