import java.util.*;

public class DijkstraAlgorithm {
    private int V;
    private List<List<Edge>> adjList;

    private class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public DijkstraAlgorithm(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);

        for (int i = 0; i < V; ++i)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(dest, weight));
        adjList.get(dest).add(new Edge(src, weight)); // If the graph is undirected
    }

    public void shortestPath(int src) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.distance));
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        parent[src] = -1;
        priorityQueue.offer(new Node(src, 0));

        while (!priorityQueue.isEmpty()) {
            int u = priorityQueue.poll().vertex;

            if (visited[u])
                continue;

            visited[u] = true;

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (!visited[v] && distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    parent[v] = u;
                    priorityQueue.offer(new Node(v, distance[v]));
                }
            }
        }

        // Print the shortest distances and paths
        System.out.println("Vertex\tDistance\tPath");
        for (int i = 0; i < V; ++i) {
            System.out.print(i + "\t\t" + distance[i] + "\t\t");
            printPath(parent, i);
            System.out.println();
        }
    }

    private void printPath(int[] parent, int v) {
        if (v == -1)
            return;

        printPath(parent, parent[v]);
        System.out.print(v + " ");
    }

    private class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        int source = 0; // Source vertex

        DijkstraAlgorithm graph = new DijkstraAlgorithm(V);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 1, 1);
        graph.addEdge(4, 0, 2);

        graph.shortestPath(source);
    }
}
