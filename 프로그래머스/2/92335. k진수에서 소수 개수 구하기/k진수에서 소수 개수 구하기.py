import math

def solution(n, k):
    answer = 0
    k_num = k_number_converter(n, k)
    k_num_zero_split_list = k_num.split("0")
    
    for num in k_num_zero_split_list:
        if num == '':
            continue
        
        if is_prime(int(num)):
            answer += 1
    
    return answer

# 소수 판별 함수
def is_prime(n):
    if n < 2:
        return False
    for i in range (2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

# k 진법 변환 함수
def k_number_converter(n, k):
    # StringBuilder
    digits = []
    while n > 0:
        n, mod = divmod(n, k)
        digits.append(str(mod))
    return ''.join(reversed(digits))