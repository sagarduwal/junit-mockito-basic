package com.trustgeek.service;

import com.trustgeek.dao.TicketDAO;
import com.trustgeek.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDAO ticketDAO;

    public TicketDAO getTicketDAO() {
        return ticketDAO;
    }

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public int buyTicket(String passengerName, String phone) {
        Ticket ticket = new Ticket();
        ticket.setPassengerName(passengerName);
        ticket.setPhone(phone);

        return getTicketDAO().createTicket(ticket);
    }
}
