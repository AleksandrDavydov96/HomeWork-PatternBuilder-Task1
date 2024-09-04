import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected OptionalInt optionalIntAge = OptionalInt.of(age);
    protected String adress;

    public PersonBuilder setName(String name) {
        if (name == null) {
            throw new IllegalStateException("Не указано имя!");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null) {
            throw new IllegalStateException("Не указана фамилия!");
        }
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть положительным!");
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        if (address == null) {
            throw new IllegalStateException("Не указан адрес!");
        }
        this.adress = address;
        return this;
    }
    public Person build() {
        if (name == null && surname == null && adress == null) {
            throw new IllegalStateException("Не хватает обязательных полей!");
        }
        return new Person(name, surname, age, adress);
    }
}
