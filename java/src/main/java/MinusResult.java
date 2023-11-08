import java.util.EnumSet;

public enum MinusResult {

    ONE(1, "Advantage %s"),
    TWO(2, "Win for %s"),
    MINUS_ONE(-1, "Advantage %s"),
    DEFAULT(99, "Win for %s"),

    ;

    private static final int MINIMUM_WIN_FOR_PLAYER1_NUMBER = 2;

    private final int key;
    private final String value;

    MinusResult(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static MinusResult findByKey(int key) {
        if (key >= MINIMUM_WIN_FOR_PLAYER1_NUMBER) return TWO;
        return EnumSet.allOf(MinusResult.class).stream()
                .filter(minusResult -> minusResult.getKey() == key)
                .findAny()
                .orElse(DEFAULT);
    }

    public static String getMinusResultValue(int score, String player1Name, String player2Name) {
        MinusResult minusResult = MinusResult.findByKey(score);
        if (minusResult == MINUS_ONE || minusResult == DEFAULT) {
            return String.format(minusResult.getValue(), player2Name);
        }
        return String.format(minusResult.getValue(), player1Name);
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
