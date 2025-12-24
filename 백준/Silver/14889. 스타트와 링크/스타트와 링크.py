# 스타트와 링크 14889
# 실버 1

import math

def main():
    def spliter(lst, idx):
        if idx==n:
            splited.append(lst)
            return
        if len(lst[0]) < n/2:
            spliter([lst[0]+[idx], lst[1]], idx+1)
        if len(lst[1]) < n/2:
            spliter([lst[0], lst[1]+[idx]], idx+1)

    # 두 팀의 능력치 차이를 최소로 하고자 함
    # 각각의 시너지는 2차원 배열로 제공됨
    # 첫째줄에 전체 인원의 수
    # 둘째줄부터 2차원 배열
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    # 이것도 결국 완전탐색인것인가?
    # 같은것을 두번 연산하지 않게 하기 위해, index=0인 사람을 1번팀에 고정시켜두고,
    # 나머지 사람들을 두 팀으로 균등하게 배분하는것이 좋아보임

    # 경우의 수를 나누는 함수 하나와 시너지 계산하는 함수 하나가 필요해보임
    splited = []
    spliter([[0],[]], 1)
    minVal = math.inf

    for splt in splited:
        scoreA, scoreB = 0, 0
        for a in splt[0]:
            for a_ in splt[0]:
                if a == a_:
                    continue
                scoreA += matrix[a][a_]
        for b in splt[1]:
            for b_ in splt[1]:
                if b == b_:
                    continue
                scoreB += matrix[b][b_]
        minVal = min(minVal, abs(scoreA - scoreB))

    print(minVal)

if __name__ == '__main__':
    main()