import math
class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        self.dp = {}
        for i, v in enumerate(price):
            item = [0 for j in range(len(price))]
            item[i] = 1
            item.append(v)
            special.append(item)
        best_offer = self.shoppinghelper(price, special, needs)

        return best_offer

    def shoppinghelper(self, price, special, needs):

        needs_key = tuple(needs)
        if needs_key in self.dp:
            return self.dp[ needs_key ]

        is_done = True
        for n in needs:
            if n < 0:
                return None
            if n != 0:
                is_done = False
        if is_done:
            return 0

        best_offer = None

        for promo in special:
            promo_price = promo[-1]
            promo_package = promo[:-1]
            new_needs = [a - b for a, b in zip(needs, promo_package)]
            result = self.shoppinghelper(price, special, new_needs)
            if result is None:
                continue
            current_offer = result + promo_price
            #print(result, promo_price)
            if best_offer is None or current_offer < best_offer:
                best_offer = current_offer


        self.dp[ needs_key ] = best_offer
        return best_offer

#print(Solution().shoppingOffers([2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]))
print(Solution().shoppingOffers([4,3,2,9,8,8] ,[[1,5,5,1,4,0,18],[3,3,6,6,4,2,32]], [6,5,5,6,4,1]))