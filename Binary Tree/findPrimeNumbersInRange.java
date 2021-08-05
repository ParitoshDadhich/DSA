class Solution {
    ArrayList<Integer> primeRange(int M, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=M; i<=N; i++){
            if(i == 1) continue;
            
            if(isPrime(i))
                list.add(i);
        }
                
        return list;
    }
    
    private static boolean isPrime(int num){
        int len = (int)Math.sqrt(num);
        for(int i=2; i<=len; i++){
            if(num%i == 0)
                return false;
        }
        
        return true;
    }
    
}
