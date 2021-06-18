class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        ArrayList<String> a = new ArrayList<>();
        int n = s.length();
        int powerSet = (int)Math.pow(2, n);
        
        for(int counter = 0; counter<powerSet; counter++){
            String temp = "";
            for(int j=0; j<n; j++){
                if((counter & (1<<j)) != 0)
                    temp += s.charAt(j);
            }
            if(temp.length() != 0)
                a.add(temp);
        }
        
        Collections.sort(a);
        return a;
    }
}
