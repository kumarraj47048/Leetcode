class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int in[]=new int[n];
        int size=edges.size();
        for(int i=0;i<size;i++){
            int from=edges.get(i).get(0);
            int to=edges.get(i).get(1);
            in[to]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0) ans.add(i);
        }
        return ans;
    }
}