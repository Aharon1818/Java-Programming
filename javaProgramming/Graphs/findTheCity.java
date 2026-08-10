package Graphs;

public class findTheCity {
    public int findTheCity(int n, int[][] edges, int Threshold) {
        int[][] dist = new int[n][n];
        for(int i= 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        // Floyd Warshall
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                if(i == k);
                for(int j = 0; j < n; j++) {
                    if(j == k);
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int minCity = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(dist[i][j] <= Threshold) count++;
            }
            if(count <= min) {
                min = count;
                minCity = i;
            }
        }
        return minCity;
    }
}
