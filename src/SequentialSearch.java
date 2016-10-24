/**
 * Created by GuoYufu on 2016/10/24.
 */
public class SequentialSearch {
    public static void main(String[] args) {
        int[] array = {2, 4, 7, 5, 1, 3, 6, 9, 8 ,10};
        int key = 6;
        System.out.println(search(array, key));
    }

    public static int search(int[] array, int key) {
        int index = -1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == key) {
                index = j;
                break;
            }
        }
        return index;
    }

    public static int searchAddGuard(int[] array, int key) {
        int index = 0;
        while (array[index] != key) {
            index++;
        }
        return index;
    }
}
