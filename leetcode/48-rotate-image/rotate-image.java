class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    public void transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[i].length;j++){
                if(i!=j){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                }
            }
        }
    }
    public void reverse(int[][] matrix){
       
       for(int i=0;i<matrix.length;i++){
        int start=0,end=matrix[0].length-1;
        while(start<end){
            int temp=matrix[i][start];
            matrix[i][start]=matrix[i][end];
            matrix[i][end]=temp;
            start++;
            end--;
        }
       }
    }
}