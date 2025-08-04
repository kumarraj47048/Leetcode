class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int len=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int p1=0;
        for(int i=0;i<n;i++){
            map.put(fruits[i], map.getOrDefault(fruits[i],0)+1);
            while(p1<i && map.size()>=3){
                map.put(fruits[p1],map.getOrDefault(fruits[p1],0)-1);
                if(map.get(fruits[p1])<=0) map.remove(fruits[p1]);
                p1++;
            }

            len=Math.max(len,i-p1+1);
        }

        return len;
    }
}