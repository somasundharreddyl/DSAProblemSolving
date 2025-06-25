class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(){
        }
        public Node(int key,int val){
           this.key=key;
           this.val=val;
        }
    }
    Map<Integer,Node> map;
    Node head=new Node();
    Node tail=new Node();
    int size;
    
    public LRUCache(int capacity) {
        map=new HashMap<>();
        head.next=tail;
        tail.prev=head;
        size=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
         Node temp=deleteNode(head,map.get(key));
           addNode(tail,temp);
            return map.get(key).val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
          if(map.containsKey(key)){
            Node rem=deleteNode(head,map.get(key));
            rem.val=value;
            map.put(key,rem);
            addNode(tail,rem);
          }else{     
        if(map.size()>=size){
         Node rem=deleteNode(head,head.next);
         map.remove(rem.key);
        }
        Node node=new Node(key,value);
          map.put(key,node);
        addNode(tail,node);
          }
    }
    public Node deleteNode(Node head,Node temp){
        Node cm1=temp.prev;
        Node cp1=temp.next;
        cm1.next=cp1;
        cp1.prev=cm1;
        temp.next=null;
        temp.prev=null;
        return temp;
    }
    
    public void addNode(Node tail,Node temp){
        Node cm1=tail.prev;
        cm1.next=temp;
        temp.next=tail;
        tail.prev=temp;
        temp.prev=cm1;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */