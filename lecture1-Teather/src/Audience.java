public class Audience {
    public Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        final Long audienceAmount = this.bag.getAmount();

        return (this.bag.hold(audienceAmount, ticket));
    }

}
