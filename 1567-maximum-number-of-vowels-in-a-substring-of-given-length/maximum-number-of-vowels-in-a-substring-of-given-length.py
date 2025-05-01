class Solution(object):
    def maxVowels(self, s, k):
        count=0
        ans=0
        for i in range(k):
            if s[i] in "aeiou":
                count+=1
        ans=max(ans,count)
        n=len(s)
        for i in range(k,n):
            if s[i] in "aeiou":
                count+=1
            if s[i-k] in "aeiou":
                count-=1
            ans=max(ans,count)

        return ans
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        