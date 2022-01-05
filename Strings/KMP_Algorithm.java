package strings;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s = "ari";
	     int lpsArray[] = lps(s);
	        
	    for(int i: lpsArray)
	    	System.out.println(i);
	     
	    String str = "paritosh";
	    
	    int pos = -1;
	    int i=0, j=0; 
	    int len = str.length();
	    
	    while(i<len) {
	    	if(str.charAt(i)== s.charAt(j)) {
	    		i++;
	    		j++;
	    	} else {
	    		if(j != 0)
	    			j = lpsArray[j-1];
	    		else
	    			i++;
	    	}
	    	
	    	if(j == s.length()) {
	    		pos = i-s.length();
	    		break;
	    	}
	    }
	    
	    System.out.println(pos);
   
	}
	
  
  
	public static int[] lps(String s) {
		
		int n = s.length();
		
//		 if n <=1, then no suffix and prefix would be equal;
//		if(n <= 1) return 0;
		
		
		// abcabcd
		int lpsArray[] = new int[n];
		lpsArray[0] = 0;
		
		int len = 0;
		
		for(int i=1; i<n;) {
			// when prefix and suffix are equal
			if(s.charAt(i) == s.charAt(len)) {
				len++;
				lpsArray[i] = len;
				i++;
			}
			else {
				if(len == 0) {
					lpsArray[i] = 0;
					i++;
				}
				else {
					len = lpsArray[len-1];
				}
			}
		}
		
//	    for(int i: lpsArray)
//	    	System.out.println(i);
		
		return lpsArray;
	     
	}

}
