def solution(n):
    answer = [[-1] * n for _ in range(n)]
    # 우 하 좌 상
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    direction = 0
    num, x, y = 1, 0, 0
    while n * n >= num:
        answer[x][y] = num
        num += 1
        nx = x + dx[direction]
        ny = y + dy[direction]
        # 방향 전환을 해야할 순간
        # 1. 맵 벗어나는 경우
        # 2. 이미 값이 채워진 경우
        if nx < 0 or nx >= n or ny < 0 or ny >= n or answer[nx][ny] != -1:
            direction = (direction + 1) % 4
            nx = x + dx[direction]
            ny = y + dy[direction]
        x = nx
        y = ny
    return answer