public class DoublyLinkedList<T> implements Iterable {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // internal node class
    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // empty the linked list O(1)
    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
        addLast(elem);
    }

    // adding element to the beginning of the linked list O(1)
    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }

        size++;
    }

    // adding element to the end of the linked list O(1)
    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // peek element of the head of linked list O(1)
    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        return head.data;
    }

    // peek element of the tail of linked list O(1)
    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        return tail.data;
    }

    // remove the head of the linked list O(1)
    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        T data = head.data;
        head = head.next;
        --size;

        if (isEmpty())
            tail = null;

        else
            head.prev = null;

        return data;
    }

    // remove the tail of the linked list O(1)
    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if (isEmpty())
            head = null;

        else
            tail.next = null;

        return data;
    }

    // remove arbitrary node O(1)
    private T remove(Node<T> node) {
        if (node.prev == null)
            return removeFirst();
        if (node.next == null)
            return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;
        node.data = null;
        node = node.prev = node.next = null;
        --size;

        return data;
    }

    // remove at a particular index O(n)
    public T removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();

        int i;
        Node<T> trav;

        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
        } else {
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }

        return remove(trav);
    }

    // remove a particular value in the linked list. O(n)
    public boolean remove(Object o) {
        Node<T> trav = head;

        if (o == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (o.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }

        return false;
    }

    // index of a pariticular value in the linked list. O(n)
    public int indexOf(Object o) {
        int index = 0;
        Node<T> trav = head;

        if (o == null) {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (trav.data == null) {
                    return index;
                }
            }
        } else {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (o.equals(trav.data)) {
                    return index;
                }
            }
        }

        return -1;
    }

    // check is a value contained in the linked list
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;
        while (trav.next != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append(trav.data);
        sb.append("]");
        return sb.toString();
    }

}
