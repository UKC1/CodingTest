import sys
from collections import deque

# 빠른 입력을 위해 사용
input = sys.stdin.readline

# 입력 받기
N, M = map(int, input().split())
grid = []
visited = [[-1] * M for _ in range(N)] # 방문 안 한 곳은 -1로 초기화
target_x, target_y = 0, 0

# 지도 생성 및 목표지점(2) 찾기
for i in range(N):
    # 한 줄을 리스트로 바로 받습니다.
    row = list(map(int, input().split()))
    grid.append(row)
    for j in range(M):
        if row[j] == 2:
            target_x, target_y = i, j
            visited[i][j] = 0   # 목표지점의 거리는 0
        elif row[j] == 0:
            visited[i][j] = 0   # 원래 갈 수 없는 땅(0)은 거리를 0으로 표시

# 상하좌우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(sx, sy):
    q = deque([(sx, sy)])
    
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            # 지도 범위 안이고, 아직 방문하지 않았으며(-1), 갈 수 있는 땅(0이 아님)인 경우
            if 0 <= nx < N and 0 <= ny < M:
                if visited[nx][ny] == -1 and grid[nx][ny] != 0:
                    visited[nx][ny] = visited[x][y] + 1 # 현재 거리 + 1
                    q.append((nx, ny))

bfs(target_x, target_y)

for row in visited:
    print(*row) 
    # 리스트 앞의 *는 대괄호 없이 내용을 공백 구분으로 출력해줍니다.