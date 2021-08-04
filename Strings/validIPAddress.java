class Solution {

    public boolean isValid(String s) {
        String str[] = s.split("\\.", -1);
        
        if(str.length < 4 || str.length > 4)
            return false;
            
         
        for(String a: str) {
            try{
                if(Integer.parseInt(a)>255 || (a.charAt(0)=='0' && a.length()!=1)) return false;
            } catch (NumberFormatException e) { return false; }
        }
        return true;
    }
}
