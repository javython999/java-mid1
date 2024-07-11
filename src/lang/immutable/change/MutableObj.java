package lang.immutable.change;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MutableObj {

    private int value;

    public MutableObj(int value) {
        this.value = value;
    }

    public void add(int addValue) {
        value += addValue;
    }
}

