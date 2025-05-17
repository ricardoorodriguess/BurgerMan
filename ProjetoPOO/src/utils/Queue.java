package utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Queue<T> {
    class Node {
        T item;
        Node next;

        Node(T item) {
            this.item = item;
            next = null;
        }
    }

    @Nullable Node first, last;
    int size;

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(@NotNull T item) {
        if (first == null || last == null) {
            first = new Node(item);
            last = first;
            size = 1;
            return;
        }
        last.next = new Node(item);
        last = last.next;
        size++;
    }

    public @Nullable T dequeue() {
        if (first == null) return null;
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }
}