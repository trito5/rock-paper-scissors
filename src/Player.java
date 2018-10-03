public class Player {
    private int score = 0;
    private int wins = 0;

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score = this.score + 1;
    }

    public int getwins() { return wins; }

    public void setWins() { this.wins = this.wins + 1;}

    public void resetScore() { this.score = 0; }
}
