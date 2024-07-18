def get_king_moves(position):
    """
    Get the list of indices of possible king moves from the given position.
    
    :param position: The current position of the king (0-63).
    :return: A list of possible move indices for the king.
    """
    def is_valid_index(index):
        return 0 <= index < 64

    def same_row(index1, index2):
        return index1 // 8 == index2 // 8

    moves = []
    row, col = divmod(position, 8)
    possible_moves = [
        (row - 1, col - 1), (row - 1, col), (row - 1, col + 1),
        (row, col - 1),                 (row, col + 1),
        (row + 1, col - 1), (row + 1, col), (row + 1, col + 1)
    ]
    
    for r, c in possible_moves:
        if 0 <= r < 8 and 0 <= c < 8:
            moves.append(r * 8 + c)
    
    return moves

s = '{'
for i in range(64):
    num = 0
    for move in get_king_moves(i):
        num += 1 << move
    s += f'{hex(num)}L,'
s += '}'

print(s)