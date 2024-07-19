package parkerfish_v1;

public class Main extends bitboard{
    public static void main(String[] args) {
        printBitboard(bit_after[A4][C6]);

    }
    public static void printBitboard(long bitboard, boolean with_coords) {
        for (int rank = 7; rank >= 0; rank--) {  // Start from the top rank (rank 7)
            System.out.print(with_coords ? (""+(rank+1)+"   ") : "");
            for (int file = 0; file < 8; file++) {  // Iterate through each file in the rank
                int square = rank * 8 + file;
                long mask = 1L << square;
                // Print 1 if the bit at the current square is set, otherwise print 0
                System.out.print((bitboard & mask) != 0 ? "1 " : "0 ");
            }
            System.out.println();
              // Move to the next line after printing a rank
        }
        System.out.println(with_coords ? "    A B C D E F G H" : "");

    }

    public static void printBitboard(long bitboard){
        printBitboard(bitboard, false);
    }
    

    
}