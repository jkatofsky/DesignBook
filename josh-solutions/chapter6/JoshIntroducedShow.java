package chapter6;

public class JoshIntroducedShow implements Show {

    private Show show;
    private String speaker;
    private int speechTime;

    public JoshIntroducedShow(Show show, String speaker, int speechTime) {
        this.show = show;
        this.speaker = speaker;
        this.speechTime = speechTime;
    }

    public JoshIntroducedShow copy() {
        return new JoshIntroducedShow(show.copy(), speaker, speechTime);
    }

    public String description() {
        return speaker + " is introducing: " + show.description();
    }

    public int runningTime() {
        return speechTime + show.runningTime();
    }
}