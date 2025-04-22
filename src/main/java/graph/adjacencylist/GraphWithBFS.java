package graph.adjacencylist;
import queues.*;

public class GraphWithBFS {
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

    public GraphWithBFS(int numVertices) {
        graph = new Edge[numVertices];
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

    /**
     * Run BFS from a given vertex
     * @param vertex source vertex
     * @param visited boolean array that for each vertex id stores true if it has been visited
     */
    void bfs(int vertex, boolean visited[]) {
        Queue queue = new ArrayQueue(10);
        queue.enqueue(vertex);
        visited[vertex] = true;
        System.out.println(vertex);
        while (!queue.empty()) {
            int nextV = (int)queue.dequeue();
            Edge e = graph[nextV];
            while (e != null) {
                if (!visited[e.neighbor]) {
                    queue.enqueue(e.neighbor);
                    System.out.println(e.neighbor);
                    visited[e.neighbor] = true;
                }
                e = e.next;
            }

        } // while queue is not empty
    }


    /** Runs BFS starting from every vertex that has not been visited.
     *
     */
    public void bfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                bfs(i, visited);
        }
    }

    public static void main(String[] args) {
        GraphWithBFS g = new GraphWithBFS(8);

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

       System.out.println("Running BFS");
       g.bfsMain();
    }
}


