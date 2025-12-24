# 상어 초등학교 21608
# 골드 5

import math

def main():
    # 무조건적으로 첫번째 학생은 1, 1 위치임 (아래 규칙에 의거)
    # 이후부터는 아래의 우선순위대로 자리 배정
    # 1. 빈칸 중 좋아하는 학생이 인접한 칸이 가장 많은 칸으로 자리 정함
    # 2. 만족하는 경우가 여러개라면, 해당 자리 중 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 자리 정함
    # 3. 이것도 여러개 만족한다면, 행이 작은것 우선, 가장 마지막으로는 열이 작은것 우선으로 자리 정함
    # 인접하다 = 4방향 자리를 의미함

    # 각 칸에 학생 앉힐 때마다 인접한 칸에다가 '인접 칸 학생 목록'을 작성하면 좋을듯
    # 동시에, 인접 칸에다가 '인접 빈칸 수'를 기록하게 하여, 위를 작성하면서 해당 값을 1씩 감소시키면 될듯

    def isInArea(row, col):
        if 0 <= row < n and 0 <= col < n:
            return True
        else:
            return False

    def update(row, col, studentID, injupVal):
        # studentID는 index 아님
        seats[row][col] = None
        resSeats[row][col][0] = studentID
        resSeats[row][col][1] = injupVal
        for i in range(4):
            nowRow, nowCol = row + injup_row[i], col + injup_col[i]
            if isInArea(nowRow, nowCol):
                if seats[nowRow][nowCol] is not None:
                    seats[nowRow][nowCol][0] -= 1
                    seats[nowRow][nowCol][1].add(studentID)
                else:
                    if studentID in student[resSeats[nowRow][nowCol][0]-1]:
                        resSeats[nowRow][nowCol][1] += 1


    n = int(input())
    student = [set() for _ in range(n**2)] # student의 index는 학생ID가 아님. 단, set내의 값은 학생ID임
    soonser = [] # sooner에 기록되는것은 student index
    for _ in range(n**2):
        lst = list(map(int, input().split()))
        student[lst[0]-1].update(lst[1:])
        soonser.append(lst[0]-1)
    seats = [[[4, set()] for _ in range(n)] for _ in range(n)]
    for i in range(n):
        seats[0][i], seats[i][0], seats[n-1][i], seats[i][n-1] = [3, set()], [3, set()], [3, set()], [3, set()]
    seats[0][0], seats[n-1][0], seats[0][n-1], seats[n-1][n-1] = [2, set()], [2, set()], [2, set()], [2, set()]
    injup_row = [0, 1, 0, -1]
    injup_col = [1, 0, -1, 0]

    # resSeats에 기록되는것은 학생 ID (index아님)
    resSeats = [[[None, 0] for _ in range(n)] for _ in range(n)] # ID, How many Injup Student
    update(1, 1, soonser[0]+1, 0)
    for i in range(1, n**2):
        maxVal, maxEmpty, maxIdx = -math.inf, -math.inf, None
        liker = student[soonser[i]]
        for row in range(n):
            for col in range(n):
                if seats[row][col] is not None:
                    collapsed = len(seats[row][col][1] & liker)
                    if collapsed > maxVal:
                        maxVal = collapsed
                        maxEmpty = seats[row][col][0]
                        maxIdx = (row, col)
                    elif collapsed == maxVal and maxEmpty < seats[row][col][0]:
                        maxEmpty = seats[row][col][0]
                        maxIdx = (row, col)
        update(maxIdx[0], maxIdx[1], soonser[i]+1, maxVal)
        #print(resSeats)

    res = 0
    for i in range(n):
        for j in range(n):
            now = resSeats[i][j][1]
            # now==0일 때 res에 0.1 더해지는 문제 해결
            if now > 0:
                res += 10**(now-1)
    #print(resSeats)
    print(res)

if __name__ == '__main__':
    main()