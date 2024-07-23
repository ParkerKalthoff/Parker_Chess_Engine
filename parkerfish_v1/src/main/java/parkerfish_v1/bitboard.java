package parkerfish_v1;
import static java.lang.Math.abs;
import java.util.concurrent.TimeUnit;

public class bitboard extends cons{

    public static Long bit_pawncaptures[][] = new Long[2][64]; 
    public static Long bit_pawndefends[][] = new Long[2][64];
    public static Long bit_left[][] = new Long[2][64];
    public static Long bit_right[][] = new Long[2][64];
    public static Long bit_pawnmoves[][] = new Long[2][64];
    public static Long bit_knightmoves[] = {0x20400L,0x50800L,0xa1100L,0x142200L,0x284400L,0x508800L,0xa01000L,0x402000L,0x2040004L,0x5080008L,0xa110011L,0x14220022L,0x28440044L,0x50880088L,0xa0100010L,0x40200020L,0x204000402L,0x508000805L,0xa1100110aL,0x1422002214L,0x2844004428L,0x5088008850L,0xa0100010a0L,0x4020002040L,0x20400040200L,0x50800080500L,0xa1100110a00L,0x142200221400L,0x284400442800L,0x508800885000L,0xa0100010a000L,0x402000204000L,0x2040004020000L,0x5080008050000L,0xa1100110a0000L,0x14220022140000L,0x28440044280000L,0x50880088500000L,0xa0100010a00000L,0x40200020400000L,0x204000402000000L,0x508000805000000L,0xa1100110a000000L,0x1422002214000000L,0x2844004428000000L,0x5088008850000000L,0xa0100010a0000000L,0x4020002040000000L,0x400040200000000L,0x800080500000000L,0x1100110a00000000L,0x2200221400000000L,0x4400442800000000L,0x8800885000000000L,0x100010a000000000L,0x2000204000000000L,0x4020000000000L,0x8050000000000L,0x110a0000000000L,0x22140000000000L,0x44280000000000L,0x88500000000000L,0x10a00000000000L,0x20400000000000L};
    public static Long bit_bishopmoves[] = {0x8040201008040200L,0x0080402010080500L,0x0000804020110a00L,0x0000008041221400L,0x0000000182442800L,0x0000010204885000L,0x000102040810a000L,0x0102040810204000L,0x4020100804020002L,0x8040201008050005L,0x00804020110a000aL,0x0000804122140014L,0x0000018244280028L,0x0001020488500050L,0x0102040810a000a0L,0x0204081020400040L,0x2010080402000204L,0x4020100805000508L,0x804020110a000a11L,0x0080412214001422L,0x0001824428002844L,0x0102048850005088L,0x02040810a000a010L,0x0408102040004020L,0x1008040200020408L,0x2010080500050810L,0x4020110a000a1120L,0x8041221400142241L,0x0182442800284482L,0x0204885000508804L,0x040810a000a01008L,0x0810204000402010L,0x0804020002040810L,0x1008050005081020L,0x20110a000a112040L,0x4122140014224180L,0x8244280028448201L,0x0488500050880402L,0x0810a000a0100804L,0x1020400040201008L,0x0402000204081020L,0x0805000508102040L,0x110a000a11204080L,0x2214001422418000L,0x4428002844820100L,0x8850005088040201L,0x10a000a010080402L,0x2040004020100804L,0x0200020408102040L,0x0500050810204080L,0x0a000a1120408000L,0x1400142241800000L,0x2800284482010000L,0x5000508804020100L,0xa000a01008040201L,0x4000402010080402L,0x0002040810204080L,0x0005081020408000L,0x000a112040800000L,0x0014224180000000L,0x0028448201000000L,0x0050880402010000L,0x00a0100804020100L,0x0040201008040201L,};
    public static Long bit_rookmoves[] = {0x01010101010101feL,0x02020202020202fdL,0x04040404040404fbL,0x08080808080808f7L,0x10101010101010efL,0x20202020202020dfL,0x40404040404040bfL,0x808080808080807fL,0x010101010101fe01L,0x020202020202fd02L,0x040404040404fb04L,0x080808080808f708L,0x101010101010ef10L,0x202020202020df20L,0x404040404040bf40L,0x8080808080807f80L,0x0101010101fe0101L,0x0202020202fd0202L,0x0404040404fb0404L,0x0808080808f70808L,0x1010101010ef1010L,0x2020202020df2020L,0x4040404040bf4040L,0x80808080807f8080L,0x01010101fe010101L,0x02020202fd020202L,0x04040404fb040404L,0x08080808f7080808L,0x10101010ef101010L,0x20202020df202020L,0x40404040bf404040L,0x808080807f808080L,0x010101fe01010101L,0x020202fd02020202L,0x040404fb04040404L,0x080808f708080808L,0x101010ef10101010L,0x202020df20202020L,0x404040bf40404040L,0x8080807f80808080L,0x0101fe0101010101L,0x0202fd0202020202L,0x0404fb0404040404L,0x0808f70808080808L,0x1010ef1010101010L,0x2020df2020202020L,0x4040bf4040404040L,0x80807f8080808080L,0x01fe010101010101L,0x02fd020202020202L,0x04fb040404040404L,0x08f7080808080808L,0x10ef101010101010L,0x20df202020202020L,0x40bf404040404040L,0x807f808080808080L,0xfe01010101010101L,0xfd02020202020202L,0xfb04040404040404L,0xf708080808080808L,0xef10101010101010L,0xdf20202020202020L,0xbf40404040404040L,0x7f80808080808080L};
    public static Long bit_queenmoves[] = {0x81412111090503feL,0x02824222120a07fdL,0x0404844424150efbL,0x08080888492a1cf7L,0x10101011925438efL,0x2020212224a870dfL,0x404142444850e0bfL,0x8182848890a0c07fL,0x412111090503fe03L,0x824222120a07fd07L,0x04844424150efb0eL,0x080888492a1cf71cL,0x101011925438ef38L,0x20212224a870df70L,0x4142444850e0bfe0L,0x82848890a0c07fc0L,0x2111090503fe0305L,0x4222120a07fd070aL,0x844424150efb0e15L,0x0888492a1cf71c2aL,0x1011925438ef3854L,0x212224a870df70a8L,0x42444850e0bfe050L,0x848890a0c07fc0a0L,0x11090503fe030509L,0x22120a07fd070a12L,0x4424150efb0e1524L,0x88492a1cf71c2a49L,0x11925438ef385492L,0x2224a870df70a824L,0x444850e0bfe05048L,0x8890a0c07fc0a090L,0x090503fe03050911L,0x120a07fd070a1222L,0x24150efb0e152444L,0x492a1cf71c2a4988L,0x925438ef38549211L,0x24a870df70a82422L,0x4850e0bfe0504844L,0x90a0c07fc0a09088L,0x0503fe0305091121L,0x0a07fd070a122242L,0x150efb0e15244484L,0x2a1cf71c2a498808L,0x5438ef3854921110L,0xa870df70a8242221L,0x50e0bfe050484442L,0xa0c07fc0a0908884L,0x03fe030509112141L,0x07fd070a12224282L,0x0efb0e1524448404L,0x1cf71c2a49880808L,0x38ef385492111010L,0x70df70a824222120L,0xe0bfe05048444241L,0xc07fc0a090888482L,0xfe03050911214181L,0xfd070a1222428202L,0xfb0e152444840404L,0xf71c2a4988080808L,0xef38549211101010L,0xdf70a82422212020L,0xbfe0504844424140L};
    public static Long bit_kingmoves[] = {0x302L,0x705L,0xe0aL,0x1c14L,0x3828L,0x7050L,0xe0a0L,0xc040L,0x30203L,0x70507L,0xe0a0eL,0x1c141cL,0x382838L,0x705070L,0xe0a0e0L,0xc040c0L,0x3020300L,0x7050700L,0xe0a0e00L,0x1c141c00L,0x38283800L,0x70507000L,0xe0a0e000L,0xc040c000L,0x302030000L,0x705070000L,0xe0a0e0000L,0x1c141c0000L,0x3828380000L,0x7050700000L,0xe0a0e00000L,0xc040c00000L,0x30203000000L,0x70507000000L,0xe0a0e000000L,0x1c141c000000L,0x382838000000L,0x705070000000L,0xe0a0e0000000L,0xc040c0000000L,0x3020300000000L,0x7050700000000L,0xe0a0e00000000L,0x1c141c00000000L,0x38283800000000L,0x70507000000000L,0xe0a0e000000000L,0xc040c000000000L,0x302030000000000L,0x705070000000000L,0xe0a0e0000000000L,0x1c141c0000000000L,0x3828380000000000L,0x7050700000000000L,0xe0a0e00000000000L,0xc040c00000000000L,0x203000000000000L,0x507000000000000L,0xa0e000000000000L,0x141c000000000000L,0x2838000000000000L,0x5070000000000000L,0xa0e0000000000000L,0x40c0000000000000L};
    public static Long bit_pieces[][] = new Long[2][7];
    public static Long bit_units[] = new Long[2];
    public static Long bit_all = 0xffffffffffffffffL;
    public static Long bit_between[][] = generateAllSquaresBetween();
    public static Long bit_after[][] = generateAllBitsAfter();
    public static Long mask_passed[][] = new Long[2][64];
    public static Long mask_path[][] = new Long[2][64];
    public static Long mask[] = new Long[64];
    public static Long not_mask[] = new Long[64];
    public static Long mask_cols[] = new Long[64];
    public static Long mask_isolated[] = new Long[64];
    public static Long kingside = 0xf0f0f0f0f0f0f0f0L;
    public static Long queenside = 0x0f0f0f0f0f0f0f0fL;
    public static Long not_a_file;
    public static Long not_h_file;

