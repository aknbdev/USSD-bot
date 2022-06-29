package a.k.n.b.USSD.bot.menu.adminPanel;
import a.k.n.b.USSD.bot.dto.CodeMessage;
import a.k.n.b.USSD.bot.dto.Menu;
import a.k.n.b.USSD.bot.dto.MenuState;
import a.k.n.b.USSD.bot.enums.CodeMessageType;
import a.k.n.b.USSD.bot.enums.MenuType;
import a.k.n.b.USSD.bot.menu.MainMenuButton;
import a.k.n.b.USSD.bot.menu.Start;
import a.k.n.b.USSD.bot.model.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.*;

@Component
public class AdminMenu {
    @Autowired private MainMenuButton mainMenuButton;
    @Autowired private AdminButtons adminButtons;
    @Autowired private MenuState menuState;
    @Autowired private CheckAdd checkAdd;
    @Autowired private Start start;
    @Autowired private Menu menu;

    public CodeMessage handle(Message message) {
        SendLocation sendLocation = new SendLocation();
        CodeMessage codeMessage = new CodeMessage();
        SendMessage sendMessage = new SendMessage();
        SendVideo sendVideo = new SendVideo();
        SendPhoto sendPhoto = new SendPhoto();

        message.setForwardFrom(null);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        MenuType menuType = menuState.getMenuMap().get(message.getChatId());

        if (menuType==null){
            if (message.hasText()){
                String text = message.getText();

                switch (text) {
                    case "/start" -> {
                        sendMessage.setText("Assalamu Alaikum va Rohmatulloh.\nWelcome Admin.\n#Bismillah");
                        sendMessage.setReplyMarkup(adminButtons.panel());
                        codeMessage = start.handle(message);
                    }
                    case "ADVERTISEMENT" -> {
                        sendMessage.setText("You can send add ->");
                        sendMessage.setReplyMarkup(adminButtons.no());
                        menuState.getMenuMap().put(message.getChatId(), MenuType.ANNOUNCEMENT);
                    }
                    case "\uD83E\uDDD1\u200D\uD83D\uDCBB User_Mode" -> {
                        sendMessage.setText("You entered to the Menu Mode.\nIn this mode you can test all Commands.");
                        sendMessage.setReplyMarkup(mainMenuButton.mainMenu());
                        menu.getMenuMap().remove(message.getChatId());
                    }
                    case "\uD83D\uDCCA Statics" -> sendMessage.setText(
                            "\uD83D\uDCCA Statics of @USSD_CodesBot\n" +
                                    "\uD83D\uDC65 All Users: " + menu.getSet().size());
                    case "\uD83D\uDCCB USERS ID" -> {
                        codeMessage.setCodeMessageType(CodeMessageType.USERSID);
                        return codeMessage;
                    }
                    case "➕ Add Users" -> {
                        sendMessage.setText("You can send ADD USERS ->");
                        sendMessage.setReplyMarkup(adminButtons.no());
                        menuState.getMenuMap().put(message.getChatId(), MenuType.ADDUSERS);
                    }
                    default -> sendMessage.setText("⚠️ Kutilmagan buyruq.");
                }
                codeMessage.setSendMessage(sendMessage);
                codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
            } else {
                codeMessage.setCodeMessageType(CodeMessageType.NULL);
            }
        } else if (menuType.equals(MenuType.ADDUSERS)) {
            if (message.getText().equals("Cancel")){
                menuState.getMenuMap().remove(message.getChatId());
                sendMessage.setText("Ok, ADD USERS has been cancelled.");
                sendMessage.setReplyMarkup(adminButtons.panel());
            } else {
                String[] users = message.getText().split("\n");
                for (String user : users){
                    menu.getSet().add(Long.valueOf(user));
                }
                menuState.getMenuMap().remove(message.getChatId());
                sendMessage.setText("Ok, ADD USERS has been added.");
                sendMessage.setReplyMarkup(adminButtons.panel());
            }
            codeMessage.setSendMessage(sendMessage);
            codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
        } else if (menuType.equals(MenuType.ANNOUNCEMENT)){
            Check check = new Check();
            if (message.hasText()){
                String text = message.getText();
                if (text.equals("/start") || text.equals("ADVERTISEMENT") || text.equals("\uD83E\uDDD1\u200D\uD83D\uDCBB User_Mode")){
                    sendMessage.setText("Error pls try again.");
                    codeMessage.setSendMessage(sendMessage);
                    codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
                    return codeMessage;
                } else if (text.equals("Cancel")){
                    menuState.getMenuMap().remove(message.getChatId());
                    sendMessage.setText("Ok, advertisement has been cancelled.");
                    sendMessage.setReplyMarkup(adminButtons.panel());
                    codeMessage.setSendMessage(sendMessage);
                    codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
                } else {
                    sendMessage.setText(message.getText());

                    check.setSendMessage(sendMessage);

                    sendMessage.setReplyMarkup(adminButtons.yesNo());
                    menuState.getCheckMap().put(message.getChatId(), check);
                    menuState.getMenuMap().remove(message.getChatId());
                    menuState.getMenuMap().put(message.getChatId(), MenuType.CHECKMESSAGE);
                    codeMessage.setSendMessage(sendMessage);
                    codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
                }

            } else if (message.hasVideo()){
                String id = message.getVideo().getFileId();
                Integer duration = message.getVideo().getDuration();
                sendVideo.setChatId(message.getChatId().toString());
                sendVideo.setVideo(new InputFile().setMedia(id));
                sendVideo.setDuration(duration);
                sendVideo.setCaption(message.getCaption());

                check.setSendVideo(sendVideo);

                sendVideo.setReplyMarkup(adminButtons.yesNo());
                menuState.getCheckMap().put(message.getChatId(), check);
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getMenuMap().put(message.getChatId(), MenuType.CHECKVIDEO);

                codeMessage.setCodeMessageType(CodeMessageType.SENDVIDEO);
                codeMessage.setSendVideo(sendVideo);
            } else if (message.hasPhoto()){
                sendPhoto.setChatId(String.valueOf(message.getChatId()));
                sendPhoto.setCaption(message.getCaption());
                sendPhoto.setPhoto(new InputFile().setMedia(message.getPhoto().get(0).getFileId()));

                check.setSendPhoto(sendPhoto);

                sendPhoto.setReplyMarkup(adminButtons.yesNo());

                menuState.getCheckMap().put(message.getChatId(), check);
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getMenuMap().put(message.getChatId(), MenuType.CHECKPHOTO);

                codeMessage.setSendPhoto(sendPhoto);
                codeMessage.setCodeMessageType(CodeMessageType.SENDPHOTO);
            } else if (message.hasLocation()){
                sendLocation.setLongitude(message.getLocation().getLongitude());
                sendLocation.setLatitude(message.getLocation().getLatitude());
                sendLocation.setChatId(String.valueOf(message.getChatId()));

                check.setSendLocation(sendLocation);

                sendLocation.setReplyMarkup(adminButtons.yesNo());

                menuState.getCheckMap().put(message.getChatId(), check);
                menuState.getMenuMap().remove(message.getChatId());
                menuState.getMenuMap().put(message.getChatId(), MenuType.CHECKLOCATION);

                codeMessage.setSendLocation(sendLocation);
                codeMessage.setCodeMessageType(CodeMessageType.SENDLOCATION);
            } else{
                sendMessage.enableHtml(true);
                sendMessage.setText("Error pls check try again.\nAdd must contains from:<b>\nMessage\nVideo\nPhoto\nLocation</b>");
                codeMessage.setSendMessage(sendMessage);
                codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
                return codeMessage;
            }
        } else if (menuType.equals(MenuType.CHECKMESSAGE)){
            codeMessage = checkAdd.handle(menuType, message);

        } else if (menuType.equals(MenuType.CHECKVIDEO)){

            codeMessage = checkAdd.handle(menuType, message);

        } else if (menuType.equals(MenuType.CHECKPHOTO)){

            codeMessage = checkAdd.handle(menuType, message);

        } else if (menuType.equals(MenuType.CHECKLOCATION)){

            codeMessage = checkAdd.handle(menuType, message);

        }

        return codeMessage;
    }

    public SendMessage sendAnnounce(Long id, SendMessage requestMessage) {
        requestMessage.setChatId(String.valueOf(id));

        if (!requestMessage.getChatId().equals("684876119")){
            requestMessage.setReplyMarkup(null);
        }
        return requestMessage;
    }

    public SendVideo sendVideo(Long id, SendVideo sendVideos) {
        sendVideos.setChatId(String.valueOf(id));

        if (!sendVideos.getChatId().equals("684876119")){
            sendVideos.setReplyMarkup(null);
        }
        return sendVideos;
    }

    public SendPhoto sendPhoto(Long id, SendPhoto sendPhoto) {
        sendPhoto.setChatId(String.valueOf(id));

        if (!sendPhoto.getChatId().equals("684876119")){
            sendPhoto.setReplyMarkup(null);
        }
        return sendPhoto;
    }

    public SendLocation sendLocation(Long id, SendLocation sendLocation) {
        sendLocation.setChatId(String.valueOf(id));

        if (!sendLocation.getChatId().equals("684876119")){
            sendLocation.setReplyMarkup(null);
        }
        return sendLocation;
    }
}
