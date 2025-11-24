class NumMatrix {
    int[][] arr;

    public NumMatrix(int[][] matrix) {
        arr=new int[matrix.length][matrix[0].length];
      for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            if(j==0){
                arr[i][j]=matrix[i][j];
            }else{
                arr[i][j]=arr[i][j-1]+matrix[i][j];
            }
        }
      }
      for(int j=0;j<arr[0].length;j++){
        for(int i=0;i<arr.length;i++){
            if(i!=0){
                arr[i][j]+=arr[i-1][j];
            }
        }
      }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0 && col1==0){
           return arr[row2][col2];
        }else if(row1==0 && col1!=0){
           return arr[row2][col2]-arr[row2][col1-1];
        }else if(row1!=0 && col1==0){
           return arr[row2][col2]-arr[row1-1][col2];
        }else{
           return arr[row2][col2]-arr[row2][col1-1]-arr[row1-1][col2]+arr[row1-1][col1-1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */