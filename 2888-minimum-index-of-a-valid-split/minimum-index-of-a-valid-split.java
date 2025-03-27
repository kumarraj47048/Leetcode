class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
          
            max=Math.max(max, map.get(i));
            System.out.println(max+" ");
        }
        
        int temp=0;
        for(int key:map.keySet()){
            if(map.get(key)==max){
                temp=key;
                break;
            }
        }
        int right=max;
        System.out.println(right);
        int left=0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==temp){
                left++;
                right--;
            }
            if(left*2>i+1 && right*2>n-i-1) return i;

        }

        return -1;
    }
}