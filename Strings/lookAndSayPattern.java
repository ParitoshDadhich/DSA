class Solution{
    static String lookandsay(int n) {
        if(n<=0) return "";
        
        String res = "1";
        for(int i=1; i<=n-1; i++){
            StringBuilder cur = new StringBuilder();
            for(int j=0; j<res.length(); j++){
                int count = 1;
                while(j+1 < res.length() && res.charAt(j) == res.charAt(j+1)){
                    count++;
                    j++;
                }
                
                cur.append(count).append(res.charAt(j));
            }
            res = cur.toString();
        }
        
        return res;
    }
    
}
