package a.k.n.b.USSD.bot.handler;
import a.k.n.b.USSD.bot.dto.CodeMessage;
import a.k.n.b.USSD.bot.dto.Menu;
import a.k.n.b.USSD.bot.enums.CodeMessageType;
import a.k.n.b.USSD.bot.enums.MenuType;
import a.k.n.b.USSD.bot.menu.Start;
import a.k.n.b.USSD.bot.menu.adminPanel.AdminMenu;
import a.k.n.b.USSD.bot.menu.beeline.BeelineMenu;
import a.k.n.b.USSD.bot.menu.mobiuz.MobiuzMenu;
import a.k.n.b.USSD.bot.menu.telecom.TelecomMenu;
import a.k.n.b.USSD.bot.menu.ucell.UcellMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class MessageHandler {
    @Autowired private BeelineMenu beelineMenu;
    @Autowired private TelecomMenu telecomMenu;
    @Autowired private MobiuzMenu mobiuzMenu;
    @Autowired private AdminMenu adminMenu;
    @Autowired private UcellMenu ucellMenu;
    @Autowired private Start start;
    @Autowired private Menu menu;

    public CodeMessage handle(Message message){
        CodeMessage codeMessage = new CodeMessage();
        MenuType menuType = menu.getMenuMap().get(message.getChatId());
        if (message.hasText() && menuType==null){
            String text = message.getText();
            switch (text) {
                case "/start" -> {
                    codeMessage = start.handle(message);
                    menu.getSet().add(message.getChatId());
                }
                case "UZMOBILE" -> {
                    codeMessage = telecomMenu.handle(message);
                    menu.getMenuMap().put(message.getChatId(), MenuType.TELECOM);
                }
                case "Ucell" -> {
                    codeMessage = ucellMenu.handle(message);
                    menu.getMenuMap().put(message.getChatId(), MenuType.UCELL);
                }
                case "mobiuz" -> {
                    codeMessage = mobiuzMenu.handle(message);
                    menu.getMenuMap().put(message.getChatId(), MenuType.MOBIUZ);
                }
                case "Beeline" -> {
                    codeMessage = beelineMenu.handle(message);
                    menu.getMenuMap().put(message.getChatId(), MenuType.BEELINE);
                }
                default -> codeMessage = start.unknownMessage(message);
            }
        } else if (menuType!=null){
            if (menuType.equals(MenuType.TELECOM)){
                codeMessage = telecomMenu.handle(message);
            } else if (menuType.equals(MenuType.UCELL)){
                codeMessage = ucellMenu.handle(message);
            } else if (menuType.equals(MenuType.MOBIUZ)){
                codeMessage = mobiuzMenu.handle(message);
            } else if (menuType.equals(MenuType.BEELINE)){
                codeMessage = beelineMenu.handle(message);
            } else if (menuType.equals(MenuType.ADMIN)){
                codeMessage = adminMenu.handle(message);
            } else {
                codeMessage = start.unknownMessage(message);
            }
        } else {
            codeMessage.setCodeMessageType(CodeMessageType.NULL);
        }
        return codeMessage;
    }
}
