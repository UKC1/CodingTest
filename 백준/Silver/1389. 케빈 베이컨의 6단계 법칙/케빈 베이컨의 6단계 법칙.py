import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
adj = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

def bfs(start: int) -> list[int]:
    dist = [-1] * (N + 1)
    q = deque([start])
    dist[start] = 0
    while q:
        cur = q.popleft()
        for nx in adj[cur]:
            if dist[nx] == -1:
                dist[nx] = dist[cur] + 1
                q.append(nx)
    return dist

min_sum = float('inf')
min_num = 0
for i in range(1, N + 1):
    d = bfs(i)
    s = sum(x for x in d[1:] if x != -1)  # 연결되지 않은 정점은 제외(필요 시 처리 변경)
    
    if (min_sum > s):
        min_sum = s
        min_num = i

print(min_num)
