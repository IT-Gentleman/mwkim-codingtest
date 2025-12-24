# 시험 감독 13458
# 브론즈 2

import math
from collections import Counter

def main():
    # 첫줄에 시험장 수
    # 둘째줄에 각 시험장 응시자 수 (첫줄에서 받은 값을 횟수로)
    # 셋째줄에 B, C
    # B: 총감독관이 한 시험장에서 감시 가능한 응시자 수
    # C: 부감독관이 ''
    # 필요한 감독관 수의 최소값은?
    # 단, 각 시험장에 총감독관은 1명이 무조건 존재하고, 부감독관은 0명 이상 가능

    # 각 시험장 응시자 수에서 B 값을 빼고, C를 나눈 값에 올림하여 총합하면 되는것은?
    # 이때, lst에 들어오는 값에 대해서 Counter로 처리함으로써 연산횟수 줄이기는 어떤가?
    n = int(input())
    cntr = Counter(map(int, input().split()))
    b, c = tuple(map(int, input().split()))

    count = n
    for val, cnt in cntr.items():
        if (val-b)>0:
            count += cnt * math.ceil((val-b) / c)

    print(count)

if __name__ == '__main__':
    main()