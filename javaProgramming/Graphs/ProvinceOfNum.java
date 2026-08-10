package Graphs;

import java.util.ArrayList;

public class ProvinceOfNum {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int vis[]) {
        vis[node] = 1;
        for(Integer it: adjLs.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adjLs, vis) ;
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < v; i++) {
            adjLs.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < v; i++) {
            for(int j = 0; j < v; j++) {
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int vis[] = new int[v];
        int cnt = 0;
        for(int i = 0; i < v; i++) {
            if(vis[i] == 0) {
                cnt++;
                dfs(i, adjLs, vis) ;

            }
        }
        return cnt;
    }
}
