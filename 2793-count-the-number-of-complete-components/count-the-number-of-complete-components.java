class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int ct=0;
        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        int out[]=new int[n];
        boolean vis[]=new boolean[n];
        for(int i[]:edges){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
            out[i[0]]++;
            out[i[1]]++;
        }
        for(int i=0;i<n;i++) System.out.print(out[i]+" ");
        for(int i=0;i<n;i++){
            if(vis[i]==false && check(i,graph,out,vis)) ct++;
        }
        return ct;

    }
    public static boolean check(int source, ArrayList<Integer> graph[], int out[], boolean vis[]){
        int ref=0; //out[source];
        vis[source]=true;
        boolean check_return=true;
        HashSet<Integer> set=new HashSet<>();
        set.add(source);
        Queue<Integer> temp_q=new LinkedList<>();
        temp_q.add(source);
        while(temp_q.size()>0){
            int curr=temp_q.poll();
            for(int u:graph[curr]){
                if(!set.contains(u)){
                    ref++;
                    temp_q.add(u);
                    set.add(u);
                }
            }
        }

        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        while(q.size()>0){
            int curr=q.poll();
            for(int u:graph[curr]){
                if(out[u]!=ref) check_return=false;
                if(vis[u]==false){
                    q.add(u);
                    vis[u]=true;
                }
            }
        }

        return check_return;
    }
}