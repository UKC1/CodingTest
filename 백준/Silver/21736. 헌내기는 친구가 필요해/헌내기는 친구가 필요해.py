import sys
from collections import deque

# 입력 받기
N, M = map(int, sys.stdin.readline().split())
maps = [list(sys.stdin.readline().strip()) for _ in range(N)]

# 시작 위치 찾기
start_x = start_y = 0
for i in range(N):
    for j in range(M):
        if maps[i][j] == 'I':
            start_x, start_y = i, j
            break

# BFS 준비
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
visited = [[False] * M for _ in range(N)]
q = deque()
q.append((start_x, start_y))
visited[start_x][start_y] = True

# 탐색
person_cnt = 0
while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
            if maps[nx][ny] != 'X':  # 벽이 아니면 이동
                visited[nx][ny] = True
                if maps[nx][ny] == 'P':
                    person_cnt += 1
                q.append((nx, ny))

# 출력
print(person_cnt if person_cnt > 0 else "TT")
