public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        Ticket ticket = ticketSeller.getTicketOffice().getTicket();

        if (audience.getBag().hasInvitation()) {
            audience.getBag().setTicket(ticket);
            return;
        }

        final Long audienceAmount = audience.getBag().getAmount();

        if (audienceAmount < ticket.getFee()) {
            ticketSeller.getTicketOffice().addTicket(ticket);
            return;
        } else {
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
