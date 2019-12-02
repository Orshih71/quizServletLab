public class Quiz {
    private String[] quistions = {
            "3, 1, 4, 1, 5",
            "1, 1, 2, 3, 5",
            "1, 4, 9, 16, 25",
            "2, 3, 5, 7, 11",
            "1, 2, 4, 8, 16"
    };
    private int[] answers = {9, 8, 36, 13, 32};
    private int score = 0;
    private int qno = 0;

    public String[] getQuistions() {
        return quistions;
    }

    public void setQuistions(String[] quistions) {
        this.quistions = quistions;
    }

    public int[] getAnswers() {
        return answers;
    }

    public void setAnswers(int[] answers) {
        this.answers = answers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }
}
