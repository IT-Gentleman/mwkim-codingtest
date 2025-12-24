# 인구 이동 16234
# 골드 4

from collections import deque

def main():
    # 어떤곳들이 '연합'을 이루는지 기록할 필요 있음
    # 기본값은 reference가 자기자신을 하도록 하고,
    # 연합을 이루는 경우, row값이 (같다면 col값이) 가장 작은 국가가 대표 reference 국가가 되도록 하고,
    # 해당 reference 국가는 reference 배열에 자신 국가를 추가하고, 자신을 reference로 삼는 국가들의 리스트를 reference로 갖는다.
    # reference가 아닌 국가들은 대표 reference 국가를 reference로 갖는다.

    # 새로운 연합을 형성할 때, 아래와 같은 절차로 수행한다.
    # 1. 가장 작은 idx 갖는 국가를 reference(이하 대표) 국가로 정한다.
    # 2. 해당 대표국가를 country 변수에 두고, country == country.reference라면 reference 배열의 country index에 다른 국가들을 추가한다. (새로운 대표국가)
    # 3. country == country.reference가 아니라면, country == country.reference 일 때까지 타고 올라간다.
    # 3-1. reference 배열의 country index에 다른 국가들을 추가한다. 이때, country는 1의 대표국가가 아니기에, 1의 대표국가도 추가한다.

    class Tree:
        def __init__(self):
            # leaf들을 담도록 함. 이때 leaf는 여러개 존재 가능
            self.leaf = [[[] for _ in range(n)] for _ in range(n)]
            # parent가 자기자신이 아니라는 것은 자신은 부모노드의 leaf라는 것. 즉 parent가 자기자신이면 root 노드임
            self.parent = [[(x, y) for y in range(n)] for x in range(n)]
            self.rootLst = set()
        def connect(self, mainI, mainJ, subI, subJ):
            while self.parent[mainI][mainJ] != (mainI, mainJ):
                mainI, mainJ = self.parent[mainI][mainJ]
            while self.parent[subI][subJ] != (subI, subJ):
                subI, subJ = self.parent[subI][subJ]
            if mainI == subI and mainJ == subJ:
                return
            self.rootLst.add((mainI, mainJ))
            self.rootLst.discard((subI, subJ))
            self.leaf[mainI][mainJ].append((subI, subJ))
            self.parent[subI][subJ] = (mainI, mainJ)
        def process(self):
            for root in list(self.rootLst):
                lst = []
                q = deque([root])
                while q:
                    x, y = q.popleft()
                    lst.append((x, y, ingoo[x][y]))
                    q.extend(self.leaf[x][y])
                each = int(sum([x[2] for x in lst]) / len(lst))
                for x, y, _ in lst:
                    ingoo[x][y] = each
            if len(self.rootLst) == 0:
                return False
            return True

    n, l, r = map(int, input().split())
    ingoo = [list(map(int, input().split())) for _ in range(n)]
    count = 1
    while True:
        tree = Tree()
        for i in range(n):
            for j in range(n):
                if i+1 < n:
                    if l <= abs(ingoo[i][j]-ingoo[i+1][j]) <= r: # 국경 여는 대상
                        tree.connect(i, j, i+1, j)
                if j+1 < n:
                    if l <= abs(ingoo[i][j]-ingoo[i][j+1]) <= r: # 국경 여는 대상
                        tree.connect(i, j, i, j+1)
        if not tree.process():
            count -= 1
            print(count)
            return
        count += 1

if __name__ == '__main__':
    main()