class Solution {
    static Long reversedBits(Long x) {
        long res = 0;
        int pow = 31;
        while(x != 0){
            res += (x&1)<<pow;
            pow = pow-1;
            x = x>>1;
        }

        return res;
    }
};

