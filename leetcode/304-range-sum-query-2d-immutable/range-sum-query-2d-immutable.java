class NumMatrix {

    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        sumMatrix=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(j==0){
                 sumMatrix[i][j]=matrix[i][j];
                }else{
                 sumMatrix[i][j]=sumMatrix[i][j-1]+matrix[i][j];  
                }
            }
        }
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                if(j==0){
                 sumMatrix[j][i]=sumMatrix[j][i];
                }else{
                 sumMatrix[j][i]+=sumMatrix[j-1][i];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total=sumMatrix[row2][col2];
        if(row1==0 && col1==0){
            return total;
        }else if(row1==0){
            return total-sumMatrix[row2][col1-1];
        }else if(col1==0){
            return total-sumMatrix[row1-1][col2];
        }else{
            return total-sumMatrix[row2][col1-1]-sumMatrix[row1-1][col2]+sumMatrix[row1-1][col1-1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */