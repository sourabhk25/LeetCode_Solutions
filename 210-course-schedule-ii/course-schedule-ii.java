class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Topological sort Kahn's algorithm
        int[] indegree = new int [numCourses];  //indegree array
        List<List<Integer>> adj = new ArrayList<>();    //adjacency list
        for(int i=0; i<numCourses; i++) {   //creating empty adjacency list
            adj.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites) {  //adding edges
            adj.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;  //increasing indegrees
        }

        Queue<Integer> queue = new LinkedList<>();  //queue for BFS
        int visitedCount = 0;   //visitedCount
        for(int i=0; i<numCourses; i++) {   //add nodes with 0 indegree to queue to start BFS
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] topo = new int[numCourses];   //array for storing topo sort 
        int i=0;    //increment
        while(!queue.isEmpty()) {   //loop till queue is empty
            int node = queue.poll();    //remove front node
            visitedCount++; //increase visitedCount
            topo[i++] = node;   //add node to topo list
            for(int neighbor: adj.get(node)) {  //loop in neighbors
                indegree[neighbor]--;   //decrease indegree
                if(indegree[neighbor] == 0) {   //if indegree 0 add to queue
                    queue.add(neighbor);
                }
            }
        }

        if(i == numCourses)  return topo;   //if iterator is same as numCourses then return topo array
        int[] arr = {}; //else create empty array and return
        return arr;
    }
}
