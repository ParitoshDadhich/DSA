// method 1
// time o(mn) and space o(m+n)

class Solution {
    public void setZeroes(int[][] mat) {
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];
        
        int m = row.length;
        int n = col.length;
        
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i] == 0 || col[j] == 0)
                    mat[i][j] = 0;
                 
          }
        }
    }
}


// method 2
// time o(mn), space o(1)



class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
