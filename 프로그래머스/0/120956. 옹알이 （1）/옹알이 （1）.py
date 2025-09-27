def solution(babbling):
    answer = 0
    oal_list = ["aya", "ye", "woo", "ma"]
    for bab in babbling:
        show_cnt = 0
        for oal in oal_list:
            if oal in bab:
                show_cnt += 1
                bab = bab.replace(oal, "t")
        if show_cnt == len(bab):
            answer += 1
    return answer