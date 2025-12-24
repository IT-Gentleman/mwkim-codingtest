# 연산자 끼워넣기 14888
# 실버 1

import math

def main():
    # 첫째줄에 수의 수
    # 둘째줄에 각 수
    # 셋째줄에 덧셈/뺄셈/곱셈/나눗셈 수
    # 각 연산은 연산자 우선순위 무시하고 앞에서부터 진행
    # 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램 작성
    # Brute-Force 해야겠는걸요
    # 순열을 구해야겠는걸요 -> 순열 말고 recur를 사용하는것이 훨씬 편하겠습니다
    def recur(prev, idx, ctrl):
        nonlocal maxVal, minVal
        if idx==n:
            maxVal = max(maxVal, prev)
            minVal = min(minVal, prev)
            return
        for i in range(4):
            if ctrl[i]:
                newCtrl = ctrl[:]
                newCtrl[i] -= 1
                recur(int(eval(f"{prev}{control_initial[i]}{values[idx]}")), idx+1, newCtrl)
        return

    n = int(input())
    values = list(map(int, input().split()))
    control = list(map(int, input().split()))
    control_initial = "+-*/"
    maxVal = -math.inf
    minVal = math.inf

    recur(values[0], 1, control)

    print(maxVal)
    print(minVal)

if __name__ == '__main__':
    main()