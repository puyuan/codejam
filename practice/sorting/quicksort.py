arr = [9, 1, 23, 34, 5, 7, 8, 45, 100, 2, 23423, 23, 234, 234, 234, 23, 1, 2, 3, 4, 5, 6, 7, 7]


def partition(arr, p, r):

    pivot = arr[r]
    i = p - 1
    for j in range(p, r):
        if arr[j] <= pivot:
            i += 1
            tmp = arr[i]
            arr[i] = arr[j]
            arr[j] = tmp
    tmp = arr[i+1]
    arr[i+1] = arr[r]
    arr[r] = tmp
    return i + 1

def quicksort(arr):
    quicksort_helper(arr, 0, len(arr) - 1)

def quicksort_helper(arr, start, end):
    if start >= end:
        return
    partition_i = partition(arr, start, end)
    #print(arr)
    quicksort_helper(arr, start, partition_i - 1)
    quicksort_helper(arr, partition_i+1, end)

quicksort(arr)
print(arr)


