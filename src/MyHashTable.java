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

