import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    public Long amount;
    public List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void sellTicketTo(Audience audience) {
        final Long audienceAmount = audience.bag.getAmount();

        if (audienceAmount > 0) {
            this.plusAmount(audience.buy(this.getTicket()));
        }
    }
}
