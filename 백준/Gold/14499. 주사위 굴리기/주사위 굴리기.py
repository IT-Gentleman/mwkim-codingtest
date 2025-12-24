# 주사위 굴리기 14499
# 골드 4

def main():
    def rollRight():
        # bottom -> left
        # left -> top
        # top -> right
        # right -> bottom
        temp = dice["right"]
        dice["right"] = dice["top"]
        dice["top"] = dice["left"]
        dice["left"] = dice["bottom"]
        dice["bottom"] = temp
    def rollLeft():
        # bottom -> right
        # right -> top
        # top -> left
        # left -> bottom
        temp = dice["left"]
        dice["left"] = dice["top"]
        dice["top"] = dice["right"]
        dice["right"] = dice["bottom"]
        dice["bottom"] = temp
    def rollUp():
        # bottom -> down
        # down -> top
        # top -> up
        # up -> bottom
        temp = dice["up"]
        dice["up"] = dice["top"]
        dice["top"] = dice["down"]
        dice["down"] = dice["bottom"]
        dice["bottom"] = temp
    def rollDown():
        # bottom -> up
        # up -> top
        # top -> down
        # down -> bottom
        temp = dice["down"]
        dice["down"] = dice["top"]
        dice["top"] = dice["up"]
        dice["up"] = dice["bottom"]
        dice["bottom"] = temp

    n, m, row, col, k = map(int, input().split())
    maplst = [list(map(int, input().split())) for _ in range(n)]
    dice = {"bottom": 0, "top": 0, "left": 0, "right": 0, "up": 0, "down": 0}
    movelst = list(map(int, input().split())) # 길이가 k
    for mv in movelst:
        moved = True
        match mv:
            case 1:
                if col+1 != m:
                    col += 1
                    rollRight()
                else: moved = False
            case 2:
                if col-1 != -1:
                    col -= 1
                    rollLeft()
                else: moved = False
            case 3:
                if row-1 != -1:
                    row -= 1
                    rollUp()
                else: moved = False
            case 4:
                if row+1 != n:
                    row += 1
                    rollDown()
                else: moved = False
        if moved:
            if maplst[row][col] == 0:
                maplst[row][col] = dice["bottom"]
            else:
                dice["bottom"] = maplst[row][col]
                maplst[row][col] = 0
            print(dice["top"])


if __name__ == '__main__':
    main()