console.log("Hello World, i Know how to count");

[1,2,3,4].forEach(n=>console.log(n));

//a)
var boys = ["Peter", "lars", "Ole"]
var girls = ["Janne", "Hanne", "Sanne"]
//b)
var mixedGenders = boys.concat(girls)


//c)
let SringGenders1 = mixedGenders.join(',')
let StringGenders2 = mixedGenders.join('-')
//d)
mixedGenders.push("Lone", "Gitte")
mixedGenders.unshift("Hans", "Kurt")

//e)
mixedGenders.shift()
mixedGenders.pop()



//f))
mixedGenders.splice(3, 2)
console.log(mixedGenders)


//g))

mixedGenders.reverse()
console.log(mixedGenders)

//h)




//i)

let newMap = mixedGenders.map(n=> n.toUpperCase())
console.log(newMap)


//j)

function filterName(arrayOfNames, index, letter) {
    var filteredNames = arrayOfNames.filter(function(word) {
     return word[index] === letter;
    });
    return filteredNames 
}


var larsLoneArray = filterName(mixedGenders, 0, 'L').concat(filterName(mixedGenders, 0, 'l'))

console.log(larsLoneArray)