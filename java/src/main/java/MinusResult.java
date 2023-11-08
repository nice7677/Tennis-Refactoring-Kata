import java.util.EnumSet;

public enum MinusResult {

    ONE(1, "Advantage player1"),
    TWO(2, "Win for player1"),
    MINUS_ONE(-1, "Advantage player2"),
    DEFAULT(99, "Win for player2"),

            ;

    private final int key;
    private final String value;

    MinusResult(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static MinusResult findByKey(int key) {
        return EnumSet.allOf(MinusResult.class).stream()
                .filter(minusResult -> minusResult.getKey() == key)
                .findAny()
                .orElse(DEFAULT);
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
