package parkerfish_v1;

public class utils {
    public static String printBitboard(long myLong){
        return binaryStringToBoard(longToBinaryString(myLong));
    }

    public static String longToBinaryString(long myLong){
        String binaryString = "";
        for(int i = 0; i < 64; i++){
            long toBinaryMask = 1L << i;
            binaryString += ((myLong & toBinaryMask) != 0 ? "1" : "0");
        }

        return binaryString;
    }

    public static String binaryStringToBoard(String binaryString){
        char[] binaryArray = binaryString.toCharArray();
        String boardString = "";

        for(int i = 0; i < 64; i++){
            if(i % 8 == 0 && i != 0){
                boardString += "\n";
            }
            boardString += " " + binaryArray[i];
        }

        return boardString;
    }
}
