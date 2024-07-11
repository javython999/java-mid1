package lang.immutable.address;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberV1 {

    public String name;
    private Address address;

    public MemberV1(String name, Address address) {
        this.name = name;
        this.address = address;
    }


}
