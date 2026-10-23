class MedianFinder {

    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    public MedianFinder() {
       minPq=new PriorityQueue<>(); 
       maxPq=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        maxPq.add(num);
        if(maxPq.size()>minPq.size()){
            minPq.add(maxPq.remove());
        }else{
            if(maxPq.peek()>minPq.peek()){
                int temp=maxPq.remove();
                maxPq.add(minPq.remove());
                minPq.add(temp);
            }
        }
    }
    
    public double findMedian() {
        if(minPq.size()==maxPq.size()){
            return (minPq.peek()+maxPq.peek())/2.0;
        }else{
            return minPq.peek()*1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */