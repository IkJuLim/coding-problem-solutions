winPattern = [[0, 4, 8],
              [2, 4, 6],
              [0, 3, 6],
              [1, 4, 7],
              [2, 5, 8],
              [0, 1, 2],
              [3, 4, 5],
              [6, 7, 8]]


def get_winner(string):
    winner = '.'
    for horse in ['X', 'O']:
        for pattern in winPattern:
            cnt = 0
            for position in pattern:
                if string[position] == horse:
                    cnt = cnt + 1
            if cnt == 3:
                if (winner != horse) & (winner != '.'):
                    return "both"
                else:
                    winner = horse
    return winner


while True:
    case = input()
    if case == 'end':
        break
    x_count = case.count('X')
    o_count = case.count('O')

    if x_count == o_count + 1 or x_count == o_count:
        typ = 'X' if x_count == o_count + 1 else 'O'

        winner = get_winner(case)

        if winner == typ:
            print('valid')
        elif winner == '.':
            if case.count('.') == 0:
                print('valid')
            else:
                print('invalid')
        else:
            print('invalid')
    else:
        print('invalid')
