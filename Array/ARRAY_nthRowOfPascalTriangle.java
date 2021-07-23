// methdo 1
// using nCr
// space o(n) and time o(n)


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        int prev = 1;
        row.add(prev);
        
        for(int i=1; i<=rowIndex; i++){
            int curr = (prev * (rowIndex - i+1))/i;
            row.add(curr);
            prev = curr;
        }
        
        return row;
    }
}


// method 2
// using additon of previous values;
// time o(n2) and space o(n)

class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer ans[] = new Integer[rowIndex + 1];
        Arrays.fill(ans, 0);
        ans[0] = 1;
        
        for(int i=1; i<=rowIndex; i++){
            for(int j=i; j>0; j--)
                ans[j] = ans[j-1] + ans[j];
        }
        
        return Arrays.asList(ans);
    }
}

 

