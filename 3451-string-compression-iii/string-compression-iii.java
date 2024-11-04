class Solution {
    public String compressedString(String word) {
        int n=word.length();
        char ch[]=new char[n];
        ch=word.toCharArray();
        int i=0;
        ArrayList<Character> list=new ArrayList<>();
        int ct=0;
        int p1=0;
        char c='@';
        while(p1<n){
            if(c!=ch[p1]){
                char x=Character.forDigit(ct, 10);
                list.add(x);
                list.add(c);
                ct=1;
                c=ch[p1];
            }
            else{
                ct++;
                if(ct>=10){
                     char x=Character.forDigit(ct, 10);
                    list.add('9');
                    list.add(c);
                    ct=1;
                    c=ch[p1];
                }
            }
            p1++;
        }
        char x=Character.forDigit(ct, 10);
        list.add(x);
                    list.add(c);
        
        StringBuilder sb=new StringBuilder("");
        for(int k=2;k<list.size();k++){
          sb.append(list.get(k));
        }
        return sb.toString();
    }
}