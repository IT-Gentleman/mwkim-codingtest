# 마법사 상어와 비바라기 21610
# 골드 5

def main():
    # N*N 행렬, 문제에서 주어지는것은 1번부터 N번까지임 (index처럼 0번부터가 아님에 유의)
    # 이때, 행렬이 순환됨 (index로 따지면 -1이 실현됨)

    # 비바라기 시전 시 좌측하단에 2x2로 생성됨 (index로 따졌을 때 [n-1][0], [n-1][1], [n-2][0], [n-2][1])

    # 0. 최초 비바라기 시전하여 구름 생성
    # 1. 각 구름은 d_i 방향으로 s_i 칸 이동
    # 2. 이동된 칸의 바구니에 저장된 물의 양이 1 증가
    # 3. 기존의 구름을 모두 삭제하고, 위에서 물이 증가한 칸에 대해서, 각 '대각선 방향'으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 해당 칸의 물이 더 증가한다.
    # 3-1. 경계를 넘어가는 칸은 거리가 1인 칸으로 보지 않음 => 경계체크 필요
    # 4. 바구니에 저장된 물의 양이 2이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어듦. 이때, 구름이 방금 삭제된 칸은 구름을 재생성할 수 없음

    def inArea(row, col):
        if 0 <= row < n and 0 <= col < n:
            return True
        else:
            return False
    def movingCrossArea(row, col, direction, distance):
        return (row+n+move_row[direction-1]*distance)%n, (col+n+move_col[direction-1]*distance)%n
    def crossCount(row, col):
        count = 0
        for i in range(4):
            newRow, newCol = row + crossmove_row[i], col + crossmove_col[i]
            if inArea(newRow, newCol):
                if area[newRow][newCol] > 0:
                    count += 1
        return count


    n, m = map(int, input().split())
    area = [list(map(int, input().split())) for i in range(n)]
    increased = [[False for _ in range(n)] for _ in range(n)] # 방금 증가하여 구름으로 생성될 수 없는구역 마킹
    crossmove_row = [1, 1, -1, -1]
    crossmove_col = [1, -1, 1, -1]
    move_row = [0, -1, -1, -1, 0, 1, 1, 1]
    move_col = [-1, -1, 0, 1, 1, 1, 0, -1]

    # 구름을 저장할 공간
    clouds = [(n-1,0), (n-1,1), (n-2,0), (n-2,1)]
    # 물이 증가한 곳을 일시적으로 저장할 공간 (대각선방향 물바구니만큼 증가시킬때 사용해야함)
    waterIncreased = []
    # 방금 구름 사라진곳은 사용 불가하니, waterIncreased의 칸들은 곧바로 구름생성 불가함. 따라서 다음 턴을 위해 저장시켜두어야함
    waterPrevStoring = [(i, j) for i in range(n) for j in range(n) if area[i][j] >= 2]

    moveDirect = [list(map(int, input().split())) for _ in range(m)]
    for md in moveDirect:
        # 각 구름에 대해 이동조치
        for _ in range(len(clouds)):
            row, col = clouds.pop()
            row, col = movingCrossArea(row, col, md[0], md[1])
            # 물복사버그를 수행하기 위해 저장
            waterIncreased.append((row, col))
            # 물복사버그를 수행한곳은 increase 불가
            increased[row][col] = True
            # 물 증가
            area[row][col] += 1
        nextCloud = []
        for row, col in waterIncreased:
            # 물복사버그
            area[row][col] += crossCount(row, col)
            # 당장은 구름생성 불가하나, 다음번 구름생상 대상인가?
            if area[row][col] >= 2:
                nextCloud.append((row, col))
        clouds.clear()
        for row, col in waterPrevStoring:
            # 물복사버그를 수행한곳(물이 증가된곳)이면 pass (이미 대상이면 nextCloud에 추가됨)
            if increased[row][col]:
                continue
            area[row][col] -= 2
            clouds.append((row, col))
            # 다음번에도 구름생성 가능한곳인가?
            if area[row][col] >= 2:
                nextCloud.append((row, col))
        for row, col in waterIncreased:
            increased[row][col] = False
        waterIncreased.clear()
        waterPrevStoring = nextCloud

    print(sum([sum(x) for x in area]))



    return
if __name__ == '__main__':
    main()