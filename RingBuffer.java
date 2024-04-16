public class RingBuffer {
    private double[] rb;    // items in the buffer
    private int first;     // index for the next dequeue or peek
    private int last;    // index for the next enqueue
    private int size;     // number of items in the buffer

    // Creates an empty ring buffer with the specified capacity.
    public RingBuffer(int capacity) {
        rb = new double[capacity];
        first = 0;
        last = 0;
        size = 0;
    }

    // Returns the capacity of this ring buffer.
    public int capacity() {
        return rb.length;
    }

    // Returns the number of items currently in this ring buffer.
    public int size() {
        return size;
    }

    // Is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        return size == 0;
    }

    // Is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        return size == capacity();
    }

    // Adds item x to the end of this ring buffer.
    public void enqueue(double x) {
        if (isFull())
            throw new IllegalStateException("Ring buffer is full.");

        // Store at the last index of the array.
        rb[last] = x;
        last++;
        size++;

        // Wrap around the index.
        if (last == capacity()) last = 0;
    }

    // Deletes and returns the item at the front of this ring buffer.
    public double dequeue() {
        if (size == 0)
            throw new IllegalStateException("Ring buffer is empty.");

        // Store and return the first item of the array
        // and increment instance variables.
        double firstItem = rb[first];
        first++;
        size--;

        // Wrap around the index.
        if (first == capacity()) first = 0;

        return firstItem;
    }

    // Returns the item at the front of this ring buffer.
    public double peek() {
        if (size == 0)
            throw new IllegalStateException("Ring buffer is empty.");

        return rb[first];
    }

    // Tests this class by directly calling all instance methods.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(n);

        StdOut.printf("Test #1 - check capacity - should be %d\n", n);
        StdOut.printf("**** Capacity is %d\n", buffer.capacity());

        StdOut.printf("Test #2 - check size - should be %d\n", 0);
        StdOut.printf("**** Size is %d\n", buffer.size());

        for (int i = 1; i <= n; i++) {
            buffer.enqueue(i);
            StdOut.printf("Test #3.%d - check size after %d enqueues- should be %d\n",
                          i, i, i);
            StdOut.printf("**** Size is %d\n", buffer.size());
        }

        double val1 = buffer.peek();
        StdOut.printf("Test #4 - check peek value == %.1f\n", 1.0);
        StdOut.printf("**** Value is %.1f\n", val1);

        double val2 = buffer.dequeue();
        StdOut.printf("Test #5 - dequeue a value, then check value == %.1f and "
                              + "size == %d after a dequeue\n", 1.0, n - 1);
        StdOut.printf("**** Value is %.1f\n", val2);
        StdOut.printf("**** Size is %d\n", buffer.size());

        buffer.enqueue(val2);
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        StdOut.printf("Test #6 - enqueues + dequeues, then check size == %d and"
                              + " peek == %.1f\n",
                      1, (double) (n + 1) * n / 2);
        StdOut.printf("**** Size is %d\n", buffer.size());
        StdOut.printf("**** Peek value is %.1f\n", buffer.peek());

        StdOut.printf("Test #7 - check if array is empty of full == %.1f\n");
        StdOut.printf("**** Is this ring buffer empty? %.1f\n", buffer.isEmpty());
        StdOut.printf("**** Is this ring buffer full? %.1f\n", buffer.isFull());
    }
}
