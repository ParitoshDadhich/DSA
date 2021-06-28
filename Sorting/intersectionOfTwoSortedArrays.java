// brute force
// time o(n2) and space o(1)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
  
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n1; i++){
            if(i>0 && nums1[i] == nums1[i-1])
                continue;
            for(int j=0; j<n2; j++){
                if(j>0 && nums2[j] == nums2[j-1])
                    continue;
                
                if(nums1[i] == nums2[j]){
                    list.add(nums2[j]);
                    // break;
                }
            }
        }
        
        int n = list.size();
        int ans[] = new int[n];
        for(int i=0; i<n; i++)
            ans[i] = list.get(i);
        
        
        return ans;
    }
}


// using hash maps
// time o(n) and space o(n)


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        ArrayList<Integer> output = new ArrayList<>();
        
        for(int i: nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        for(int i: nums2){
            if(map.containsKey(i)){
                output.add(i);
                map.remove(i);
            }
        }
        
        int l = output.size();
        int ans[] = new int[l];
        for(int i=0; i<l; i++)
            ans[i] = output.get(i);
        
        return ans;
    }
}



// using merging idea
// time o(n1 + n2) and space o(1)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        int i = 0, j = 0;
        while(i<n1 && j<n2){
            if(i>0 && nums1[i] == nums1[i-1]){i++; continue;}
            
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int n = list.size();
        int ans[] = new int[n];
        for(i=0; i<n; i++)
            ans[i] = list.get(i);
        
        
        return ans;
    }
}
