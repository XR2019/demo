package demo.快速排序;

import java.util.Arrays;

public class QuickSort {
/*
    快速排序：双边循环法
 */
    public static void main(String[] args) {
        int[] arr = new int[]{-4,7,3,5,6,2,8,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归终止的条件
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素d的下标位置
        int provitIndex = partition(arr,startIndex,endIndex);
        //根据基准元素，分成两部分进行递归实现
        quickSort(arr,startIndex,provitIndex-1);
        quickSort(arr,provitIndex+1,endIndex);
    }

    //该方法是寻找基准元素的下标位置
    public static int partition(int[] arr,int startIndex,int endIndex) {
        //通常我们取数组下标为0的元素为基准元素
        int provit = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制右指针左移
            while (left < right && provit < arr[right]) {
                right--;
            }
            //控制左指针右移
            while (left < right && provit >= arr[left]) {
                left++;
            }
            //否则交换left指针和right指针所指向的元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //当程序走到这一步，则说明left和right重合,及provit和指针重合点进行交换
        arr[startIndex] = arr[left];
        arr[left] = provit;
        return left;
    }
}
