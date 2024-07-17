def square_to_row_col(square_num):
    if not 0 <= square_num <= 63:
        raise ValueError("Square number must be between 1 and 64 inclusive.")

    # Convert square number to 0-indexed row and column
    row = 7 - (square_num) // 8
    col = (square_num) % 8
    
    return row, col

row_l = []
col_l = []

for i in range(64):
    a, b = square_to_row_col(i)
    row_l.append(a)
    col_l.append(b)

print(row_l)
print(col_l)