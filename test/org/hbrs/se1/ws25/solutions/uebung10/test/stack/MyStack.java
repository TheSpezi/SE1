package org.hbrs.se1.ws25.solutions.uebung10.test.stack;

import java.util.Stack;

public class MyStack<T> extends Stack<T> {

    private int maxSize;

    public MyStack(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    @Override
    public T push(T object) {
        //If the stack is too big, remove elements until it's the right size.
        if ( this.size() < maxSize) {
            return super.push(object);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isFull(){
        if (this.size() == maxSize) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
