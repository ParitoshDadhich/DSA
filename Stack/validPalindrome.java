class Solution {
    public boolean isValid(String x) {
        int size = x.length();
        if(size%2 != 0)
            return false;
            
        Stack<Character> st = new Stack<>();
        
        int i = 0;
        while(i<size){
            char ch = x.charAt(i);
            
            if(ch == '{' || ch == '[' || ch == '(')
                st.add(ch);
            else if(ch == '}' || ch == ']' || ch == ')'){
                if(st.size() == 0) return false;
                
                if(ch == '}' && st.peek() != '{')
                    return false;
                else if(ch == ']' && st.peek() != '[')
                     return false;
                else if(ch == ')' && st.peek() != '(')
                    return false;
                
                st.pop();
            }
            
            i++;
        }
        
        return st.size() == 0;
    }
}
