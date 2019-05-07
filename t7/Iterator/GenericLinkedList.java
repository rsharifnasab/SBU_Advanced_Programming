import java.util.*;

class Node<T> {
    
}

enum Operation {
	None, Next, Prev
}

class GenericListIterator<T> implements ListIterator<T> {
    private final GenericLinkedList<T> innerList;
    private boolean valid;    

    public GenericListIterator(GenericLinkedList<T> innerList) {
        this.innerList = innerList;
        valid = true;
			
		// TODO
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean hasNext() {
        if (!valid)
            throw new ConcurrentModificationException();
		
        // TODO
    }

    @Override
    public T next() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		// TODO
    }

    @Override
    public boolean hasPrevious() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		// TODO
    }

    @Override
    public T previous() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		// TODO
    }

    @Override
    public int nextIndex() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		// TODO
    }

    @Override
    public int previousIndex() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		// TODO
    }

    @Override
    public void remove() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		// TODO
    }

    @Override
    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}

public class GenericLinkedList<T> implements Iterable<T> {
    private Node<T> first = null;
    private List<GenericListIterator<T>> currentIterators;

    public GenericLinkedList() {
        this.currentIterators = new ArrayList<>();
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    @Override
    public Iterator<T> iterator() {
        GenericListIterator<T> newIterator = new GenericListIterator<>(this);
        currentIterators.add(newIterator);
        return newIterator;
    }

    public ListIterator<T> listIterator() {
        GenericListIterator<T> newIterator = new GenericListIterator<>(this);
        currentIterators.add(newIterator);
        return newIterator;
    }


    public int size() {
        // TODO
    }

    public boolean isEmpty() {
        // TODO
    }

    public void add(T element) {
        // TODO
    }

    public boolean remove(Object o) {
        // TODO
    }

    public void clear() {
        // TODO
    }

    public T get(int index) {
        // TODO
    }

    public void set(int index, T element) {
		// TODO
    }
}
