import java.util.*;

class Node<T> {
  Node<T> next = null;
  Node<T> pre = null;
  T value;
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
  private Node<T> last = null;
  private int size = 0;
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
    return size;
  }

  public boolean isEmpty() {
    return size==0;
  }

  public void add(T element) {
    nullCheck(element);
    Node<T> n = new Node<T>();
    n.value = element;
    n.next = null;
    this.last = n;
    if(size != 0){
      Node<T>before = indexToNode(size-1);
      before.next = n;
      n.pre = before;
    }
    else{
      first = n;
      n.next = null;
      n.pre = null;
    }
    this.last = n;
    size++;
  }


  public boolean remove(Object o) {
    nullCheck(element);
    int index = indexOf(element);
    if(index == -1) return false;
    removeIndex(index);
    return true;
  }


  public boolean removeIndex(int index) {
    indexCheck(index);
    if(index == 0) {first = first.next; size--; return true;}
    Node<T> before = indexToNode(index-1);
    before.next = before.next.next;
    if(index != size-1) before.next.pre = before;
    size--;
    return true;
  }

  public void clear() {
    size = 0;
    first = null
  }

  public T get(int index) {
    indexCheck(index);
    Node<T> head = indexToNode(index);
    return (T) head.value;
  }

  private void indexCheck(int index) throws IndexOutOfBoundsException{
    if(index>=this.size || index<0) throw new IndexOutOfBoundsException();
  }

  private void nullCheck(Object toCheck) throws NullPointerException{
    if(toCheck == null) throw new NullPointerException();
  }


  public void set(int index, T element) {
    indexCheck(index);
    nullCheck(element);
    Node<T> head = indexToNode(index);
    head.value = element;
  }
}
