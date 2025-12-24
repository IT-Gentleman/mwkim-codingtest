# 마법사 상어와 토네이도 20057
# 골드 3

"""
전체 맵 크기 : nxn (n은 홀수)
위치 표현법 : (r, c) (r, c >= 1)

토네이도는 좌하우상 순서로 퍼져나감
좌하 로 움직일 동안 증가량 1
우상 으로 움직일 동안 증가량 2
좌하 로 움직일 동안 증가량 3
...
토네이도가 row=col=1 (index상 0, 0)에 도달하면 소멸

토네이도 한칸 이동 시마다 모래 흩날림 발생
(토네이도가 존재하던 칸은 모래가 없다고 생정하는것이 맞을것임)
비율이 명시된 칸 : 이동하는(이동해갈) 칸에 있던 모래의 해당 비율만큼 추가 (소수점 이하 버림)
알파로 명시된 칸 : 나머지 (100-5-10-10-7-7-2-2-1-1 = 55)%

격자 밖으로 나간 모래의 양의 총합은?
"""

class TornadoMorae:
    def __init__(self, n, mapLst):
        self.n = n
        self.mapLst = [row[:] for row in mapLst]
        self.outOfRange = 0
        self.percentagesLst = ((0.01, 2), (0.02, 2), (0.05, 1), (0.07, 2), (0.10, 2))
        self.percentagesMap = [[0 for _ in range(5)] for _ in range(5)]

        self.percentagesMap[1][3] = self.percentagesMap[3][3] = 0.01
        self.percentagesMap[0][2] = self.percentagesMap[4][2] = 0.02
        self.percentagesMap[2][0] = 0.05
        self.percentagesMap[1][2] = self.percentagesMap[3][2] = 0.07
        self.percentagesMap[1][1] = self.percentagesMap[3][1] = 0.1
        #self.percentagesMap[2][1] = 0.55
        #print(self.percentagesMap)

    def appendMorae(self, r, c, val):
        if val == 0:
            return
        if 0 <= r < self.n and 0 <= c < self.n:
            self.mapLst[r][c] += val
        else:
            self.outOfRange += val

    def pushMorae(self, r, c, value, way):
        #print(r, c, value)
        alphaVal = value - sum([int(value*perc)*cnt for perc, cnt in self.percentagesLst])

        match way:
            case 'left':
                newMap = [row[:] for row in self.percentagesMap]
                self.appendMorae(r, c-1, alphaVal)
            case 'right':
                newMap = [row[::-1] for row in self.percentagesMap[::-1]]
                self.appendMorae(r, c+1, alphaVal)
            case 'up':
                newMap = [list(row) for row in zip(*self.percentagesMap[::-1])]
                #newMap = list(map(list, zip(*self.percentagesMap[::-1])))
                self.appendMorae(r-1, c, alphaVal)
            case 'down':
                newMap = [list(row) for row in zip(*self.percentagesMap)][::-1]
                #newMap = list(map(list, zip(*self.percentagesMap)))[::-1]
                self.appendMorae(r+1, c, alphaVal)
        #print(f"way: {way}, alpha: {alphaVal}")
        #for row in newMap:
        #    print(row)
        #print()
        for i in range(-2, 3):
            for j in range(-2, 3):
                self.appendMorae(r + i, c + j, int(value * newMap[i+2][j+2]))
        self.mapLst[r][c] = 0
        #print("after pushing")
        #for row in self.mapLst:
        #    print(row)
        #print()

    def doGame(self):
        r, c = self.n//2, self.n//2
        for i in range(1, self.n, 2): # 증가량, 증가량은 self.n 미만임
            for dx, dy, way in ((0, -1, 'left'), (1, 0, 'down')): # 좌 하
                for _ in range(i): # i회만큼 증가한다는 것
                    #print(self.mapLst)
                    nr, nc = r + dx, c + dy # newRow, newCol (새로 이동해갈 위치임. 항상 지도 내 위치)
                    #print(f"{nr},{nc}. val: {self.mapLst[nr][nc]}")
                    self.pushMorae(nr, nc, self.mapLst[nr][nc], way)
                    r, c = nr, nc
                    #print(nr, nc)
            for dx, dy, way in ((0, 1, 'right'), (-1, 0, 'up')):
                for _ in range(i+1):
                    #print(self.mapLst)
                    nr, nc = r + dx, c + dy # newRow, newCol (새로 이동해갈 위치임. 항상 지도 내 위치)
                    #print(nr, nc, r, dx, c, dy)
                    self.pushMorae(nr, nc, self.mapLst[nr][nc], way)
                    r, c = nr, nc
                    #print(nr, nc)
        dx, dy, way = 0, -1, 'left'
        for _ in range(self.n-1):
            nr, nc = r + dx, c + dy
            self.pushMorae(nr, nc, self.mapLst[nr][nc], way)
            r, c = nr, nc
        #print(self.mapLst)

def main():
    n = int(input())
    mapLst = [list(map(int, input().split())) for _ in range(n)]
    game = TornadoMorae(n, mapLst)
    game.doGame()
    print(game.outOfRange)

if __name__ == '__main__':
    main()