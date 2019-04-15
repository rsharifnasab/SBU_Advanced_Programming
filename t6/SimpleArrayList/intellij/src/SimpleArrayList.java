public class SimpleArrayList {
    private int[] db = null;
    private final int MAX_SIZE = 100;
    private int size = 0;

    private void reset(){
        db = new int[MAX_SIZE];
    }

    public int size(){
        return size;
    }

    public SimpleArrayList () { }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
        reset();
    }

    public boolean add(Integer toAdd ){
        if(toAdd == null) throw new NullPointerException();
        if(size() >= MAX_SIZE) return false;
        db[size++] = toAdd;
    }

    public int get(int i){
        return db[i];
    }



}
