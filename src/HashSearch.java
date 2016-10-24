/**
 * Created by GuoYufu on 2016/10/24.
 */

// 实现哈希函数为“除法取余法”，解决冲突为“开放地址线性探测法”
    /**
     * http://blog.csdn.net/xiaoping8411/article/details/7706376
     *
     哈希查找的操作步骤：

     1)用给定的哈希函数构造哈希表；

     2)根据选择的冲突处理方法解决地址冲突；

     3)在哈希表的基础上执行哈希查找。
     *
     * **/
public class HashSearch {

    public static void main(String[] args) {
        int hashLength = 13;
        int[] array = {13, 29, 27, 28, 26, 30, 38, 31, 25};

        int[] hash = new int[hashLength];

        for (int i = 0; i < array.length; i++) {
            insertHash(hash, hashLength, array[i]);
        }

        for (int value:hash) {
            System.out.println(value);
        }

        int result = searchHash(hash, hashLength, 10);
        if (result != -1) {
            System.out.println("已经在数组中找到，索引位置为：" + result);
        }
        else {
            System.out.println("没有此原始值");
        }
    }

    private static int searchHash(int[] hash, int hashLength, int key) {

        int hashAddress = key % hashLength;
        while (hash[hashAddress] != 0 && hash[hashAddress] != key) {
            hashAddress = (++hashAddress) % hashLength;
        }
        if (hash[hashAddress] == 0) {
            return -1;
        }
        return hashAddress;
    }

    private static void insertHash(int[] hash, int hashLength, int data) {

        int hashAddress = data % hashLength;
        while (hash[hashAddress] != 0) {
            hashAddress = (++hashAddress) % hashLength;
        }
        hash[hashAddress] = data;
    }
}
