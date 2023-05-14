import java.util.Random;
public class MyTestingClass<K,V> {
    private Random random;
    private K id;
    private V name;

    public MyTestingClass(K id, V name) {
        this.id = id;
        this.name = name;
        this.random = new Random();
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

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
    public void tester() {
        MyHashTable nan = new MyHashTable();
        nan.put(12, "mes");
        nan.put(1, "kgn");
        nan.put(25, "sne");
        nan.put(13, "sae");
        nan.put(4, "mne");
        nan.put(49, "nan");
        nan.put(18, "egnan");
        System.out.println(nan.getKey("mne"));
        System.out.println(nan.get(4));
        System.out.println(nan.contains("egnan"));
        System.out.println(nan.remove(18));
        System.out.println(nan.get(49));
    }
}
