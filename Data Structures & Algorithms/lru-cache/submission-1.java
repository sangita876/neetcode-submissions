class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
    private final int capacity;
    private final Map<Integer, Node>map;
    private final Node head;
    private final Node tail;
    public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>();
      this.head = new Node(-1, -1);
      this.tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
    }
    
    public int get(int key) {
     Node node = map.get(key);
     if(node==null) return -1;
     remove(node);
     addToFront(node);
     return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node !=null){
            node.value = value;
            remove(node);
            addToFront(node);
            return;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);

        if(map.size() > capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    
    }
    private void remove(Node node){
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }
    private void addToFront(Node node){
        Node first = head.next;
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
    }
    
  }
    
   

