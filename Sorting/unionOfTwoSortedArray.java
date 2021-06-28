// method1;
// using set
// time o((m+n)log(m+n)) and space o(n+m)

1. put all the elements into set
2. transfer all elements into equalent size array
3. sort the array
4. return its array size;



// method 2
// using maps
// time o(m) and space o(m)

import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int s=0; s<t; s++){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    
		    for(int i=0; i<n; i++)
		        arr1[i] = sc.nextInt();
		    
		    for(int i=0; i<m; i++)
		        arr2[i] = sc.nextInt();
		        
		  
		    HashMap<Integer, Integer> map = new HashMap<>();
		    for(int i=0; i<n; i++){
		        if(map.containsKey(arr1[i]))
		            map.put(arr1[i], map.get(arr1[i]) + 1);
		        else
		            map.put(arr1[i], 1);
		    }
		     
		   
		     for(int i=0; i<m; i++){
		         if(map.containsKey(arr2[i]))
		            continue;
		         
		      //  if(mp.containsKey(arr2[i]))
		      //      map.put(arr2[i], map.get(arr2[i]) + 1);
		        else
		            map.put(arr2[i], 1); 
		         
		     }
		     
		    System.out.println(mp.size() + map.size());
		}
	}
}



// method 3
// using merging idea
// time o(m+n) and space o(1)



class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        
        int i = 0, j = 0;
        int count = 0;
        while(i<n && j<m){
            if(i>0 && a[i] == a[i-1]) {i++; continue;}
            if(j>0 && b[j] == b[j-1]) {j++; continue;}
            
            if(a[i] < b[j]){
                i++;
                count++;
            } else if(a[i] > b[j]){
                j++;
                count++;
            } else{
                i++;
                j++;
                count++;
            }
        }
        
        while(i < n){
            if(i == 0 || a[i] != a[i-1])
                count++;
            i++;
        }
        
        while(j < m){
            if(j == 0 || b[j] != b[j-1])
                count++;
            j++;
        }
        
         
        
        return count;
    }
}
