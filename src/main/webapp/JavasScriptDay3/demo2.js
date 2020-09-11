//Function Declaration
       //Observe: no return type, no type on parameters
function add(n1, n2){
   return n1 +n2;
}

//Function Expression
var sub = function(n1,n2){
  return n1 - n2
} 

//Callback example
var cb = function(n1,n2, callback){
    
   if(typeof n1 == "number" && typeof n2 == "number" && typeof callback == "function" ){
       
       return "Result from the two numbers: "+n1+"+"+n2+"="+callback(n1,n2);
       
   } else{
       
       throw new Exception("Exception message");
       
   }
    
  
};

function divide(n1,n2){
    
   return n1 / n2
}



var mul = function(n1,n2,callback){
    
    return "Result from the two numbers: "+n1+"/"+n2+"="+callback(n1,n2);
}





//2)
console.log( add(1,2) )     // What will this print? Resultatet af 1+2 sammenlagt
console.log( add )          // What will it print and what does add represent? Ingen argumenter med i metodekaldet, derfor vil funktionen bare blive kaldt
console.log( add(1,2,3) ) ; // What will it print Metoden tage kun to argumenter derfor 1+2 = 3
console.log( add(1) );	  // What will it print NaN manglende argument	
console.log( cb(3,3,add) ); // What will it print 3+3 = 6, da 3 og 3 bliver sendt med, samt en callbackfunction add, som lægger de to tal sammen.
console.log( cb(4,3,sub) ); // What will it print 4-3 = 1, da 4-3 bliver sendt med, samt en callbackfunction sub, som trækker de to tal fra hinanden
//console.log(cb(3,3,add())); // What will it print (and what was the problem) Vi kan ikke kalde metoden direkte i form parametren

//3)
//try catch
try {
console.log(cb(3,"hh",add));// What will it print
} catch(e){
    
    console.log("Det skal være tal.")
}

//4-5) more callbacks

console.log(mul(2,2,divide))

//more callbacks filte map and foreach


//1)
let myNames = ["Lars", "Jan", "Peter", "Bo", "Frederik"]

let filtered = myNames.filter(n=> n.length <= 3)

console.log(filtered)

//2)
let upperCaseNames = myNames.map(n=> n.toUpperCase())

console.log(upperCaseNames)


//3)

let arrayOfNames = ["Lars", "Peter", "Jan", "Ian"]


let htmlArray = arrayOfNames.map(function(n){
    
    return "<li>" + n + "</li>" 
    
})


htmlArray.unshift("<ul>")
htmlArray.push("</ul>")

let stringArray = htmlArray.join(" ")

console.log(stringArray)

//4)

var cars = [
  { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
  { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
  { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
  { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
  { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
];

let filteredCarsYear = cars.filter(function(n){
    
    
    return n.year > 1999;
    
})

let filteredCarsVolvo = cars.filter(function(n){
    
    
    return n.make == 'Volvo';
    
})

let filteredCarsPrice = cars.filter(function(n){
    
    
    return n.price < 5000;
    
})

console.log(filteredCarsYear)


//4a

var sqlCars = cars.filter(n => n.year > 1999).map(x => 'INSERT INTO cars (id,year,make,model,price) VALUES (' + x.id +"," + x.year +","+ x.make + ","+x.model + ","+x.price + ") ")

console.log(sqlCars.join(""))


// Asynchronous Callbacks

var msgPrinter = function(msg,delay){
  setTimeout(function(){
    console.log(msg);
  },delay);
};
console.log("aaaaaaaaaa"); //nr1
msgPrinter ("bbbbbbbbbb",2000); //nr5
console.log("dddddddddd");// nr2
msgPrinter ("eeeeeeeeee",1000); //nr4
console.log("ffffffffff"); //nr3



