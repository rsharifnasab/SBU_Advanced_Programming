import java.util.*;

class Node<T> {
    Node<T> previous = null;
    T value;
    Node<T> next = null;

    public Node(T value) {
        this.value = value;
    }
}

enum Operation {
	None, Next, Prev
}

class GenericListIterator<T> implements ListIterator<T> {
    private final GenericLinkedList<T> innerList;
    private boolean valid;
    private int index;
    private Operation operation;

    public GenericListIterator(GenericLinkedList<T> innerList) {
        this.innerList = innerList;
        valid = true;
        operation = Operation.None;

		index = 0;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean hasNext() {
        if (!valid)
            throw new ConcurrentModificationException();
		
        return index < innerList.size();
    }

    @Override
    public T next() {
        if (!valid)
            throw new ConcurrentModificationException();

        if (!hasNext())
            throw new NoSuchElementException();

		operation = Operation.Next;
		return innerList.get(index++);
    }

    @Override
    public boolean hasPrevious() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		return index > 0;
    }

    @Override
    public T previous() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		if (!hasPrevious())
		    throw new NoSuchElementException();

		operation = Operation.Prev;
		return innerList.get(--index);
    }

    @Override
    public int nextIndex() {
        if (!valid)
            throw new ConcurrentModificationException();

        if (index >= innerList.size())
            return innerList.size();
		return index;
    }

    @Override
    public int previousIndex() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		if (index <= 0)
		    return -1;
		return index - 1;
    }

    @Override
    public void remove() {
        if (!valid)
            throw new ConcurrentModificationException();
        
		if (operation == Operation.None)
		    throw new IllegalStateException();

        if (operation == Operation.Next) {
            innerList.remove(innerList.get(index - 1));
            if (index == 1)
                index = 0;
        }
        else
            innerList.remove(innerList.get(index));
        if (index > innerList.size())
            index = innerList.size();
        operation = Operation.None;
		valid = true;
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
    private int size = 0;

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
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        if (element == null)
            throw new NullPointerException();
        Node new_node = new Node(element);
        if (first == null) {
            new_node.previous= null;
            first = new_node;
        }
        else {
            Node last = first;
            new_node.next = null;
            while (last.next != null)
                last = last.next;

            last.next = new_node;
            new_node.previous = last;
        }
        size++;
        for (GenericListIterator it :
                currentIterators) {
            it.setValid(false);
        }
    }

    public boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException();
        Node temp = first;
        while (temp != null) {
            if (temp.value.equals(o)) {
                if (temp.previous == null) {
                    first = first.next;
                    if (first != null && first.previous != null)
                        first.previous = null;
                }
                else if (temp.next == null) {
                    temp.previous.next = null;
                }
                else {
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                }
                size--;
                for (GenericListIterator it :
                        currentIterators) {
                    it.setValid(false);
                }
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void clear() {
        first = null;
        size = 0;
        for (GenericListIterator it :
                currentIterators) {
            it.setValid(false);
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node temp = first;
        for (int i = 0; i < index; i++, temp = temp.next);
        return ((T) temp.value);
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (element == null)
            throw new NullPointerException();

        if (first == null) {
            first = new Node<>(element);
            size++;
            return;
        }

        Node temp = first;
        for (int i = 0; i < index; i++, temp = temp.next);
        temp.value = element;
    }
}

