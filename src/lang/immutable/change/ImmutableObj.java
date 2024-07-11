package lang.immutable.change;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ImmutableObj {

    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public ImmutableObj add(int addValue) {
        return new ImmutableObj(value + addValue);
    }

}
