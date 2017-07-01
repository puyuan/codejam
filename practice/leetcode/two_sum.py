'''Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
'''

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        nums_dict = {}
        for i in range(0, len(nums)):
                vals = nums_dict.setdefault(nums[i], [])
                vals.append(i)
        
        for n in nums:
            if n in nums_dict and nums_dict[n]:
                index1 = nums_dict[n].pop(0)
                second_num = target - n
                if second_num in nums_dict and nums_dict[second_num]:
                    index2 = nums_dict[second_num].pop(0)
                    return [index1, index2]
                
            
        
