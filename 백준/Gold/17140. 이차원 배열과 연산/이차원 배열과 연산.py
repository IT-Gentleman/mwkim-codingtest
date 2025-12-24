# 이차원 배열과 연산
# 골드 4

from collections import Counter

def main():
    def rCalc():
        newMatrix = []
        maxLen = 0
        for row in range(rows):
            cntr = Counter([x for x in matrix[row] if x != 0])
            newRow = []
            for which, howmany in sorted(cntr.items(), key=lambda item: (item[1], item[0])):
                newRow.extend([which, howmany])
            if len(newRow) > 100:
                newRow = newRow[:100]
            if len(newRow) > maxLen:
                maxLen = len(newRow)
            newMatrix.append(newRow)
        for row in range(rows):
            newMatrix[row].extend([0] * (maxLen-len(newMatrix[row])))
        return newMatrix

    def cCalc():
        newMatrix = []
        maxLen = 0
        matrix_transposed = list(map(list, zip(*matrix)))
        for row in range(cols):
            cntr = Counter([x for x in matrix_transposed[row] if x != 0])
            newRow = []
            for which, howmany in sorted(cntr.items(), key=lambda item: (item[1], item[0])):
                newRow.extend([which, howmany])
            if len(newRow) > 100:
                newRow = newRow[:100]
            if len(newRow) > maxLen:
                maxLen = len(newRow)
            newMatrix.append(newRow)
        for row in range(cols):
            newMatrix[row].extend([0] * (maxLen-len(newMatrix[row])))
        newMatrix_transposed = list(map(list, zip(*newMatrix)))
        return newMatrix_transposed

    r, c, k = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(3)]
    rows, cols = 3, 3
    time = 0
    while time < 100:
        if r-1 < rows and c-1 < cols:
            if matrix[r - 1][c - 1] == k:
                break
        if rows >= cols:
            matrix = rCalc()
        else:
            matrix = cCalc()
        rows, cols = len(matrix), len(matrix[0])
        time += 1
        #print(matrix)
    if time == 100:
        if r-1 < rows and c-1 < cols:
            if matrix[r - 1][c - 1] == k:
                print(100)
            else:
                print(-1)
        else:
            print(-1)
    else:
        print(time)
if __name__ == '__main__':
    main()