import java.util.EnumSet;

public enum Score {

    ZERO(0, "Love-All"),
    ONE(1, "Fifteen-All"),
    TWO(2, "Thirty-All"),
    DEFAULT(99, "Deuce"),

    ;

    private final int key;
    private final String value;

    Score(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Score findByKey(int key) {
        return EnumSet.allOf(Score.class).stream()
                .filter(score -> score.getKey() == key)
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
