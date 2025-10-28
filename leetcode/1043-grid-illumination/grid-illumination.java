class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer,Integer> hmRow=new HashMap<>();
        Map<Integer,Integer> hmCol=new HashMap<>();
        Map<Integer,Integer> hmRminusC=new HashMap<>();
        Map<Integer,Integer> hmRplusC=new HashMap<>();
        Map<Integer,Integer> hmBox=new HashMap<>();
        int[][] directions={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{0,0}};
        int[] ans=new int[queries.length];
        for(int i=0;i<lamps.length;i++){
            int x=lamps[i][0];
            int y=lamps[i][1];
            hmRow.put(x,hmRow.getOrDefault(x,0)+1);
            hmCol.put(y,hmCol.getOrDefault(y,0)+1);
            hmRminusC.put(x-y,hmRminusC.getOrDefault(x-y,0)+1);
            hmRplusC.put(x+y,hmRplusC.getOrDefault(x+y,0)+1);
            hmBox.put(x*n+y,hmBox.getOrDefault(x*n+y,0)+1);
        }

        for(int i=0;i<queries.length;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            if(hmRow.getOrDefault(x,0)>0 || hmCol.getOrDefault(y,0)>0 || hmRminusC.getOrDefault(x-y,0)>0
            || hmRplusC.getOrDefault(x+y,0)>0 || hmBox.getOrDefault(x*n+y,0)>0){
                ans[i]=1;
            }
            for(int j=0;j<directions.length;j++){
                int x1=x+directions[j][0];
                int y1=y+directions[j][1];
                if(x1>=0 && x1<n && y1>=0 && y1<n && hmBox.containsKey(x1*n+y1)){
                      int count=hmBox.get(x1*n+y1);
                      hmRow.put(x1,hmRow.getOrDefault(x1,0)-count);
                      hmCol.put(y1,hmCol.getOrDefault(y1,0)-count);
                      hmRminusC.put(x1-y1,hmRminusC.getOrDefault(x1-y1,0)-count);
                      hmRplusC.put(x1+y1,hmRplusC.getOrDefault(x1+y1,0)-count);
                      hmBox.remove(x1*n+y1);    
                }
            }
        }
        return ans;
    }
}