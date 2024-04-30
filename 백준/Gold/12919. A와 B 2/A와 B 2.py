def reverse(s):
    ret = ""
    for i in range(len(s), 0, -1):
        ret = ret + s[i-1]
    return ret


def recall(s, t):

    if len(s) == len(t):
        if s == t:
            return True
        return False

    ret_1 = False
    ret_2 = False
    if t[0] == 'B':
        ret_1 = recall(s, reverse(t[1:]))
    if t[-1] == 'A':
        ret_2 = recall(s, t[:-1])

    return ret_1 | ret_2


def main():
    s = input()
    t = input()

    if recall(s, t):
        print(1)
    else:
        print(0)


main()
