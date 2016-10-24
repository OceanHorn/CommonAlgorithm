/**
 * Created by GuoYufu on 2016/10/20.
 */

// 二分查找
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 5;
        System.out.println(binarySearch(array, key));
    }

    private static int binarySearch(int[] list, int key) {

        int index = -1;

        int highIndex = list.length - 1;
        int lowIndex = 0;
        int middleIndex;

        while (highIndex >= lowIndex) {

            middleIndex = (highIndex + lowIndex) / 2;

            if (key > list[middleIndex]) {
                lowIndex = middleIndex + 1;
            }
            else if (key == list[middleIndex]) {
                index = middleIndex;
                return index;
            }
            else {
                highIndex = middleIndex - 1;
            }
        }
        return -lowIndex - 1;
    }
}
