import math

def solution(fees, records):
    answer = []
    # car_time: 차량별 누적 주차 시간(분)
    car_time = {}
    # current_car_time: 입장(IN) 시간(분)을 저장. OUT이면 삭제
    current_car_time = {}
    
    for record in records:
        time_str, car_no, status = record.split()
        t = minute_converter(time_str)
        
        if status == 'IN':
            # 입장: 입장 시간만 저장
            current_car_time[car_no] = t
            # 누적시간 초기화(처음 보는 차량이면 0으로 초기화)
            if car_no not in car_time:
                car_time[car_no] = 0
        else:  # OUT
            # 안전하게 IN이 있었는지 확인
            in_time = current_car_time.get(car_no)
            if in_time is None:
                # 비정상 데이터지만 무시하거나 continue
                continue
            duration = t - in_time
            car_time[car_no] = car_time.get(car_no, 0) + duration
            # 현재 입장 기록 제거
            del current_car_time[car_no]
    
    # 23:59까지 나가지 않은 차량 처리
    end_of_day = minute_converter("23:59")
    for car_no, in_time in list(current_car_time.items()):
        duration = end_of_day - in_time
        car_time[car_no] = car_time.get(car_no, 0) + duration
        # del current_car_time[car_no]  # optional
    
    # 요금 계산
    default_minute, default_fee, unit_time, unit_fee = fees
    # 차량번호 오름차순 정렬
    for car_no in sorted(car_time.keys()):
        used_minute = car_time[car_no]
        if used_minute <= default_minute:
            answer.append(default_fee)
        else:
            extra = used_minute - default_minute
            fee_units = math.ceil(extra / unit_time)
            total_fee = default_fee + fee_units * unit_fee
            answer.append(total_fee)
    
    return answer

def minute_converter(time):
    h, m = time.split(":")
    return int(h) * 60 + int(m)
