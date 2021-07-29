// method 1
// using split function

class Solution {
    public String reverseWords(String S) {
        String str[] = S.split(" +");
        
        String s = "";
        int len = str.length;
        for(int i=len-1; i>=0; i--)
                s += str[i] + " ";  
            
 
        return s.trim();
    }
}



// method 2
// without using built in function;


class Solution {
    public String reverseWords(String S) {
        String str[] = S.split(" +");
        
        str = reverse(str, str.length);
        String s = String.join(" ", str);
            
 
        return s.trim();
    }
    
    
    private String[] reverse(String str[], int n){
        if(n%2 == 0){
            int mid = n/2;
            
            while(mid <n){
                String temp = str[mid];
                str[mid] = str[n-mid-1];
                str[n-mid-1] = temp;
                
                mid++;
            }
            
        } else{
            int mid = n/2 + 1;
            
            while(mid <n){
                String temp = str[mid];
                str[mid] = str[n-mid-1];
                str[n-mid-1] = temp;
                
                mid++;
            }
        }
        
        return str;
    }
    
}


 
