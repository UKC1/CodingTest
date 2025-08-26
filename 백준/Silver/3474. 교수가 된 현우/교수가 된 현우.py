# bj_3474
import sys

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    count = 0
    divisor = 5
    while N >= divisor:
        count += N // divisor
        divisor *= 5
    print(count)
