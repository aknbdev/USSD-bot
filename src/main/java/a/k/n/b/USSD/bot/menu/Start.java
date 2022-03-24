package a.k.n.b.USSD.bot.menu;
import a.k.n.b.USSD.bot.dto.CodeMessage;
import a.k.n.b.USSD.bot.dto.Menu;
import a.k.n.b.USSD.bot.enums.CodeMessageType;
import a.k.n.b.USSD.bot.enums.MenuType;
import a.k.n.b.USSD.bot.menu.adminPanel.AdminButtons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Start {
    @Autowired private MainMenuButton mainMenuButton;
    @Autowired private AdminButtons adminButtons;
    @Autowired private Menu menu;
    CodeMessage codeMessage = new CodeMessage();
    SendMessage sendMessage = new SendMessage();

    public CodeMessage handle(Message message){
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        Long adminId = 684876119L;
        if (adminId.equals(message.getChatId())){
            menu.getMenuMap().put(message.getChatId(), MenuType.ADMIN);
            sendMessage.setText("Assalamu Alaikum va Rohmatulloh.\nWelcome Admin.\n#Bismillah");
            sendMessage.setReplyMarkup(adminButtons.panel());
        } else{
            sendMessage.setText("Assalomu Alaikum USSD Kodlar botiga hush kelibsiz");
            sendMessage.enableMarkdown(true);
            sendMessage.setReplyMarkup(mainMenuButton.mainMenu());
        }
        codeMessage.setSendMessage(sendMessage);
        codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
        return codeMessage;
    }

    public CodeMessage unknownMessage(Message message){
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText("Kutilmagan buyruq!");
        codeMessage.setSendMessage(sendMessage);
        codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
        return codeMessage;
    }
}