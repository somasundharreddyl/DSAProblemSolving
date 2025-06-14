class NumMatrix {
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        prefixSum=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                   prefixSum[i][j]=matrix[i][j];
                }else{
                    prefixSum[i][j]=prefixSum[i][j-1]+matrix[i][j];
                }   
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                    prefixSum[i][j]+=prefixSum[i-1][j];  
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r=prefixSum.length-1;
        int c=prefixSum[0].length-1;

        if(row1==0 && col1==0){
            return prefixSum[row2][col2];
        }else if(col1==0){
           return prefixSum[row2][col2]-prefixSum[row1-1][col2];
        }else if(row1==0){
           return prefixSum[row2][col2]-prefixSum[row2][col1-1];
        }else{
            return prefixSum[row2][col2]-prefixSum[row2][col1-1]-prefixSum[row1-1][col2]
            +prefixSum[row1-1][col1-1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */