import java.time.LocalTime;

public class Screening {
    private Movie movie;
    private LocalTime startTime;
    private LocalTime endTime;
    private int sequence;


    public Screening(Movie moive) {
        this.movie = moive;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public Money getMovieFee() {
        this.movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(Customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
