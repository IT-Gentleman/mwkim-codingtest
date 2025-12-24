# 마법사 상어와 파이어볼 20056
# 골드 4

def main():
    def mapIntoArea(val):
        return val % n
    n, m, k = map(int, input().split())
    fullMap = [[[] for _ in range(n)] for _ in range(n)]
    fireList = []
    mv_r = [-1, -1, 0, 1, 1, 1, 0, -1]
    mv_c = [0, 1, 1, 1, 0, -1, -1, -1]
    for _ in range(m):
        r, c, m, s, d = map(int, input().split())
        fullMap[r-1][c-1].append((m, s, d))
        fireList.append((r-1, c-1))
    mass = 0
    for t in range(k):
        #print(fullMap)
        newMap = [[[] for _ in range(n)] for _ in range(n)]
        newFire = set()
        for r, c in fireList:
            for fire in fullMap[r][c]:
                m, s, d = fire
                newRow, newCol = mapIntoArea(r+mv_r[d]*s), mapIntoArea(c+mv_c[d]*s)
                newMap[newRow][newCol].append((m, s, d))
                newFire.add((newRow, newCol))
        fireList = list(newFire)
        for r, c, in list(newFire):
            if t+1 == k:
                if len(newMap[r][c]) == 1:
                    mass += newMap[r][c][0][0]
            if len(newMap[r][c])>1:
                massiveSum, speedSum = 0, 0
                isEvens, allSame = None, True
                for m, s, d in newMap[r][c]:
                    massiveSum += m
                    speedSum += s
                    if not allSame:
                        pass
                    elif isEvens is None:
                        if d%2==0: isEvens = True
                        else: isEvens = False
                    elif (d%2==0) == (isEvens == False): # 엇갈릴 경우
                        allSame = False
                massiveEach = int(massiveSum/5)
                speedEach = int(speedSum/len(newMap[r][c]))
                newMap[r][c] = []
                if t+1 == k:
                    mass += massiveEach * 4
                if massiveEach==0:
                    fireList.remove((r, c))
                    continue
                if allSame:
                    for i in range(0, 7, 2):
                        newMap[r][c].append((massiveEach, speedEach, i))
                else:
                    for i in range(1, 8, 2):
                        newMap[r][c].append((massiveEach, speedEach, i))
        fullMap = newMap
        #print(fullMap)
    print(mass)

if __name__ == '__main__':
    main()