    public static int bits_row[] = {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7};
    public static int bits_rank[] = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};
    // (A 1), (B 2), (C 3), (D 4), (E 5), (F 6), (G 7), (H 8)
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

    public static Long[][] generateAllBitsAfter(){
        Long bitsAfter[][] = new Long[64][64];
        for(int i = 0; i < 64; i++){
            for(int y = 0; y < 64; y++){
                bitsAfter[i][y] = getBitsAfter(i, y);
            }   
        }
        return bitsAfter;
    }

    public static Long getBitsAfter(int startIndex, int endIndex) {
        
        // 8 [56][57][58][59][60][61][62][63]
        // 7 [48][49][50][51][52][53][54][55]
        // 6 [40][41][42][43][44][45][46][47]
        // 5 [32][33][34][35][36][37][38][39]
        // 4 [24][25][26][27][28][29][30][31]
        // 3 [16][17][18][19][20][21][22][23]
        // 2 [08][09][10][11][12][13][14][15]
        // 1 [00][01][02][03][04][05][06][07]
        //    A   B   C   D   E   F   G   H

        // ^  [RANK/ROW][ROW][ROW][ROW][ROW][ROW][ROW][ROW]
        // R  [RANK] 
        // A  [RANK]
        // N  [RANK]
        // K  [RANK]
        // S  [RANK]
        // v  [RANK]
        //    [RANK]
        //    <   R   O   W   S   >

        Long bitsafter = 0L;

        long vector = Math.abs(startIndex - endIndex);

        if(vector == 0L){return 0L;} // Identical start and ends

        int scalar;

        if(startIndex % 8 == endIndex % 8){ // Same rank
            scalar = 8;
        } else if(startIndex / 8 == endIndex / 8){ // same row
            scalar = 1;
        } else if((vector & 0x2040810204080L) > 0) { // North west to south east diagonal -> \ 
            scalar = 7;
        } else if((vector & 0x8040201008040200L) > 0){// South west to north east diagonal -> /
            scalar = 9;
        } else {return 0L;};
        


        return bitsafter;
    }
    
    
    private static Long[][] generateAllSquaresBetween(){
        Long[][] allSquaresBetween = new Long[64][64];
        for (int startIndex = 0; startIndex < 64; startIndex++) {
            for(int endIndex = 0; endIndex < 64; endIndex++){
                allSquaresBetween[startIndex][endIndex] = getSquaresBetween(startIndex, endIndex);
            }
        }
        return allSquaresBetween;
    }

    private static Long getSquaresBetween(int startIndex, int endIndex) {
        
        if (startIndex == endIndex) {
            return 0L;
        }
        
        Long squaresBetween = 0L;
        
        int startRow = startIndex / 8;
        int startCol = startIndex % 8;
        int endRow = endIndex / 8;
        int endCol = endIndex % 8;
        
        if (startRow == endRow) { // same row
            int step = (startIndex < endIndex) ? 1 : -1;
            for (int i = startIndex + step; i != endIndex; i += step) {
                squaresBetween |= 1L << i;
            }
        } else if (startCol == endCol) { // same column
            int step = (startIndex < endIndex) ? 8 : -8;
            for (int i = startIndex + step; i != endIndex; i += step) {
                squaresBetween |= 1L << i;
            }
        } else if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) { // diagonal
            int rowStep = (startRow < endRow) ? 1 : -1;
            int colStep = (startCol < endCol) ? 1 : -1;
            for (int i = startIndex + 8 * rowStep + colStep; i != endIndex; i += 8 * rowStep + colStep) {
                squaresBetween |= 1L << i;
            }
        } else {
            return 0L; // not aligned in row, column, or diagonal
        }
        
        return squaresBetween;
    }

}