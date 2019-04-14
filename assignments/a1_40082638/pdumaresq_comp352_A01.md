1. 
    - **A)** Given an array $A$ of integers of any size, $n ≥ 1$, and an integer value $x$, write an algorithm as a pseudo code (not a program!) that would find out the sum of all elements in the array that have values bigger than $x$, as well as the sum of all elements in the array that have values smaller than $x$. For instance, assume that array $A$ is as follows:
        $\{10, 14, 3, 9, 22, 35, 92, 5, 9, 64\}$
        Given $x = 9$, the algorithm would find the two sums as $237$ and $8$. Your algorithm must handle possible special cases. Finally, the algorithm must use the smallest auxiliary/additional storage to perform what is needed.
        ```
        Algorithm Compute Sums(list, x)
            Input: Array<{xER|x > 0}>, {xER|x > 0}
            Output: int, int 

            let sum1 = 0, 
                sum2 = 0,
                count = 0

            while count < list.length do
                if list[count] > x then
                    sum1 = sum1 + list[count]
                if list[count] < x then
                    sum2 = sum2 + list[count]

                count = count + 1

            return sum1, sum2
        ```

    - **B)** What is the time complexity of your algorithm, in terms of Big-O?
        > $O(n)$

    - **C)** What is the space complexity of your algorithm, in terms of Big-O?
        > $O(1)$
---

2. Prove or disprove the following statements, using the relationship among typical growth-rate
functions seen in class.
    - **A)** $5000000n^5 log(n) + n^7 = O(n^7 log(n))$
    > $let~f(x) = 5000000n^5 log(n) + n^7$
    $let~g(x) = n^7 log(n)$
    &nbsp;
    $\displaystyle{\lim_{x\to\infty}} {f(g)\over{g(x)}} = \displaystyle{\lim_{x\to\infty}}{{5000000n^5 log(n) + n^7}\over{n^7 log(n)}} = \displaystyle{\lim_{x\to\infty}}{5000000n^5 log(n)\over{n^7 log(n)}} + {n^7\over{n^7 log(n)}}$
    &nbsp;
    $= \displaystyle{\lim_{x\to\infty}}{5000000n^5\over{n^7}} + {1\over{log(n)}}= \displaystyle{\lim_{x\to\infty}}{5000000\over{n^2}} + {1\over{log(n)}}$
    &nbsp;
    $\displaystyle{{5000000\over{\infty^2}} + {1 \over{log(\infty)}} = {5000000\over{\infty}} + {1 \over{\infty}}} = 0 + 0 = 0$
    &nbsp;
    Since the limit is 0 and we're checking against Big-O, which is the upper bound, then it mean that $f(x)\in O(g(x))$
    $\therefore$ this is **True**

    - **B)** $10^{22}n^{21} + 5n^5 + 120n^3 = Θ(n^{29})$
    >$let~f(x) = 10^{22}n^{21}+5n^5+130n^3$
    $let~g(x) = n^{99}$
    &nbsp;
    $\displaystyle{\lim_{n\to\infty}}{f(x)\over{g(x)}} = {10^{22}n^{21}+5n^5+130n^3\over{n^{99}}} = {10^{22}n^{21}\over{n^{99}}} + {5n^5\over{n^{99}}} + {{130n^3\over{n^{99}}}}$
    &nbsp;
    $\displaystyle{\lim_{n\to\infty}}{10^{22}\over{n^{78}}} + {5\over{n^{94}}} + {{130\over{n^{96}}}} = {10^{22}\over{\infty^{78}}} + {5\over{\infty^{94}}} + {130\over{\infty^{96}}} = {10^{22}\over{\infty}} + {5\over{\infty}} + {130\over{\infty}} = 0+0+0 = 0$
    &nbsp;
    Since the limit is 0 then it means that $f(x) \notin\Theta(g(x))$
    $\therefore$ this is **false**

    - **C)** $n^n = Ω(n!)$
    > $let~f(x) = n^n$
    $let~g(x) = n!$
    &nbsp;
    $\displaystyle{\lim_{n\to\infty}}{f(x)\over{g(x)}} = {n^n\over{n!}} = \infty$
    &nbsp;
    Since we're checking against Big-$\Omega$, which is the lower bound, $f(x) \in\Omega(g(x))$
    $\therefore$ this is **true.**



    - **D)** $0.01n^3 + 0.0000001n^7 = Θ(n^3)$
    > $Let f(x) = 0.01n^3 + 0.0000001n^7$
    $let g(x) = n^3$
    &nbsp;
    $\displaystyle \lim_{n\to\infty} {f(x)\over{g(x)}} = {0.01n^3 + 0.0000001n^7\over{n^3}} = {0.01n^3\over{n^3}} + {0.0000001n^7\over{n^3}} = {0.01} + {0.0000001n^4}$
    &nbsp;
    $= 0.01 + {0.0000001\infty^4} = 0.01 + \infty = \infty$
    &nbsp;
    Since we're checking against Big-$\Theta$, which is true for both the upper and lower bound, $f(x) \notin \Theta(g(x))$ 
    $\therefore$ this is **false.** 


    - **E)** $n^6 + 0.0000001n^5 = Ω(n^5)$
    >$let~f(x) = n^6 + 0.0000001n^5$
    $let~f(x) = n^5$
    &nbsp;
    $\displaystyle \lim_{x\to\infty}{f(x)\over{g(x)}} = {n^6+0.0000001n^5\over{n^5}} = {n^6\over{n^5}} + {0.0000001n^5\over{n^5}} = n + 0.0000001$
    &nbsp;
    $\displaystyle = \infty + 0.0000001 = \infty$
    &nbsp;
    Since we're checking against Big-$\Omega$ which is the lower bound, $f(x) \in \Omega(g(x))$
    $\therefore$ this is **true.**

    - **F)** $n! = Θ(2^n)$
    >$let~f(x) = n!$
    $let~g(x) = 2^n$
    &nbsp;
    $\displaystyle {\lim_{n\to\infty}} {f(x)\over{g(x)}} = {n!\over{2^n}} = \infty$
    &nbsp;
    Since the limit is $\infty$ and we're checking against Big-$\Theta$, $f(x) \notin \Theta(g(x))$
    $\therefore$ this is **false.**

