public class OffByN implements CharacterComparator{
    private int L;

    public OffByN(int N){
        L = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        if ( Math.abs( x - y ) == L){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {

    }
}