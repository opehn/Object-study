public class Audience {
    public Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {

        if (this.bag.hasInvitation()) {
            this.bag.setTicket(ticket);
            return (0L);
        }

        final Long audienceAmount = this.bag.getAmount();

        if (audienceAmount < ticket.getFee()) {
            return (-1L);
        } else {
            bag.minusAmount(ticket.getFee());
            bag.setTicket(ticket);
        }
        return (ticket.getFee());
    }
}
