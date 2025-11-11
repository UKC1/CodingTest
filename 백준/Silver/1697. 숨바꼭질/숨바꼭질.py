import sys
from collections import deque
from typing import List

N, K = map(int, sys.stdin.readline().split())

MAX = 200000
visited: List[bool] = [False] * (MAX + 1)

queue = deque()
queue.append((N, 0))
visited[N] = True

while queue:
    x, time = queue.popleft()
    
    if x == K:
        print(time)
        break
    
    for nx in (x - 1, x + 1, x * 2):
        if 0 <= nx <= MAX and not visited[nx]:
            visited[nx] = True
            queue.append((nx, time + 1))
