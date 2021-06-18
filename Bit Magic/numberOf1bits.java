
// method 1
// time o(total bits in n)

class Solution {
    static int setBits(int n) {
        int res = 0;
        while(n > 0){
            if((n & 1) == 1)
                res++;
            
            n = n>>1;
        }
        return res;
    }
}



// method 2
// time o(total bits in n)

class Solution {
    static int setBits(int n) {
        int res = 0;
        while(n > 0){
            if(n%2 != 0)
                res++;
            
            n = n/2;
        }
        return res;
    }
}





// method 3
// using Brion kerningam's Algo
// time O(total number of set bits in n)


class Solution {
    static int setBits(int n) {
        int res = 0;
        while(n != 0){
             n = (n & (n-1));
                res++;
        }
        return res;
    }
}



// method 4
// using lookup table method for 32 bit numbers;
// time o(1)

// in this approach I split 32 bits into 4 section of 8 bits each;
class Solution {
    static int setBits(int n) {
        int table[] = new int[256];     // 2^8 = 256
        
        table[0] = 0;
        // initializing how many set bits are there in each number from 1 to 256;
        for(int i=1; i<256; i++)
            table[i] = (i&1) + table[i/2];
            
        int res = table[n & 0xff];  // 0xff -> 11111111
        n = n>>8;
        
        res += table[n & 0xff];
        n = n >> 8;
        
        res += table[n & 0xff];
        n = n >> 8;
        
        res += table[n & 0xff];
        n = n >> 8;
        
        return res;
    }
}
