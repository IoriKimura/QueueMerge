package mainpart;

import java.util.ArrayList;

public class Queue {
    public ArrayList<Integer> queue;

    public Queue(){
        queue = new ArrayList<Integer>();
    }

    //Метод добавления числа в очередь. Добавляем в её конец.
    //1 + 1 = 2 --- O(2)=O(1)=1
    public void push(int item){ //+1, Так как метод принимает в себя значение)
        queue.add(item); //+1, так как передаётся для добавления (item).
        Main.nOp +=2;
    }

    //Извлечение числа из начала очереди, удаление его с первого индекса.
    //+2+1+1=4 O(1)=1
    public int pop(){
        int first = queue.get(0);//+2
        queue.remove(0);//+1
        Main.nOp+=4;
        return first; //+1
    }

    //Возвращаем первый элемент очереди в данный момент.
    //O(1)=1
    public int nowFirst(){
        Main.nOp+=2;
        return queue.get(0);//+2
    }

    //Так как мы рассматриваем худший случай для очереди, то позиция равняется последнему элементу n-1. //pos = n-1

    //Получение элемента очереди по позиции.
    //+1+4n+2+2+6+1=4n+12=f(n) -- O(f(n))=n
    public int get(int position){//+1
        Main.nOp++;
        for (int i = 0; i < position; i++){ //+2+∑(i=0 -> n-1)(+2+2)=+2+4*∑(i=1 -> n)(1)=+2+4*(n)=4n+2
            push(pop());//+2
            Main.nOp+=2;
        }

        int first = nowFirst();//+2
        Main.nOp+=2;
        //В худшем случае выполниться один раз цикл.
        for (int i = position; i < queue.size(); i++){//+2+∑(i=n-1 -> n)(+4)=2+4*∑(i=n-1 -> n)(1)=6
            push(pop());//+2
            Main.nOp+=2;
        }
        Main.nOp++;
        return first; //+1
    }

    //Заносим новый элемент на определённую позицию.
    //+2+4n+2+2+6+1=4n+13=f(n) -- O(f(n))=n
    public void set(int position, int value){
        Main.nOp+=2;
        for (int i = 0; i < position; i++){
            push(pop());
            Main.nOp+=2;
        }

        queue.set(0,value);
        for (int i = position; i < queue.size(); i++) {
            push(pop());
            Main.nOp+=2;
        }
    }

    //Метод, который использовался для отладки программы.
    public void printQueue(){
        for (int it: queue) {
            System.out.print(it+ " ");;
        }
        System.out.println();
    }

    public int size(){
        return queue.size();
    }
}
