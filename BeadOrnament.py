#!/bin/python3

import os
import sys

#
# Complete the beadOrnaments function below.
#
def beadOrnaments(b):
    #
    # Write your code here.
    base = cayleys(len(b))
    #base = sum(arr)
    if len(b) == 1:
        return cayleys(b[0])%1000000007
    else:
        base = sum(b)**(len(b) - 2)
        for i in b:
            base *= i*cayleys(i)
        return base%1000000007

def cayleys(n):
    if n<=2:
        return 1
    else:
        return pow(n,n-2)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        b_count = int(input())

        b = list(map(int, input().rstrip().split()))

        result = beadOrnaments(b)

        fptr.write(str(result) + '\n')

    fptr.close()
