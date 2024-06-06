function solution(maps) {
    const n = maps.length, m = maps[0].length;
    const visited = Array.from({ length: n }, () => Array(m).fill(false));
    const queue = [];
    const dx = [-1, 0, 1, 0];
    const dy = [0, -1, 0, 1];

    queue.push([0, 0, 1]);
    visited[0][0] = true;
    
   
    while (queue.length > 0) {
        const [x, y, cnt] = queue.shift();

        if (x === n - 1 && y === m - 1) {
            return cnt;
        }

        for (let i = 0; i < 4; i++) {
            const nx = x + dx[i];
            const ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && maps[nx][ny] === 1) {
                visited[nx][ny] = true;
                queue.push([nx, ny, cnt + 1]);
            }
        }
    }

    return -1;
}
