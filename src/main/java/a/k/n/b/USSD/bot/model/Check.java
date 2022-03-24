package a.k.n.b.USSD.bot.model;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;

@Component @Data
public class Check {
    private SendVideo sendVideo;
    private SendPhoto sendPhoto;
    private SendLocation sendLocation;
    private SendMessage sendMessage;
}
