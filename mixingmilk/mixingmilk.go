/* based on the problem from
http://acm.hit.edu.cn/judge/show.php?Proid=1003

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
