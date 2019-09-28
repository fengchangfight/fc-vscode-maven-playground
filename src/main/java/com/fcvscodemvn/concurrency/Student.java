import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String code;

    public Student(String code) {
        this.code = code;
    }
}
