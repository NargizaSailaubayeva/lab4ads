# Laboratory 4 Algorithms and Data Structures
![hello](https://media.tenor.com/Rme4nOJ8P7IAAAAM/%E1%83%94%E1%83%98%E1%83%A4%E1%83%9D%E1%83%A0%E1%83%98%E1%83%90-%E1%83%AE%E1%83%90%E1%83%97%E1%83%A3%E1%83%9C%E1%83%90.gif)
## Description
In this repository, I made laboratory 4 for Algorithms and Data Structures by creating classes MyHashTable and MyTestingClass.

+ ***Hashing*** means using some function or algorithm to map object data to some representative integer value 
+ ***Hash table*** maps keys to values. Any non-null object can be used as a key or as a value 

![ht](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Hash_table_3_1_1_0_1_0_0_SP.svg/1200px-Hash_table_3_1_1_0_1_0_0_SP.svg.png)
 
 **The `MyHashTable` class** provides the following methods:
+ put(K key, V value): Inserts a new key-value pair into the Hash Table.
+ get(K key): Returns the value associated with the given key. Returns null if the key is not present in the Hash Table.
+ contains(V value): Returns a boolean indicating whether the given value is present in the Hash Table.
+ getKey(V value): Returns the key associated with the given value. Returns null if the value is not present in the Hash Table.
+ remove(K key): Removes the key-value pair associated with the given key from the Hash Table and returns the value. Returns null if the key is not present in the Hash Table.
+ counter(): Prints the number of collisions that have occurred during the Hash Table operations.

**The `MyTestingClass` class** provides two methods for testing the MyHashTable class. 
+ The test() method generates 10,000 random key-value pairs and inserts them into a new Hash Table. 
+ The tester() method tests the functionality of the Hash Table by inserting some key-value pairs, retrieving, and removing them.
___
class `MyHashTable`
```java
/**
 * This is a Java class definition for a generic Hash Table data structure.
 * The class includes methods for adding, getting, removing, checking if a value exists, getting the key for a value, and counting the number of elements in each bucket.
 * @param <K> the type of keys in the hash table
 * @param <V> the type of values in the hash table
 */
public class MyHashTable<K, V> {
    /**
     * The class has a private inner class HashNode that represents a node in the hash table.
     * Each node has a key and a value, and a reference to the next node in the chain if there is a collision.
     */
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        /**
         * Constructor for HashNode.
         * @param key the key for the node
         * @param value the value for the node
         */
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    private int size;
    private int capacity;
    private HashNode<K,V>[] chainArray;
    //Constructor for MyHashTable with default capacity of 11.
    public MyHashTable() {
        size = 0;
        capacity = 11;
        chainArray = new HashNode[capacity];
    }
    //Constructor for MyHashTable with specified capacity.
    public MyHashTable(int M) {
        capacity = M;
        size = 0;
        chainArray = new HashNode[capacity];
    }

    /**
     * Private hash function that takes the hash code of the key and uses the modulus operator to map it to a bucket in the array.
     * @param key the key to hash
     * @return the index of the bucket in the array
     */
    private int hash(K key) {
        return key.hashCode();
    }

    /**
     * The put method is used to add a key-value pair to the hash table. If the key already exists, the value is updated.
     * @param key the key to add or put
     * @param value te value to add or put
     */
    public void put(K key, V value) {
        int index = hash(key) % capacity;
        HashNode node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode newNode = new HashNode(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    /**
     * The get method is used to get the value associated with a given key.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    public V get(K key){
        int index = hash(key);
        HashNode node = chainArray[index];
        while(node!=null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            else{
                node= node.next;
            }
        }
        return null;
    }

    /**
     * The contains method is used to check if a value exists in the hash table.
     * @param value the value to be searched in the hashtable
     * @return true if this hashtable contains a mapping for the specified value, false otherwise
     */
    public boolean contains(V value){
        for(int i = 0; i<capacity; i++){
            HashNode node = chainArray[i];
            while(node!=null){
                if(node.value.equals(value)){
                    return true;
                }
                node= node.next;
            }
        }
        return false;
    }

    /**
     * The getKey method is used to get the key associated with a given value.
     * @param value the value to be searched in the hashtable
     * @return the first key that maps to the specified value, or null if no such mapping exists
     */
    public K getKey(V value){
        for(int i=0;i<capacity;i++){
            HashNode node= chainArray[i];
            while(node!=null){
                if(node.value.equals(value)){
                    return (K) node.key;
                }
                node= node.next;
            }
        }
        return null;
    }

    /**
     * The remove method is used to remove a key-value pair from the hash table.
     * @param key the key whose mapping is to be removed from the hashtable
     * @return the value to which the key had been mapped in this hashtable, or null if the key did not have a mapping
     */
    public V remove(K key){
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        V n= null;
        if(node!=null && node.key.equals(key)){
            n = node.value;
            chainArray[index]= node.next;
            size--;
        }
        else{
            while(node!=null && node.next != null){
                if (node.next.key.equals(key)){
                    n= node.next.value;
                    node.next= node.next.next;
                    size--;
                    break;
                }
                node= node.next;
            }
        }
        return n;
    }

    /**
     * The counter method is used to count the number of elements in each bucket of the hash table
     */
    public void counter() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            HashNode node = chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println(i + " bucket " + count + " elements");
            count = 0;
        }
    }
}
```
___
class `MyTestingClass`
```java
import java.util.Random;

public class MyTestingClass<K, V> {
    private Random random;
    private K id;
    private V name;
    /**
     * Constructs a new instance of the MyTestingClass with the given id and name.
     * @param id the id to be set for the object
     * @param name the name to be set for the object
     */
    public MyTestingClass(K id, V name) {
        this.id = id;
        this.name = name;
        this.random = new Random();
    }
    /**
     * This method overrides the default hashCode() method of the Object class.
     * It generates a unique hashcode for each MyTestingClass instance based on its id and name fields.
     * If id or name are null, their hashcode is set to 0.
     * @return an integer hashcode value for the MyTestingClass instance.
     */
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    /**
     * Generates 10000 random integer values for keys and string values for names, creates new MyTestingClass objects with the generated key-value pairs,
     * puts the key-value pairs into a new MyHashTable instance and calls the counter method to count the frequency of keys in the hash table.
     */
    public void test() {
        MyHashTable<K, V> n = new MyHashTable<>();
        for (int i = 0; i < 10000; i++) {
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(x, y + "Student");
            n.put((K) key.id, (V) key.name);
        }
        n.counter();
    }
    /**
     * This method tests various methods of the MyHashTable class by creating a new instance,
     * inserting some key-value pairs, and then calling the getKey, get, contains, and remove methods on the hashtable.
     * The output of each method call is printed to the console for testing purposes.*/
    public void tester() {
        MyHashTable nan = new MyHashTable();
        //Add some key-value pairs to the hash table
        nan.put(12, "mes");
        nan.put(1, "kgn");
        nan.put(25, "sne");
        nan.put(13, "sae");
        nan.put(4, "mne");
        nan.put(49, "nan");
        nan.put(18, "egnan");
        System.out.println(nan.getKey("mne")); // Outputs 4
        System.out.println(nan.get(4));// Outputs "mne"
        System.out.println(nan.contains("egnan")); // Outputs true
        System.out.println(nan.remove(18)); // Outputs "egnan"
        System.out.println(nan.get(49)); // Outputs "nan"
    }
}

```
___
`Main`
```java
public class Main {
    //check each classes
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyHashTable nan=new MyHashTable();
        MyTestingClass ads=new MyTestingClass(null,null);
        nan.put(45,"as");
        System.out.println(nan.get(45));
        ads.test();
        ads.tester();
    }
}
```
___

## Installation
IntelliJ IDEA 2022.3.1
## Contributing
***Bug reports and\or pull requests are*** 

![gif](https://cdn.dribbble.com/users/1117770/screenshots/2626626/welcome.gif)

![welcome](https://media.tenor.com/4F0S8rm_t98AAAAC/thank-you-sticker-thanks-sticker.gif)

![bye](https://media.tenor.com/Arsu0w_nD2EAAAAM/bob-anakshie.gif)
