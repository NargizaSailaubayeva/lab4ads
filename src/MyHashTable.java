public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    private int size;
    private int capacity;
    private HashNode<K,V>[] chainArray;
    public MyHashTable() {
        size = 0;
        capacity = 11;
        chainArray = new HashNode[capacity];
    }
    public MyHashTable(int M) {
        capacity = M;
        size = 0;
        chainArray = new HashNode[capacity];
    }
    private int hash(K key) {
        return key.hashCode();
    }

}

