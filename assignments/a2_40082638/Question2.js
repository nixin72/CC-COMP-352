let array = [88, 12, 94, 17, 2, 36, 69];

function MyAlgorithm(A, n) {
    let Res = [];
    for (let q = 0; q <= n - 1; q++) {
        Res[q] = 0;
    }

    for (let q = 0; q <= n - 2; q++) {
        for (let k = q + 1; k <= n - 1; k++) {
            if (A[q] <= A[k]) {
                Res[k] = Res[k] + 1;
            }
            else {
                Res[q] = Res[q] + 1;
            }
        }
    }

    let B = [];
    for (let q = 0; q <= n - 1; q++) {
        B[Res[q]] = A[q]; 
    }

    return B;
}

function myImplementation(A) {
    let Res = []; 
    let B = [];
    let n = A.length;

    for (let q = 0; q <= n - 1; q++) {
        if (Res[q] == undefined) {
            Res[q] = 0;
        }
        for (let k = q + 1; k <= n - 1; k++) {
            if (A[q] <= A[k]) {
                if (Res[k]) {
                    Res[k]++;
                }
                else {
                    Res[k] = 1
                }
            }
            else {
                if (Res[q]) {
                    Res[q]++;
                }
                else {
                    Res[q] = 1
                }
            }
        }

        B[Res[q]] = A[q];
    }

    return B;        
}

function myImplementation2(A) {
    let Res = 0;
    let B = [];
    
    for (let q = 0; q <= A.length - 1; q++) {
        for (let k = 0; k <= A.length - 1; k++) {
            if (A[q] > A[k]) {
                Res++;
            }
        }

        B[Res] = A[q];
        Res = 0;
    }

    return B;        
}

let result1 = MyAlgorithm(array, array.length);
let result2 = myImplementation(array);
let result3 = myImplementation2(array);

console.log(result1);
console.log(result2);
console.log(result3);  