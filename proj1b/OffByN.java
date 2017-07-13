public class OffByN implements CharacterComparator{
    private int L;

    public OffByN(int N){
        L = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        return Math.abs( x - y ) == L;
    }

}