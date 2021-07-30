class Solution{
    static String removeChars(String string1, String string2){
        int arr[] = new int[26];
        Arrays.fill(arr, 0);
        
        int l1 = string1.length();
        int l2 = string2.length();
        
        for(int i=0; i<l2; i++)
            arr[string2.charAt(i) - 'a']++;
        
        String ans = "";
        
        for(int i=0; i<l1; i++){
            if(arr[string1.charAt(i) - 'a'] == 0)
                ans += string1.charAt(i);
        }
        
        
        return ans;
    }
}