---

3. 
    - **A)** Given an unsorted array $A$ of integers of any size, $n ≥ 3$, and an integer value $x$, write an algorithm as a pseudo code (not a program!) that would find out if there exist EXACTLY $3$ occurrences in the array with value $x$.
    ```
    Algorithm ExactlyThree(list, pairs, current)
        Input:
            - A list of type integer. These will be the values to loop through.
            - A hashmap of <int, int> to store the list elements and the number of occurences
            - The index of the current item in the list. 
        Output: A boolean value indicating if any list item occurs exactly 3 times. 

        if current equal the length of the list
            loop through hashmap's values
                if value = 3
                    return true
            return false
        
        if the list item at the current index has a key in the hashmap
            increment the number of occurences for the current list item in the hashmap
        else 
            Add a new key/value pair to the hashmap with the current list item and 1 occurence

        return ExactlyThree(list, pairs, current + 1)

    ```
    - **B)** What is the time complexity of your algorithm, in terms of Big-O?
        > $O(n)$
    - **C)** What is the space complexity of your algorithm, in terms of Big-O?
        > $O(1)$
    - **D)** Will time complexity change if $A$ was given as a sorted array? If yes; give a new algorithm that achieves this better complexity (indicate the time complexity as of that algorithm). If no, explain why such new constraints/conditions cannot lead to a better time complexity.
  
        > No, inputting a sorted array will not change the time complexity of my algorithm. My algorithm will always search through the entire array because it needs to know if a single list item will occur *more* than three times, meaning it will need to search the whole list every time. Given a sorted array, you could re-write this to use a binary-search kind of algorithm to improve the performance. 

---

### Programming Questions (50 marks):
In class, we discussed about the two versions of Fibonacci number calculations: BinaryFib(n) and LinearFibonacci(n) (refer to your slides and the text book). The first algorithm has exponential time complexity, while the second one is linear.

- **A)** In this programming assignment, you will design an algorithm (in pseudo code), and implement (in Java), two recursive versions of an Oddonacci calculator (similar to the ones of Fibonacci) and experimentally compare their runtime performances. Oddonacci numbers are inspired by Fibonacci numbers but start with three predetermined values, each value afterwards being the sum of the preceding three values. The first few Oddonacci numbers are:    
    > $\{1, 1, 1, 3, 5, 9, 17, 31, 57, 105, 193, 355, 653, 1201, 2209, 4063, 7473, 13745, 25281, 46499, ...\}$

    For that, with each implemented version you will calculate Oddonacci(5), Oddonacci (10), etc. in increments of 5 up to Oddonacci(100) (or higher value if required for your timing measurement) and measure the corresponding run times. For instance, Oddonacci(10) returns 105 as value. You can use Java’s built-in time function for this purpose. You should redirect the output of each program to an out.txt file. You should write about your observations on the timing measurements in a separate text file. You are required to submit the two fully commented Java source files, the compiled files, and the text files.

    ```
    Algorithm MultiOddo(x)
        Input: {xER|x > 0}
        Output: sum of the Oddonacci sequence

        if x <= 2 then
            return 1
        else 
            reuturn MultiOddo(x-3) + MultiOddo(x-2) + MultiOddo(x-1)
    ```
    ```
    Algorithm LinOddo(x)
        Input: {xER|x > 0}
        Output: Array of the last 3 Oddonacci number calculated

        if n <= 2 then
            return [1, 1, 1];
        else
            let temp = LinOddo(n - 1);
            return [temp[0] + temp[1] + temp[2], temp[0], temp[1]];
    ```

- **B)** Briefly explain why the first algorithm is of exponential complexity and the second one is linear (more specifically, how the second algorithm resolves some specific bottleneck(s) of the first algorithm). You can write your answer in a separate file and submit it together with the other submissions.
    > The first algorithm has an exponential complexity because for each non-base case of the function call, it needs to call itself 3 more times. That means that the first call to the function will spawn 3 more function calls, all 3 of which will spawn 3 more, and so on. This means that the number of function calls will increase from 1 to 4 to 13 to 40 to 121 very quickly. 
- **C)** Do any of the previous two algorithms use tail recursion? Why or why not? Explain your answer. If your answer is “No” then:
  Can a tail-recursive version of Oddonacci calculator be designed?
    - i. If yes; write the corresponding pseudo code for that tail recursion algorithm and
implement it in Java and repeat the same experiments as in part (a) above.
    - ii. If no, explain clearly why such tail-recursive algorithm is infeasible. You will need to submit both the pseudo code and the Java program, together with your experimental results. Keep in mind that Java code is not pseudo code. 
    
    No, neither of my algorithms use tail recursion. Neither of them use any sort of accumulator to keep track of current values, so during each recursive call, it needs to keep track of the state in each of the previous calls. 
    &nbsp;
    Yes this algorithm can be implemented using tail recursion. 

    ```
    Algorithm OddonacciTail(n, a, b, c)
        Input: 
            - The n-th oddonacci number to compute
            - The previous three oddonacci numbers
        Output:
            - The n-th oddonacci number

        if n == (0 or 1)
            return 1
        if n == 2 
            return c
        return OddonacciTail(n - 1, b, c, a + b + c)
    ```