package lang.immutable.address;

import lombok.Getter;

@Getter
public class ImmutableAddress {

    private final String value;

    public ImmutableAddress(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "value='" + value + '\'' +
                '}';
    }
}
