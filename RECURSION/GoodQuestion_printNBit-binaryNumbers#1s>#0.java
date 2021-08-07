class Solution {
    ArrayList<String> NBitBinary(int n) {
        ArrayList<String> list = new ArrayList<>();
        helper(n, "", 0, 0, list);
        
        return list;
    }
    
    private static void helper(int n , String op, int ones, int zeroes, ArrayList<String> list){
        if(n == 0){
            list.add(op);
            return;
        }
        
        
        if(ones == zeroes){
            helper(n-1, op+"1", ones+1, zeroes, list);
        } else if(ones > zeroes){
            helper(n-1, op+"1", ones+1, zeroes, list);
            helper(n-1, op+"0", ones, zeroes+1, list);
        }
        
        return;
        
    }
    
}
