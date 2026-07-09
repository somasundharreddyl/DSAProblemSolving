class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int rowSteps=matrix.length-1,colSteps=matrix[0].length-1;
        int r=0,c=0;
        while(rowSteps>0 && colSteps>0){
            for(int i=0;i<colSteps;i++){
                ans.add(matrix[r][c]);
                c++;
            }
            for(int i=0;i<rowSteps;i++){
                ans.add(matrix[r][c]);
                r++;
            }
            for(int i=0;i<colSteps;i++){
                ans.add(matrix[r][c]);
                c--;
            }
            for(int i=0;i<rowSteps;i++){
                ans.add(matrix[r][c]);
                r--;
            }
            rowSteps-=2;
            colSteps-=2;
            r++;
            c++;
        }
        if(colSteps==0){
            for(int i=0;i<=rowSteps;i++){
                ans.add(matrix[r][c]);
                r++;
            }
        }
        else if(rowSteps==0){
         for(int i=0;i<=colSteps;i++){
                ans.add(matrix[r][c]);
                c++;
            }   
        }
        return ans;
    }
}