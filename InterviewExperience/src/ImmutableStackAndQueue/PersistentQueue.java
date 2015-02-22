package ImmutableStackAndQueue;

import java.util.NoSuchElementException;

/**
 * WEB EXAMPLE for my ImmutableQueue
 *  https://github.com/yingzhox/worksapplication2013recruite/blob/master/Exam/src/jp/co/wap/exam/PersistentQueue.java
 *  
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects. The key to implement such an immutable queue is maintaining two
 * reversed stack A and B, A is used to enqueue element and B is used to dequeue
 * element. When B is empty, simply reverse stack A and "clear" the elements in
 * A. Notice that A and B are immutable stacks. The performance test shows that
 * this implementation can be hundreds times faster than the sample code.
 * Enqueue and Dequeue 1 million random object only take about 100 milliseconds
 * in total.
 * 
 * @author Felix
 * @param <E>
 */
public class PersistentQueue<E> {
        /**
         * This is the internal immutable stack.
         * 
         * @author Felix
         * @param <E>
         */
        private static class PersistentStack<E> {
                private E head;
                private PersistentStack<E> tail;
                private int size;

                private PersistentStack(E obj, PersistentStack<E> tail) {
                        this.head = obj;
                        this.tail = tail;
                        this.size = tail.size + 1;
                }

                public static PersistentStack emptyStack() {
                        return new PersistentStack();
                }

                private PersistentStack() {
                        this.head = null;
                        this.tail = null;
                        this.size = 0;
                }

                /**
                 * Get a new reversed stack.
                 * 
                 * @return
                 */
                public PersistentStack<E> toReverseStack() {
                        PersistentStack<E> stack = new PersistentStack<E>();
                        PersistentStack<E> tail = this;
                        while (!tail.isEmpty()) {
                                stack = stack.push(tail.head);
                                tail = tail.tail;
                        }
                        return stack;
                }

                public boolean isEmpty() {
                        return this.size == 0;
                }

                public PersistentStack<E> push(E obj) {
                        return new PersistentStack<E>(obj, this);
                }
        }

        private PersistentStack<E> order;
        /**
         * The reverse stack of order
         */
        private PersistentStack<E> reverse;

        
        private PersistentQueue(PersistentStack<E> order, PersistentStack<E> reverse) {
                this.order = order;
                this.reverse = reverse;
        }
        
        /**
         * requires default constructor.
         */
        public PersistentQueue() {
                this.order = PersistentStack.emptyStack();
                this.reverse = PersistentStack.emptyStack();
        }

        /**
         * Returns the queue that adds an item into the tail of this queue without
         * modifying this queue.
         * 
         * <pre>
         * e.g.
         *  When this queue represents the queue (2,1,2,2,6) and we enqueue the value 4 into this queue,
         *  this method returns a new queue (2,1,2,2,6,4)
         *  and this object still represents the queue (2,1,2,2,6)
         * </pre>
         * 
         * @param e
         * @return
         */
        public PersistentQueue<E> enqueue(E e) {
                if (null == e)
                        throw new IllegalArgumentException();
                return new PersistentQueue<E>(this.order.push(e), this.reverse);
        }

        /**
         * Returns the queue that removes the object at the head of this queue
         * without modifying this queue.
         * 
         * <pre>
         * e.g.
         *  When this queue represents the queue (7,1,3,3,5,1) .
         *  this method returns a new queue (1,3,3,5,1)
         *  and this object still represents the queue (7,1,3,3,5,1)
         * </pre>
         * 
         * If this queue is empty, throws java.util.NoSuchElementException.
         * 
         * @param e
         * @return
         */
        public PersistentQueue<E> dequeue() {
                if (this.isEmpty())
                        throw new NoSuchElementException();
                if (!this.reverse.isEmpty()) {
                        return new PersistentQueue<E>(this.order, this.reverse.tail);
                } else {
                        // revers the ordered stack then "clean" that stack
                        return new PersistentQueue<E>(PersistentStack.emptyStack(),
                                        this.order.toReverseStack().tail);
                }
        }

        /**
         * This method simply reverse the order stack and assign it to reverse
         * stack, the internal queue is not modified, it is necessary since all new
         * objects are enqueued to order stack, while peek() looking at the reverse
         * stack, we do not want to reverse the order stack again and again while
         * looking for the head of reverse when it is empty.
         */
        private void balanceQueue() {
                this.reverse = this.order.toReverseStack();
                this.order = PersistentStack.emptyStack();
        }

        /**
         * Looks at the object which is the head of this queue without removing it
         * from the queue.
         * 
         * <pre>
         * e.g.
         *  When this queue represents the queue (7,1,3,3,5,1) .
         *  this method returns 7 and this object still represents the queue (7,1,3,3,5,1)
         * </pre>
         * 
         * If this queue is empty, throws java.util.NoSuchElementException.
         * 
         * @param e
         * @return
         */
        public E peek() {
                if (this.isEmpty())
                        throw new NoSuchElementException();
                if (this.reverse.isEmpty())
                        balanceQueue();
                return this.reverse.head;
        }

        public boolean isEmpty() {
                return size() == 0;
        }

        /**
         * Returns the number of objects in this queue.
         * 
         * @return
         */
        public int size() {
                return this.order.size + this.reverse.size;
        }
}