package parkerfish_v1;
import parkerfish_v1.cons;

public class bitboard {

    public static cons cons = new cons(); 

    public static Long bit_pawncaptures[][] = new Long[2][64]; 
    public static Long bit_pawndefends[][] = new Long[2][64];
    public static Long bit_left[][] = new Long[2][64];
    public static Long bit_right[][] = new Long[2][64];
    public static Long bit_pawnmoves[][] = new Long[2][64];
    public static Long bit_knightmoves[] = new Long[64];
    public static Long bit_bishopmoves[] = new Long[64];
    public static Long bit_rookmoves[] = new Long[64];
    public static Long bit_queenmoves[] = new Long[64];
    public static Long bit_kingmoves[] = new Long[64];
    public static Long bit_pieces[][] = new Long[2][7];
    public static Long bit_units[] = new Long[2];
    public static Long bit_all;
    public static Long bit_between[][] = new Long[64][64];
    public static Long mask_passed[][] = new Long[2][64];
    public static Long mask_path[][] = new Long[2][64];
    public static Long mask[] = new Long[64];
    public static Long not_mask[] = new Long[64];
    public static Long mask_cols[] = new Long[64];
    public static Long mask_isolated[] = new Long[64];
    public static Long kingside;
    public static Long queenside;
    public static Long not_a_file;
    public static Long not_h_file;

    public static Integer row[] = {7, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    public static Integer col[] = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};

    public static Integer pawnplus[][] = new Integer[2][64];
    public static Integer pawndouble[][] = new Integer[2][64];
    public static Integer pawnleft[][] = new Integer[2][64];
    public static Integer pawnright[][] = new Integer[2][64];

    public static void SetBit(Long bb, int square){
        bb |= (1L << square);
    }

    public static void SetBitFalse(Long bb, int square){
        bb &= ~mask[square];
    } 

    public static void SetBits(){

    }

    public static void SetBetweenVector(){
        int x,y,z;
        for(x=0;x<64;x++){
            for(y=0;y<64;y++){
                if(row[x] == row[y]){
                    
                }
            }
        }
    }
}
