class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list=new ArrayList<Integer>();
        int row=0,col=0,rowSteps=matrix.length,colSteps=matrix[0].length;

        while(rowSteps>1 && colSteps>1){

           for(int i=0;i<colSteps-1;i++){
             list.add(matrix[row][col]);
             col++;
           }

           for(int i=0;i<rowSteps-1;i++){
               list.add(matrix[row][col]);
               row++;
           }

           for(int i=0;i<colSteps-1;i++){
               list.add(matrix[row][col]);
               col--;
           }

           for(int i=0;i<rowSteps-1;i++){
               list.add(matrix[row][col]);
               row--;
           }

           rowSteps-=2;
           colSteps-=2;
           row++;
           col++;
        }

        if(rowSteps==1){
            for(int i=0;i<colSteps;i++){
                list.add(matrix[row][col]);
                col++;
            } 
        }
       else if(colSteps==1){
            for(int i=0;i<rowSteps;i++){
                list.add(matrix[row][col]);
                row++;
            }
        }
        return list;
    }
}