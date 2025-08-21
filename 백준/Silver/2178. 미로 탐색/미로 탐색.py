# bj_2178
# BFS 문제
# 1은 이동 
# 0은 이동 x
# 1 1 -> N M 최소 칸수

import sys
from collections import deque

# sys.stdin.readline()을 사용하면 더 빠르게 입력받을 수 있습니다.
input = sys.stdin.readline

# split 공백 기준
N, M = map(int, input().split())

# 미로 입력: '10101' 같은 문자열을 정수 리스트로 변환
maze = [list(map(int, input().strip())) for _ in range(N)]

# 방문 여부
visited = [[False] * M for _ in range(N)]

# BFS
q = deque()
q.append((0, 0, 1))  # (x, y, dist) 시작 칸을 포함하므로 dist=1
visited[0][0] = True

# 상,좌,하,우 (문제는 보통 상하좌우면 어떤 순서든 무관)
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

while q:
    x, y, dist = q.popleft()

    # 목표 지점 도달
    if x == N - 1 and y == M - 1:
        print(dist)
        sys.exit(0)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < M:
            if maze[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, dist + 1))

