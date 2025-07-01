class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[] ans=new int[queries.length];
        int[][] dir=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{0,0}};
        Map<Integer,Integer> rows=new HashMap<>();
        Map<Integer,Integer> cols=new HashMap<>();
        Map<Integer,Integer> topLeftD=new HashMap<>();
        Map<Integer,Integer> topRightD=new HashMap<>();
        Map<Integer,Integer> lampsMap=new HashMap<>();
        for(int i=0;i<lamps.length;i++){
            int x=lamps[i][0];
            int y=lamps[i][1];
            rows.put(x,rows.getOrDefault(x,0)+1);
            cols.put(y,cols.getOrDefault(y,0)+1);
            topLeftD.put(x-y,topLeftD.getOrDefault(x-y,0)+1);
            topRightD.put(x+y,topRightD.getOrDefault(x+y,0)+1);
            lampsMap.put(x*n+y,lampsMap.getOrDefault(x*n+y,0)+1);   
        }
        for(int i=0;i<queries.length;i++){
            int x1=queries[i][0];
            int y1=queries[i][1];
             if(rows.getOrDefault(x1,0)>0 || cols.getOrDefault(y1,0)>0 || topLeftD.getOrDefault(x1-y1,0)>0 || 
topRightD.getOrDefault(x1+y1,0)>0){
                ans[i]=1;
            }
            for(int d=0;d<dir.length;d++){
               int x=x1+dir[d][0];
               int y=y1+dir[d][1];
               if(x>=0 && x<n && y>=0 && y<n && lampsMap.containsKey(x*n+y)){
               int times=lampsMap.get(x*n+y);
            rows.put(x,rows.getOrDefault(x,0)-times);
            cols.put(y,cols.getOrDefault(y,0)-times);
            topLeftD.put(x-y,topLeftD.getOrDefault(x-y,0)-times);
            topRightD.put(x+y,topRightD.getOrDefault(x+y,0)-times);
            lampsMap.remove(x*n+y);
               }
            }
        }
        return ans;
    }
}