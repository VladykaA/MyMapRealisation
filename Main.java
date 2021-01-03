public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(null, "nothing");
        map.put(1, "Jack");
        map.put(2, "Mick");
        map.display();
        //map.put(null, "something");
        map.put(1, "Sam");
        map.put(2, "Mick again");
        map.display();
    }
}
