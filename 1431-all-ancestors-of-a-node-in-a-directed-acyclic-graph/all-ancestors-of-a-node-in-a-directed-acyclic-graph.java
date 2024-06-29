class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer> g[]=new ArrayList[n];
        for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int i[]:edges){
            int u=i[0];
            int v=i[1];
            g[v].add(u);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            int vis[]=new int[n];
            vis[i]=1;
            while(q.size()>0){
                int curr=q.poll();
                for(int k:g[curr]){
                    if(vis[k]==0){
                        q.add(k);
                        vis[k]=1;
                        ans.get(i).add(k);
                    }
                }
            }

            Collections.sort(ans.get(i));
        }
        return ans;
    }
}