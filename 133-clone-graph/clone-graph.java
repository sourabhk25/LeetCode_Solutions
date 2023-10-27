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
    public Node cloneGraph(Node node) {
        //BFS
        if(node == null) {  //return node if it is null
            return node;
        }

        HashMap<Node, Node> visited = new HashMap<>();  //create hashmap for storing visited nodes and their clones
        LinkedList<Node> queue = new LinkedList<>();    //queue for BFS
        queue.add(node);    //add given node as start point
        visited.put(node, new Node(node.val, new ArrayList<>()));   //add given node and its clone in map
        while(!queue.isEmpty()) {   //loop till queue is not empty
            Node n = queue.remove();    //remove front of queue
            for(Node neighbor: n.neighbors) {   //loop through front node's neighbors
                if(!visited.containsKey(neighbor)) {    //if neighbor is not visited
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));   //add neighbor and its clone to map
                    queue.add(neighbor);    //add neighbor to queue
                }

                visited.get(n).neighbors.add(visited.get(neighbor));    //add clone of neighbors to neighbor list
            }
        }

        return visited.get(node);   //return clone of node
    }
}