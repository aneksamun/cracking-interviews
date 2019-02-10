function add(a, b) {
    return a + b;
}

function partial(f, a) {
    return function (b) {
        return f(a, b);
    }
}

var addTwo = partial(add, 2);
var sum = addTwo(3);
console.log(sum);
