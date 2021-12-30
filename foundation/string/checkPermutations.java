import java.util.*;

public class Solution {

	public static boolean isPermutation(String str1, String str2) {
      if(str1.length()!=str2.length()){
          return false;
      }
       int a[]=new int[256];
        
        for(int i=0;i<str1.length();i++){
            int index=(int)str1.charAt(i);
            a[index]++;
        }
        for(int i=0;i<str2.length();i++){
            int index=(int)str2.charAt(i);
            a[index]--;
        }
        for(int i=0;i<str1.length();i++){
           int index=(int)str1.charAt(i);
            if(a[index]!=0){
                return false;
            }
        }
        return true;
        
    }
}
        


// method 2

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
