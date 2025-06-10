class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
       for(int i=0;i<stones.length;i++){
        pq.add(stones[i]);
       }
       while(pq.size()>1){
        int x=pq.remove();
        int y=pq.remove();
        int diff=x>y?x-y:y-x;
        if(diff!=0){
        pq.add(diff);
        }
       }
       if(pq.size()==0){
        return 0;
       }else{
        return pq.peek();
       }
    }
}