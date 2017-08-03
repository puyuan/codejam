'''
Give a max weight of W, find all possible items that can fit in knacksack that sums up to the maximun value
Input -
  W - maxweight
  weight_list - [] item weights
  value_list - item values
  return max_value


'''
def knapsack(W, weight_list, value_list):
    n = len(weight_list)
    mem = {} # i, w    (i, num subset chosen, w - maxweight)
    for i in range(n+1):
        for w in range(W+1):

            if i == 0 or w == 0:
                mem[(i, w)]= 0
            elif weight_list[i-1] <= w:
                mem[(i, w)] = max(mem[(i-1, w)], value_list[i-1] +  mem[(i-1, w-weight_list[i-1])])
                print(mem[(i - 1, w)])
                print(value_list[i - 1] + mem[(i - 1, w - weight_list[i - 1])])
            else:
                mem[(i, w)] = mem[(i - 1, w)]
            print("mem i: %s w: %s  max_val %s" % (i, w, mem[(i, w)]))

    return mem[(i, w)]


if __name__ == "__main__":
    val = [60, 100, 120]
    wt = [10, 20, 30]
    W = 50

    print(knapsack(W , wt , val ))