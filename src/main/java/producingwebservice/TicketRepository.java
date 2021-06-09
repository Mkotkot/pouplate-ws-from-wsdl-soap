package producingwebservice;

import eg.intercom.ca.ics.web.soap.wsdl.CheckTicketResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class TicketRepository {

    private static final Map<String, CheckTicketResponse> datesResponseMap = new HashMap<>();

    @PostConstruct
    public void initData() {
        CheckTicketResponse b1 = new CheckTicketResponse();
        b1.setCheckTicketResult(true);
        datesResponseMap.put("1", b1);

    }

    public CheckTicketResponse findCheckTicketResponse(String id) {
        return datesResponseMap.get(id);
    }
}
