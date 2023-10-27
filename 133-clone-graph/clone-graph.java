/*
// Definition for a Node.
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
    private HashMap<Node, Node> visited = new HashMap<>();  //map to store visited nodes and clones
    public Node cloneGraph(Node node) {
        //DFS
        if(node == null) {  //return if node is null i.e. base case
            return node;
        }

        if(visited.containsKey(node)) { //if node is visited return its clone i.e. base case
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>()); //create clone 
        visited.put(node, cloneNode);   //add node and clone to map

        for(Node neighbor: node.neighbors) {    //for all neighbors
            cloneNode.neighbors.add(cloneGraph(neighbor));  //add list of cloned neighbors
        }

        return cloneNode;   //return cloneNode
    }
}