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
  Operation oper = Operation.None;
  public int index;
  int firstSize;
  public GenericListIterator(GenericLinkedList<T> innerList) {
    this.innerList = innerList;
    index = 0;
    firstSize = innerList.size();
  }

  public void setValid(boolean valid) {
    if(valid) firstSize = innerList.size();
    else firstSize = -1;
  }
  public boolean valid(){
    return innerList.size() == firstSize;
  }

  @Override
  public boolean hasNext() {
    if (!valid())
    throw new ConcurrentModificationException();

    if (index < innerList.size() ) return true; //TODO
    return false;
  }

  @Override
  public T next() {
    if (!valid())
    throw new ConcurrentModificationException();
    if (hasNext() == false)
      throw new NoSuchElementException();
    oper = Operation.Next;
    Node<T> head = innerList.indexToNode(index++);
    return head.value;
  }

  @Override
  public boolean hasPrevious() {
    if (!valid())
    throw new ConcurrentModificationException();

    if(index > 0) return true;
    return false;
  }

  @Override
  public T previous() {
    if (!valid())
      throw new ConcurrentModificationException();
    if (hasPrevious() == false)
      throw new NoSuchElementException();
    oper = Operation.Prev;
    Node<T> head = innerList.indexToNode(--index);
    return head.value;
  }

  @Override
  public int nextIndex() {
    if (!valid())
    throw new ConcurrentModificationException();
    return index;
  }

  @Override
  public int previousIndex() {
    if (!valid())
    throw new ConcurrentModificationException();
    return index-1;
  }

  @Override
  public void remove() {
    if (!valid())
    throw new ConcurrentModificationException();

    System.err.println("case is"+oper);
    switch (oper) {
          case None:
            throw new IllegalStateException();

          case Next:
            innerList.removeIndex(index-1);
            break;
          case Prev:
            innerList.removeIndex(index-2); //TODO
            break;
    }
    oper = Operation.None;
    firstSize = innerList.size(); //make it vald again
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

  public int indexOf(Object element) {
    nullCheck(element);
    Node<T> head = first;
    for (int i=0;i<size;i++ ) { //TODO
      if(head.value.equals(element)) return i;
      head = head.next;
    }
    return -1;
  }

  public boolean remove(Object o) {
    nullCheck(o);
    int index = indexOf(o);
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

    first = null;
  }

  public T get(int index) {
    indexCheck(index);
    Node<T> head = indexToNode(index);
    return (T) head.value;
  }

  Node<T> indexToNode(int index){
    indexCheck(index);
    Node<T> head = first;
    for (int i=0;i<index;i++ ) {
      head = head.next;
    }
    return head;
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
