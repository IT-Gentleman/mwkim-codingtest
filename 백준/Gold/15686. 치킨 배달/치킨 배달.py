# 치킨 배달 15686
# 골드 5

from itertools import combinations
import math

def main():
    # 어떤 치킨집을 폐업시켜야 도시의 치킨 거리 (모든 집의 치킨 거리의 합)가 최솟값이 될까?
    # 문제에서 주어지는것은 '폐업시키지 않을 치킨집'임을 명심해야함

    # 각 치킨집의 모든 집으로의 치킨 거리를 구한 배열을 모든 치킨집에 대해서 구하고,
    # 폐업시키지 않을 치킨집 갯수만큼 골라서 도시의 치킨거리를 새로 계산하고,
    # 이중 최소값을 반환하면 될것임

    # 오히려, 각 치킨집에 대해서 계산하지 말고, 각 집에 대해서 치킨집까지의 거리를 계산하는것이 나을수도 있음

    n, m = tuple(map(int, input().split()))
    matrix = [list(map(int, input().split())) for _ in range(n)]

    houseLst = []
    chickenLst = []

    for i, row in enumerate(matrix):
        for j, col in enumerate(row):
            if col == 1:
                houseLst.append((i, j))
            elif col == 2:
                chickenLst.append((i, j))

    chickenDestLst = [[] for _ in range(len(houseLst))]
    for i, house in enumerate(houseLst):
        for chicken in chickenLst:
            chickenDestLst[i].append(abs(house[0] - chicken[0]) + abs(house[1] - chicken[1]))

    comb = list(combinations(range(len(chickenLst)), m))
    minChickVal = math.inf

    for now in comb:
        thisChickVal = 0
        for house in chickenDestLst:
            thisChickVal += min([house[x] for x in now])
        minChickVal = min(minChickVal, thisChickVal)

    print(minChickVal)



if __name__ == '__main__':
    main()