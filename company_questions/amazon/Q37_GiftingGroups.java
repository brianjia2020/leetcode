package company_questions.amazon;

public class Q37_GiftingGroups {
    private boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        visited = new boolean[n];
        for(int i =0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i) {
        visited[i] = true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(isConnected,j);
            }
        }
    }
}
