class LRUCache {

    int size;
    Map<Integer,Node> hm;
    Node startNode=new Node();
    Node endNode=new Node();

    public LRUCache(int capacity) {
        size=capacity;
        hm=new HashMap<>();
        startNode.next=endNode;
        endNode.prev=startNode;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
          Node remNode=delete(hm.get(key));
          add(remNode,endNode);
          return remNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
           Node remNode=delete(hm.get(key));
           remNode.val=value;
           Node addNode=add(remNode,endNode);
           hm.put(key,addNode);
        }
        else{
            if(hm.size()>=size){
                Node remNode=delete(startNode.next);
                hm.remove(remNode.key);
            }
           Node addNode=add(new Node(key,value),endNode);
           hm.put(key,addNode);
        }
    }

    public Node add(Node node,Node endNode){
         Node prevM1=endNode.prev;
         prevM1.next=node;
         node.next=endNode;
         node.prev=prevM1;
         endNode.prev=node;
         return node;
    }

    public Node delete(Node node){
         Node prevm1=node.prev;
         Node nextp1=node.next;
         prevm1.next=nextp1;
         nextp1.prev=prevm1;
         node.next=null;
         node.prev=null;
         return node;

    }

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
        Node(){}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */