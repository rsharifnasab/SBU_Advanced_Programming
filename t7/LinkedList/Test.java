import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 3; i++){
            list.add(i);
        }
        System.out.println(list.contains(1)); // true
        System.out.println(list.get(2)); // 2
        System.out.println(list.remove(1.2)); // false
        System.out.println(list.remove(0)); // true
        list.clear();

        for (int i = 10; i >= 1; i--) {
            list.add(10 - i, i);
        }
        System.out.println(list.indexOf(10)); // 0
        System.out.println(list.indexOf(1)); // 9
        System.out.println(Arrays.toString(list.toArray())); // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        System.out.println(list.remove(4)); // true
        System.out.println(Arrays.toString(list.toArray())); // [10, 9, 8, 7, 6, 5, 3, 2, 1]
        list.set(0, 9);
        System.out.println(Arrays.toString(list.toArray())); // [9, 9, 8, 7, 6, 5, 3, 2, 1]
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        System.out.println(Arrays.toString(list.toArray())); // [1, 2, 3, 5, 6, 7, 8, 9, 9]
        System.out.println(list.lastIndexOf(9)); // 8
        System.out.println(list.indexOf(9)); // 7
        System.out.println(list.size()); // 9
        try {
            System.out.println(list.get(9));
            System.out.println("Unable to catch IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Catch IndexOutOfBoundsException");
        }
    }
}
