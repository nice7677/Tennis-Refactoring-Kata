public class TennisGame1 implements TennisGame {

    private static final int START_GAME_ROUNDS = 1;
    private static final int END_GAME_ROUNDS = 3;
    private final String player1Name;
    private final String player2Name;
    private int mScore1 = 0;
    private int mScore2 = 0;

    public TennisGame1(final String player1Name, final String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            mScore1 += 1;
            return;
        }
        mScore2 += 1;
    }

    public String getScore() {

        if (mScore1 == mScore2) {
            return Score.getScoreValue(mScore1);
        }

        if (mScore1 >= 4 || mScore2 >= 4) {
            return MinusResult.getMinusResultValue(mScore1 - mScore2, player1Name, player2Name);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = START_GAME_ROUNDS; i < END_GAME_ROUNDS; i++) {
            sb.append(TempScore.getTempScoreValue(getTempScore(i, sb)));
        }

        return sb.toString();

    }

    private int getTempScore(int round, StringBuilder sb) {
        if (round == START_GAME_ROUNDS) {
            return mScore1;
        }
        addDashBar(round, sb);
        return mScore2;
    }

    private void addDashBar(int round, StringBuilder sb) {
        if (round != 1) {
            sb.append("-");
        }
    }



}
