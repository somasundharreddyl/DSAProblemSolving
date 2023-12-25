class NumMatrix {

int[][] prefixSum;
    public NumMatrix(int[][] matrix) {

     prefixSum=new int[matrix.length][matrix[0].length];
     int m=matrix.length,n=matrix[0].length;

     for(int i=0;i<m;i++) {
         for(int j=0;j<n;j++){
             if(j==0){prefixSum[i][j]=matrix[i][j];}
             else{
                prefixSum[i][j]=prefixSum[i][j-1]+matrix[i][j];
             }
         }
     }

    for(int i=0;i<n;i++) {
         for(int j=1;j<m;j++){
                prefixSum[j][i]=prefixSum[j-1][i]+prefixSum[j][i];
             }
         }
     

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=prefixSum[row2][col2];
        if(row1-1>=0){
          sum=sum-prefixSum[row1-1][col2];
        }
        if(col1-1>=0){
          sum=sum-prefixSum[row2][col1-1];
        }
        if(row1-1>=0&&col1-1>=0){
            sum=sum+prefixSum[row1-1][col1-1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */