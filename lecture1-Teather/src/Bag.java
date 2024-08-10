public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public Long hold(Long audienceAmount, Ticket ticket) {
        if (this.hasInvitation()) {
            this.setTicket(ticket);
            return (0L);
        }

        if (audienceAmount < ticket.getFee()) {
            return (-1L);
        } else {
            this.minusAmount(ticket.getFee());
            this.setTicket(ticket);
        }

        return (ticket.getFee());
    }

}
