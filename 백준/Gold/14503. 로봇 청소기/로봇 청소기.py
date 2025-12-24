# 로봇 청소기 14503
# 골드 5

def main():
    def check(row, col):
        if row < n and col < m:
            return room[row][col]
        else:
            return None
    def spin(way):
        if way-1<0:
            return 3
        return way-1
    n, m = tuple(map(int, input().split()))
    robot = tuple(map(int, input().split()))
    room = [list(map(int, input().split())) for _ in range(n)] # 0: not cleaned, 1: wall, -1: cleaned (-1 is not given, for setting)
    rows = [-1, 0, 1, 0]
    cols = [0, 1, 0, -1]

    count = 0
    row, col, whereto = robot
    while True:
        allClean = True
        # 1
        if room[row][col] == 0:
            count += 1
            room[row][col] = -1
        # 2
        newWhereto = whereto
        for _ in range(4): # 반시계 90도로 돌면서 가장 처음 발견한 청소되지 않은 빈칸을 발견하여 전진해야함
            newWhereto = spin(newWhereto)
            newRow = row + rows[newWhereto]
            newCol = col + cols[newWhereto]
            if check(newRow, newCol) == 0: # 청소되지 않은 빈 칸인 경우 한칸 전진한다
                allClean = False
                break
        if allClean == True:
            newRow, newCol = row - rows[whereto], col - cols[whereto]
            if check(newRow, newCol) == 1:
                print(count)
                break
            else:
                row, col = newRow, newCol
                continue
        # 3
        # 더 갈곳이 있고, 현재 newOO 변수에 저장된 곳이 다음에 갈 곳임
        row, col, whereto = newRow, newCol, newWhereto

if __name__ == '__main__':
    main()