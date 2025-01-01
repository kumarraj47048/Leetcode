class Solution {
    public String clearStars(String s) {
        int n=s.length();
        char ch[]=s.toCharArray();
        //Pair arr[]=new Pair[n];
        PriorityQueue<Pair> p=new PriorityQueue<>((a,b)->{
            if(a.c!=b.c) return Character.compare(a.c,b.c);
            else return Integer.compare(b.idx,a.idx);
        }
        );
        for(int i=0;i<n;i++){
            if(ch[i]=='*') p.poll();
            else p.add(new Pair(ch[i],i));
        }
        Pair arr[]=new Pair[p.size()];
        int i=0;
        
        while(p.size()>0){
            arr[i++]=new Pair(p.peek().c,p.poll().idx);
        }
       
        Arrays.sort(arr,(a,b)->Integer.compare(a.idx,b.idx));
        StringBuilder sb=new StringBuilder("");
        for( i=0;i<arr.length;i++){
            sb.append(arr[i].c);
        }
        return sb.toString();
    }
}
class Pair{
    Character c;
    int idx;
    Pair(Character c, int idx){
        this.c=c;
        this.idx=idx;
    }
}