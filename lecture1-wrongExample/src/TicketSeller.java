public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();

        if (audience.getBag().hasInvitation()) {
            audience.getBag().setTicket(ticket);
            return;
        }

        final Long audienceAmount = audience.getBag().getAmount();

        if (audienceAmount < ticket.getFee()) {
            ticketOffice.addTicket(ticket);
            return;
        } else {
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
