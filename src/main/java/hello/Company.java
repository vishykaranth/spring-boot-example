package hello;

public class Company {
    private final int id;
    private final String name;
    private final int age;
    private final String address;
    private final float salary;

    public Company(int id, String name, int age, String address, float salary) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address.trim();
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public float getSalary() {
        return salary;
    }
}
