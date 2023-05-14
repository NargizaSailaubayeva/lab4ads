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