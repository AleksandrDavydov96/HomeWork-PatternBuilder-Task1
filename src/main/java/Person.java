import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected OptionalInt optionalIntAge = OptionalInt.of(age);
    protected String adress;

    public Person(String name, String surname, int age, String adress) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adress = adress;
    }

    public boolean hasAge() {
        return optionalIntAge.isEmpty();
    }

    public boolean hasAddress() {
        return adress != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (optionalIntAge.isPresent()) {
            return optionalIntAge;
        }
        return null;
    }

    public String getAdress() {
        return adress;
    }

    public void setAddress(String address) {
        this.adress = address;
    }

    public void happyBirthday() {
        if (optionalIntAge.isPresent()) {
            age ++;
        }
    }

    public PersonBuilder newChildBuilder() {
       return new PersonBuilder().setSurname(surname).setAddress(adress);
    }

    @Override
    public String toString() {
        return "имя - " + name
                + "; фамилия - " + surname
                + "; возраст - " + age
                + "; город - " + adress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, adress);
    }
}
