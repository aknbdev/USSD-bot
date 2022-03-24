package a.k.n.b.USSD.bot.db;
import a.k.n.b.USSD.bot.model.Daq;
import a.k.n.b.USSD.bot.model.MB;
import a.k.n.b.USSD.bot.model.SMS;
import a.k.n.b.USSD.bot.model.USSD;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component @Data
public class MTMSBeelineDB {
    private Map<String, MB> mbMap = new HashMap<>();
    private Map<String, Daq> daqMap = new HashMap<>();
    private Map<String, SMS> smsMap = new HashMap<>();
    private Map<String, USSD> ussdMap =new HashMap<>();
}
