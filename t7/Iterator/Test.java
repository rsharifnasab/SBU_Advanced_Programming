import java.util.ConcurrentModificationException;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
/*
      GenericLinkedList<Integer> ml = new GenericLinkedList<>();
      ml.add(0);
      ml.add(1);
      ml.add(2);
      ml.add(3);
        ListIterator<Integer> it = ml.listIterator();
      int ii = 0;
      for (;it.hasNext() ;ii++ ) {
        System.out.println(ii + " : ");
        System.out.println(it.next());

      }
      for (;it.hasPrevious() ;ii-- ) {
        System.out.println(ii + " : ");
        for (Integer in : ml ) {
          System.out.print(in+" ");
        }
        System.out.println();
        it.remove();
        it.next();
        it.previous();

      }
*/
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 3; i++)
            list.add(i);
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println(); // 0 1 2

        for (Integer value : list)
            System.out.print(value + " ");
        System.out.println(); // 0 1 2

        ListIterator<Integer> iterator1 = list.listIterator();
        ListIterator<Integer> iterator2 = list.listIterator();
        list.remove(4); // doesn't corrupt iterator because list doesn't change
        System.out.println(iterator1.next()); // 0
        list.remove(0);

        try {
            iterator1.next();
            System.out.println("Unable to catch ConcurrentModificationException");
        } catch (ConcurrentModificationException e) {
            System.out.println("Catch ConcurrentModificationException");
        }
        try {
            iterator2.next();
            System.out.println("Unable to catch ConcurrentModificationException");
        } catch (ConcurrentModificationException e) {
            System.out.println("Catch ConcurrentModificationException");
        }
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        iterator = list.listIterator();
        list.set(1, 12); // doesn't corrupt list because pointers valid after set
        //System.out.println("sjafa");
        while (iterator.hasNext()) {
            Integer data = iterator.next();
            System.err.println("data : "+data);
            if (data % 2 == 0)
                iterator.remove();
        }

        for (Integer value : list)
            System.out.print(value + " ");
        System.out.println(); // 1 3 5 7 9
         // 1 3 5 7 9 // values
         // 0 1 2 3 4 // indexes
         //0 1 2 3 4 5 // iterator
        for(;iterator.hasNext();) System.out.println(iterator.next());
        System.out.println("before test, index is "+ iterator.nextIndex());

        System.out.println(iterator.previous());
        System.out.println("iter prev ok");
        iterator.remove();
        for (Integer value : list)
            System.out.print(value + " ");
    }
}
