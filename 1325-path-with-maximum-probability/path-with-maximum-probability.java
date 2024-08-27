class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Pair> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        double dis[]=new double[n];
        for(int i=0;i<edges.length;i++){
              int x=edges[i][0];
              int y=edges[i][1];
              double prob=succProb[i];
              graph[x].add(new Pair(y,prob));
              graph[y].add(new Pair(x,prob));
        }
        Queue<Pair> q=new LinkedList<>();
        for(Pair p:graph[start_node]){
            int source=p.b;
            double val=p.val;
            dis[source]=val;
            q.add(new Pair(source,val));
        }
        
        
       // q.add(new Pair(start_node,0));
        while(q.size()>0){
            Pair curr=q.poll();
            int source=curr.b;
            double valP=dis[source];
            for(Pair p:graph[source]){
                int des=p.b;
                double weight=p.val;
                if(valP*weight>dis[des]){
                    dis[des]=valP*weight;
                    q.add(new Pair(des,dis[des]));
                }
            }
        }
    return dis[end_node];
    }
}
class Pair{
    int b;
    double val;
    Pair(int b, double val){
        this.b=b;
        this.val=val;
    }
}