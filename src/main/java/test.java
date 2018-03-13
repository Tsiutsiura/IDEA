/**
 * Created by Yulia.Tsyutsyura on 31.01.2018.
 */
public class test {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 1, 0, 6, 3, 4};

        //bubbleSort(arr);
        //selectionSort(arr);

        int low = 0;
        int high = arr.length -1;
        quickSort(arr, low, high);

        printArray(arr);

    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;

            for (int j = i + 1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }
        }
    }


        public static void quickSort(int[] arr, int low, int high) {
            if (arr.length == 0)
                return;//завершить выполнение если длина массива равна 0

            if (low >= high)
                return;//завершить выполнение если уже нечего делить

            // выбрать опорный элемент
            int middle = low + (high - low) / 2;   /*2, 5, 1, 0, 6, 3, 4*/
            int opora = arr[middle];

            // разделить на подмассивы, который больше и меньше опорного элемента
            int i = low, j = high;
            while (i <= j) {
                while (arr[i] < opora) {
                    i++;
                }

                while (arr[j] > opora) {
                    j--;
                }

                if (i <= j) {//меняем местами
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            // вызов рекурсии для сортировки левой и правой части
            if (low < j)
                quickSort(arr, low, j);

            if (high > i)
                quickSort(arr, i, high);
    }

}
