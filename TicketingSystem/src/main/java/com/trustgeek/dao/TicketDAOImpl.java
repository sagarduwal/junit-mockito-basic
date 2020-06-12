package com.trustgeek.dao;
import com.trustgeek.dto.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDAOImpl implements TicketDAO {
    @Override
    public int createTicket(Ticket ticket) {
        return 1;
    }
}
