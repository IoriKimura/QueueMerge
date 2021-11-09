package mainpart;

import java.util.ArrayList;

public class Queue {
    public ArrayList<Integer> queue;

    public Queue(){
        queue = new ArrayList<Integer>();
    }

    //Что это? Добавление числа в очередь
    public void push(int item){
        queue.add(item);
    }

    //Попсня. Берём первое число в очереди, возвращаем его и удаляем из очереди.
    public int pop(){
        int first = queue.get(0);
        queue.remove(0);
        return first;
    }

    public int showFirst(){
        return queue.get(0);
    }

    public int get(int position){

        for (int i = 0; i < position; i++){
            push(pop());
        }

        int first = showFirst();
        for (int i = position; i < queue.size(); i++){
            push(pop());
        }
        return first;
    }

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
