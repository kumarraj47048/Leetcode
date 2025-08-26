class Solution(object):
    def areaOfMaxDiagonal(self, nums):
        """
        :type dimensions: List[List[int]]
        :rtype: int
        """
        ans = 0
        area = 0

        for i in range(len(nums)):
            if math.sqrt(nums[i][0]**2 + nums[i][1]**2) > ans:
                
                ans = math.sqrt(nums[i][0]**2 + nums[i][1]**2)
                
                area = nums[i][0] * nums[i][1]
            elif math.sqrt(nums[i][0]**2 + nums[i][1]**2) == ans:
                if area < (nums[i][0] * nums[i][1]):
                    
                    
                    ans = math.sqrt(nums[i][0]**2 + nums[i][1]**2)
                    
                    area = nums[i][0] * nums[i][1]

        return area
        