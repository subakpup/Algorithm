import sys
input = sys.stdin.readline

def isPrime(n):
    if n < 2:
        return False
    else:
        for i in range(2, int(n**0.5)+1):
            if n % i == 0:
                return False
        return True

for i in range(int(input())):
