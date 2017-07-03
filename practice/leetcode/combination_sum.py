'''
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]

'''


class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        return self.sum_helper(candidates, target, [], 0)

    def sum_helper(self, candidates, target, pick, currentsum):
        if currentsum == target:
            return [pick]
        elif currentsum >= target:
            return None

        final_result = []
        for i in range(0, len(candidates)):
            candidate = candidates[i]
            new_pick = list(pick)
            new_pick.append(candidate)
            result = self.sum_helper(candidates[i:], target, new_pick, currentsum + candidate)
            if result:
                final_result += result
        return final_result


sol = Solution()
result = sol.combinationSum([2, 3, 6, 7], 7)
print(result)