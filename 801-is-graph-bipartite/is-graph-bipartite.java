class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
       
        int color[]=new int[n];
        Arrays.fill(color,-1);
        // -1 == no color, 0==green, 1==red
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                color[i]=0;
                while(q.size()>0){
                    int curr=q.poll();
                    for(int j=0;j<graph[curr].length;j++){
                        int dest=graph[curr][j];
                        if(color[dest]==-1){
                            color[dest]=1-color[curr];
                            q.add(dest);
                        }
                        else if(color[dest]==color[curr]) return false;
                    }
                }
            }
        }
        return true;
    }
}