from collections import deque


def bfs(que):
    global b
    global isFinished

    while len(que) > 0:

        now_no = que.popleft()
        if isFinished:
            break
        if now_no == b:
            print(visit[now_no])
            isFinished = True
            break
        else:
            for i in range(4):
                if i == 0:  # D
                    temp_no = now_no * 2
                    temp_no = temp_no % 10000
                    if (visit[temp_no] != '') | (temp_no == now_no):
                        continue
                    visit[temp_no] = visit[now_no] + 'D'
                    que.append(temp_no)
                elif i == 1:  # S
                    if now_no == 0:
                        temp_no = 9999
                    else:
                        temp_no = now_no - 1
                    if (visit[temp_no] != '') | (temp_no == now_no):
                        continue
                    visit[temp_no] = visit[now_no] + 'S'
                    que.append(temp_no)
                elif i == 2:  # L
                    temp_mod = now_no % (10 ** 3)
                    temp_no = int(now_no / (10 ** 3))

                    temp_no = (temp_mod * 10) + temp_no
                    if (visit[temp_no] != '') | (temp_no == now_no):
                        continue

                    visit[temp_no] = visit[now_no] + 'L'
                    que.append(temp_no)
                else:  # R
                    temp_mod = now_no % 10
                    temp_no = int(now_no / 10)
                    temp_no = (temp_mod * 10 ** 3) + temp_no
                    if (visit[temp_no] != '') | (temp_no == now_no):
                        continue

                    visit[temp_no] = visit[now_no] + 'R'
                    que.append(temp_no)


t = int(input())

for i in range(t):
    visit = [''] * 10000
    a, b = map(int, input().split())

    isFinished = False
    q = deque()
    q.append(a)
    bfs(q)
