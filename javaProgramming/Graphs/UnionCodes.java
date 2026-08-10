package Graphs;

public class UnionCodes {
    static int[] parent;
    static int[] size;
    static boolean[] parity;
    public int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] =  find(parent[a]);
    }
    public void union(int a, int b){
//        int leaderA = find(a);
//        int leaderB = find(b);
//        if(leaderA != leaderB) {
//            parent[leaderB] = leaderA;
//        }

        a = find(a);
        b = find(b);
        if(a != b) {
            if(size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
    public int findCircleNum(int[][] isConnected){
        int n= isConnected.length;
        parent = new int[n+1];
        for(int i = 0; i <=n; i++)
            parent[i] = i;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j && isConnected[i][j] == 1) union(i+1, j+1);
            }
        }
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(parent[i] == i) count++;
        }
        return count;
    }

    // 684 leetCode Question

    int leader(int u) {
        if(parent[u] == u) return u;
        return leader(parent[u]);
    }

    void union2(int u, int v) {
        int a = leader(u);
        int b = leader(v);
        if(a != b) {
            if(size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i= 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int[] ans = new int[2];
        for(int[] arr : edges) {
            int u = arr[0], v = arr[1];
            if(leader(u) == leader(v)){
                ans[0] = u;
                ans[1] = v;
                break;
            }
            else{
                union2(u, v);
            }
        }
        return ans;
    }

    // 785 leetCode Question

    int leader2(int u) {
        if(parent[u] == u) return u;
        return parent[u] = leader2(parent[u]);
    }

    void union3(int u, int v) {
        int a = leader2(u);
        int b = leader2(v);
        if(a != b) {
            if(size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
                parity[v] = !parity[u];
            } else {
                parent[a] = b;
                size[b] += size[a];
                parity[u] = !parity[v];
            }
        }
    }

    public boolean isBirartite(int[][] graph) {
        int n = graph.length;
        parent = new int[n];
        size = new int[n];
        parity = new boolean[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            parity[i] = false;
        }
        for(int i= 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] > i) {
                    if(leader2(i) == leader2(graph[i][j])) {
                        if(parity[i] == parity[graph[i][j]]) return false;
                    }
                    else union3(i, graph[i][j]);
                }
            }
        }
        return true;
    }
}
