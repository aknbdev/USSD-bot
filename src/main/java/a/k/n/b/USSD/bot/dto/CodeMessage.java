package a.k.n.b.USSD.bot.dto;
import a.k.n.b.USSD.bot.enums.CodeMessageType;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

@Component @Data
public class CodeMessage {
    private CodeMessageType codeMessageType;
    private EditMessageMedia editMessageMedia;
    private EditMessageText editMessageText;
    private SendLocation sendLocation;
    private SendContact sendContact;
    private SendMessage sendMessage;
    private SendPhoto sendPhoto;
    private SendVideo sendVideo;
}
