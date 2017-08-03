import heapq


class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        result = self.find_candidates(nums1, nums2, k)
        result.reverse()
        return result

    def find_candidates(self, nums1, nums2, k):
        if k ==0:
            return []
        i = 0
        heap = []
        while i < len(nums1) and i < len(nums2):
            heapq.heappush(heap, (-nums1[i], i, 1))
            heapq.heappush(heap, (- nums2[i], i, 2))
            i += 1
        while i < len(nums1):
            heapq.heappush(heap, (-nums1[i], i, 1))
            i += 1
        while i < len(nums2):
            heapq.heappush(heap, (-nums2[i], i , 2))
            i += 1

        valid_candidate = False
        candidates = []
        while not valid_candidate:
            candidate, index, list_num = heapq.heappop(heap)
            candidate = -candidate
            if list_num == 1:
                num_candidates = len(nums1) - index
                num_candidates += len(nums2)
            else:
                num_candidates = len(nums2) - index
                num_candidates += len(nums1)
            if num_candidates >= k:
                valid_candidate = True
                candidates.append((candidate, index, list_num))

        if valid_candidate and len(heap) > 0:
            candidate, index, list_num = heapq.heappop(heap)
            candidate = -candidate
            if list_num == 1:
                num_candidates = len(nums1) - index
                num_candidates += len(nums2)
            else:
                num_candidates = len(nums2) - index
                num_candidates += len(nums1)
            if num_candidates >= k:
                candidates.append((candidate, index, list_num))

        return_result = []

        for candidate, index, list_num in candidates:
            if list_num == 1:
                tmp_result = self.find_candidates(nums1[index+1:], nums2, k-1)
            else:
                tmp_result = self.find_candidates(nums1, nums2[index+1:], k - 1)
            tmp_result.append(candidate)
            tmp_result.reverse()
            if  tmp_result > return_result:
                return_result = tmp_result

        return_result.reverse()
        return return_result


nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5

nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5


nums1 = [3, 9]
nums2 = [8, 9]
k = 3

result = Solution().maxNumber(nums1, nums2, k)
print(result)