# 연구소 14502
# 골드 4

"""
예제1
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
=>
2"1"0 0 1 1 0
1"0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0"1"0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
"""

"""
예제2
4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2
=>
0 0 0 0"1"0
1 0 0"1"0 2
1 1 1 0 0 2
0 0 0"1"0 2
"""

import math
from collections import deque

def main():
    # BFS를 수행하되, 최소 추가감염 영역보다 더 많아질 경우 중단
    # 각 벽을 세우는것은 naive하게 브루트포스로 수행해야할듯
    def setWall(threePoints):
        for point in threePoints:
            newMap[point[0]][point[1]] = 1
    def isEmpty(row, col):
        if 0 <= row < n and 0 <= col < m:
            return newMap[row][col] == 0
        else:
            return False
    def findEmpty(row, col):
        result = []
        for i in range(4):
            newRow, newCol = row + four_ways_row[i], col + four_ways_col[i]
            if isEmpty(newRow, newCol):
                newMap[newRow][newCol] = 3
                result.append((newRow, newCol))
        return result

    n, m = map(int, input().split()) # n: 세로, m: 가로
    maplst = [list(map(int, input().split())) for _ in range(n)]

    empty_slot = [(row, col) for row in range(n) for col in range(m) if maplst[row][col] == 0]
    virus_slot = [(row, col) for row in range(n) for col in range(m) if maplst[row][col] == 2]
    four_ways_row = [0, 1, 0, -1]
    four_ways_col = [-1, 0, 1, 0]

    minExtraVirusedArea = math.inf
    for first in range(len(empty_slot)):
        for second in range(first+1, len(empty_slot)):
            for third in range(second+1, len(empty_slot)):
                extraVirusedArea = 0
                newMap = [row[:] for row in maplst]
                setWall((empty_slot[first], empty_slot[second], empty_slot[third]))
                q = deque(virus_slot)
                while len(q) > 0:
                    new = findEmpty(*q.popleft())
                    #print(f"{new} found when {(first, second, third)}")
                    extraVirusedArea += len(new)
                    if extraVirusedArea > minExtraVirusedArea:
                        break
                    q.extend(new)
                if extraVirusedArea < minExtraVirusedArea:
                    minExtraVirusedArea = extraVirusedArea
    print(len(empty_slot) - minExtraVirusedArea - 3) # 3은 벽을 세운곳

if __name__ == '__main__':
    main()