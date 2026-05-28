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
            for(int j=1;j<r;j++){
                sumMatrix[j][i]+=sumMatrix[j-1][i];
            }
        } 
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=sumMatrix[row2][col2];
        if(row1>0){
            sum-=sumMatrix[row1-1][col2];
        }
        if(col1>0){
            sum-=sumMatrix[row2][col1-1];
        }
        if(row1>0 && col1>0){
            sum+=sumMatrix[row1-1][col1-1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */