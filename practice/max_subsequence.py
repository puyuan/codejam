'''
Introduction to Algorithms
  Divide and Conquer  Sec 4.1

'''
arr = [1, 8, 3, -3, -7, -6, 2]

def max_subsequence_helper(arr, start, end):
    if start == end:
        return arr[start]
    mid = int((start+end)/2)
    max_left = max_subsequence_helper(arr, start, mid)
    max_right = max_subsequence_helper(arr, mid+1, end)
    max_center = max_sum_mid_section(arr, start, end)
    return max(max_left, max_right, max_center)


def max_sum_mid_section(arr, start, end):
    mid_left = int((start + end)/2)
    mid_right = mid_left + 1
    max_sum_left = 0
    max_sum_right = 0
    cur_sum_left = 0
    cur_sum_right = 0
    for i in range(mid_left, start-1, -1):
        cur_sum_left += arr[i]
        if cur_sum_left > max_sum_left:
            max_sum_left = cur_sum_left

    for i in range(mid_right, end + 1):
        cur_sum_right += arr[i]
        if cur_sum_right > max_sum_right:
            max_sum_right = cur_sum_right

    return max_sum_left + max_sum_right


print(max_subsequence_helper(arr, 0, 6))


