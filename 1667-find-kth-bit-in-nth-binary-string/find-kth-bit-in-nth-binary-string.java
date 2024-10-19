class Solution {
    public char findKthBit(int n, int k) {
        ArrayList<Character> list=new ArrayList<>();
        list.add('0');
     //   System.out.println(list);
        for(int i=2;i<=n;i++){
            char ch[]=new char[list.size()];
            ch=reverse(list);
            list.add('1');
            for(int m=ch.length-1;m>=0;m--){
                list.add(ch[m]);
            }
          //  System.out.println(list);
        }
        return list.get(k-1);
    }
    public static char[] reverse(ArrayList<Character> list){
        char temp[]=new char[list.size()];
        for(int i=0;i<list.size();i++){
            if(list.get(i)=='0') temp[i]='1';
            else temp[i]='0';
        }
        return temp;
    }
}