class Solution {
    public int minReorder(int n, int[][] connections) {
        int ct=0;
      
        int vis[]=new int[n];
        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            graph[u].add(v);
            graph[v].add(-u);
           
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=1;
        while(q.size()>0){
            int curr=q.poll();
            vis[Math.abs(curr)]=1;
            for(int x:graph[Math.abs(curr)]){
                if(vis[Math.abs(x)]==0){
                   q.add(Math.abs(x));
                   vis[Math.abs(x)]=1;
                   if(x>0) ct++;
                }
              
            }
        }
        return ct;
    }
}