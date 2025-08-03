class Solution {
    public static int k;
    public int maximumPoints(int[][] edges, int[] coins, int K) {
        k=K;
        int n=coins.length;
        if(k==0){
            int sum=0;
            for(int i:coins) sum+=i;
            return sum;
        }
        ArrayList<Integer> tree[]=new ArrayList[n];
        for(int i=0;i<n;i++) tree[i]=new ArrayList<>();
        for(int i[]:edges){
            tree[i[0]].add(i[1]);
            tree[i[1]].add(i[0]);
        }
        HashMap<String,Integer> map=new HashMap<>();

        return dfs(0,-1,0,tree,coins,map);

    }
    public static int dfs(int root, int par, int p, ArrayList<Integer> tree[], int coins[], HashMap<String,Integer> map){
       
       int a=(coins[root]/(1<<p))-k;
       int b=coins[root]/(1<<(p+1));
       String key=root+","+p;
       if(map.containsKey(key)) return map.get(key);
       map.put(key,0);
       if(p>14) return 0;
      
        for(int u:tree[root]){
            if(u!=par){
                a+=dfs(u,root,p,tree, coins,map);
                b+=dfs(u,root,p+1,tree,coins,map);
            }
        }
        int val=Math.max(a,b);
        map.put(key,val);
        return val;
    }
}