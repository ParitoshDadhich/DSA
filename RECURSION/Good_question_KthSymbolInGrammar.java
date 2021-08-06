class Solution {
    public int kthGrammar(int N, int K) {
        // base case which is given in the question;
        if(N == 1 && K == 1)
            return 0;
        
        /*
            length of the grammer depends on the value of N, it is of the order 2^N-1
            so we are calculating the mid of the grammar;
        */
        int mid = (int)Math.pow(2, N-1)/2;
        /*
            suppose N=4, K=3 then grammar would be
            0
            0 1
            0 1 1 0
            0 1 1 0 1 0 0 1
            and the answer would be 1;
            
            it is to be noted the first half of grammar is exactly similar to the grammar of N-1
            0 1 1 0     N=3
            0 1 1 0     first half of N=4 
            and the grammar of other half is the first compliment to the grammar of N-1.
            0 1 1 0     N=3
            1 0 0 1     first complement of N=3
            
            it means if the value of K lies in the first half i.e. K<=mid then we simply return the value;
            if K>mid then we pass value of K as K-mid in order to map with the corresponding index of N-1 grammer 
            and return the complement value which we get through recursive call.
        */
        if(K<=mid)
            return kthGrammar(N-1, K);
        else{
            int k = kthGrammar(N-1, K-mid);
            return k==1?0:1;
        }
    }
}
