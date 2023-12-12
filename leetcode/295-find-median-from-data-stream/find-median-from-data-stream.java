class MedianFinder {
   PriorityQueue<Integer> minPQ;
   PriorityQueue<Integer> maxPQ;
    public MedianFinder() {
       this.minPQ=new PriorityQueue<Integer>();
        this.maxPQ=new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
      if(minPQ.size()==maxPQ.size()){
          minPQ.add(num);
          maxPQ.add(minPQ.remove());
      } else{
          maxPQ.add(num);
          minPQ.add(maxPQ.remove());
      } 
    }
    
    public double findMedian() {
        if(minPQ.size()==maxPQ.size()){
            return (minPQ.peek()+maxPQ.peek())/2.0;
        }else{
            return maxPQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */