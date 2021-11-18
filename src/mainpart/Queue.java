package mainpart;

import java.util.ArrayList;

public class Queue {
    public ArrayList<Integer> queue;


    public Queue(){
        queue = new ArrayList<Integer>();
    }

    //Что это? Добавление числа в очередь
    //Метода push: 1 + 1 = 2 --- O(2)=O(1)=1
    public void push(int item){ //+1 (Так как метод принимает в себя значение.) Можно посчитать потом, когда отдаю сам элемент в сортировке
        queue.add(item); //+1, так как передаётся для добавления (item))
    }

    //Попсня. Берём первое число в очереди, возвращаем его и удаляем из очереди.
    //+2+1+1=4 O(1)=1
    public int pop(){
        int first = queue.get(0);//+2
        queue.remove(0);//+1
        return first; //+1
    }
    //O(1)=1
    public int showFirst(){
        return queue.get(0);//+2
    }

    //Так как мы рассматриваем худший случай для очереди, то позиция равняется последнему элементу n-1. //pos = n-1

    //+1+4n+2+2+6+1=4n+12=f(n) -- O(f(n))=n
    public int get(int position){//+1

        for (int i = 0; i < position; i++){ //+2+∑(i=0 -> n-1)(+2+2)=+2+4*∑(i=1 -> n)(1)=+2+4*(n)=4n+2
            push(pop());//+2
        }

        int first = showFirst();//+2
        //В худшем случае выполниться один раз цикл
        for (int i = position; i < queue.size(); i++){//+2+∑(i=n-1 -> n)(+4)=2+4*∑(i=n-1 -> n)(1)=6
            push(pop());//+2
        }
        return first; //+1
    }

    //+2+4n+2+2+6+1=4n+13=f(n) -- O(f(n))=n
    public void set(int position, int value){

        for (int i = 0; i < position; i++){
            push(pop());
        }

        queue.set(0,value);
        for (int i = position; i < queue.size(); i++) {
            push(pop());
        }
    }

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
