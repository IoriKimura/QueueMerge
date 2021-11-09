package mainpart;

public class MergeSort {
    public Queue queue;
    public int size;

    public MergeSort(Queue original){
        this.queue = original;
        this.size = queue.size();
    }

    public Queue mergeSort()
    {
        int step = 1;// Шаг разбиения последовательности. Изначально равен единице.
        int[] temp = new int[size];
        int left = 0;
        while (step < size) { //Пока шаг меньше длины массива
            int index = 0;
            left = 0;
            int midl = left + step;
            int right = left + step * 2;
            while( left < size ) {
                midl = Math.min(midl, size);// сортируемый участок не выходит за границы последовательности
                right = Math.min(right, size);
                int i1 = left;
                int i2 = midl;
                while (i1 < midl && i2 < right) {
                    if (queue.get(i1) < queue.get(i2)) {
                        temp[index++] = queue.get(i1++);
                    } else{
                        temp[index++] = queue.get(i2++);
                    }

                }
                while (i1 < midl){
                    temp[index++] = queue.get(i1++);
                }
                while (i2 < right){
                    temp[index++] = queue.get(i2++);
                }
                left += step * 2;
                midl += step * 2;
                right += step * 2;
            }
            for (int i = 0; i < size; i++) {
                queue.set(i, temp[i]);
            }
            step *= 2;
        }
        return queue;
    }
}
