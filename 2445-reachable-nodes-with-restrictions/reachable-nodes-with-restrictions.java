class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i[]:edges){
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        boolean rest[]=new boolean[n];
        for(int i:restricted){
            rest[i]=true;
        }

        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        int ct=1;

        while(q.size()>0){
            int curr=q.poll();
            for(int u:graph.get(curr)){
                if(!vis[u] && !rest[u]){
                    q.add(u);
                    vis[u]=true;
                    ct++;
                }
            }
        }

        return ct;
    }
}