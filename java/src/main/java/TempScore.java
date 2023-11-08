import java.util.EnumSet;

public enum TempScore {

    ZERO(0, "Love"),
    ONE(1, "Fifteen"),
    TWO(2, "Thirty"),
    THREE(3, "Forty"),

    ;

    private final int key;
    private final String value;

    TempScore(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static TempScore findByKey(int key) {
        return EnumSet.allOf(TempScore.class).stream()
                .filter(score -> score.getKey() == key)
                .findAny()
                .get();
    }

    public static String getTempScoreValue(int score) {
        return TempScore.findByKey(score).getValue();
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
