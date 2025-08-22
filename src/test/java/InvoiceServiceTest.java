import io.github.aks.nowpayment.client.NOWPaymentClient;
import io.github.aks.nowpayment.exceptions.InvalidCurrencyException;
import io.github.aks.nowpayment.model.invoice.InvoiceRequest;
import io.github.aks.nowpayment.model.invoice.InvoiceResponse;
import io.github.aks.nowpayment.util.Paths;
import io.github.aks.nowpayment.util.Tickers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceServiceTest {
    private NOWPaymentClient client;
    @BeforeEach
    void setup(){
        client = new NOWPaymentClient(Paths.BASE_URL, System.getenv("nowpayment_api_key"));
    }

    @Test
    void validInvoiceWithSupportedCurrency(){
        InvoiceRequest req = new InvoiceRequest.Builder("99.79", Tickers.BITCOIN)
                .build();

        InvoiceResponse res = client.invoices().createInvoice(req);
        assertNotNull(res);
    }

    @Test
    void invalidInvoiceCuzMadeUpTicker(){
        InvoiceRequest req = new InvoiceRequest.Builder("99.79", "CANUTE")
                .build();

        assertThrows(
                InvalidCurrencyException.class,
                () -> client.invoices().createInvoice(req)
                );
    }
}
