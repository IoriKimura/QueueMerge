package mainpart;

import java.util.Random;

public class Main {

    static long nOp = 0;
    public static void main(String[] args) {

        int N = 300;
        while (N <= 3000){
            Queue queue = new Queue();
            Random rnd = new Random();
            for(int i = 0; i < N; i++)
                queue.push(rnd.nextInt());
            MergeSort ms = new MergeSort(queue);
            long startTime = System.currentTimeMillis();
            queue = ms.mergeSort();
            long timeEnd = System.currentTimeMillis();
            queue.printQueue();
            System.out.println("Время выполнения сортировки: " + (timeEnd - startTime) + " ms" + " Количество элементов: " + N + " Количество операций: " + nOp);
            System.out.println();
            N+=300;
        }
    }
}

