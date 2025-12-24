# 감시 15683
# 골드 3

import math

def main():
    def count(matrix):
        cnt = 0
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    cnt += 1
        return cnt

    def recur(leftCCTV, newMatrix):
        if len(leftCCTV) == 0:
            nonlocal res
            #print(newMatrix)
            res = min(res, count(newMatrix))
            return
        newCCTV = leftCCTV[:]
        r, c, which = newCCTV.pop()
        if which == 5:
            onlyOne = [row[:] for row in newMatrix]
            for i in range(r-1, -1, -1):
                if newMatrix[i][c] == 6:
                    break
                onlyOne[i][c] = -1
            for i in range(r+1, n):
                if newMatrix[i][c] == 6:
                    break
                onlyOne[i][c] = -1
            for j in range(c-1, -1, -1):
                if newMatrix[r][j] == 6:
                    break
                onlyOne[r][j] = -1
            for j in range(c+1, m):
                if newMatrix[r][j] == 6:
                    break
                onlyOne[r][j] = -1
            recur(newCCTV, onlyOne)
        elif which == 4:
            fourWay = [[row[:] for row in newMatrix] for _ in range(4)]
            for i in range(r - 1, -1, -1):
                if newMatrix[i][c] == 6:
                    break
                fourWay[0][i][c] = -1
                fourWay[1][i][c] = -1
                fourWay[2][i][c] = -1
            for i in range(r + 1, n):
                if newMatrix[i][c] == 6:
                    break
                fourWay[0][i][c] = -1
                fourWay[1][i][c] = -1
                fourWay[3][i][c] = -1
            for j in range(c - 1, -1, -1):
                if newMatrix[r][j] == 6:
                    break
                fourWay[0][r][j] = -1
                fourWay[2][r][j] = -1
                fourWay[3][r][j] = -1
            for j in range(c + 1, m):
                if newMatrix[r][j] == 6:
                    break
                fourWay[1][r][j] = -1
                fourWay[2][r][j] = -1
                fourWay[3][r][j] = -1
            recur(newCCTV, [row[:] for row in fourWay[0]])
            recur(newCCTV, [row[:] for row in fourWay[1]])
            recur(newCCTV, [row[:] for row in fourWay[2]])
            recur(newCCTV, [row[:] for row in fourWay[3]])
        elif which == 3:
            fourWay = [[row[:] for row in newMatrix] for _ in range(4)]
            for i in range(r - 1, -1, -1):
                if newMatrix[i][c] == 6:
                    break
                fourWay[0][i][c] = -1
                fourWay[3][i][c] = -1
            for i in range(r + 1, n):
                if newMatrix[i][c] == 6:
                    break
                fourWay[1][i][c] = -1
                fourWay[2][i][c] = -1
            for j in range(c - 1, -1, -1):
                if newMatrix[r][j] == 6:
                    break
                fourWay[2][r][j] = -1
                fourWay[3][r][j] = -1
            for j in range(c + 1, m):
                if newMatrix[r][j] == 6:
                    break
                fourWay[0][r][j] = -1
                fourWay[1][r][j] = -1
            recur(newCCTV, [row[:] for row in fourWay[0]])
            recur(newCCTV, [row[:] for row in fourWay[1]])
            recur(newCCTV, [row[:] for row in fourWay[2]])
            recur(newCCTV, [row[:] for row in fourWay[3]])
        elif which == 2:
            twoWay = [[row[:] for row in newMatrix] for _ in range(2)]
            for i in range(r - 1, -1, -1):
                if newMatrix[i][c] == 6:
                    break
                twoWay[0][i][c] = -1
            for i in range(r + 1, n):
                if newMatrix[i][c] == 6:
                    break
                twoWay[0][i][c] = -1
            for j in range(c - 1, -1, -1):
                if newMatrix[r][j] == 6:
                    break
                twoWay[1][r][j] = -1
            for j in range(c + 1, m):
                if newMatrix[r][j] == 6:
                    break
                twoWay[1][r][j] = -1
            recur(newCCTV, [row[:] for row in twoWay[0]])
            recur(newCCTV, [row[:] for row in twoWay[1]])
        elif which == 1:
            fourWay = [[row[:] for row in newMatrix] for _ in range(4)]
            for i in range(r - 1, -1, -1):
                if newMatrix[i][c] == 6:
                    break
                fourWay[0][i][c] = -1
            for i in range(r + 1, n):
                if newMatrix[i][c] == 6:
                    break
                fourWay[1][i][c] = -1
            for j in range(c - 1, -1, -1):
                if newMatrix[r][j] == 6:
                    break
                fourWay[2][r][j] = -1
            for j in range(c + 1, m):
                if newMatrix[r][j] == 6:
                    break
                fourWay[3][r][j] = -1
            recur(newCCTV, [row[:] for row in fourWay[0]])
            recur(newCCTV, [row[:] for row in fourWay[1]])
            recur(newCCTV, [row[:] for row in fourWay[2]])
            recur(newCCTV, [row[:] for row in fourWay[3]])

    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    cctv = []
    for i, row in enumerate(matrix):
        cctv.extend([(i, j, val) for j, val in enumerate(row) if 0 < val < 6])
    res = math.inf
    recur(cctv, matrix)
    print(res)

    return
if __name__ == '__main__':

    #with open("input2.txt", "r") as f:
    #    lines = f.read().splitlines()

    #input_iter = iter(lines)
    #input = lambda: next(input_iter)
    main()