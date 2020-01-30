import java.io.Serializable;

/**
 * @author Matteo Galiazzo
 */
public class Person implements Serializable {
    
    private String name;
    private String surname;
    private Gender gender;
    private int age;
    
    public Person(String name, String surname, Gender gender, int age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person\n{" + "name=" + name + ",\n surname=" + surname + ",\n gender=" + gender + ",\n age=" + age + "\n}";
    }
    
}
