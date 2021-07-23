// method 1
// using swap sort
// time o(n) and space o(1)

  
class Solve {
    int[] findTwoElement(int arr[], int n) {
        int ans[] = new int[2];
        
        int i=0;
        while(i<n){
            if(arr[i] == arr[arr[i] -1])
                i++;
            else if(arr[i] != arr[arr[i] -1]){
                int t = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[t-1] = t;
            }
        }
        
        // for(int k: arr)
        //     System.out.print(k + " ");
        
        for(i=0; i<n; i++){
            if(arr[i] != i+1){
                ans[0] = arr[i];
                ans[1] = i+1;
            }
        }
        
        return ans;
        
    }
}


// method 2
// using maps
// time o(n) and space o(n)

class Solve {
    int[] findTwoElement(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: arr)
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
 
 
            
        int missing = -1;
        int repeat = -1;
        
        for(int i=1; i<=n; i++){
            // System.out.println(map.containsKey(i) + " " + map.get(i));
            if(map.containsKey(i)){
                if(map.get(i) == 2)
                    repeat = i;
                    // break;
            }
            else if(!map.containsKey(i))
                missing = i;
                
            // System.out.println(repeat + " " + missing);
        }
        
        int ans[] = {repeat, missing};
        
        return ans;
    }
}
