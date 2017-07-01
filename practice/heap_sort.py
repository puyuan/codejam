arr = [1, 4, 8, 3, 20]

def left(i):
    return 2 * (i+1) -1

def right(i):
    return 2*(i+1)

def max_heapify(arr, i, length):
    '''

    :param arr:
    :param i: 0th based index
    :return:
    '''
    left_i = left(i)
    right_i = right(i)
    max_i = i
    if left_i < length and arr[left_i] > arr[i]:
        max_i = left_i
    if right_i < length and arr[right_i] > arr[max_i]:
        max_i = right_i

    if max_i != i:
        tmp = arr[i]
        arr[i] = arr[max_i]
        arr[max_i] = tmp
        max_heapify(arr, max_i, length)


def build_heap(arr):
    for i in range(int(len(arr)/2) - 1, -1, -1):
        max_heapify(arr, i, len(arr))

def heap_sort(arr):
    build_heap(arr)
    print(arr)
    for i in range(len(arr)-1, -1, -1):
        tmp = arr[0]
        arr[0] = arr[i]
        arr[i] = tmp
        max_heapify(arr, 0, i)


#max_heapify(arr, 0)
heap_sort(arr)

print(arr)