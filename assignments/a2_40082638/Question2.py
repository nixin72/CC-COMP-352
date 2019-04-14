array = [88, 12, 94, 17, 2, 36, 69]

def MyAlgorithm(A, n):
    Res = [0 for q in range(0, n)]

    for q in range(0, n - 1):
        for k in range(q+1, n):
            if A[q] <= A[k]:
                Res[k] = Res[k] + 1
            else:
                Res[q] = Res[q] + 1

    B = [0 for q in range(0, n)]
    for q in range(0, n):
        B[Res[q]] = A[q]
    
    return B

def myImplementation(A):
    n = len(A)
    Res = [None] * n
    B = [0] * n

    for q in range(0, n):
        if Res[q] == None:
            Res[q] = 0

        for k in range(q+1, n):
            if A[q] <= A[k]:
                if Res[k]:
                    Res[k] += 1
                else:
                    Res[k] = 1
            else:
                if Res[q]:
                    Res[q] += 1
                else:
                    Res[q] = 1

        B[Res[q]] = A[q]

    return B

def myImplementation2(A):
    Res = 0
    n = len(A)
    B = [0] * n 
    
    for q in range(0, n):
        for k in range(0, n):
            if A[q] > A[k]:
                Res += 1

        B[Res] = A[q]
        Res = 0

    return B

print(MyAlgorithm(array, len(array)))
print(myImplementation(array))
print(myImplementation2(array))