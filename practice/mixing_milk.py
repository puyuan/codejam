'''
http://acm.hit.edu.cn/judge/show.php?Proid=1003

Since milk packaging is such a low margin business, it is important to keep the
price of the raw product (milk) as low as possible. Help Merry Milk Makers get
the milk they need in the cheapest possible manner.  The Merry Milk Makers
company has several farmers from which they may buy milk, and each one has a
(potentially) different price at which they sell to the milk packing plant.
Moreover, as a cow can only produce so much milk a day, the farmers only have
so much milk to sell per day. Each day, Merry Milk Makers can purchase an
integral amount of milk from each farmer, less than or equal to the farmer's
limit.  Given the Merry Milk Makers' daily requirement of milk, along with the
cost per gallon and amount of available milk for each farmer, calculate the
minimum amount of money that it takes to fulfill the Merry Milk Makers'
requirements.  Note: The total milk produced per day by the farmers will be
sufficient to meet the demands of the Merry Milk Makers.

PROGRAM NAME: milk

INPUT FORMAT
Line 1:	Two integers, N and M.
The first value, N, (0 <= N <= 2,000,000) is the amount of milk that Merry Milk Makers' want per day. The second, M, (0 <= M <= 5,000) is the number of farmers that they may buy from.
Lines 2 through M+1:	The next M lines each contain two integers, Pi and Ai.
Pi (0 <= Pi <= 1,000) is price in cents that farmer i charges.
Ai (0 <= Ai <= 2,000,000) is the amount of milk that farmer i can sell to Merry Milk Makers per day.
SAMPLE INPUT (file milk.in)
100 5
5 20
9 40
3 10
8 80
6 30

'''

import time

milk_stock_price = [[5, 20], [9, 40], [3,10], [8, 80], [6,30]]

def calculate_lowest_milk_purchase_budget(milk_amount, milk_stock_price):
    total_price = 0
    while milk_amount:
        min_price_tuple = [10000, 10000]
        for tuple in milk_stock_price:
            [price, amount] = tuple

            if price < min_price_tuple[0] and amount > 0:
                print(tuple)
                min_price_tuple = tuple
        [price, amount] = min_price_tuple
        print(milk_amount, amount)
        if milk_amount >= amount:
            total_price += amount * price
            milk_amount -= amount
            min_price_tuple[1] = 0
        else:
            total_price += milk_amount * price
            milk_amount = 0
            min_price_tuple[1] -= milk_amount
    return total_price

print(calculate_lowest_milk_purchase_budget(120, milk_stock_price))