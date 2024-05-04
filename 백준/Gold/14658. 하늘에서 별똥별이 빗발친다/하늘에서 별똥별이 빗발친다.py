N, M, L, K = map(int, input().split())
shootingstarlist = []


for i in range(K):
    x, y = map(int, input().split())
    shootingstarlist.append([x, y])


def countshootingstar(first, second):
    count = 0
    for tar in shootingstarlist: 
        if (first[0] <= tar[0] <= first[0] + L) and (second[1] <= tar[1] <= second[1] + L):
            count += 1
    return count

ret = 0
for first in shootingstarlist:
    for second in shootingstarlist:
        ret = max(ret, countshootingstar(first, second))
        
print(K - ret)
