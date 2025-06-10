class MedianFinder {

    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;
    public MedianFinder() {
       minPq=new PriorityQueue<>(); 
       maxPq=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
       if(maxPq.size()==minPq.size()){
           minPq.add(num);
           maxPq.add(minPq.remove());
       }else {
           maxPq.add(num);
           minPq.add(maxPq.remove());
       }
    }
    
    public double findMedian() {
        if(minPq.size()==maxPq.size()){
            return (minPq.peek()+maxPq.peek())/2.0;
        }else{
            return maxPq.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */