# 컨베이어 벨트 위의 로봇 20055
# 골드 5

from collections import deque
# 로봇 위치 관리용

def main():
    def newHT(index):
        if index - 1 < 0:
            return 2*n - 1 # -번으로 따지면 2N번
        return index - 1
    def newIdx(index):
        if index + 1 == 2*n: # -번으로 따지면 2N+1번, 즉 Index range out
            return 0
        return index + 1

    n, k = map(int, input().split())
    belt = list(map(int, input().split()))
    robot = deque()
    beltHead, beltTail = 0, n-1
    zerocount = 0
    count = 0
    while zerocount < k:
        count += 1
        beltHead, beltTail = newHT(beltHead), newHT(beltTail) # 각 올리는곳과 내리는곳의 idx는 하나씩 줄어가며 회전함. 즉 로봇의 belt idx는 변하지 않도록 함
        howManyPop = 0
        #print(f"at beginning of count: {count} - {robot} while head: {beltHead} - tail: {beltTail} / belt: {belt}")
        for i, idx in enumerate(robot):
            if idx == beltTail:
                howManyPop += 1
                # 이미 내려간 로봇때문에 뒤의 로봇들이 한칸 못움직이지지 않도록 idx를 증가시켜버리기
                idx = newIdx(idx)
                robot[i] = idx
                continue
            # 벨트 위의 로봇이 하나거나, 가장앞의 로봇이 아닌 상태일 때 뒤의 로봇들이 한칸 움직이면 앞의 로봇과 위치가 같아지지 않을때 / 동시에 벨트 내구도 남아있을때
            if (i==0 or robot[i-1] != newIdx(idx)) and belt[newIdx(idx)] > 0:
                #print(f"robot in robotIdx={i} which location on belt {idx} has moved to next")
                idx = newIdx(idx)
                belt[idx] -= 1
                robot[i] = idx
                if belt[idx] == 0:
                    zerocount += 1
                if idx == beltTail:
                    howManyPop += 1
                    # 이미 내려간 로봇때문에 뒤의 로봇들이 한칸 못움직이지지 않도록 idx를 증가시켜버리기
                    idx = newIdx(idx)
                    robot[i] = idx
        for _ in range(howManyPop):
            robot.popleft()

        # 새로운 로봇을 올릴 수 있는가?
        if belt[beltHead] != 0:
            belt[beltHead] -= 1
            if belt[beltHead] == 0:
                zerocount += 1
            robot.append(beltHead)
        #print(f"at the end of count: {count} - {robot} while head: {beltHead} - tail: {beltTail} / belt: {belt}")

    print(count)

if __name__ == '__main__':
    main()