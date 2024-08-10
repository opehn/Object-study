public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        final Long amount = audience.buy(ticket);

        if (amount < 0) {
            ticketOffice.addTicket(ticket);
        }
        ticketOffice.plusAmount(amount);
    }

}
