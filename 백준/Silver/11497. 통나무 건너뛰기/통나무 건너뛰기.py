import sys

# 빠른 입력을 위해 사용
input = sys.stdin.readline

try:
    line = input().strip()
    if not line:
        T = 0
    else:
        T = int(line)
except ValueError:
    T = 0

for _ in range(T):
    N = int(input())
    
    nums = list(map(int, input().split()))
    
    nums.sort()
    
    # 정렬된 상태에서 '인덱스가 2 차이 나는 것'들의 차이와 같습니다.
    max_diff = 0
    
    # 인덱스 2부터 시작해서 2칸 전(i-2)과 비교
    for i in range(2, N):
        diff = nums[i] - nums[i-2]
        max_diff = max(max_diff, diff)
        
    print(max_diff)