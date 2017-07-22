from collections import deque
def rotten_oranges(matrix):
    # find initial rotten oranges
    queue = deque()
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if matrix[i][j] == 2:
                queue.append((i, j))
    queue.append("TIME")
    total_time = 0
    while len(queue) > 0 :
        item = queue.popleft()
        if item == "TIME":
            total_time +=1
            if len(queue) > 0:
                queue.append("TIME")
            continue
        else:
            # turn all adjacent into bad oranges
            (i, j) = item
            if matrix[i+1][j] == 1:
                queue.append((i+1, j))
                matrix[i+1][j] = 2
            if matrix[i -1][j] == 1
                queue.append((i-1, j))
                matrix[i -1][j] = 2
            if matrix[i][j+1] == 1
                queue.append((i, j+1))
                matrix[i][j+1] = 2
            if matrix[i][j-1] == 1
                queue.append((i, j-1))
                matrix[i][j-1] = 2
    # check unreachable nodes
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if matrix[i][j] == 1:
                return -1
    return total_time
            
    