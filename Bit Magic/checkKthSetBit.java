
class CheckBit
{
    // using left shift operator
    static boolean checkKthBit(int n, int k)
    {
        return (n & (1 << k)) != 0;
    }
    
    
    
    // using right shift operator
    static boolean checkKthBit(int n, int k)
    {
        return (((n>>k) & 1) != 0);
    }
    
    
    
}
