class Solution {
    public int[][] transpose(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        if(m == n){
            for(int i=0; i<m; i++)
                for(int j=i+1; j<n; j++)
                    swap(mat, i, j);
            
            return mat;
        }
         
        
        int ans[][] = new int[n][m];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                ans[j][i] = mat[i][j];
        
        return ans;
    }
    
    private void swap(int mat[][], int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
    
}
