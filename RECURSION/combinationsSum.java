class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        helper(arr, target, 0, list, output);
        return output;
    }
    
    private void helper(int arr[], int target, int sI, List<Integer> list, List<List<Integer>> output){
        if(target == 0){
            output.add(new ArrayList<Integer>(list));
            return;
        }
        else if(arr.length == sI)
            return;
        
        
        // pick the candidate
        if(arr[sI] <= target){
            list.add(arr[sI]);
            helper(arr, target-arr[sI], sI, list, output);
            list.remove(list.size()-1);
        }
        // don't pick the candidate
        helper(arr, target, sI+1, list, output);
        
        return;
    }
    
}
