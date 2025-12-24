# 미세먼지 안녕! 17144
# 골드 4

def main():
    def isCleaner(row, col):
        return col == 0 and row in cleanerRow
    def isSpreadableSpace(row, col):
        return 0 <= row < r and 0 <= col < c and not isCleaner(row, col)
    def spread(row, col):
        count = 0
        #now = sum(matrix[row][col])
        #matrix[row][col] = [now, 0]
        now = matrix[row][col][0]
        for i in range(4):
            newRow, newCol = row + spread_row[i], col + spread_col[i]
            if isSpreadableSpace(newRow, newCol):
                count += 1
                matrix[newRow][newCol][1] += int(now/5)
        matrix[row][col][0] -= int(now/5)*count
    def upperCycle():
        moveUpper((cleanerRow[0]-1, 0), (0, 0))
        moveRight((0, 0), (0, c-1))
        moveLower((0, c-1), (cleanerRow[0], c-1))
        moveLeft((cleanerRow[0], c-1), (cleanerRow[0], 1))
        matrix[cleanerRow[0]][1] = [0, 0]
        return
    def lowerCycle():
        moveLower((cleanerRow[1]+1, 0), (r-1, 0))
        moveRight((r-1, 0), (r-1, c-1))
        moveUpper((r-1, c-1), (cleanerRow[1], c-1))
        moveLeft((cleanerRow[1], c-1), (cleanerRow[1], 1))
        matrix[cleanerRow[1]][1] = [0, 0]
        return
    def moveUpper(start, end):
        startRow, endRow, col = start[0], end[0], start[1]
        for i in range(startRow, endRow, -1):
            matrix[i][col] = matrix[i-1][col]
    def moveLower(start, end):
        startRow, endRow, col = start[0], end[0], start[1]
        for i in range(startRow, endRow):
            matrix[i][col] = matrix[i+1][col]
    def moveRight(start, end):
        startCol, endCol, row = start[1], end[1], start[0]
        for i in range(startCol, endCol):
            matrix[row][i] = matrix[row][i+1]
    def moveLeft(start, end):
        startCol, endCol, row = start[1], end[1], start[0]
        for i in range(startCol, endCol, -1):
            matrix[row][i] = matrix[row][i-1]


    # 초기 미세먼지 상태 / 확산되는 양을 더하면 되지 않을까?
    r, c, t = map(int, input().split())
    matrix = [[[int(x), 0] for x in input().split()] for _ in range(r)]
    cleanerRow = [x for x in range(r) if matrix[x][0][0] == -1]
    spread_row = [0, 1, 0, -1]
    spread_col = [1, 0 ,-1, 0]
    for i in range(t):
        for row in range(r):
            for col in range(c):
                if not isCleaner(row, col):
                    spread(row, col)
        summary = 0
        for row in range(r):
            for col in range(c):
                res = sum(matrix[row][col])
                matrix[row][col] = [res, 0]
                summary += res
        if i+1 == t:
            print(summary-matrix[cleanerRow[0]-1][0][0]-matrix[cleanerRow[1]+1][0][0]+2)
            return
        upperCycle()
        lowerCycle()

if __name__ == '__main__':
    main()