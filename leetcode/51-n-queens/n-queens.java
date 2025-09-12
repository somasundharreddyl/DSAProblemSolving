class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] chess=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess[i][j]=0;
            }
        }
        nQueens(chess,0);
        return ans;    
    }
    public void nQueens(int[][] chess,int i){

       if(i>=chess.length){
        List<String> l=new ArrayList<>();
        for(int[] n:chess){  
            String str="";
            for(int val:n){
               if(val==1){
                str=str+"Q";
               }else{
                str=str+".";
               }
            }
            l.add(str);
        }
        ans.add(l);
        return;
       }

        for(int j=0;j<chess.length;j++){
            if(isValid(chess,i,j)){
                chess[i][j]=1;
                nQueens(chess,i+1);
                chess[i][j]=0;
            }
        }
    }
    public boolean isValid(int[][] chess, int i, int j){
       //check columnwise
       for(int k=0;k<i;k++){
        if(chess[k][j]==1){return false;}
       } 
       //Left diagonal
       int r1=i-1,c1=j-1;
       while(r1>=0 && c1>=0){
        if(chess[r1][c1]==1){
            return false;
        }
        r1--;
        c1--;
       }

       //Right diagonal
       int r2=i-1,c2=j+1;
       while(r2>=0 && c2<chess.length){
        if(chess[r2][c2]==1){
            return false;
        }
        r2--;
        c2++;
       }

       return true;
    }
}