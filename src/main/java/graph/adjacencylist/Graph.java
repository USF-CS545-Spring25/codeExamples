package graph.adjacencylist;
import java.util.Stack;

public class Graph {
    private Edge[] graph; // adjacency list for this graph

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor (id of the destination node)
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Return the number of vertices in the graph
     * @return number of vertices
     */
    public int getNumVertices() {
        return graph.length;
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        // insert in front
        edge.next = head;
        graph[vertexId] = edge;
    }


    /** Print the whole adjacency list */
    public void printAdjacencyList() {
        for (int i = 0; i < graph.length; i++) {
            Edge curr = graph[i];
            System.out.println("i = " + i);
            while (curr != null) {
                System.out.print(curr.neighbor + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    /**
     * Print nodes that have no outgoing edges
     */
    public void printNodesWithoutOutgoingEdges() {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null)
                System.out.println(i);
        }
    }

    /**
     * Print all the vertices we can directly reach from a given vertex
     * by following outgoing edges.
     * @param vertexId vertex
     */
    public void printNeighbors(int vertexId) {
        Edge curr = graph[vertexId]; // linked list of outgoing edges for this vertex
        while (curr != null) {
            System.out.println(curr.neighbor);
            curr = curr.next;
        }
    }

    /**
     * Print nodes that have no incoming edges from other nodes
     */
    public void printNodesWithoutIncomingEdges() {
        boolean[] incoming = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            Edge e = graph[i];
            while (e  != null) {
                incoming[e.neighbor] = true;
                e = e.next;
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (!incoming[i])
                System.out.println(i);
        }
    }

    /**
     * Print incoming edges - edges that point to a vertex.
     * Ex: Suppose the vertex is 0, and there is an edge.
     * @param vertexId vertex
     */
    public void printIncomingEdges(int vertexId) {
        System.out.println("Incoming edges for vertex " + vertexId + ":");
        for (int i = 0; i < graph.length; i++) {
            Edge curr = graph[i];
            while (curr != null) {
                if (curr.neighbor == vertexId) {
                    System.out.println(i + ", " + vertexId);
                    break;
                }
                curr = curr.next;
            }
        }
    }

    /** A helper method for dfsMain - runs DFS once from the given source vertex
     *
     * @param vertex source vertex
     * @param visited an array, where for each vertex id we store true if it has been visited,
     * and false otherwise
     */
    public void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        Edge curr = graph[vertex];
        while (curr != null) {
            if (!visited[curr.neighbor]) {
                dfs(curr.neighbor, visited);
            }
            curr = curr.next;
        }
    }

    /**
     * Iterative DFS implementation that uses a stack.
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited, and false otherwise
     */
    // pop the vertex nextV from the stack, mark it as visited
    // iterate over the neighbors of nextV
    // if the neighbor has not been visited, push it onto the stack
    public void dfsWithStack(int vertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex); // push the source vertex onto the stack

        while (!stack.isEmpty()) {
            int vi = stack.pop();
            if (!visited[vi]) {
                visited[vi] = true;
                System.out.println(vi);
                Edge curr = graph[vi];
                while (curr != null) {
                    if (!visited[curr.neighbor]) {
                        stack.push(curr.neighbor); // might be duplicates in the stack
                    }
                    curr = curr.next;
                }
            }
        }

    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfs(i, visited);
                // dfsWishStack(i, visited); // alternative without recursion
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Edge edge10 = new Edge(0);
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Edge edge05 = new Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Edge edge26 = new Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Edge edge54 = new Edge(4);
        Edge edge56 = new Edge(6);
        g.addEdge(5, edge54);
        g.addEdge(5, edge56);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);

        //System.out.println("No outgoing edges: ");
        //g.printNodesWithoutOutgoingEdges();
        //System.out.println("No incoming edges: ");
        //g.printNodesWithoutIncomingEdges();

        //System.out.println("Print neighbors: ");
       // g.printNeighbors(5);
        //System.out.println("Print incoming edges");
        g.printIncomingEdges(5);

        g.dfsMain();
    }
}


