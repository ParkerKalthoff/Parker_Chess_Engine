def bits_below_offset(value, offset):
    # Create a bitmask with bits below the offset set to 1
    mask = (1 << offset) - 1
    # Apply the bitmask to get the bits below the offset
    return value & mask

def bits_above_offset(value, offset):
    # Create a bitmask with bits above the offset set to 1
    mask = ~((1 << offset) - 1)
    # Apply the bitmask to get the bits above the offset
    return value & mask

def print_bitboard(bitboard, with_coords=False):
    for rank in range(7, -1, -1):  # Start from the top rank (rank 7)
        if with_coords:
            print(f"{rank + 1}   ", end="")
        for file in range(8):  # Iterate through each file in the rank
            square = rank * 8 + file
            mask = 1 << square
            # Print 1 if the bit at the current square is set, otherwise print 0
            print("1 " if (bitboard & mask) != 0 else "0 ", end="")
        print()
        # Move to the next line after printing a rank
    if with_coords:
        print("    A B C D E F G H")

# Example usage:
bitboard = 0xff << 56  # Example bitboard with the top-left corner set
print_bitboard(bitboard)

# 8 [56][57][58][59][60][61][62][63]
# 7 [48][49][50][51][52][53][54][55]
# 6 [40][41][42][43][44][45][46][47]
# 5 [32][33][34][35][36][37][38][39]
# 4 [24][25][26][27][28][29][30][31]
# 3 [16][17][18][19][20][21][22][23]
# 2 [08][09][10][11][12][13][14][15]
# 1 [00][01][02][03][04][05][06][07]