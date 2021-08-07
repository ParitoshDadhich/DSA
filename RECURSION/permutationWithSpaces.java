
class Solution{
    
    ArrayList<String> permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        helper(str.substring(1), str.charAt(0)+"", list);
        
        return list;
    }
    
    private static void helper(String str, String op, ArrayList<String> list){
        if(str.length() == 0){
            list.add(op);
            return;
        }
        
        String op1 = op + " " + str.charAt(0);
        String op2 = op + str.charAt(0);
        
        helper(str.substring(1), op1, list);
        helper(str.substring(1), op2, list);
        
        return;
    }
    
}
