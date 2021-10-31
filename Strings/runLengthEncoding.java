
class GfG
 {
	String encode(String str)
	{
        StringBuilder ans = new StringBuilder();
        int count = 1;
        int len = str.length();
        
        for(int i=0; i<len; i++){
            if(i+1 < len && str.charAt(i) == str.charAt(i+1))
                count++;
            else{
                ans.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        
        return ans.toString();
	}
	
 }
