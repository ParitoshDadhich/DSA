class Solution
{
    //Function to check if the given pattern exists in the given string or not.
    static boolean search(String pat, String txt)
    {
        int patLen = pat.length();
        int txtLen = txt.length();
        
        if(patLen > txtLen) return false;
        
        for(int i=0; i<txtLen-patLen+1; i++){
            boolean flag = true;
            for(int j=0; j<patLen; j++){
                char txtChar = txt.charAt(i+j);
                char patChar = pat.charAt(j);
                
                if(patChar != txtChar){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        
        return false;
    }
    
}
