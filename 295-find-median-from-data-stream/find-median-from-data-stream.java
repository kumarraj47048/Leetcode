class MedianFinder {
    public static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    public static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        minHeap.clear();
        maxHeap.clear();
    }
    
    public void addNum(int num) {
        if(maxHeap.size()>0 && maxHeap.peek()<num){
            minHeap.add(num);
            if(minHeap.size()>maxHeap.size()) maxHeap.add(minHeap.poll());
        }
        else{
            maxHeap.add(num);
            if(maxHeap.size()-minHeap.size()>1) minHeap.add(maxHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if((minHeap.size()+maxHeap.size())%2==0) return (((double)minHeap.peek()+(double)maxHeap.peek())/2);
        else return (double)(maxHeap.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */