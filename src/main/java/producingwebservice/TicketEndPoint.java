package producingwebservice;

import eg.intercom.ca.ics.web.soap.wsdl.CheckTicket;
import eg.intercom.ca.ics.web.soap.wsdl.CheckTicketResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TicketEndPoint {
    private static final String NAMESPACE_URI = "http://tempuri.org/";
    final private TicketRepository ticketRepository;

    public TicketEndPoint(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CheckTicket")
    @ResponsePayload
    public CheckTicketResponse getCheckTicketResponse(@RequestPayload CheckTicket request) {
        return ticketRepository.findCheckTicketResponse(request.getTicketID().toString());
    }
}