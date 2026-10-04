class MyCircularQueue {

    int[] arr;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (size == arr.length) {
            return false;
        }

        if (size == 0) {
            front = rear = 0;
            arr[rear] = value;
        } else {
            rear = (rear + 1) % arr.length;
            arr[rear] = value;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0)
            return false;

        if (size == 1) {
            front = rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }

        size--;
        return true;
    }

    public int Front() {
        if (size == 0)
            return -1;
        return arr[front];
    }

    public int Rear() {
        if (size == 0)
            return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */