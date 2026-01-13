package org.hbrs.se1.ws25.exercises.uebung10.stackAufagbe;

import java.util.Stack;

public class EigenerStack<E> extends Stack<E> {

    private int capacity;

    public EigenerStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public E push(E item) {
        if(this.size() >= this.capacity) {
            throw new RuntimeException("Stack ist voll!");
        }

        return super.push(item);

    }



}
