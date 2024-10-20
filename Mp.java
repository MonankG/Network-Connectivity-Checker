import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Graph {
    private int nodes;
    private List<List<Integer>> adjacencyList;

    Graph(int nodes) {
        this.nodes = nodes;
        adjacencyList = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    boolean isGraphConnected() {
        boolean[] visited = new boolean[nodes];
        // Starts graph traversing
        dfs(0, visited);
        // Checks if all nodes are visited
        for (boolean visit : visited) {
            if (!visit) {
                return false; // If any node is not connected, means the graph is not connected and returns
                              // false
            }
        }
        return true; // If all nodes are visited, the graph is connected and it will return true
    }

    private void dfs(int startNode, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        visited[startNode] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}

public class Mp {
    public static void main(String[] args) {
        try {
            int u, v;
            System.out.println("*-------- MINI PROJECT --------*");
            System.out.println("SUBJECT NAME : Monank Gajjar");
            System.out.println("SUBJECT CODE : 102045601");
            System.out.println("Mini Project Title : Network Connectivity Checker using DFS Traversal");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of edges: ");
            int edges = sc.nextInt();
            Graph graph = new Graph(edges);

            System.out.println("Enter the edges (format: u v):");
            for (int i = 0; i < edges; i++) {
                graph.addEdge(u = sc.nextInt(), v = sc.nextInt());
            }
            if (graph.isGraphConnected()) {
                System.out.println("The graph is connected.");
            }
        } catch (Exception e) {
            System.out.println("The graph is not connected");
        }
    }
}
