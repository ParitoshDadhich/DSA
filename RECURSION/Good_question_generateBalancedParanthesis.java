class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        int open = n;
        int close = n;
        ArrayList<String> list = new ArrayList<>();
        generateParenthesis(open, close, "", list);
        
        return list;
    }
    
    private static void generateParenthesis(int open, int close, String op, ArrayList<String> list){
        if(open == 0 && close == 0){
            list.add(op);
            return;
        }
        
        if(open == close)
            generateParenthesis(open-1, close, op+'(', list);
        else if(open == 0)
            generateParenthesis(open, close-1, op+')', list);
        else if(open < close){
            generateParenthesis(open-1, close, op+'(', list);
            generateParenthesis(open, close-1, op+')', list);
        }
        
        return;
    }
    
}
