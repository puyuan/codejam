/*
http://acm.hit.edu.cn/judge/show.php?Proid=1033
*/

package main
import "fmt"

func main(){
  //  testRejectSolution()
  //  testGenerateNextCandidate()
  data:=[]string{"acm", "ibm"}
  testBackTrack(data)
  data=[]string{"acm", "malform", "mouse"}
  testBackTrack(data)
  data=[]string{"ok", "ok"}
  testBackTrack(data)

}

func testRejectSolution(){
  partialSolution:=[]string{"a", "b","c"}
  result:=rejectSolution(partialSolution)
  if(result){
    //fmt.Println("solution accepted")
    return
  }

  //fmt.Println("solution rejected")

}

func testGenerateNextCandidate(){

  partialSolution:=[]string{"abc", "cde", "ghh"}
  remainderArr:=[]string{"test", "123", "abcsdf"}
  candidateIndex:=0
  partialSolution, remainderArr = generateNextCandidate(partialSolution, remainderArr, candidateIndex)

}




func testBackTrack(data[]string){

  var partialSolution []string 
  //remainderArr:=[]string{"kabcz", "abcdef", "fghei", "iflijk"}
  remainderArr:=data
  result:=backTrack(partialSolution, remainderArr)

  if(result){
    fmt.Println("Ordering is possible.")

  }else{
    fmt.Println("The door cannot be opened.")

  }

}


func backTrack(partialSolution[]string, remainderArr[]string) bool{

  if rejectSolution(partialSolution){
    //fmt.Println("solution rejected")
    return false
  }

  if (acceptSolution(remainderArr)){
    //fmt.Println("solution accepted")
    return true
  }

  for i:=0; i< len(remainderArr); i++ {
    partialSolution, nextRemainderArr:= generateNextCandidate(partialSolution, remainderArr, i)
    if (backTrack(partialSolution, nextRemainderArr)==true){
       return  true

     }

  }
  return false
}


func generateNextCandidate(partialSolution[] string, remainderArr[] string, candidateIndex int) ([]string, []string){

  nextPartialSolution:=make([]string, len(partialSolution))
  copy(nextPartialSolution, partialSolution)
  candidate:=remainderArr[candidateIndex]
  nextPartialSolution=append(nextPartialSolution, candidate)
  nextRemainderArr:=make([]string, len(remainderArr))
  copy(nextRemainderArr, remainderArr)
  nextRemainderArr= append(nextRemainderArr[:candidateIndex], nextRemainderArr[candidateIndex+1:len(remainderArr)]...)
  //fmt.Printf("Generate candidate \n %q\n%q\n", nextPartialSolution, nextRemainderArr)


  return nextPartialSolution, nextRemainderArr

}
func acceptSolution(remainderArr[]string) bool{
    if (len(remainderArr)==0){
      return true
    }

    return false

}


func rejectSolution(partialSolution [] string) bool{

  if (len(partialSolution)<=1){
    return false
  }

  candidate:=partialSolution[len(partialSolution)-1]
  firstChar:=candidate[0]

  lastSolution:=partialSolution[len(partialSolution)-2]
  lastChar:=lastSolution[len(lastSolution)-1]
  if(lastChar!=firstChar){
    //fmt.Printf("REJECTED")

    return true 
  }


  return false

}
