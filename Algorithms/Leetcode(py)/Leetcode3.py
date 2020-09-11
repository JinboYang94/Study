class Solution:

    """
    def lengthOfLongestSubstring(self, s):
        if len(s) == 0:
            return 0           
        ret = 1
        i = 0
        while i < len(s) - 1:
            j = i + 1
            uni_set = set()
            uni_set.add(s[i])
            i += 1
            while j < len(s):
                if s[j] not in uni_set:
                    uni_set.add(s[j])
                    j += 1
                else:
                    break
            temp = len(uni_set)
            if temp >= ret:
                ret = temp
        return ret
    """

    def lengthOfLongestSubstring(self, s):
        ## dict "seen" to store seen chars
        seen = {}
        ret = char_to_start = 0
        for idx, context in enumerate(s):
            if context in seen and char_to_start <= seen[context]:
                char_to_start = seen[context] + 1
            else:
                ret = max(ret, idx - char_to_start + 1)
            seen[context] = idx
        return ret
            

