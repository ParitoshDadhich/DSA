

public class Solution {

	public static String getCompressedString(String str) {
		        
        int l = str.length();
        String answer = str.charAt(0) + "";
     
        int currentCharCount = 1;
        for(int i=1; i<l; i++){
            if(str.charAt(i) == str.charAt(i-1)){
                currentCharCount++;
            } else{
                if(currentCharCount > 1){
                    //answer += str.charAt(i);
                    answer += currentCharCount;
                    currentCharCount = 1;
                } 
                
                answer += str.charAt(i);
            }
        }
        
        if(currentCharCount > 1)
            answer += currentCharCount;
        
        return answer;
	}

}
