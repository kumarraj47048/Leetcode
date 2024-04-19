class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size=rooms.size();
        int vis[]=new int[size];
        Queue<List> q=new LinkedList<>();
        q.add(rooms.get(0));
        vis[0]=1;
        while(q.size()>0){
           List<Integer> list=new ArrayList<>();
           list=q.poll();
           
           for(int i=0;i<list.size();i++){
              int rm=list.get(i);
              if(vis[rm]==0){
                q.add(rooms.get(rm));
                vis[rm]=1;
              }
           }
        }
        for(int i=0;i<size;i++){
            if(vis[i]==0) return false;
        }
        return true;
    }
}