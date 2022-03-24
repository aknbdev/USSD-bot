package a.k.n.b.USSD.bot.handler;
import a.k.n.b.USSD.bot.dto.CodeMessage;
import a.k.n.b.USSD.bot.dto.Menu;
import a.k.n.b.USSD.bot.enums.CodeMessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaAudio;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaVideo;

@Component
public class ChannelPost {
    @Autowired private Menu menu;

    public CodeMessage handle(Message message){
        CodeMessage codeMessage = new CodeMessage();
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(String.valueOf(message.getChatId()));
        editMessageText.setMessageId(message.getMessageId());
        menu.getSet().add(message.getChatId());
        if (message.hasText()){
            StringBuilder text = new StringBuilder();
            if (message.getText()!=null) {
                text.append(message.getText());
            }
            text.append("\n\n");
            text.append("\uD835\uDE7C\uD835\uDE8A\uD835\uDE97\uD835\uDE8B\uD835\uDE8A => @");
            text.append(message.getChat().getUserName());
            editMessageText.setText(text.toString());

            codeMessage.setCodeMessageType(CodeMessageType.EDIT);
            codeMessage.setEditMessageText(editMessageText);
        } else if (message.hasPhoto()){
            StringBuilder text = new StringBuilder();
            if (message.getCaption()!=null){
                text.append(message.getCaption());
            }
            text.append("\n\n");
            text.append("\uD835\uDE7C\uD835\uDE8A\uD835\uDE97\uD835\uDE8B\uD835\uDE8A => @");
            text.append(message.getChat().getUserName());
            EditMessageMedia editMessageMedia = new EditMessageMedia();
            InputMedia inputMedia = new InputMediaPhoto(message.getPhoto().get(0).getFileId());
            inputMedia.setCaption(String.valueOf(text));
            editMessageMedia.setChatId(String.valueOf(message.getChatId()));
            editMessageMedia.setMedia(inputMedia);
            editMessageMedia.setMessageId(message.getMessageId());

            codeMessage.setCodeMessageType(CodeMessageType.EDITMEDIA);
            codeMessage.setEditMessageMedia(editMessageMedia);
        } else if (message.hasVideo()){
            StringBuilder text = new StringBuilder();
            if (message.getCaption()!=null){
                text.append(message.getCaption());
            }
            text.append("\n\n");
            text.append("\uD835\uDE7C\uD835\uDE8A\uD835\uDE97\uD835\uDE8B\uD835\uDE8A => @");
            text.append(message.getChat().getUserName());

            EditMessageMedia editMessageMedia = new EditMessageMedia();
            InputMedia inputMedia = new InputMediaVideo(message.getVideo().getFileId());
            inputMedia.setCaption(String.valueOf(text));

            editMessageMedia.setChatId(String.valueOf(message.getChatId()));
            editMessageMedia.setMedia(inputMedia);
            editMessageMedia.setMessageId(message.getMessageId());

            codeMessage.setCodeMessageType(CodeMessageType.EDITMEDIA);
            codeMessage.setEditMessageMedia(editMessageMedia);
        } else if (message.hasAudio()){
            StringBuilder text = new StringBuilder();
            if (message.getCaption()!=null){
                text.append(message.getCaption());
            }
            text.append("\n\n");
            text.append("\uD835\uDE7C\uD835\uDE8A\uD835\uDE97\uD835\uDE8B\uD835\uDE8A => @");
            text.append(message.getChat().getUserName());

            EditMessageMedia editMessageMedia = new EditMessageMedia();
            InputMedia inputMedia = new InputMediaAudio(message.getAudio().getFileId());

            inputMedia.setCaption(String.valueOf(text));

            editMessageMedia.setChatId(String.valueOf(message.getChatId()));
            editMessageMedia.setMedia(inputMedia);
            editMessageMedia.setMessageId(message.getMessageId());

            codeMessage.setCodeMessageType(CodeMessageType.EDITMEDIA);
            codeMessage.setEditMessageMedia(editMessageMedia);
        } else {
            codeMessage.setCodeMessageType(CodeMessageType.NULL);
        }
        return codeMessage;
    }
}
