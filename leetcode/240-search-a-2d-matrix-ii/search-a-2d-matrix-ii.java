class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r1=0,r2=matrix.length-1,c1=0,c2=matrix[0].length-1;
        while(r1<=r2 && c2>=0){
            if(matrix[r1][c2]==target){
                return true;
            }else if(target<matrix[r1][c2]){
                c2--;
            }else{
                r1++;
            }
        }
        return false;
    }
}