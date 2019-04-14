Prefix Averages Alogrithm:
```Python
# Shitty version
avgs = [];
amounts = range(0, 10);
for x in amounts:
    avgs.push(sum(amounts[0:x])/len(amounts[0:x]));

print avgs;

```
This implementation of the prefix averages algorithm is $O(n^2)$

```Python
# Better Version
avgs = [];
amounts = range(0, 10);
sum = 0;
n = 1;
for x in amount: 
    sum += x;
    avgs.push(sum / n);
```
This function does the same thing but is $O(n)$

We've taken a function that does the exact same thing and reduced it's complexity by the order of an exponent. 

$Big-O, Big-\Omega, Big-\Theta$

Big-Omege:
- Given $f(n)$ and $g(n)$, we say $f(n)$ is $\Omega(g(n))$ if there are any positive contants, $c$ and n<sub>0</sub> such that: 
    - $f(n) >= cg(n) for n >= n\scriptscriptstyle 0$ 


What are $O()$ and $\Omega()$
- $f(n) = 2n+10$
    - $O(n)$ and $\Omega(n)$
- $f(n) = 3n^4 + 6n^3 + 10n^2 + 5n + 4$
    - $O(n^2)$ and $\Omega(n^4)$
- $f(n) = 4n^8 + 3n^2  + 2$
    - $O(n^{12})$
- $f(n) = 4n^6 + 3n^3 +12$
    - $O(n^6)$ and $\Omega(n^6)$

Big Theta: Given $f(n)$ and $g(n)$, we say $f(n)$ is $\Theta$

What is $\Theta()$ of the function $f(n) = 3n^4 + 6n^3 + 10n^2 + 5n+4$
$O(n^4)...O(n^x)$
$\Omega(n^4)...(1)$
$\Theta(n^6)$

$5n^2$ is $O(n^2)$
$5n^2$ is $\Omega(n)$
$5n^2$ is $\Theta(n)$

$f(n) = 3n^6 - 15n^8$
- doesn't work because algorithm's speed decreases as the size of input increases

$f_1(n) = 2n^2$
$f_2(n) = .1n^3$ <- Performs better for a little bit, but $f_1(n)$ surpasses it.

if $n = 1000,000,000$ on a machine that can execute $1,000,000$ statements per second. 

$log_2n = .0024 secs$
$n = 17 mins$
$nlog_2n = 7 hrs$
$n^2 = 300 yrs$


```CS
void main(String[] args) {
    int n = 31337;

    print("write Vertical (Iterative): " + n);
    writeVertical1(n);

    print("write Vertical (Recursive): " + n);
    writeVertical2(n);
}

void writeVeritcal1(int n) {
    int len = 0;
    int tmp = n;

    while (tmp > 0) {
        tmp = tmp / 10;
        len++;
    }

    for (int i = 1 ; i < len ; i++) {
        tmp = (int)Math.pow(10, len-i);
        tmp = n/tmp;
        tmp = tmp % 10;
        print("" + tmp);
    }
}

// I don't know why we didn't just do it this way? ¯\_(ツ)_/¯
void vert(int n) {
    while (n > 0) {
        System.out.println(n % 10);
        n = n / 10;
    }
}
```
Time complexity: $O(n + n) = O(2n) = O(n)$

```CS
void writeVertical2(int n) {
    if (n > 10)
        writeVertical2(n/2);

    print(n%10);
}

void writeVertical3(int n) {
    n > 10 ? writeVertical3(n/2) : print(n%10);
}

void tailRercusive(int n) {
    print(n%10);
    if (n > 10)
        tailRecursive(n/10);
}
```

Time complexity: $O(n)$

```Java
int factorial(int n) throws IllegalArgumentException {
    if (n < 0)
        throw new IllegalArgumentExeception();
    else if (n == 0)
        return 1;
    else 
        return n * factorial(--n);
}
```

- Linear Recursion
    - When your function makes a single recursive call on every iteration
- Binary Recursion
    - When your function makes two recursive calls on every iteration
- Multiple Recursion
    - When your function makes $N$ recursive calls on every iterations where $N > 2$


```
diskUsage(path)
    total = size(path);                 // O(1)
    if path is directory then           // O(1)
        for each child in dir           // O(n)
            total + diskUsage(path);    // O(n)

    return total; 
```
Time complexity: $O(n * n) = O(N^2)$





Ammorization

