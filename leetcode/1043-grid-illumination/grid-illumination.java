class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[] ans=new int[queries.length];
        Map<Integer,Integer> xMap=new HashMap<>();
        Map<Integer,Integer> yMap=new HashMap<>();
        Map<Integer,Integer> d1Map=new HashMap<>();
        Map<Integer,Integer> d2Map=new HashMap<>();
        Map<Integer,Integer> lampsMap=new HashMap<>();
        int[][] dirs={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{0,0}};
        for(int i=0;i<lamps.length;i++){
               int x=lamps[i][0];
               int y=lamps[i][1];
               int k=(x*n)+y;
               lampsMap.put(k,lampsMap.getOrDefault(k,0)+1);
               xMap.put(x,xMap.getOrDefault(x,0)+1);
               yMap.put(y,yMap.getOrDefault(y,0)+1);
               d1Map.put(x+y,d1Map.getOrDefault(x+y,0)+1);
               d2Map.put(x-y,d2Map.getOrDefault(x-y,0)+1);
        }
        for(int i=0;i<queries.length;i++){
            int x1=queries[i][0];
            int y1=queries[i][1];
            if(xMap.getOrDefault(x1,0)>0 || yMap.getOrDefault(y1,0)>0 || d1Map.getOrDefault(x1+y1,0)>0 || d2Map.getOrDefault(x1-y1,0)>0){
                ans[i]=1;
            }
            for(int[] dir:dirs){
                int x2=dir[0]+x1;
                int y2=dir[1]+y1;
                if(x2>=0 && x2<n && y2>=0 && y2<n && lampsMap.containsKey(x2*n+y2)){
                    int c=lampsMap.get(x2*n+y2);
                    xMap.put(x2,xMap.getOrDefault(x2,1)-c);
                    yMap.put(y2,yMap.getOrDefault(y2,1)-c);
                    d1Map.put(x2+y2,d1Map.getOrDefault(x2+y2,1)-c);
                    d2Map.put(x2-y2,d2Map.getOrDefault(x2-y2,1)-c);
                    lampsMap.remove(x2*n+y2);
                }
            }
        }
        return ans;
    }
}