class Solution
{
    public void deleteMid(Stack<Integer>s,int size){
        if(size == 0){
            return;
        }
        
        int mid = size/2 + 1;
        
        solve(s, mid);
        return;
    } 
    
    private void solve(Stack<Integer> s, int k){
        if(k == 1){
            s.pop();
            return;
        }
        
        int val = s.pop();
        solve(s, k-1);
        s.push(val);
    }
}
