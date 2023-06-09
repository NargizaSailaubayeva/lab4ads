import java.util.Random;

public class MyTestingClass<K, V> {
    private Random random;
    private K id;
    private V name;

    /**
     * Constructs a new instance of the MyTestingClass with the given id and name.
     *
     * @param id   the id to be set for the object
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
     *
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
     * The output of each method call is printed to the console for testing purposes.
     */
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
        nan.remove(13, "sae", "ase"); //defence task
        System.out.println(nan.getKey("mne")); // Outputs 4
        System.out.println(nan.get(4));// Outputs "mne"
        System.out.println(nan.contains("egnan")); // Outputs true
        System.out.println(nan.remove(18)); // Outputs "egnan"
        System.out.println(nan.get(49)); // Outputs "nan"
        System.out.println(nan.remove(13)); //output "ase" defence task
    }
}
