N = int(input())

start = 1
end = 1
current_sum = 1
count = 0

while start <= N:
    if current_sum == N:
        count += 1
        current_sum -= start
        start += 1
    elif current_sum < N:
        end += 1
        if end > N:
            break
        current_sum += end
    else:
        current_sum -= start
        start += 1

print(count)
