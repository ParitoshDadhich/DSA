class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans);
        
        return ans;
    }
    
    private void solve(int index, int arr[], List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i: arr)
                list.add(i);
            
            ans.add(new ArrayList<>(list));
            return;
        }   
        
    
        for(int i=index; i<arr.length; i++){
            swap(index, i, arr);
            solve(index+1, arr, ans);
            swap(index, i, arr);    // swaping again so that order will remain same ans we can put every element at each index
        }
    }
    
    private void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
