public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Vasiliev", "+79990000000");
        phoneBook.add("Vasiliev", "+79990000001");
        phoneBook.add("Vasiliev", "+79990000002");
        phoneBook.add("Petrov", "+78880000000");
        phoneBook.add("Petrov", "+78880000001");
        phoneBook.add("Sidorov", "+71111111111");

        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("Sidorov"));
        System.out.println(phoneBook.get("Vasiliev"));

    }

}
