package mainpart;

public class MergeSort {
    public Queue queue;
    public int size;

    public MergeSort(Queue original){
        this.queue = original;
        this.size = queue.size();
    }

    //10.25n^4+37.75n^3+66.5n^2+44n + 4 = f(n); O(f(n)) = n^4
    public Queue mergeSort()
    {
        int step = 1; //+1 // Шаг разбиения последовательности. Изначально равен единице.
        int[] temp = new int[size];//+1
        int left = 0;//+1
        Main.nOp+=3;

        //Пока шаг меньше длины массива
       // ∑(step=1 -> n/2)(1 + 1 + 1 + 2 + 3 + 20.5n^3+71.5n^2+113n+62 + 4n^2+20n+18) = ∑(step=1 -> n/2)(88 + 20.5n^3 + 75.5n^2 + 133n) = 20.5n^3(n/2) + 75.5n^2(n/2) + 133n(n/2) + 88(n/2) = 10.25n^4+37.75n^3+66.5n^2+44n;
        while (step < size) { //+1
            int index = 0;//+1
            left = 0;//+1
            Main.nOp+=3;
            int midl = left + step; //+2
            int right = left + step * 2; //+3
            Main.nOp+=5;
            //∑(left=0 -> n)(1+3+3+1+1+6n^2+34n+44+4n^2+17n+10.5n^2+9)=∑(left=0 -> n)(62+51n+20.5n^2)= 20.5n^2(n+1) + 51n(n+1) + 62(n+1) = 20.5n^3+71.5n^2+113n+62;
            while( left < size ) {//+1
                Main.nOp++;
                midl = Math.min(midl, size); //+3 //// сортируемый участок не выходит за границы последовательности
                right = Math.min(right, size);//+3
                int i1 = left;//+1
                int i2 = midl;//+1
                Main.nOp+=8;
                //В худшем случае midl = n/2
                //∑(i=0 -> n/2)(12n+44)= 12n∑(i=1 -> n/2+1)(1) + 44∑(i=1 -> n/2+1)(1) = 12n(n/2+1) + 44(n/2+1) = 6n^2+34n+44;
                while (i1 < midl && i2 < right) { //+3
                    Main.nOp+=3;
                    if (queue.get(i1) < queue.get(i2)) {//8n+25 в худшем случае берётся такой мАССив, что его левая часть всегда больше правой. Следовательно выполняться будет только else
                        temp[index++] = queue.get(i1++);
                    } else{
                        temp[index++] = queue.get(i2++); //4n+16
                    }

                }
                //∑(i1=0 -> n/2)(4n+17) = 4n∑(i1=1 -> n)(1) + 17∑(i1=1 -> n)(1) = 4n^2+17n;
                while (i1 < midl){//+1
                    Main.nOp++;
                    temp[index++] = queue.get(i1++);//4n+16
                }
                //∑(i2=n/2 -> n-1)(4n+17)= 4n∑(i2=n/2 -> n-1)(1) + 17∑(i2=n/2 -> n-1)(1) = 4n(n/2) + 17(n/2) = 2n^2+8.5n^2 = 10.5n^2;
                while (i2 < right){//+1
                    Main.nOp++;
                    temp[index++] = queue.get(i2++);//4n+16
                }
                left += step * 2;//+3
                midl += step * 2;//+3
                right += step * 2;//+3
                Main.nOp+=9;
            }

            for (int i = 0; i < size; i++) {//+2+∑(i=0 -> n)(2+4n+14) = 2+4n(n+1)+16(n+1) = 4n^2+4n+16n+16+2 = 4n^2+20n+18;
                Main.nOp+=2;
                queue.set(i, temp[i]);//4n+14
            }
            step *= 2;//+2
            Main.nOp+=2;
        }
        Main.nOp++;
        return queue; //+1
    }
}
