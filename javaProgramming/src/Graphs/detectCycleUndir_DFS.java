package Graphs;

import java.util.ArrayList;

public class detectCycleUndir_DFS {
    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode] == 0) {
                if(dfs(adjacentNode, node, vis, adj) == true)
                    return true;
            }
            else if(adjacentNode != parent) return true;
        }
        return false;
    }

    //Function to detect to cycle in an undirected graph
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[v];
        for(int i = 0;i < v; i++) {
            if(vis[i] == 0) {
                if(dfs(i, -1, vis, adj) == true) return true;
            }
        }
        return false;
    }
}
