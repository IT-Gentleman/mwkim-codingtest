import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

# 12865
# 평범한 배낭 - 골드5

# 냅색 문제
# 그리디 문제로 풀면 안됨 (반례 존재)

# dp[i][w]의 의미는, 배낭 최대크기가 w인 상황에서 1번째~i번째의 물품을 고려했을 때 최대 가치

"""
n: 물품의 수
k: 최대 배낭 무게
w, v: 각 물건 무게와 물건 가치
"""

n, k = map(int, input().split())

items = []
for _ in range(n):
    w, v = map(int, input().split())
    items.append((w, v))

dp = [[0]*(k+1) for _ in range(n+1)]

for i in range(1, n+1):
    w, v = items[i-1]
    for weight in range(1, k+1): # weight=0인 것은 아무것도 추가 안한 상태이므로, 업데이트할 것 없음
        if w > weight: # item의 weight 미만은 item 추가 불가, 이전 상태 가져오기
            dp[i][weight] = dp[i-1][weight]
        else:
            dp[i][weight] = max(
                dp[i-1][weight],
                dp[i-1][weight-w]+v # item 추가한 것과, 이전상태와 비교하여 최댓값 선정
            )

print(dp[n][k]) # 최종적으로 배낭 크기가 k일 때, n번째까지 고려했을 때 최대 결과가 dp[n][k]에 저장
