class Solution {

    public void solveSudoku(char[][] board) {
        sudoko(board);
    }

    boolean sudoko(char[][] board){
           for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                if(board[i][j]=='.'){
                for(char ch='1';ch<='9';ch++){
                   if(isValid(board,i,j,ch)){
                      board[i][j]=ch;
                    boolean check=sudoko(board);
                    if(check){
                      return true;
                    }else{
                      board[i][j]='.';
                    }
                   }
                }
                return false;
                } 
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int i, int j, char ch){

        //row Checker
        for(int col=0;col<board[0].length;col++){
            if(board[i][col]!='.' && board[i][col]==ch){
                return false;
            }
        }

        //col Checker
        for(int row=0;row<board[0].length;row++){
            if(board[row][j]!='.' && board[row][j]==ch){
                return false;
            }
        }

        //box checker
        int row=(i/3)*3;
        int col=(j/3)*3;

        for(int r=row;r<=row+2;r++){
            for(int c=col;c<=col+2;c++){
                if(board[r][c]!='.' && board[r][c]==ch){
                    return false;
                }
            }
        }
         return true;
    }
}