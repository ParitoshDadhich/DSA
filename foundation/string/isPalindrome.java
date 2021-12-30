 public static boolean isPalindrome(String str) {
        int l = str.length();
        int k = l-1;
        for(int i=0; i<l/2; i++){
             if(str.charAt(i) != str.charAt(k-i))
                 return false;
        }
        
        return true;
	}

}
