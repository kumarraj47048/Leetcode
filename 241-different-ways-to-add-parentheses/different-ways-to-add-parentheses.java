class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list=new ArrayList<>();
        if(expression.length()==0) return list;
        if(expression.length()==1){
            list.add(Integer.parseInt(expression));
            return list;
        }
        if(expression.length()==2 && Character.isDigit(expression.charAt(0))){
            list.add(Integer.parseInt(expression));
            return list;
        }
        
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(Character.isDigit(c)) continue;
            List<Integer> leftList=new ArrayList<>();
            List<Integer> rightList=new ArrayList<>();
            leftList=diffWaysToCompute(expression.substring(0,i));
            rightList=diffWaysToCompute(expression.substring(i+1));

            for(int left:leftList){
                for(int right:rightList){
                    int currR=0;
                    switch(c){
                        case '+':
                          currR=left+right;
                          break;
                        case '-':
                          currR=left-right;
                          break;
                        case '*':
                          currR=left*right;
                          break;
                    }
                    list.add(currR);
                }
            }
        }
        return list;
    }
}