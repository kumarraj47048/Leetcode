class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[n];
        q.add(source);
        vis[source]=true;
        if(source==destination) return true;
        while(q.size()>0){
            int curr=q.poll();
            vis[curr]=true;
            for(int i=0;i<graph.get(curr).size();i++){
                int v=graph.get(curr).get(i);
                if(vis[v]==false){
                    q.add(v);
                    vis[v]=true;
                }
            }
            if(curr==destination) return true;
        }
        return false;
    }
}