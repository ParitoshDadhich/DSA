public class Solution {
	public static String reverseWordWise(String s) {
		
        int i = s.length() - 1;
        String ans = "";
        while(i>=0){
            // taking care of spaces
            while(i>=0 && s.charAt(i) == ' ')
                i--;
            
            int j = i;
            if(i<0)
                break;
        	
            // main logic
            while(i>=0 && s.charAt(i) != ' ')
            	i--;
        	if(ans.isEmpty())
                ans = ans.concat(s.substring(i+1, j+1));
            else{
                ans = ans.concat(" " + s.substring(i+1, j+1));
            }
        }
	
        return ans;
	}
}



// by using string builder

public class Solution {
	public static String reverseWordWise(String s) {
		
        int i = s.length() - 1;
        StringBuilder ans = new StringBuilder();
        while(i>=0){
            // taking care of spaces
            while(i>=0 && s.charAt(i) == ' ')
                i--;
            
            int j = i;
            if(i<0)
                break;
        	
            // main logic
            while(i>=0 && s.charAt(i) != ' ')
            	i--;
        	if(ans.capacity() == 0)
                ans.append(s.substring(i+1, j+1));
            else{
                ans.append(" " + s.substring(i+1, j+1));
            }
        }
	
        return ans.toString().trim();
	}
}
