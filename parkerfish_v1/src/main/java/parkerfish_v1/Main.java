package parkerfish_v1;

public class Main {
    public static void main(String[] args) {

    
        printBitboard(0xf0f0f0f0f0f0f0f0L);

    }
    public static void printBitboard(long bitboard) {
        for (int rank = 7; rank >= 0; rank--) {  // Start from the top rank (rank 7)
            for (int file = 0; file < 8; file++) {  // Iterate through each file in the rank
                int square = rank * 8 + file;
                long mask = 1L << square;
                // Print 1 if the bit at the current square is set, otherwise print 0
                System.out.print((bitboard & mask) != 0 ? "1 " : "0 ");
            }
            System.out.println();  // Move to the next line after printing a rank
        }
        System.out.println();  // Add an extra line for better readability
    }
    

    
}