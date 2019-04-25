public class SimpleArrayList {
    private Integer[] db = null;
    private final int MAX_SIZE = 1101;
    private int size = 0;


    public int size(){
        return size;
    }

    public SimpleArrayList () { clear(); }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
        db = new Integer[MAX_SIZE];
        size = 0;
    }

    public boolean add(Integer toAdd ){
        if(toAdd == null) throw new NullPointerException();
        if(size() >= MAX_SIZE) return false;
        db[size++] = toAdd;
        return  true;
    }

    public void add(int index,Integer toAdd ){
        if(toAdd == null) throw new NullPointerException();
        if(size() >= MAX_SIZE || index>= MAX_SIZE  || index > size()|| index < 0) throw new IndexOutOfBoundsException("salam");

        for(int i = size; i > index; i--)
            db[i] = db [i-1];

        db[index] = toAdd;
        size++;

    } //TODO

    public boolean addAll(Integer...elements){
        System.err.println("max size:" + MAX_SIZE + " - -  size :" + size() + "  + length : " + elements.length);
        for(Integer i : elements) {
            if (i == null) throw new NullPointerException();
        }

        if(MAX_SIZE < (size() + elements.length) ) return false;
        for(Integer i : elements) {
            if (add(i) == false) return false;
        }
        return true;
    }

    public Integer get(int i){
        if(i >= size() || i < 0) throw new IndexOutOfBoundsException();
        return db[i];
    }


    public Integer set(int index,Integer value){
        if(index >= size() || index < 0) throw new IndexOutOfBoundsException();
        if ( value == null ) throw new NullPointerException();
        Integer ans = db[index];
        db[index] = value; //TODO
        return ans;

    }

    public Integer remove(int index){
        Integer ans = db[index];
        if (ans == null) throw new IndexOutOfBoundsException();
        for(int i = index; i < size; i++)
            db[i] = db [i+1];
        size--;
        return ans; //TODO

    }



}
