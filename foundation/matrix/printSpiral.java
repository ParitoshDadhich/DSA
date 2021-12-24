public class Solution {

	public static void spiralPrint(int arr[][]){
        
        if(arr.length==0)
            return;
        
		int m = arr.length;
        int n = arr[0].length;
        int totalElements = m*n;
        int count = 0;
        
        
        // initializing four variables which will help to track all elements
        // and we can print elements in a spiral fashion;
        int colStart = 0;
        int colEnd = n-1;
        int rowStart = 0; 
        int rowEnd = m-1;
        while(count < totalElements){
             if(colStart<n && colEnd>=0 && rowStart<m && rowEnd>=0){
                 
                // print elements from colStart to colEnd;
            	for(int i=colStart; i<=colEnd; i++){
                	System.out.print(arr[rowStart][i] + " ");
                	count++;
            	}
            	rowStart++; 
            
            	// print elements from rowStart to rowEnd;
            	for(int i=rowStart; i<=rowEnd; i++){
                	System.out.print(arr[i][colEnd] + " ");
                	count++;
            	}
            	colEnd--;
            
            	// print elements from colEnd to colStart;
            	for(int i=colEnd; i>=colStart; i--){
                	System.out.print(arr[rowEnd][i] + " ");
                	count++;
            	}
            	rowEnd--;
            
            	// print elements form rowEnd to rowStart;
            	for(int i=rowEnd; i>=rowStart; i--){
                	System.out.print(arr[i][colStart] + " ");
                	count++;
            	}
            	colStart++;
             }
        }
	}
}
