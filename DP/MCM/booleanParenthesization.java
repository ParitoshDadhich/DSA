// method 1
// recursive solution
// time o(2^N)

class Solution{
    static int countWays(int n, String str){
        return solve(str, 0, n-1, true);
    }
    
    private static int solve(String str, int i, int j, boolean isTrue){
        // base conditions
        if(i > j)
            return 0;
        
        if(i == j){
            if(isTrue)
                return str.charAt(i) == 'T' ? 1 : 0;
            else
                return str.charAt(i) == 'F' ? 1 : 0;
        }
        
        int ans = 0;
        for(int k=i+1; k<=j-1; k=k+2){
            int leftTrue = solve(str, i, k-1, true);
            int leftFalse = solve(str, i, k-1, false);
            
            int rightTrue = solve(str, k+1, j, true);
            int rightFalse = solve(str, k+1, j, false);
            
            // for OR operator
            if(str.charAt(k) == '|'){
                if(isTrue)
                    ans += leftTrue * rightTrue +
                           leftTrue * rightFalse +
                           leftFalse * rightTrue;
                else
                    ans += leftFalse * rightFalse;
            }
            
            // for AND operator
            if(str.charAt(k) == '&'){
                if(isTrue)
                    ans += leftTrue * rightTrue;
                else
                    ans += leftFalse * rightFalse +
                           leftTrue * rightFalse +
                           leftFalse * rightTrue;
            }
            
            // for XOR operator
            if(str.charAt(k) == '^'){
                if(isTrue)
                    ans += leftFalse * rightTrue +
                           leftTrue * rightFalse;
                else
                    ans += leftFalse * rightFalse +
                           leftTrue * rightTrue;
            }
            
        }
        
        return ans;
    }
    
}

// method 2
// memoization using maps

 class Solution{
    static HashMap<String, Integer> map = new HashMap<>();
    static int countWays(int n, String str){
        // HashMap<String, Integer> map = new HashMap<>();
        return solve(str, 0, n-1, true);
    }
    
    private static int solve(String str, int i, int j, boolean isTrue){
        
        // base case
        if(i > j)
            return 0;
        
        if(i == j){
            if(isTrue)
                return str.charAt(i) == 'T' ? 1 : 0;
            else
                return str.charAt(i) == 'F' ? 1 : 0;
        }
        
        
        
        // use of hashmap
        String temp = i + " " + j + " " + isTrue;
        // System.out.println(temp + " ");
        if(map.containsKey(temp))
            return map.get(temp);
        
        int ans = 0;
        for(int k=i+1; k<=j-1; k=k+2){
            int leftTrue = solve(str, i, k-1, true);
            int leftFalse = solve(str, i, k-1, false);
            
            int rightTrue = solve(str, k+1, j, true);
            int rightFalse = solve(str, k+1, j, false);
            
            // for OR operator
            if(str.charAt(k) == '|'){
                if(isTrue)
                    ans += leftTrue * rightTrue +
                           leftTrue * rightFalse +
                           leftFalse * rightTrue;
                else
                    ans += leftFalse * rightFalse;
            }
            
            // for AND operator
            else if(str.charAt(k) == '&'){
                if(isTrue)
                    ans += leftTrue * rightTrue;
                else
                    ans += leftTrue * rightFalse +
                           leftFalse * rightTrue +
                           leftFalse * rightFalse;
            }
            
            // for XOR operator
            else if(str.charAt(k) == '^'){
                if(isTrue)
                    ans += leftTrue * rightFalse +
                           leftFalse * rightTrue;
                else
                    ans += leftFalse * rightFalse +
                           leftTrue * rightTrue;
            }
        }
        
        // put the value into the map;
        ans = ans%1003;
        // System.out.println(temp);
        map.put(temp, ans);
        return ans;
    }
    
}
