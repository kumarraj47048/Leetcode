class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int vis[]=new int[n];
        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    graph[i].add(j);
                }
            }
        }

        int ct=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                ct++;
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                vis[i]=1;
                while(q.size()>0){
                    int curr=q.poll();
                    vis[i]=1;
                    for(int x:graph[curr]){
                        if(vis[x]==0){
                            q.add(x);
                            vis[x]=1;
                        }
                    }
                }
            }
        }
        return ct;
    }
}