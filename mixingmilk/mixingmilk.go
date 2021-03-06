/* based on the problem from
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
*/
package main
import "fmt"
import "os"
import "strconv"
import "sort"
type Producer struct{

  price int
  amount int
}

type ByPrice []Producer
func (a ByPrice) Len() int {return len(a)}
func (a ByPrice) Swap(i, j int) {a[i], a[j]=a[j], a[i]}
func (a ByPrice) Less(i, j int ) bool {return a[i].price < a[j].price}


func main(){

  amountMilk, err:=strconv.Atoi(os.Args[1])
  if (err!=nil){
    fmt.Println("error")
  }
  var  numProducers int
  numProducers, err= strconv.Atoi(os.Args[2])

  producers:= make([]Producer, numProducers)
  for i:=0; i< numProducers; i++ {

    producers[i].price, err=strconv.Atoi(os.Args[3+i*2])
    producers[i].amount, err=strconv.Atoi(os.Args[4+i*2])
  }


   fmt.Println(computeMinCost(producers, amountMilk))
   fmt.Println(amountMilk)



}

func computeMinCost( producers []Producer, amount int) int{
  sum:=0
  sort.Sort(ByPrice(producers))
  for i:=0; i< len(producers); i++{
    var curAmount int= producers[i].amount
    if (amount < producers[i].amount){
        curAmount=amount
    }
        amount-=curAmount
    sum+=computeRevenue(producers[i].price, curAmount)

  }
  return sum
}

func computeRevenue(price int , amount int) int{

  fmt.Printf("price: %d, amount %d\n", price, amount)
  return (price*amount)
}
