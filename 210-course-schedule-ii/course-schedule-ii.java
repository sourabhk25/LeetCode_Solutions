class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int [numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int visitedCount = 0;
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] topo = new int[numCourses];
        int i=0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            visitedCount++;
            topo[i++] = node;
            for(int neighbor: adj.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if(i == numCourses)  return topo;
        int[] arr = {};
        return arr;
    }
}
