/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node>hm = new HashMap<>();
        Queue<Node>q = new LinkedList<>();
        hm.put(node, new Node(node.val));
        q.offer(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node nei:cur.neighbors){
                if(!hm.containsKey(nei)){
                    hm.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                Node curCloned = hm.get(cur);
                Node neiCloned = hm.get(nei);
                curCloned.neighbors.add(neiCloned);
            }
        }
        return hm.get(node);
    }
    
}