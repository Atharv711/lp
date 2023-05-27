import java.util.*;

public class GraphTraversal {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public GraphTraversal(int[][] matrix) {
        adjacencyMatrix = matrix;
        numVertices = matrix.length;
    }

    // Breadth-First Search (BFS)
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS)
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    private void dfsRecursive(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        GraphTraversal graph = new GraphTraversal(adjacencyMatrix);

        System.out.println("BFS Traversal:");
        graph.bfs(0);

        System.out.println("DFS Traversal:");
        graph.dfs(0);

        scanner.close();
    }
}
