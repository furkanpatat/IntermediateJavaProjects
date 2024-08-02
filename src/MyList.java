class MyList<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyList() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }


    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Kapasite 0'dan büyük olmalıdır.");
        }
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }


    public void add(T data) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = data;
    }


    @SuppressWarnings("unchecked")
    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }


    public int size() {
        return size;
    }


    public int getCapacity() {
        return array.length;
    }


    public T getIndex(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Geçersiz indeks");
        }
    }

    public int lastIndexOf(T data) {
        int eleman = 0;
        for (T i : array) {

            if (i.equals(data)) {
                System.out.println(i + " indexi ->" + eleman);
                return eleman;
            }
            eleman++;
        }
        return -1;

    }

    public boolean isEmpty() {
        for (T i : array) {
            if (i != null) {
                System.out.println("Liste'de eleman vardır.");
                return false;
            }

        }
        return true;
    }

    public void clear() {
        for (T i : array) {
            if (i != null) {
                i = null;
            }
        }
        size = 0;
    }

    public boolean contains(T data) {
        for (T i : array) {
            if (i.equals(data)) {
                return true;
            }

        }
        return false;
    }

    public MyList<T> sublist(int start, int finish) {
        MyList<T> sublist = new MyList<>(finish - start);

        for (int i = start; i < finish; i++) {
            sublist.add(array[i]);

        }
        return sublist;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        T removedElement = array[index];


        System.arraycopy(array, index + 1, array, index, size - index - 1);


        array[--size] = null;

        return removedElement;

    }
    public T setIndex(int index,T data){
        if (index < 0 || index >= size) {
            return null;
        }
        array[index] = data;
        return array[index];
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        String result = "[";
        for (int i = 0; i < size; i++) {
                result += array[i];
                if (i < size - 1) {
                    result += ", ";
                }
            }
            result += "]";
            return result;
        }
    }
