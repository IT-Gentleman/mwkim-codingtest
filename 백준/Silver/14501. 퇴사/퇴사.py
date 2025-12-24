# 퇴사 14501
# 실버 3

def main():
    # DP로 풀어야할듯?
    # 전체 배열은 수익 이며, 초기값은 0으로
    # 각 일자별로, lst[현재+T_i]=max(lst[현재+T_i], lst[현재]+P_i) 계산
    # 현재 idx는 0부터 len(lst)-1까지
    # 현재+T_i가 len(lst) 벗어나면 불가한 것도 계산해야할 것

    # 추가문제확인! index가 현재+T_i 이후의 것도 max 연산을 필요로 함
    # 단순히, best[i]를 연산할 때, best[i-1]과 max 연산을 수행하면 될듯?

    n = int(input())
    lst = [tuple(map(int, input().split())) for _ in range(n)]
    best = [0 for _ in range(n)]
    best_val = 0

    for i in range(n):
        if i > 0:
            best[i] = max(best[i-1], best[i])
        if i + lst[i][0] < n and best[i+lst[i][0]] < best[i]+lst[i][1]: # 추가로 메모잉이 필요한 구간이자, 업데이트가 필요한 경우
            best[i+lst[i][0]] = best[i]+lst[i][1]
            best_val = max(best_val, best[i]+lst[i][1])
        elif i + lst[i][0] == n and best_val < best[i]+lst[i][1]: # 앞으로의 메모잉은 필요하지 않으나, 업데이트가 필요한 경우
            best_val = best[i]+lst[i][1]

    print(best_val)

if __name__ == '__main__':
    main()