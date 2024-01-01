class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(k,n,ans,new ArrayList<>(),0,1);
        return ans;
    }

    public static void dfs(int k, int n , List<List<Integer>> ans , ArrayList<Integer> comb, int sum, int start){
        if(sum==n && comb.size()==k){
            Collections.sort(comb);
            if(!ans.contains(comb))
            ans.add(new ArrayList<>(comb));
            return;
        }

        if(sum>n) return;

        for(int i=start;i<=9;i++){
            if(!comb.contains(i)){
             comb.add(i);
             dfs(k,n,ans,comb,sum+i,i);
             comb.remove(comb.size()-1);
            }
        }
    }
}