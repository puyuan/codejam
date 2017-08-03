a = [11,2,1,15]
b = [235,127,19,4,12,23]


def smallest_pair():
    a.sort()
    b.sort()
    i = 0
    j = 0
    current_pick = None
    minimum = None
    minimum_pair = None
    while i < len(a) and j < len(b):
        print(a[i], b[j], current_pick)
        if a[i] <= b[j]:
            if current_pick and current_pick != "a":
                diff = abs(a[i] - b[j])
                if not minimum:
                    minimum = diff
                    minimum_pair = (a[i], b[j])
                else:
                    minimum = min(diff, minimum)
                    if minimum == diff:
                        minimum_pair = (a[i], b[j])

            current_pick = "a"
            i += 1
        else:
            if current_pick and current_pick != "b":
                print(b[j] - a[i])
                diff = abs(a[i] - b[j])
                if not minimum:
                    minimum = diff
                    minimum_pair = (a[i], b[j])
                else:
                    minimum = min(diff, minimum)
                    if minimum == diff:
                        minimum_pair = (a[i], b[j])

            current_pick = "b"
            j += 1

        print(minimum_pair)


smallest_pair()
