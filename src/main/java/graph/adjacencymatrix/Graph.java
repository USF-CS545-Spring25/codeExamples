package graph.adjacencymatrix;

// A graph represented using an adjacency matrix
public class Graph {
    private int[][] adjacencyMatrix;

    public Graph(int n) {
        adjacencyMatrix = new int[n][n];
    }

    public void addEdge(int n1, int n2) {
        adjacencyMatrix[n1][n2] = 1;
    }

    /**
     * Print vertices that have no outgoing edges
     */
    public void printNodesWithoutOutgoingEdges() {
        for (int i = 0 ; i < adjacencyMatrix.length; i++) {
            boolean hasNeighbor = false;
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] == 1)
                    hasNeighbor = true;
            }
            if (!hasNeighbor)
                System.out.println(i);
        }
    }

    /**
     * Print vertices without incoming edges
     */
    public void printNodesWithoutIncomingEdges() {
        for (int i = 0 ; i < adjacencyMatrix.length; i++) {
            boolean flag = false;
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[j][i] == 1)
                    flag = true;
            }
            if (!flag)
                System.out.println(i);
        }
    }

    /** Run DFS traversal from a given source vertex
     *
     * @param vertex source vertex
     * @param visited array of booleans, indicates whether the vertex has been discovered
     */
    void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        // go over neighbors
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                dfs(i, visited);

            }
        }
    }

    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[adjacencyMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfs(i, visited);
        }
    }

}
