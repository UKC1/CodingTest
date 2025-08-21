# bj_4375
# 1로만 구성된 숫자 찾기
# n 1 ~ 10000
import sys

import sys

for line in sys.stdin:
    N = int(line.strip())
    num = 1
    length = 1
    while True:
        if num % N == 0:
            print(length)
            break
        num = num * 10 + 1
        num %= N   # 숫자 커지는 것 방지
        length += 1
