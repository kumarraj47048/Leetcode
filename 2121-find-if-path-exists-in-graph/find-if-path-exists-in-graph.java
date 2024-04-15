class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> q=new LinkedList<>();
        int vis[]=new int[n];
        q.add(source);
        vis[source]=1;

        while(q.size()>0){
            int curr=q.remove();
            vis[curr]=1;
            if(curr==destination) return true;
            for(int i=0;i<graph[curr].size();i++){
                int x=graph[curr].get(i);
                if(vis[x]==0){
                    q.add(x);
                    vis[x]=1;
                    if(x==destination) return true;
                }
            }
        }
        return false;
    }
}