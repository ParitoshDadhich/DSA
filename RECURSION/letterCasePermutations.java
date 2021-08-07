class Solution {
    public List<String> letterCasePermutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        caseCombinations(str, "", list);
        
        return list;
    }
    
    private void caseCombinations(String str, String op, ArrayList<String> list){
        if(str.length() == 0){
            list.add(op);
            return;
        }
        
        char ch = str.charAt(0);
        
        if(Character.isDigit(ch))
            caseCombinations(str.substring(1), op+ch, list);
        else{
            caseCombinations(str.substring(1), op+Character.toUpperCase(ch), list);
            caseCombinations(str.substring(1), op+Character.toLowerCase(ch), list);
        }
    }
    
}
