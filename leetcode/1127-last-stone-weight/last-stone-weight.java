class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
       for(int i=0;i<stones.length;i++) {
           pq.add(stones[i]);
       }
       while(pq.size()>1){
           int a=pq.remove();
           int b=pq.remove();
           if(a!=b){
               pq.add(a-b);
           }
       }
       if(pq.size()==0){
           return 0;
       }else{
           return pq.peek();
       }
    }
}