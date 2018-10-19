import java.util.List;
import java.util.ArrayList;

public class DijkstraTest {
    public static void main(String[] args) throws Exception {
        // set startTime to measure how long the program takes
        long startTime = System.currentTimeMillis();
        Node[] nodes = new Node[6];
        for (int i = 0; i < 6; i++) {
            nodes[i]=new Node();
        }
        nodes[0].edges.add(new Edge(2, 5));
        nodes[0].edges.add(new Edge(3, 8));
        nodes[2].edges.add(new Edge(3, 2));
        nodes[2].edges.add(new Edge(4, 3));
        nodes[3].edges.add(new Edge(1, 3));
        nodes[3].edges.add(new Edge(5, 7));
        nodes[4].edges.add(new Edge(1, 6));
        nodes[1].edges.add(new Edge(5, 2));
        nodes=dijkstra(nodes, nodes[0]);
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i].distance+"\t"+nodes[i].parent);
        }
        // print final time taken
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static Node[] dijkstra(Node[] nodes, Node source) {
        // distance(j) is distance from source vertex to vertex j
        // parent(j) is the vertex that precedes vertex j in any shortest path (to reconstruct the path subsequently) 
        
        source.distance=0;
        source.parent=-1;
        
        int numVisited = 0;
        while(numVisited<nodes.length) {
            // find unvisited vertex with min distance to source; call it vertex i
            int mini = 0;
            int min = Integer.MAX_VALUE;
            for (int i=0; i < nodes.length; i++) {
                if (!nodes[i].visited && nodes[i].distance < min) {
                    mini=i;
                    min=nodes[i].distance;
                }
            }
            nodes[mini].visited=true;
            
            for (int i = 0; i < nodes[mini].edges.size(); i++) {
                Edge edge = nodes[mini].edges.get(i);
                if (nodes[mini].distance + edge.weight < nodes[edge.destination].distance) {
                    nodes[edge.destination].distance = nodes[mini].distance + edge.weight;
                    nodes[edge.destination].parent=mini;
                }
            }
            numVisited++;
        }
        return nodes;
    }

    public static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static class Node {
        int distance;
        boolean visited;
        int parent;
        List<Edge> edges = new ArrayList<>();

        public Node(int distance, boolean visited, int parent) {
            this.distance = distance;
            this.visited = visited;
            this.parent = parent;
        }

        public Node() {
            this.distance = Integer.MAX_VALUE;
            this.visited = false;
            this.parent = -1;
        }
    }
}