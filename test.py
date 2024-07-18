def generate_bishop_moves():
    bishop_moves = {}

    for row in range(8):
        for col in range(8):
            bitboard = 0

            for direction in [(-1, -1), (-1, 1), (1, -1), (1, 1)]:
                r, c = row, col
                while 0 <= r + direction[0] < 8 and 0 <= c + direction[1] < 8:
                    r += direction[0]
                    c += direction[1]
                    position_index = r * 8 + c
                    bitboard |= (1 << position_index)

            bishop_moves[(row, col)] = bitboard

    return bishop_moves

def generate_rook_moves():
    rook_moves = {}

    for row in range(8):
        for col in range(8):
            bitboard = 0

            for direction in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                r, c = row, col
                while 0 <= r + direction[0] < 8 and 0 <= c + direction[1] < 8:
                    r += direction[0]
                    c += direction[1]
                    position_index = r * 8 + c
                    bitboard |= (1 << position_index)

            rook_moves[(row, col)] = bitboard

    return rook_moves

def generate_queen_moves():
    queen_moves = {}

    for row in range(8):
        for col in range(8):
            bitboard = 0

            for direction in [(-1, -1), (-1, 1), (1, -1), (1, 1), (-1, 0), (1, 0), (0, -1), (0, 1)]:
                r, c = row, col
                while 0 <= r + direction[0] < 8 and 0 <= c + direction[1] < 8:
                    r += direction[0]
                    c += direction[1]
                    position_index = r * 8 + c
                    bitboard |= (1 << position_index)

            queen_moves[(row, col)] = bitboard

    return queen_moves

def print_moves_as_java_array(moves, piece_type):
    print(f"long[] {piece_type}Moves = new long[] {{")
    for position, bitboard in moves.items():
        print(f"    0x{bitboard:016x}L,")
    print("};")

if __name__ == "__main__":
    bishop_moves = generate_bishop_moves()
    rook_moves = generate_rook_moves()
    queen_moves = generate_queen_moves()

    print_moves_as_java_array(bishop_moves, "bishop")
    print_moves_as_java_array(rook_moves, "rook")    
    print_moves_as_java_array(queen_moves, "queen")
    