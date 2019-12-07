package chapter7;

//This is effectively the decorator design pattern, using inheritance
public class JoshSponsoredConcert extends Concert {

    private String sponsor;
    private int sponsorTime;

    public JoshSponsoredConcert(String sponsor, int sponsorTime, String pTitle, String pPerformer, int pTime) {
        super(pTitle, pPerformer, pTime);
        this.sponsor = sponsor;
        this.sponsorTime = sponsorTime;
    }

    @Override
    public String description() {
        return super.description() + " - " + sponsor;
    }

    @Override
    public int time() {
        return super.time() + sponsorTime;
    }

}