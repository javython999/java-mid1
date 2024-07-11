package lang.immutable.address;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberV2 {

    public String name;
    private ImmutableAddress address;

    public MemberV2(String name, ImmutableAddress address) {
        this.name = name;
        this.address = address;
    }


}
