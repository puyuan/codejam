class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        graph = [[ nums1[i] + nums2[j] for j in range(len(nums2))] for i in range(len(nums1))]
        result = []
        self.printgraph(graph)
        num1_sum = 0
        num2_sum = 0
        count = 0
        while (num1_sum is not None or num2_sum is not None) and count < k:
            num1_sum = None
            num2_sum = None
            first_node = None
            second_node = None
            for i1 in range(len(nums1)):
                for j1 in range(len(nums2)):
                    if graph[i1][j1] is not None:
                        if num1_sum is None:
                            num1_sum = graph[i1][j1]
                            first_node = (i1, j1)
                        elif num1_sum > graph[i1][j1]:
                            num1_sum = graph[i1][j1]
                            first_node = (i1, j1)
                            break

            for j2 in range(len(nums2)):
                for i2 in range(len(nums1)):
                    if graph[i2][j2] is not None:
                        if num2_sum is None:
                            num2_sum = graph[i2][j2]
                            second_node=(i2, j2)
                        elif num2_sum > graph[i2][j2]:
                            num2_sum = graph[i2][j2]
                            second_node = (i2, j2)
                        break
            print(first_node, second_node)
            print(num1_sum, num2_sum)
            if num1_sum is None and num2_sum is None:
                break
            if num1_sum <= num2_sum:
                result.append((nums1[first_node[0]], nums2[first_node[1]]))
                graph[first_node[0]][first_node[1]] = None
                count += 1
            else:
                result.append((nums1[second_node[0]], nums2[second_node[1]]))
                graph[second_node[0]][second_node[1]] = None
                count += 1
            self.printgraph(graph)
        return result
    def printgraph(self, graph):
        for row in graph:
            print(row)

'''
class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        graph = []

        # init graph using adjacency list
        for i in range(len(nums1)):
            graph.append([])
            for j in range(len(nums1), len(nums2)+len(nums1)):
                graph[i].append(j)



        for i in range(len(nums2)):
            graph.append([])
            for j in range(len(nums1)):
                graph[i+len(nums1)].append(j)

        result = []

        print(graph)
        source_node = 0
        count = 0
        while graph[source_node] and count < k:
            target_node_list = graph[source_node]
            target_node = target_node_list[0]
            nodes_connected_to_target = graph[target_node]
            print("From sourcenode %s Checking targetnode %d, pick from a list of source nodes%s" %(source_node, target_node, nodes_connected_to_target))
            if nodes_connected_to_target:
                # get first edge
                source_node = nodes_connected_to_target[0]
                source_node_value = self.getnodevalue(source_node, nums1, nums2)
                target_node_value = self.getnodevalue(target_node, nums1, nums2)
                result.append((source_node_value, target_node_value ))
                # remove edge
                print("processing edge (%d: %d, %d: %d)" % (source_node, source_node_value, target_node, target_node_value))
                graph[source_node].remove(target_node)
                graph[target_node].remove(source_node)
                source_node = target_node
                count += 1
        return result

    def getnodevalue(self, index, nums1, nums2):
        if index < len(nums1):
            node_value = nums1[index]
        else:
            node_value = nums2[index - len(nums1)]
        return node_value
'''

s = Solution()
print(s.kSmallestPairs([-10,-4,0,0,6], [3,5,6,7,8,100], 10))