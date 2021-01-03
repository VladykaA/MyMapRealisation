import javax.swing.text.html.parser.Entity;

public class MyHashMap<K, V> {

    private static final int CAPACITY = 16;
    private MyEntry<K, V>[] table;

    public MyHashMap() {
        table = new MyEntry[CAPACITY];
    }

    public void put(K key, V value) {
        int index = index(key);
        MyEntry newEntry = new MyEntry(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            MyEntry<K, V> previousNode = null;
            MyEntry<K, V> currentNode = table[index];
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if (previousNode != null) {
                previousNode.setNext(newEntry);
            }
        }
    }

    public V get(K key) {
        V value = null;
        int index = index(key);
        MyEntry<K, V> newEntry = table[index];
        while (newEntry != null) {
            if (newEntry.getKey().equals(key)) {
                value = newEntry.getValue();
                break;
            }
            newEntry = newEntry.getNext();
        }
        return value;
    }

    public void display() {
        for (int i = 0; i < CAPACITY; i++) {
            if (table[i] != null) {
                MyEntry<K, V> currentNode = table[i];
                while (currentNode != null){
                    System.out.println(String.format("Key is: %s , value is: %s", currentNode.getKey(), currentNode.getValue()));
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    private int index(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % CAPACITY);
    }
}
