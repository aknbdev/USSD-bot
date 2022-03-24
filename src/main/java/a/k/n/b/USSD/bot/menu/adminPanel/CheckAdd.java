package a.k.n.b.USSD.bot.menu.adminPanel;
import a.k.n.b.USSD.bot.dto.CodeMessage;
import a.k.n.b.USSD.bot.dto.MenuState;
import a.k.n.b.USSD.bot.enums.CodeMessageType;
import a.k.n.b.USSD.bot.enums.MenuType;
import a.k.n.b.USSD.bot.model.Check;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component @Data
public class CheckAdd {
    @Autowired private AdminButtons adminButtons;
    @Autowired private MenuState menuState;


    public CodeMessage handle(MenuType menuType, Message message) {
        CodeMessage codeMessage = new CodeMessage();
        SendMessage sendMessage = new SendMessage();
        SendLocation sendLocation;
        SendVideo sendVideo;
        SendPhoto sendPhoto;

        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if (menuType.equals(MenuType.CHECKMESSAGE)){
            String text = message.getText();
            Check check = menuState.getCheckMap().get(message.getChatId());
            if (text.equals("Send")){
                sendMessage = check.getSendMessage();
                sendMessage.setReplyMarkup(adminButtons.panel());
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getCheckMap().remove(message.getChatId());
                codeMessage.setSendMessage(sendMessage);
                codeMessage.setCodeMessageType(CodeMessageType.ANNOUNCE);
            } else if (text.equals("Cancel")){
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getCheckMap().remove(message.getChatId());
                sendMessage.setText("Ok, Cancelled.");
                sendMessage.setReplyMarkup(adminButtons.panel());
                codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
                codeMessage.setSendMessage(sendMessage);
            }
        } else if (menuType.equals(MenuType.CHECKVIDEO)){
            String text = message.getText();
            Check check = menuState.getCheckMap().get(message.getChatId());
            if (text.equals("Send")){
                sendVideo = check.getSendVideo();
                sendVideo.setReplyMarkup(adminButtons.panel());
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getCheckMap().remove(message.getChatId());
                codeMessage.setSendVideo(sendVideo);
                codeMessage.setCodeMessageType(CodeMessageType.VIDEO);
            } else if (text.equals("Cancel")){
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getCheckMap().remove(message.getChatId());
                sendMessage.setText("Ok, Cancelled.");
                sendMessage.setReplyMarkup(adminButtons.panel());
                codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
                codeMessage.setSendMessage(sendMessage);
            }
        } else if (menuType.equals(MenuType.CHECKPHOTO)){
            String text = message.getText();
            Check check = menuState.getCheckMap().get(message.getChatId());
            if (text.equals("Send")){
                sendPhoto = check.getSendPhoto();
                sendPhoto.setReplyMarkup(adminButtons.panel());
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getCheckMap().remove(message.getChatId());
                codeMessage.setSendPhoto(sendPhoto);
                codeMessage.setCodeMessageType(CodeMessageType.PHOTO);
            } else if (text.equals("Cancel")){
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getCheckMap().remove(message.getChatId());
                sendMessage.setText("Ok, Cancelled.");
                sendMessage.setReplyMarkup(adminButtons.panel());
                codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
                codeMessage.setSendMessage(sendMessage);
            }
        } else if (menuType.equals(MenuType.CHECKLOCATION)){
            String text = message.getText();
            Check check = menuState.getCheckMap().get(message.getChatId());
            if (text.equals("Send")){
                sendLocation = check.getSendLocation();
                sendLocation.setReplyMarkup(adminButtons.panel());
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getCheckMap().remove(message.getChatId());
                codeMessage.setSendLocation(sendLocation);
                codeMessage.setCodeMessageType(CodeMessageType.LOCATION);
            } else if (text.equals("Cancel")){
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getCheckMap().remove(message.getChatId());
                sendMessage.setText("Ok, Cancelled.");
                sendMessage.setReplyMarkup(adminButtons.panel());
                codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
                codeMessage.setSendMessage(sendMessage);
            }
        }
        return codeMessage;
    }
}
