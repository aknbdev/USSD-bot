package a.k.n.b.USSD.bot;
import a.k.n.b.USSD.bot.dto.CodeMessage;
import a.k.n.b.USSD.bot.dto.Menu;
import a.k.n.b.USSD.bot.handler.ChannelPost;
import a.k.n.b.USSD.bot.handler.MessageHandler;
import a.k.n.b.USSD.bot.handler.MyChatMemberHandler;
import a.k.n.b.USSD.bot.menu.adminPanel.AdminMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {
    @Autowired private MyChatMemberHandler myChatMemberHandler;
    @Autowired private MessageHandler messageHandler;
    @Autowired private ChannelPost channelPost;
    @Autowired private AdminMenu adminMenu;
    @Autowired private Menu menu;

    @Override
    public String getBotUsername() {
        return "USSD_CodesBot";
    }

    @Override
    public String getBotToken() {
        return "5248410501:AAGBoZUW7sVDxLAOIa3cHOdNrwLaBC4Hnhw";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().getChat().getType().equals("private")){
            executeMessage(messageHandler.handle(update.getMessage()));
        } else if (update.hasMyChatMember()){
            executeMessage(myChatMemberHandler.handle(update.getMyChatMember()));
        } else if (update.hasChatMember()){
            executeMessage(myChatMemberHandler.handle(update.getChatMember()));
        } else if (update.hasChannelPost()){
            executeMessage(channelPost.handle(update.getChannelPost()));
        }
    }

    public void executeMessage(CodeMessage codeMessage){
        try {
            switch (codeMessage.getCodeMessageType()){
                case USERSID -> {
                    StringBuilder usersId = new StringBuilder("Id: \n");
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId("684876119");
                    for (Long id : menu.getSet()) {
                        if (usersId.length() >= 2086){
                            sendMessage.setText(String.valueOf(usersId));
                            usersId = new StringBuilder("Id: \n");
                            execute(sendMessage);
                        }
                        usersId.append(id);
                        usersId.append("\n");
                    }
                    sendMessage.setText(String.valueOf(usersId));
                    execute(sendMessage);
                }
                case ANNOUNCE -> {
                    for (Long id : menu.getSet()) {
                        execute(adminMenu.sendAnnounce(id, codeMessage.getSendMessage()));
                    }
                }
                case VIDEO -> {
                    for (Long id : menu.getSet()) {
                        execute(adminMenu.sendVideo(id, codeMessage.getSendVideo()));
                    }
                }
                case PHOTO -> {
                    for (Long id : menu.getSet()) {
                        execute(adminMenu.sendPhoto(id, codeMessage.getSendPhoto()));
                    }
                }
                case LOCATION -> {
                    for (Long id : menu.getSet()) {
                        execute(adminMenu.sendLocation(id, codeMessage.getSendLocation()));
                    }
                }
                case NULL -> {}
                case EDITMEDIA -> execute(codeMessage.getEditMessageMedia());
                case SENDLOCATION -> execute(codeMessage.getSendLocation());
                case SENDPHOTO -> execute(codeMessage.getSendPhoto());
                case SENDVIDEO -> execute(codeMessage.getSendVideo());
                case CONTACT -> execute(codeMessage.getSendContact());
                case MESSAGE -> execute(codeMessage.getSendMessage());
                case EDIT -> execute(codeMessage.getEditMessageText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
