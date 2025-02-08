class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> map;
    HashMap<Integer,Integer> map2;
    public NumberContainers() {
        //pq=new PriorityQueue<>();
        map=new HashMap<>();
        map2=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(!map2.containsKey(index)){
            if(!map.containsKey(number)){
                TreeSet<Integer> set=new TreeSet<>();
                set.add(index);
                map.put(number,set);
            }
            else{
                map.get(number).add(index);
            }
            map2.put(index,number);
        }
        else{
            int num=map2.get(index);
            map.get(num).remove(index);
            if(map.get(num).size()==0) map.remove(num);
            map2.put(index,number);
           // map.get(num).add(i)
           if(map.containsKey(number)){
            map.get(number).add(index);
           }
           else{
            TreeSet<Integer> set=new TreeSet<>();
            set.add(index);
            map.put(number,set);
           }
        }
    }
    
    public int find(int number) {
        if(map.containsKey(number)) return map.get(number).first();
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */