
	public static int[] lps(String s) {
		
		int n = s.length();
		
//		 if n <=1, then no suffix and prefix would be equal;
		if(n <= 1) return 0;
		
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
		return lpsArray;
	     
	}
