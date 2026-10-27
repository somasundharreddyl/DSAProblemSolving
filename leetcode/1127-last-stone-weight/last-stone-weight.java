class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int s:stones){
            pq.add(s);
        }
        while(!pq.isEmpty() && pq.size()>1){
          int x=pq.remove();
          int y=pq.remove();
          int res=Math.abs(x-y);
          if(res!=0){
            pq.add(res);
          }
        }
        if(pq.isEmpty()){
            return 0;
        }else{
            return pq.peek();
        }
    }
}