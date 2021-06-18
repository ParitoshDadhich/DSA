
// method 1


class Solution{
    public static boolean isPowerofTwo(long n){
        
        while(n != 1){
            if(n%2 != 0)
                return false;
            
            n = n/2;
        }
        return true;
    }
    
}



// method 2;

class Solution{
    public static boolean isPowerofTwo(long n){
        
        if(n == 0)
            return false;
            
        while(n != 1){
            if((n&1) != 1)
                return false;
            
            n = n>>1;
        }
        return true;
    }
    
}




// method 3
class Solution{
    public static boolean isPowerofTwo(long n){
        
        if(n == 0) return false;
        return ((n&(n-1)) == 0);
    }
    
}
