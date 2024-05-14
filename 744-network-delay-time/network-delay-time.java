class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       int dis[]=new int[n+1];
       Arrays.fill(dis,Integer.MAX_VALUE);
       dis[k]=0;
       ArrayList<Pair> graph[]=new ArrayList[n+1];
       for(int i=1;i<=n;i++) graph[i]=new ArrayList<>();
       for(int i=0;i<times.length;i++){
          int u=times[i][0];
          int v=times[i][1];
          int w=times[i][2];
          graph[u].add(new Pair(v,w));
       }

       Queue<Pair> q=new LinkedList<>();
       q.add(new Pair(k,0));
       while(q.size()>0){
        Pair curr=q.poll();
        int v=curr.v;
        int w=curr.w;

          for(int i=0;i<graph[v].size();i++){
              int z=graph[v].get(i).v;
              int disW=graph[v].get(i).w;
              if(disW+w<dis[z]){
                dis[z]=disW+w;
                q.add(new Pair(z,dis[z]));
              }
          }
       }
       int ans=0;
       for(int i=1;i<=n;i++){
        if(dis[i]==Integer.MAX_VALUE) return -1;
        else
        ans=Math.max(ans,dis[i]);
       }
       return ans;
    }
}
class Pair{
    int v,w;
    Pair(int v, int w){
        this.v=v;
        this.w=w;
    }
}