class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        prefix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < r; i++) {
            prefix[i][0] = matrix[i][0];

            for (int j = 1; j < c; j++) {
                prefix[i][j] = prefix[i][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                if (c > 0) {
                    sum += prefix[r][c] - prefix[r][c - 1]; 
                } else {
                    sum += prefix[r][c];
                }

            }
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */