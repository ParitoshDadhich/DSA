// method 1 (Brute force)
// time o(n^3logm) && space o(logm), where m is size of the set

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        HashSet<List<Integer>> hs = new HashSet<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        
                        List<Integer> a = sort(arr[i], arr[j], arr[k]);
                        
                        if(!hs.contains(a)){
                            ans.add(list);
                            hs.add(a);
                        }
                        
                        hs.add(a);
                    }
                }
            }
        }
        
        return ans;
    }
    
    private List<Integer> sort(int p, int q, int r){
        int ans[] = new int[3];
        
        if(q < p){
            int temp = p;
            p = q;
            q = temp;
        }
        
        if(r < q){
            int temp = q;
            q = r;
            r = temp;
        }
        
         if(q < p){
            int temp = p;
            p = q;
            q = temp;
        }

        
        ans[0] = p;
        ans[1] = q;
        ans[2] = r;
 
        return Arrays.asList(ans[0], ans[1], ans[2]);
        
    }
    
    
}



// method 2
// use hasmap
// time o(n^2) && space o(1)  

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        
        for(int i=0; i<n-2; i++){
            if(i == 0 || (i>0 && arr[i] != arr[i-1])){
                int l = i+1, h = n-1, sum = 0 -arr[i];
                while(l < h){
                    if(arr[l] + arr[h] == sum){
                        
                        ans.add(Arrays.asList(arr[i], arr[l], arr[h]));
                        
                        while(l < h && arr[l] == arr[l+1]) l++;
                        while(l < h && arr[h] == arr[h-1]) h--;
                        
                        l++; 
                        h--;
                    } else if(arr[l] + arr[h] < sum)
                        l++;
                    else
                        h--;
                }
            }
        }
        return ans;
    }
}
