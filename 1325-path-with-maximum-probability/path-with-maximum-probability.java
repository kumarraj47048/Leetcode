class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
       
        List<List<pair>> graph=new ArrayList<>(n);
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
        int x=edges[i][0];
          int y=edges[i][1];
          graph.get(x).add(new pair(y,succProb[i]));
          graph.get(y).add(new pair(x,succProb[i]));
        }
        double dis[]=new double[n];
        Queue<pair> que=new LinkedList<>();
        Arrays.fill(dis,Double.MIN_VALUE);
        que.add(new pair(start_node,1));
        dis[start_node]=1;
        while(!que.isEmpty())
        {
            pair cur=que.poll();
            int val=cur.val;
            double w=cur.w;
            for(pair num:graph.get(val))
            {
                int v1=num.val;
                double w1=num.w;
                if(dis[v1]<dis[val]*w1)
                {
                    dis[v1]=dis[val]*w1;
                    que.add(new pair(v1,dis[v1]));
                }
            }
        }
        return dis[end_node];

    }
}
class pair{
    int val;
    double w;
    pair(int val,double w)
    {
        this.val=val;
        this.w=w;
    }
}