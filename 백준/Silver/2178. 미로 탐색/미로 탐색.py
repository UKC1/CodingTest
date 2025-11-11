import sys
from collections import deque
from typing import List

# bfs 문제

# 입력값 받기
N, M = map(int, sys.stdin.readline().split())

# map, visited 배열 초기화
maps: List[List[int]] = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]
visited: List[List[bool]] = [[False] * M for _ in range(N)]

# 사방 탐색용 배열 
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


queue = deque()
# 시작 점 대입
queue.append((0, 0, 1))
visited[0][0] = True

while queue:
    x, y, count = queue.popleft()

    # 목적지 도착
    if x == N - 1 and y == M - 1:
        print(count)
        break
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (nx >= 0 and nx < N and ny >= 0 and ny < M and not visited[nx][ny] and maps[nx][ny] == 1):
            visited[nx][ny] = True
            queue.append((nx, ny, count + 1))

