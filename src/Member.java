import java.io.Serial;
import java.io.Serializable;

public class Member implements Serializable {
    // Serialization ID
    @Serial
    private static final long serialVersionUID = 2L;

    // Attributes
    private String name;
    private int age;
    private int memberId;
    //private transient String password; // This field will not be serialized.

    // Constructor
    public Member(String name, int age, int memberId) {
        this.name = name;
        this.age = age;
        this.memberId = memberId;
    }

    // Getters
    public String getName() {return this.name;}
    public int getAge() {return this.age;}
    public int getMemberId() {return this.memberId;}

}
