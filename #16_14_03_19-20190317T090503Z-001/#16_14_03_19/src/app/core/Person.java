package app.core;

public class Person {
    int id;
    String name;
    String lastName;
    String phone;

    public Person(int id, String name, String lastName, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + lastName + "," + phone;
    }

    public static Person fromString(String data){
        String[] arr = data.trim().split(",");
        return new Person(Integer.parseInt(arr[0]),
                arr[1],
                arr[2],
                arr[3]);
    }
}
