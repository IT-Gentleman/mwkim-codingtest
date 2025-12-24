# 테트로미노 14500
# 골드 4

import math

def main():
    def isInArea(row, col):
        return 0 <= row < m and 0 <= col < n

    # 총 4종류에 대해서 탐방하면 될것임
    # 1. 가로길이 3 + 상/우/하 1개 덧붙이기 => 각 덧붙이는 곳의 row/col/row 인덱스 확인
    # 2. 세로길이 3 + 좌/하/우 1개 덧붙이기 => 각 덧붙이는 곳의 col/row/col 인덱스 확인
    # 3. 가로길이 2 + 우상/하/우하 2개 덧붙이기 => 각 덧붙이는 곳의 rowcol/row/rowcol 인덱스 확인
    # 4. 세로길이 2 + 우상/우하 2개 덧붙이기 => 각 덧붙이는 곳의 rowcol/rowcol 인덱스 확인

    n, m = map(int, input().split()) # 세로길이 n, 가로길이 m
    maplst = [list(map(int, input().split())) for _ in range(n)]
    transposed_maplst = [list(x) for x in zip(*maplst)]

    res = -math.inf

    # 슬라이싱을 할 때는 [시작인덱스:마지막인덱스+1]을 해야함을 명심
    for i in range(n):
        for j in range(m-2):
            nowSum = sum(maplst[i][j:j+3])
            if i != 0: # 상단 row가 존재하는 경우
                res = max(res, nowSum + max(maplst[i-1][j:j+3]))
            if j+3 != m:
                res = max(res, nowSum + maplst[i][j+3])
            if i+1 != n:
                res = max(res, nowSum + max(maplst[i+1][j:j+3]))
        for j in range(m-1):
            nowSum = sum(maplst[i][j:j+2])
            if i+1 != n:
                res = max(res, nowSum + sum(maplst[i+1][j:j+2]))
            if j+1 != m:
                if i+1 != n:
                    res = max(res, nowSum + sum(maplst[i+1][j+1:j+3]))
                if i-1 != -1:
                    res = max(res, nowSum + sum(maplst[i-1][j+1:j+3]))

    for i in range(m): # 기존 행렬의 col, 전치행렬에서는 row로 작용
        for j in range(n-2): # 기존 행렬의 row, 전치행렬에서는 col로 작용
            nowSum = sum(transposed_maplst[i][j:j+3])
            if i != 0: # 상단 row가 존재하는 경우
                res = max(res, nowSum + max(transposed_maplst[i-1][j:j+3]))
            if j+3 != n:
                res = max(res, nowSum + transposed_maplst[i][j+3])
            if i+1 != m:
                res = max(res, nowSum + max(transposed_maplst[i+1][j:j+3]))
        for j in range(n-1):
            nowSum = sum(transposed_maplst[i][j:j+2])
            if j+1 != n:
                if i+1 != m:
                    res = max(res, nowSum + sum(transposed_maplst[i+1][j+1:j+3]))
                if i-1 != -1:
                    res = max(res, nowSum + sum(transposed_maplst[i-1][j+1:j+3]))

    print(res)

if __name__ == '__main__':
    main()