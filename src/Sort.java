/**
 * Created by GuoYufu on 2016/10/24.
 */
public class Sort {

    public static void main(String[] args) {
        int[] numbers = {40, 20, 80, 50, 30, 60};

        printArray(numbers);
//        bubbleSort(number);
//        insertSort(number);
//        selectSort(numbers);

//        shellSort(numbers);
        quick_sort(numbers, 0, numbers.length - 1);
        printArray(numbers);
    }

    // 冒泡排序
    private static void bubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                printArray(array);
            }
        }
    }

    // 插入排序
    // http://blog.csdn.net/xiaowei_cqu/article/details/7770838
    // http://blog.csdn.net/xiaoping8411/article/details/7704584
    public static void insertSort(int[] array) {

        if(array == null || array.length < 2){
            return;
        }

        for(int i = 1; i < array.length; i++){
            int temp = array[i];

            int j;

            // j = [0,i-1] 区间为有序序列
            for (j = i - 1; j >= 0 && temp < array[j]; j--) {
//                System.out.println("满足后移条件: i = " + i + ",j = " + j);
                array[j + 1] = array[j];
                printArray(array);
            }
            array[j + 1] = temp;
            printArray(array);
        }
    }

    // 选择排序
    public static void selectSort(int[] array) {
        int minIndex = 0;
        int temp = 0;

        if((array == null)||(array.length == 0))
            return;

        for(int i = 0; i < array.length - 1; i++) {
            minIndex = i; //无序区的最小数据数组下标
            for( int j = i + 1; j < array.length; j++) {
                //在无序区中找到最小数据并保存其数组下标
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            System.out.println("最小数据下标" + minIndex);
            if(minIndex != i) {
                //如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
            printArray(array);
        }
    }



    // 希尔排序
    public static void shellSort(int[] array) {
        // 取增量
        int step = array.length / 2;

        while (step >= 1) {
            // 无序序列
            System.out.println("step:" + step);
            for (int i = step; i < array.length; i++) {

                int temp = array[i];

                int j;
                // 有序序列
                for (j = i - step; j >= 0 && temp < array[j]; j = j - step) {
                    System.out.println("i:" + i);
                    array[j + step] = array[j];
                    printArray(array);
                }

                array[j + step] = temp;
                printArray(array);
            }
            step = step / 2;
        }
    }

    // 快速排序
    // http://blog.csdn.net/morewindows/article/details/6684558
    public static void quick_sort(int array[], int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = leftIndex, j = rightIndex, middleValue = array[i];  // 将i位置的数据挖出,作为中间值
            while (i < j) {
                while(i < j && array[j] >= middleValue) { // 从右向左找第一个小于x的数
                    j--;
                }
                if( i < j) {
                    array[i] = array[j];
                    i++;
                }

                while(i < j && array[i] < middleValue) { // 从左向右找第一个大于等于x的数
                    i++;
                }
                if(i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = middleValue;  // 挖出的数据填回
            quick_sort(array, leftIndex, i - 1); // 递归调用
            quick_sort(array, i + 1, rightIndex);
        }
    }

    private static void printArray(int[] array) {
        int lastIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (i < lastIndex)
                System.out.format("%5d,", array[i]);
            else
                System.out.format("%5d", array[i]);
        }
        System.out.println();
    }
}
