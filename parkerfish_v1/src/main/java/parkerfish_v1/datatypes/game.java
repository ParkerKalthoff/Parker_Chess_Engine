package parkerfish_v1.datatypes;

public class game {
    
    public int start;
    public int dest;
    public int promote;
    public int capture;
    public int fifty;
    public int castle;
    public long hash;
    public long lock;

    public game copy(){
        game game_copy = new game();
        game_copy.start = this.start;
        game_copy.dest = this.dest;
        game_copy.promote = this.promote;
        game_copy.capture = this.capture;
        game_copy.fifty = this.fifty;
        game_copy.castle = this.castle;
        game_copy.hash = this.hash;
        game_copy.lock = this.lock;
        return game_copy;
    }
}
