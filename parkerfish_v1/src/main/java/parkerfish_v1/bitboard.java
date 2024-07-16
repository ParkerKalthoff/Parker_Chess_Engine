package parkerfish_v1;
import parkerfish_v1.datatypes.BITBOARD;

public class bitboard {

    public BITBOARD bit_pawncaptures[][] = new BITBOARD[2][64]; 
    public BITBOARD bit_pawndefends[][] = new BITBOARD[2][64];
    public BITBOARD bit_left[][] = new BITBOARD[2][64];
    public BITBOARD bit_right[][] = new BITBOARD[2][64];
    public BITBOARD bit_pawnmoves[][] = new BITBOARD[2][64];
    public BITBOARD bit_knightmoves[] = new BITBOARD[64];
    public BITBOARD bit_bishopmoves[] = new BITBOARD[64];
    public BITBOARD bit_rookmoves[] = new BITBOARD[64];
    public BITBOARD bit_queenmoves[] = new BITBOARD[64];
    public BITBOARD bit_kingmoves[] = new BITBOARD[64];
    public BITBOARD bit_pieces[][] = new BITBOARD[2][7];
    public BITBOARD bit_units[] = new BITBOARD[2];
    public BITBOARD bit_all;
    public BITBOARD bit_between[][] = new BITBOARD[64][64];
    public BITBOARD mask_passed[][] = new BITBOARD[2][64];
    public BITBOARD mask_path[][] = new BITBOARD[2][64];
    public BITBOARD mask[] = new BITBOARD[64];
    public BITBOARD not_mask[] = new BITBOARD[64];
    public BITBOARD mask_cols[] = new BITBOARD[64];
    public BITBOARD mask_isolated[] = new BITBOARD[64];
    public BITBOARD kingside;
    public BITBOARD queenside;
    public BITBOARD not_a_file;
    public BITBOARD not_h_file;

    public int pawnplus[][] = new int[2][64];
    public int pawndouble[][] = new int[2][64];
    public int pawnleft[][] = new int[2][64];
    public int pawnright[][] = new int[2][64];

    public void SetBit(BITBOARD bb, int square){
        bb.value |= (1 << square);
    }

    
}
