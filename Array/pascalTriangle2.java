// method 1
// time o(n2)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer ans[] = new Integer[rowIndex + 1];
        Arrays.fill(ans, 0);
        ans[0] = 1;
        
        for(int i=1; i<=rowIndex; i++){
            for(int j=i; j>0; j--){
                ans[j] = ans[j-1] + ans[j];
            }
        }
        
        return Arrays.asList(ans);
    }
}


// method 2
// not valid for long integers

// time o(n)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int prev = 1;
        ans.add(prev);
        for(int i=1; i<=rowIndex; i++){
            int curr = (prev * (rowIndex - i + 1))/i;
            ans.add(curr);
            prev = curr;
        }
        
        return ans;
    }
}
