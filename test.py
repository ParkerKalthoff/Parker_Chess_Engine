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

def display_bitboard(bitboard):
    # Convert the bitboard to a 64-bit binary string
    binary_string = f"{bitboard:064b}"
    
    # Split the binary string into 8 rows of 8 bits each
    rows = [binary_string[i*8:(i+1)*8] for i in range(8)]
    
    # Print the bitboard in a human-readable format
    for row in rows:
        print(' '.join(row))

display_bitboard(bits_below_offset(0xffffffffffffffff, 16))

# 8 [56][57][58][59][60][61][62][63]
# 7 [48][49][50][51][52][53][54][55]
# 6 [40][41][42][43][44][45][46][47]
# 5 [32][33][34][35][36][37][38][39]
# 4 [24][25][26][27][28][29][30][31]
# 3 [16][17][18][19][20][21][22][23]
# 2 [08][09][10][11][12][13][14][15]
# 1 [00][01][02][03][04][05][06][07]