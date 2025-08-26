# bj_2870
import sys

N = int(sys.stdin.readline())
nums = []

for _ in range(N):
    line = sys.stdin.readline().strip()
    tmp = ''
    for ch in line:
        if ch.isdigit():
            tmp += ch
        else:
            if tmp != '':
                nums.append(int(tmp))
                tmp = ''
    if tmp != '':
        nums.append(int(tmp))  # 줄 끝이 숫자로 끝날 때

nums.sort()

for num in nums:
    print(num)

