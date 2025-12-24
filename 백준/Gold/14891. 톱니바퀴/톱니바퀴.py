# 톱니바퀴 14891
# 골드 5

from collections import deque

def main():
    def toleft(which, whereto):
        nonlocal topnie
        if which < 0:
            return
        if topnie[which][2]!=topnie[which + 1][6]:
            toleft(which-1, -1 * whereto)
            spin(which, whereto)

    def toright(which, whereto):
        nonlocal topnie
        if which == 4:
            return
        if topnie[which][6] != topnie[which - 1][2]:
            toright(which + 1, -1 * whereto)
            spin(which, whereto)

    def spin(which, whereto):
        if whereto == -1:
            temp = topnie[which].popleft()
            topnie[which].append(temp)
        else:
            temp = topnie[which].pop()
            topnie[which].appendleft(temp)

    # 톱니바퀴 4개, 각 8개의 톱니. 각 톱니는 N/S극 가짐. 톱니바퀴 번호는 왼쪽부터 1번, 오른쪽까지 4번
    # 톱니바퀴 회전은 시계/반시계로 가능
    # 한 톱니바퀴를 회전시키면, 인접한 톱니바퀴와의 인접한 톱니끼리의 극성에 따라 해당 인접톱니의 회전이 결정됨
    # 인접톱니끼리의 극성 같은 상태에서 한 톱니바퀴를 회전시켜도, 인접톱니바퀴는 회전하지 않음
    # 반대로, 극성 다른 상태에서 한 톱니바퀴를 회전시킨다면, 인접톱니바퀴는 그 반대방향으로 회전되며, 해다 인접톱니바퀴의 인접톱니바퀴도 이 성질대로 연쇄작용이 발생해야함

    topnie = [deque(input()) for _ in range(4)]
    # 12시 톱니부터 시계방향 순서대로 주어지며, N극은 0, S극은 1
    # 따라서 톱니를 시계방향으로 돌린다면 pop해서 appendleft 하면 됨
    # 반대로 반시계방향으로 돌린다면 popleft해서 append하면 됨

    # 각 인접톱니와의 인덱스는 우측:2 / 좌측:6

    n = int(input())
    spins = [tuple(map(int, input().split())) for _ in range(n)] # 톱니번호와 회전방법(1은 시계, -1은 반시계)

    for now in spins:
        which, whereto = now
        which -= 1
        # 돌리는것은 recur 함수 이용해서 DFS?로 수행
        toleft(which-1, -1*whereto)
        toright(which+1, -1*whereto)
        spin(which, whereto)
    point = [2**i for i, x in enumerate(topnie) if x[0]=='1']
    print(sum(point))

if __name__ == '__main__':
    main()