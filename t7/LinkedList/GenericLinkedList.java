import java.util.*;

class Node<E> {
  Node<E> next = null;
  Node<E> pre = null;
  E value;
}

public class GenericLinkedList<T> {
    private Node<T> first = null;
    private Node<T> last = null;
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
      @SuppressWarnings("unchecked")
      T[] arr = (T[]) new Object[size]; //TODO;

      Node<T> head = first;
      for (int i=0;i<size;i++ ) {
        arr[i] = head.value;
        head = head.next;
      }
      return arr;
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

    private void addToHead(T element){ //index == 0
      nullCheck(element);
      Node<T> n = new Node<T>();
      n.value = element;
      n.next = first;
      n.pre = null;
      first = n;
      size++;
    }

    public void add(int index, T element) {
      if(index == size) {add(element); return;}
      if(index == 0) {addToHead(element); return;}
      nullCheck(element);
      indexCheck(index);
      Node<T> n = new Node<T>();
      n.value = element;
      Node<T> before = indexToNode(index-1);
      Node<T> nnext = indexToNode(index);
      before.next = n;
      n.next = nnext;
      nnext.pre = n;
      n.pre = before;
      size++;
    }
    private Node<T> indexToNode(int index){
      indexCheck(index);
      Node<T> head = first;
      for (int i=0;i<index;i++ ) {
        head = head.next;
      }
      return head;
    }

    public boolean remove(Object element) {
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
        first = null;
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

    public int indexOf(Object element) {
        nullCheck(element);
        Node<T> head = first;
        for (int i=0;i<size;i++ ) { //TODO
          if(head.value.equals(element)) return i;
          head = head.next;
        }
        return -1;
    }

    public int lastIndexOf(Object element) {
        nullCheck(element);
        int index = -1;
        Node<T> head = first;
        for (int i=0;i<size;i++ ) { //TODO
          if(head.value.equals(element)) index = i;
          head = head.next;
        }
        return index;
    }

    public void sort(Comparator<T> comparator) {
      nullCheck(comparator);
      T[] arr = toArray();
      Arrays.sort(arr,comparator);
      clear();
      for (T t:arr) {
          add(t);
      }
    }


}
