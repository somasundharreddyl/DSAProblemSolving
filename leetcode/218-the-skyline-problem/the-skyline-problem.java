class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Pair> pairs=new ArrayList<>();
        for(int[] building:buildings){
          int x=building[0];
          int y=building[1];
          int ht=building[2];
          pairs.add(new Pair(x,-ht));
          pairs.add(new Pair(y,ht));
        }
        Collections.sort(pairs);

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.add(0);
        int prevHt=0;
        for(Pair p:pairs){
           if(p.ht<0){
             pq.add(-p.ht);
             if(pq.peek()!=prevHt){
                prevHt=pq.peek();
                List<Integer> l=new ArrayList<>();
                l.add(p.x);
                l.add(pq.peek());
                ans.add(l);
             }
           }else{
             pq.remove(p.ht);
             if(pq.peek()!=prevHt){
                prevHt=pq.peek();
                List<Integer> l=new ArrayList<>();
                l.add(p.x);
                l.add(pq.peek());
                ans.add(l);
             }
           }
        }
        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int ht;
    public Pair(int x,int ht){
        this.x=x;
        this.ht=ht;
    }

    public int compareTo(Pair o){
        if(this.x!=o.x){
            return this.x-o.x;
        }else{
            return this.ht-o.ht;
        }
    }
}