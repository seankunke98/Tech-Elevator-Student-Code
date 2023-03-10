/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa is above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */


function isAdmitted(gpa, satScore = 0, recommendation = false) {
    if(gpa > 4.0 || satScore > 1300 || gpa > 3.0 && recommendation == true || satScore > 1200 && recommendation == true) {
        return true;
    } else {
        return false;
    }

}

/**
 * Write a function called useParameterToFilterArray that takes an anonymous
 * function and uses that in the `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */

let unfilteredArray = [1, 2, 3, 4, 5, 6];

function useParameterToFilterArray(filterFunction) {
    return unfilteredArray.filter(filterFunction);
}

/**
 * Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */

function makeNumber(first, second = '') {
    fullString = first + second;
    let fullNumber = parseInt(fullString);
    return fullNumber;

}

/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */
function addAll() {
    let result = 0;
    for(let i = 0; i < arguments.length; i++) {
        result += arguments[i];
    }
    return result;
}

/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */
function makeHappy(array) {
    let happy = array.map(
        (word) => {
            return "Happy " + word;
        }
        );
        return happy;
}

/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects containing the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * and returns an array of strings that turns the JavaScript objects
 * into a mailing address in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */
/**   
//    @param {number} streetNumber
//    @param {string} streetName
//    @param {string} streetType
//    @param {string} city
//    @param {string} state 
//    @param {number} zip
*/
// this also passes
// function getFullAddressesOfProperties(keys) {  
//     return keys.map(address => address.streetNumber + ' ' + address.streetName + ' ' + 
//         address.streetType + ' ' +  address.city + ' ' + address.state + ' ' + address.zip);
// }


function getFullAddressesOfProperties(keys) {
    let array = keys.map(address => {
        return address.streetNumber + ' ' + address.streetName + ' ' +  address.streetType + ' ' + address.city + ' ' + address.state + ' ' + address.zip;
    });
    console.log(array);
    return array;
}


/** 
 * Write and document a function called findLargest that uses `forEach`
 * to find the largest element in an array.
 * The function must work for strings and numbers.
 * 
 * For strings, "largest" means the word coming last in lexographical order.
 * Lexographic is similar to alphabetical order except that 
 * capital letters come before lowercase letters: 
 * 
 * "cat" < "dog" but "Dog" < "cat"
 *
 * @param {number[]|string[]} searchArray the array to search
 * @returns {number|string} the number or string that is largest
 **/
/**
 * 
 * @param {Array} elements 
 */
       
function findLargest(elements) { 
    let largest = elements[0];
     elements.forEach( function (item) {
             if (item > largest) { largest = item; }
         }) 
             return largest;  
 }

/*
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */
function getSumOfSubArrayValues(arrayOfArrays= []) {
    return arrayOfArrays.reduce( (grandTotal, innerArray) => {
        return grandTotal + innerArray.reduce ( (innerSum, current) => innerSum + current);
    }, 0)}
