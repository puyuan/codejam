$(function(){

    genTable();
    solve(sudokuGrid, 0, -1);


});

/**
 * Randomize array element order in-place.
 * Using Fisher-Yates shuffle algorithm.
 */
function shuffleArray(array) {
    for (var i = array.length - 1; i > 0; i--) {
        var j = Math.floor(Math.random() * (i + 1));
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    return array;
}

var genTable=function(){


  var table=$("#table")
    for (var i=0; i<9; i++){
      var row=$("<tr></tr>");
      for (var j=0; j<9; j++){
        
        row.append($("<td>&nbsp;</td>"));
      }
      table.append(row);
    }
}


var printTable=function(grid){

  for (var i=0; i<9; i++)
    for (var j=0; j<9; j++)
      $("#table").children().children().eq(i).children().eq(j).html(grid[i][j]);


}


var sudokuGrid=(function(){
  var grid=[]
  for (var  i=0; i<9; i++){
    grid[i]=[]
    for (var j=0; j<9; j++){
        grid[i][j]=0
    }

  }

    return grid;
  
})();

var isASolution=function(grid, i, j){

    var bitmap=[]
    for(var col=0; col<9; col++){
        if (grid[i][col]!=0)
         setBit(bitmap, grid[i][col]);
    }

    if(!verifyBitMap(bitmap))
      return false;


    bitmap=[]
     
      if (j==-1)
        return true;

    for(var row=0; row<9; row++){
        if (grid[row][j]!=0)
         setBit(bitmap, grid[row][j]);
    }
    if(!verifyBitMap(bitmap))
      return false;

    var regionx=parseInt(i/3);
    var regiony=parseInt(j/3);

    bitmap=[]
    for (var row=regionx*3; row<(regionx+1)*3; row++){

      for(var col=regiony*3; col<(regiony+1)*3; col++){
        if(grid[row][col]!=0) 
          setBit(bitmap, grid[row][col]);
      }

    }
    if(!verifyBitMap(bitmap))
      return false;




    return true;



}


var setBit=function(bitmap, i){
  if(bitmap[i]==undefined)
    bitmap[i]=1
  else
    bitmap[i]+=1
}

var verifyBitMap=function(bitmap){
   for(var i=0; i<9; i++){
       if(bitmap[i]>1)
         return false;
   }
   return true;
}

var generateCandidate=function(grid, nexti, nextj){

  var bitmap=[]
  for (var j=0; j<9; j++){
     if (grid[nexti][j]!=0)
           bitmap[grid[nexti][j]-1]=1;
  }
  for (var i=0; i<9; i++){
     if (grid[i][nextj]!=0)
           bitmap[grid[i][nextj]-1]=1;
  }
    var regionx=parseInt(nexti/3);
    var regiony=parseInt(nextj/3);

    for (var row=regionx*3; row<(regionx+1)*3; row++){

      for(var col=regiony*3; col<(regiony+1)*3; col++){
        if(grid[row][col]!=0) 
          bitmap[grid[row][col]-1]=1;
      }

    }

  var solutions=[];
  for (var i=0; i<9; i++){
    if(bitmap[i]==undefined)
    solutions.push(i+1)
  }
  return shuffleArray(solutions);
}


var copyArray=function(grid){
  var newgrid=[] 
  for (var i=0; i<9; i++){
      newgrid[i]=grid[i].slice(0);
   }
  return newgrid;

}

var count=0;
var solve=function(grid, i, j){
  grid=copyArray(grid)
  if(!isASolution(grid, i,j))
     return false;
     
  if (i==8 && j==8){
   console.log(grid);
    return true

  }

  var nexti, nextj;

  if (j<8){
    nexti=i;
    nextj=j+1;
  }else{
    nexti=i+1;
    nextj=0;}

  if(count%1000000==0){
    console.log(count);
  }
  var solutions=generateCandidate(grid, nexti, nextj)
  for (var sol=0; sol<solutions.length; sol++){
    grid[nexti][nextj]=solutions[sol];
    count++;
    setTimeout(printTable, count*100, grid);
    //printTable(grid);
    if (solve( grid, nexti, nextj))
      return true;
  }

  return false;

}
