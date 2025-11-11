import sys
from typing import List
from collections import deque

N, K = map(int, sys.stdin.buffer.readline().split())

visited: List[bool] = [False] * 200001
queue = deque()
queue.append((N, 0))
visited[N] = True
while queue:
    x, time = queue.popleft()

    if x == K:
        print(time)
        break
    
    nx = x + 1
    
    if nx >= 0 and nx < len(visited) and not visited[nx]:
        visited[nx] = True
        queue.append((nx, time + 1)) 
    
    nx = x - 1
    
    if nx >= 0 and nx < len(visited) and not visited[nx]:
        visited[nx] = True
        queue.append((nx, time + 1)) 
    
    nx = x * 2
    
    if nx >= 0 and nx < len(visited) and not visited[nx]:
        visited[nx] = True
        queue.append((nx, time + 1)) 
    
