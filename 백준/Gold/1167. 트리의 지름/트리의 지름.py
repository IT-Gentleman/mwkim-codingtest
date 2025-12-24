import sys
sys.setrecursionlimit(10**6)

V = int(sys.stdin.readline())
adj_lst = [[] for _ in range(V + 1)]
visited = [False] * (V + 1)
max_len = 0

for _ in range(V):
    parts = list(map(int, sys.stdin.readline().split()))
    node = parts[0]
    idx = 1
    while parts[idx] != -1:
        to = parts[idx]
        length = parts[idx + 1]
        adj_lst[node].append((to, length))
        idx += 2

def dfs(node):
    global max_len
    visited[node] = True
    first_max, second_max = 0, 0
    for to, length in adj_lst[node]:
        if not visited[to]:
            path_len = dfs(to) + length
            if path_len > first_max:
                second_max = first_max
                first_max = path_len
            elif path_len > second_max:
                second_max = path_len
    max_len = max(max_len, first_max + second_max)
    return first_max

dfs(1)
print(max_len)