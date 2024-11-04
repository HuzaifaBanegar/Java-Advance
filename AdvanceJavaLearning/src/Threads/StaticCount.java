package Threads;

public class StaticCount {
    public static int count = 0;

    private String name;

    public StaticCount(String name) {
        this.name = name;
        count++;
    }

    // Static count is related to the class and not the instace of it.
    // When an object is instatiated, the count is getting incremented.
    // We can call it as st1.count, but it doesn't matter
    // as it is class level and not object level
    public static void main(String[] args) {
        StaticCount st = new StaticCount("test");
        StaticCount st1 = new StaticCount("test1");
        System.out.println(StaticCount.count);

    }

}
