import java.util.Comparator;

class Node<E> {
  Node<E> next;
  Node<E> pre;
  E value;
}

public class GenericLinkedList<T> {
    private Node<T> first = null;
    private int size = 0;

    public int size() {
       return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public T[] toArray() {
        // TODO
    }

    public void add(T element) {
        // TODO

        size++;
    }

    public void add(int index, T element) {
        if(index == size) add(element);
        nullCheck(element);
        indexCheck(index);

        size++;
    }


    public boolean remove(Object element) {
      nullCheck(element);
      int index = indexOf(element);
      if(index == -1) return false;
      removeIndex(index);
    }

	public boolean removeIndex(int index) {
        // TODO

        size--;
    }

    public void clear() {
        size = 0;
        first = null;
    }

    public T get(int index) {
      indexCheck(index);
      Node<E> head = this.first;
      for (int i=0;i<index;i++ ) {
        head = head.next;
      }
      return head.value;
    }

    private void indexCheck(int index) throws IndexOutOfBoundsException{
      if(index>=this.size || index<0) throw new IndexOutOfBoundsException();
    }

    private void nullCheck(T toCheck) throws NullPointerException{
      if(toCheck == null) throw new NullPointerException();
    }

    public void set(int index, T element) {
        indexCheck(index);
        nullCheck(element);
        for (int i=0;i<index;i++ ) {
          head = head.next;
        }
        head.value = element;
    }

    public int indexOf(Object element) {
        nullCheck(element);
        for (int i=0;i<index;i++ ) { //TODO
          if(head.value.equals(element)) return i;
          head = head.next;
        }
        return -1;
    }

    public int lastIndexOf(Object element) {
        nullCheck(element);
        int index = -1;
        for (int i=0;i<index;i++ ) { //TODO
          if(head.value.equals(element)) index = i;
          head = head.next;
        }
        return index;
    }

    public void sort(Comparator<T> comparator) {
        // TODO
    }
}
