class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
       List<String> ans=new ArrayList<>();
       HashMap<String,List<Integer>> map=new HashMap<>();
       for(int i=0;i<access_times.size();i++){
           String empName=access_times.get(i).get(0);
           if(!map.containsKey(empName)){
               map.put(empName,new ArrayList<Integer>());
           }
           String time=access_times.get(i).get(1);
           char ch[]=time.toCharArray();
           int h=(ch[0]-'0')*10 + (ch[1]-'0');
           int m=(ch[2]-'0')*10 + (ch[3]-'0');
           map.get(empName).add(h*60+ m);
       }
        
        for(Map.Entry<String,List<Integer>> entry : map.entrySet()){
            String temp=entry.getKey();
            List<Integer> list=new ArrayList<>();
            list=entry.getValue();
            Collections.sort(list);
            for(int i=0;i<list.size()-2;i++){
                if(list.get(i+2)-list.get(i)<=59){
                    ans.add(temp);
                    break;
                }
            }
        }
        return ans;
    }
}