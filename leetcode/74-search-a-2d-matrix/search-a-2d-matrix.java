class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0,end=matrix.length*matrix[0].length-1,cols=matrix[0].length;
        while(start<=end){
            int mid=start+(end-start)/2;
            int rowIndex=mid/cols;
            int colIndex=mid%cols;
            if(matrix[rowIndex][colIndex]==target){
                return true;
            }
            else if(matrix[rowIndex][colIndex]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}