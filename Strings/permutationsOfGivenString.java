class Solution {
    public List<String> find_permutation(String str) {
        List<String> ans = new ArrayList<>();
        permutate(ans, str, 0, str.length()-1);
        
        Collections.sort(ans);
        return ans;
    }
    
    
    private static void permutate(List<String> ans, String str, int l, int r){
        // base case
        if(l == r){
            ans.add(str);
            return;
        }
        
        for(int i=l; i<=r; i++){
            // swap characters
            str = swap(str, l, i);    // abc -> cba;
            permutate(ans, str, l+1, r);    // A KO FIX RAKHKE REMAINING CHARACTERS KA PERMUTATIONS LENA HAI
            // backtrack
            str = swap(str, l, i);    // cba -> abc
        }
        
        
    }
    
    
    private static String swap(String str, int l, int r){
         
        char charArray[] = str.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;
        
        return String.valueOf(charArray);
    }
    
    
    
}
