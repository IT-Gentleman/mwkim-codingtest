# 게리맨더링 2
# 골드 3

'''
삼 성의 이 재현 빼뱀 뺌 빼배뱀 안타 빼뱀
이재현을 재현시의 시장으로

기준점 (x, y)에 따라서 각 d_1, d_2의 최대가 제한됨
각 d_1, d_2 >= 1
1 - (d_1 + d_2) < x <= N - (d_1 + d_2)
1 + d_1 <= y <= N - d_2

다르게 기준을 잡으면,
d_1+d_2 <= N - x
d_1 <= -1 + y
d_2 <= N - y

각 구역의 인구가 다르기에 Brute-Force 기법으로 수행해야함
x=1, y=2 부터 x=N-2, y=N-1까지 옮기면서
각 x, y값에 따른 d_1과 d_2의 범위 내의 d_1, d_2에 대해 연산하면 될듯

각 선거구 도합 계산법
1번 경계선 : 1번선거구 += [0:x-1] row들에 대해 [0:y] col 도합, for j in range(d_1): 1번선거구 += [x+j] row에 대해 [0:y-1-j] col 도합
2번 경계선 : for j in range(d_2): 3번선거구 += [x+d_1+j] row에 대해 [0:y-1-d_1+j] col 도합, 3번선거구 += [x+d_1+d_2:] row들에 대해 [0:y-d_1+d_2] col 도합
...

'''

import math

def main():
    class Seongeo:
        def __init__(self, x, y, d_1, d_2):
            self.x = x
            self.y = y
            self.d_1 = d_1
            self.d_2 = d_2

        def calc(self):
            self.seongeoGOO = [0 for _ in range(5)]
            self.line1()
            self.line3()
            self.line2()
            self.line4()
            self.calcArea5()
            #if (self.x, self.y, self.d_1, self.d_2) == (2, 2, 1, 1):
            #    print(self.seongeoGOO)
            return max([abs(self.seongeoGOO[i] - self.seongeoGOO[j]) for i in range(5) for j in range(i+1, 5)])

        def line1(self):
            self.seongeoGOO[0] += sum([sum(row[:self.y + 1]) for row in ingoo[:self.x]])
            for i in range(self.d_1):
                if self.y-i == -1:
                    break
                self.seongeoGOO[0] += sum(ingoo[self.x+i][:self.y-i])
        def line3(self):
            for i in range(self.d_2):
                if self.x+self.d_1+i == n:
                    break
                self.seongeoGOO[2] += sum(ingoo[self.x+self.d_1+i][:self.y-self.d_1+i])
            self.seongeoGOO[2] += sum([sum(row[:self.y-self.d_1+self.d_2]) for row in ingoo[self.x+self.d_1+self.d_2:]])

        def line2(self):
            self.seongeoGOO[1] += sum([sum(row[self.y+1:]) for row in ingoo[:self.x + 1]])
            for i in range(self.d_2):
                if self.y+1+i == n:
                    break
                self.seongeoGOO[1] += sum(ingoo[self.x+1+i][self.y+2+i:])
        def line4(self):
            for i in range(self.d_1):
                if self.x+self.d_2+i == n:
                    break
                self.seongeoGOO[3] += sum(ingoo[self.x+1+self.d_2+i][self.y+self.d_2-i:])
            self.seongeoGOO[3] += sum([sum(row[self.y-self.d_1+self.d_2:]) for row in ingoo[self.x+self.d_1+self.d_2+1:]])
        def calcArea5(self):
            leftAdd, rightAdd = -1, 1
            leftCol, rightCol = self.y, self.y
            leftCount, rightCount = 0, 0
            for row in range(self.x, self.x+self.d_1+self.d_2 + 1):
                self.seongeoGOO[4] += sum(ingoo[row][leftCol:rightCol + 1])
                leftCol += leftAdd
                rightCol += rightAdd
                leftCount += 1
                rightCount += 1
                if leftCount == self.d_1:
                    leftAdd *= -1
                if rightCount == self.d_2:
                    rightAdd *= -1


    n = int(input())
    ingoo = [list(map(int, input().split())) for _ in range(n)]

    minDiff = math.inf
    for x in range(1, n-2 + 1): # 최소 1, 최대 n-2
        for y in range(2, n-1 + 1): # 최소 2, 최대 n-1
            for d_1 in range(1, y-1 + 1): # 최소 1, 최대 y-1
                for d_2 in range(1, min(n-y, n-x-d_1) + 1): # 최소 1, 최대 n-y. 이때 d_1+d_2 최대 n-x
                    new = Seongeo(x-1, y-1, d_1, d_2)
                    minDiff = min(minDiff, new.calc())
    print(minDiff)

if __name__ == '__main__':
    main()