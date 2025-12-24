# 경사로 14890
# 골드 3



def main():
    # 원본과 transpose 결과 2개를 수행하면 될 것임
    # 이때, transpose 결과는 바닥이 위로 간 형태이므로 유의해야할 것

    # 같은 높이가 L개 나온 상태 (경사로 설치가능 보장)에서 높이1만큼 증가하는것 : Acceptable
    # 높이1만큼 감소하는것 : 이후 감소한 높이에 해당하는것이 L개 나와야 (경사로 설치가능 보장) Acceptable. 이때, 위의 '같은 높이가 L개 나온 상태'는 카운트되지 않아야 함
    # 위의 두 경우 모두, L개를 카운트하는 동안 다른 바닥 높이가 나올 경우 초기화되어야 함

    class Matrix:
        def __init__(self, matrix):
            self.matrix = matrix
            self.count = 0
            self.isTranspose = False
        def makeTranspose(self):
            self.matrix = list(map(list, zip(*self.matrix)))
            self.isTranspose = True
        def prepare(self, i):
            self.stacking = 1
            self.disposing = 0
            self.prevValue = self.matrix[i][0]
        def proceed(self):
            for i in range(n):
                self.prepare(i)
                for j in range(1, n):
                    match self.matrix[i][j] - self.prevValue:
                        case 0:
                            if self.disposing > 0:
                                self.disposing -= 1
                            else:
                                self.stacking += 1
                        case 1:
                            if self.stacking >= l:
                                self.stacking = 1
                            else:
                                # stacking이 되지 않은 자, 자격이 없다
                                break
                        case -1:
                            if self.disposing > 0:
                                break
                            else:
                                self.disposing = l-1
                                self.stacking = 0
                        case _:
                            # 2 이상 높이는 극복 불가
                            break
                    self.prevValue = self.matrix[i][j]
                    if j == n-1 and self.disposing == 0:
                        #print(i, j, self.isTranspose)
                        self.count += 1


    n, l = map(int, input().split())
    mat = Matrix([list(map(int, input().split())) for _ in range(n)])
    mat.proceed()
    mat.makeTranspose()
    mat.proceed()
    print(mat.count)

    return
if __name__ == '__main__':
    main()