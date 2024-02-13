package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    char n;

    Node(char n) {
        this.n = n;
    }

    public char getN() {
        return this.n;
    }
}

public class Graph {


    private int[][] adjMatrix;

    private List<Node> nodes;

    Graph(int size) {
        adjMatrix = new int[size][size];
        nodes = new ArrayList<>(size);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addNode('A');
        g.addNode('B');
        g.addNode('C');
        g.addNode('D');
        g.addNode('E');

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        g.printGraphMatrix();
        System.out.println(g.checkEdge(4, 2));
        System.out.println(g.checkEdge(4, 0));
        System.out.println(g.checkEdge(0, 4));
        /*g.dfs(0);
        g.dfs(3);*/
        g.bfs(0);

    }

    private void addEdge(int source, int dest) {
        this.adjMatrix[source][dest] = 1;
    }

    private void addNode(char n) {
        nodes.add(new Node(n));
    }

    private void printGraphMatrix() {
        System.out.print("  ");
        for (Node n : nodes) {
            System.out.print(n.getN() + " ");
        }
        System.out.println();
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print(nodes.get(i).getN() + " ");
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkEdge(int s, int d) {
        return adjMatrix[s][d] == 1;
    }

    private void dfs(int s) {
        boolean[] visited = new boolean[nodes.size()];
        dfsHelper(s, visited);
    }

    private void dfsHelper(int s, boolean[] visited) {
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        System.out.println("visited: " + nodes.get(s).getN());
        for (int i = 0; i < adjMatrix[s].length; i++) {
            if (adjMatrix[s][i] == 1) {
                dfsHelper(i, visited);
            }
        }
    }

    private void bfs(int s) {
        boolean[] visited = new boolean[nodes.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s]= true;
        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.println("visited: " + nodes.get(s).getN());
            for (int i = 0; i < adjMatrix[s].length; i++) {
                if (adjMatrix[s][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;

                }
            }
        }
    }
}
