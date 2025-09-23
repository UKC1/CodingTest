import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
maps = [list(input().strip()) for _ in range(N)]

# 시작 위치 탐색
for i in range(N):
    for j in range(M):
        if maps[i][j] == 'I':
            sx, sy = i, j

dx = (-1, 0, 1, 0)
dy = (0, -1, 0, 1)
visited = [[False] * M for _ in range(N)]
visited[sx][sy] = True

q = deque([(sx, sy)])
cnt = 0

while q:
    x, y = q.popleft()
    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
            if maps[nx][ny] != 'X':
                visited[nx][ny] = True
                if maps[nx][ny] == 'P':
                    cnt += 1
                q.append((nx, ny))

print(cnt if cnt else "TT")
