package other;

public class BuilderPattern {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setId(1)
                .setPhone(8067)
                .setAdditionalPhone(100)
                .setOfficeNumber(200)
                .setLuckyNumber(400)
                .build();

        System.out.println("id : " + person.getId() + " " + "phone : "
                + person.getPhone() + " " + "someNumbers from 1 to 3: "
                + person.getAdditionalPhone() + " " + person.getOfficeNumber() + " "
                + person.getLuckyNumber());
        System.out.println();
    }
}
