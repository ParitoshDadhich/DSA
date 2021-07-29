// time o(n!*n)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean map[] = new boolean[nums.length];
        
        int n = nums.length;
        
        getAllPermuatation(ans, nums, list, map);
        return ans;
    }
    
    
    private void getAllPermuatation(List<List<Integer>> ans, int nums[], List<Integer> list, boolean map[]){
        // base case
        if(list.size() == map.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        // traversing and generating every permutations;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(!map[i]){
                map[i] = true;
                list.add(nums[i]);
                getAllPermuatation(ans, nums, list, map);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
        
    }
    
    
}
