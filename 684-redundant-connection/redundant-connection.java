class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<Integer> graph[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i]=new ArrayList<>();
        for(int i[]:edges){
            int u=i[0];
            int v=i[1];
            if(dfs(graph,u,v,-1)) return new int[]{u,v};
            graph[u].add(v);
            graph[v].add(u);
        }
        return new int[]{0,1};
    }
    public static boolean dfs(ArrayList<Integer> graph[], int st, int end, int par){
        if(st==end) return true;
        for(int u:graph[st]){
            if(u!=par){
                if(dfs(graph,u,end,st)) return true;
            }
        }
        // Queue<Integer> q=new LinkedList<>();
        // q.add(st);
        // while(q.size()>0){
        //     int curr=q.poll();
        //     if(curr==end) return true;
        //     for(int u:graph[curr]){
        //         q.add(u);
        //     }
        // }
        return false;
    }
}