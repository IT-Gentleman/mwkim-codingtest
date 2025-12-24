# 나무 재테크 16235
# 골드 3

def main():
    def isInArea(row, col):
        return 0 <= row < n and 0 <= col < n

    n, m, k = map(int, input().split())
    addYang = [list(map(int, input().split())) for _ in range(n)]
    # YangVal, treeLst
    toji = [[[5, []] for _ in range(n)] for _ in range(n)]
    hasTree = set()
    eight_way_row = [-1, -1, 0, 1, 1, 1, 0, -1]
    eight_way_col = [0, 1, 1, 1, 0, -1, -1, -1]
    for _ in range(m):
        x, y, z = map(int, input().split())
        toji[x-1][y-1][1].append(z)
        hasTree.add((x-1, y-1))
    for x, y in hasTree:
        toji[x][y][1].sort()
    for _ in range(k):
        # Spring & Summer
        for x, y in hasTree.copy():
            atFirstYang, atFirstList = toji[x][y]
            toAddYang = 0
            fromNowList = []
            atFirstList.reverse()
            for age in atFirstList:
                if age > atFirstYang:
                    toAddYang += age//2
                else:
                    atFirstYang -= age
                    fromNowList.append(age+1)
            fromNowList.reverse()
            toji[x][y] = [atFirstYang+toAddYang, fromNowList]
            if len(fromNowList)==0:
                hasTree.remove((x, y))
        # Fall & Winter
        for x in range(n):
            for y in range(n):
                toji[x][y][0] += addYang[x][y]
                for age in toji[x][y][1]:
                    if age%5==0:
                        for i in range(8):
                            newRow, newCol = x + eight_way_row[i], y + eight_way_col[i]
                            if isInArea(newRow, newCol):
                                toji[newRow][newCol][1].append(1)
                                hasTree.add((newRow, newCol))
    count = 0
    for x, y in hasTree:
        count += len(toji[x][y][1])
    print(count)

if __name__ == '__main__':
    main()