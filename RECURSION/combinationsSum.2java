class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        helper(arr, target, 0, set, list);
        return new ArrayList<>(set);
    }
    
    private void helper(int arr[], int target, int sI, Set<List<Integer>> set, List<Integer> list){
        if(target == 0){
            set.add(new ArrayList<Integer>(list));
            return;
        }
        else if(sI == arr.length)
            return;
        
        // include an candidate
        if(arr[sI] <= target){
            list.add(arr[sI]);
            helper(arr, target-arr[sI], sI+1, set, list);
            list.remove(list.size()-1);
        }
        
        // not include an candidate
        helper(arr, target, sI+1, set, list);
        
        return;
    }
}
