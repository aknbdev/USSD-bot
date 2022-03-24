package a.k.n.b.USSD.bot.handler;
import a.k.n.b.USSD.bot.dto.CodeMessage;
import a.k.n.b.USSD.bot.dto.Menu;
import a.k.n.b.USSD.bot.enums.CodeMessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.ChatMemberUpdated;

@Component
public class MyChatMemberHandler {
    @Autowired private Menu menu;


    public CodeMessage handle(ChatMemberUpdated chatMemberUpdated){
        CodeMessage codeMessage = new CodeMessage();
        if (chatMemberUpdated.getNewChatMember().getStatus().equals("member")){
            menu.getSet().add(chatMemberUpdated.getChat().getId());
        } else if (chatMemberUpdated.getNewChatMember().getStatus().equals("left")){
            menu.getSet().remove(chatMemberUpdated.getChat().getId());
        }
        codeMessage.setCodeMessageType(CodeMessageType.NULL);
        return codeMessage;
    }
}
