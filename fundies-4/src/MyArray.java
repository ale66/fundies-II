// Define an array class in Java
public class MyArray {
    private int[] arrayData; // Internal array to store elements
    private int size; // Number of actual elements in the array

    // Constructor to initialize the internal array
    // capacity is the maximun allowed number of elements
    public MyArray(int capacity) {
        arrayData = new int[capacity];
        size = 0;
    }

    // Add an element to the array
    public void add(int element) {
        // Check if the array needs resizing
        if (size == arrayData.length) {
            resize(arrayData.length * 2); // Double the size
        }
        arrayData[size] = element; // Add the element
        size++; // Increase the size counter
    }

    // Get an element at a specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return arrayData[index];
    }

    // Remove an element at a specific index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < size - 1; i++) {
            arrayData[i] = arrayData[i + 1]; // Shift elements to the left
        }
        size--; // Decrease the size counter
    }

    // Resize the internal array
    private void resize(int newCapacity) {
        int[] newArrayData = new int[newCapacity];
        System.arraycopy(arrayData, 0, newArrayData, 0, size);
        arrayData = newArrayData;
    }

    // Get the current number of elements
    public int size() {
        return size;
    }

    // Check if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print elements present in the array
    private void printElements() {
        for (int i = 0; i < size; i++) {
            System.out.print(arrayData[i] + " ");
        }
        System.out.println();
    }

    // Method to sort the array
    public void sort() {
        // Simple implementation of the Bubble Sort algorithm
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arrayData[j] > arrayData[j + 1]) {
                    // Swap arrayData[j] and arrayData[j+1]
                    int temp = arrayData[j];
                    arrayData[j] = arrayData[j + 1];
                    arrayData[j + 1] = temp;
                }
            }
        }
    }

    // Method to add a random number to the array
    private  void addRandomNumber() {
        java.util.Random random = new java.util.Random(); // Create a Random object for generating random numbers
        int randomNumber = random.nextInt(); // Generate a random number

        // Check if the array needs resizing
        if (size == arrayData.length) {
            resize(arrayData.length * 2); // Double the size if necessary
        }

        arrayData[size] = randomNumber; // Add the random number to the array
        size++; // Increase the size counter
    }

    public static void main(String[] args) {
        int size = 20;
        // array
        MyArray arr = new MyArray(20);
        for (int i = 0; i<20; i++ )    
            arr.addRandomNumber();

        arr.printElements();
        // sorting        
        arr.sort();
        System.out.println("\nSorted..");
        arr.printElements();
    }
    

}
