### Recursion

Recursion is used when a problem needs to be broken down into smaller instances of the exact same problem. 

Base case is the case that tells the function to stop recursing. Each time you recurse, you get closer and closer to your base case. 

Examples that use recursion:
- Binary Search
    - Run $O(log_n) $ times.
    - Each recursive call inspects on elements, as well as comuputing new max/min
- Linear sum
    ``` JavaScript
    let arr = [...Array.size(N)];
    function calcSum(list, n) {
        if (n == 0) 
            return 0;
        else 
            return calcSum(list, n-1) + list[n-1];
    }
    
    // Icarus
    let calcSum = A n: n == 0 ? 0 : calcSum(A, n-1) + A[n-1]; 
    ```

- Reversing an array
    ```JavaScript
    reverse(A, i, j) {
        if (i < j) {
            let tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            
            reverse(A, i+1, j-1);
        }
    }
    
    // Icarus
    let rev = {A i j:
        if(i < j, {:
            let tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;

            rev(A, i+1, j-1);
        });
    }
    ```

- Computing Powers
    $p(x,n) = x^n$
    ```JS
    function power(x, n) {
        if (n == 1) {
            return 1;
        }
        return x * power(x, --n);
    }

    let pow = (x, n) => n == 1 ? 1 : x * pow(x, --n);
    
    // Icarus
    let pow = x n: if(n == 1, 1, x * pow(x, --n));
    let power = {x n:
        if (n == 1, {:
            1
        }, {:
            x * power(x, --n)
        });

        if (n == 1, 1);
        x * power(x, --n);
    };
    ```

#### Binary Recursion
Occurs when there are two recursive calls for each non-base case. 

```JS
function BinSum(A, i, n) {
    if (n == 1) {
        return A[i];
    }
    return BinSum(A, i, n/2) + binSum(A, i + n/2, n/2);
}

// Icarus
let binSum = (A i n): if(n == 1, A[i], binSum(A, i, n/2) + binSum(A, i+n/2, n/2));
```

Computing Fibonacci numbers:
```JS
function binaryFibonacci(n) {
    if (k <= 1)
        return k;
    return binaryFibonacci(k-1) + binaryFibonacci(k-2);
}

let bFib = n => n <= 1 ? 1 : bFib(n-1) + bFib(k-2);

// Icarus
let bFib = n : n <= 1 ? n : bFib(n-1) + bFib(k-2);
```

### Tail Recursion
- Occurs when a linear recursive method makes it's recursive call as the last step.
- The array reversal method is an example
- Such methods can easily be converted into non-recursive methods. 

### Infinite Recursion
Easy to do by mistake, and can depend on input. 
Ex. In binary search, it's easy to have an off-by-one in your recusive calls and not notice it because your test value is left or right of the center. 

