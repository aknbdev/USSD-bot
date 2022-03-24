package a.k.n.b.USSD.bot.menu.telecom;
import a.k.n.b.USSD.bot.dto.CodeMessage;
import a.k.n.b.USSD.bot.dto.Menu;
import a.k.n.b.USSD.bot.enums.CodeMessageType;
import a.k.n.b.USSD.bot.menu.MainMenuButton;
import a.k.n.b.USSD.bot.menu.Start;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class TelecomMenu {
    @Autowired private MainMenuButton mainMenuButton;
    @Autowired private TelecomMenuButton telecomButton;
    @Autowired private Start start;
    @Autowired private Menu menu;
    public CodeMessage handle(Message message){
        CodeMessage codeMessage = new CodeMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        if (message.hasText()){
            String text = message.getText();

            switch (text) {
                case "/start" -> {
                    codeMessage = start.handle(message);
                    return codeMessage;
                }
                case "UZMOBILE", "\uD83D\uDD19 Orqaga qaytish" -> {
                    sendMessage.setText("Uzmobile foydalanuvchisi uchun maxsus xizmatlar");
                    sendMessage.setReplyMarkup(telecomButton.telecomMainMenu());
                }
                case "\uD83C\uDF10 Internet paketlar" -> {
                    sendMessage.enableMarkdownV2(true);
                    sendMessage.setText("Bir oylik *MB* hajmini tanlang");
                    sendMessage.setReplyMarkup(telecomButton.telecomIntPaket());
                }
                case "\uD83D\uDD53 Daqiqa paketlar" -> {
                    sendMessage.enableMarkdownV2(true);
                    sendMessage.setText("Bir oylik *Daqiqa* hajmini tanlang");
                    sendMessage.setReplyMarkup(telecomButton.telecomDaqiqaPaket());
                }
                case "✉ SMS paketlar" -> {
                    sendMessage.enableMarkdownV2(true);
                    sendMessage.setText("Bir oylik *SMS* hajmini tanlang");
                    sendMessage.setReplyMarkup(telecomButton.telecomSMSPaket());
                }
                case "#⃣ USSD Kodlar" -> {
                    sendMessage.enableMarkdownV2(true);
                    sendMessage.setText("Bir oylik *SMS* hajmini tanlang");
                    sendMessage.setReplyMarkup(telecomButton.telecomUssdPaket());
                }
                case "\uD83D\uDD1D Asosiy oynaga qaytish" -> {
                    menu.getMenuMap().remove(message.getChatId());
                    sendMessage.setText("Assalomu Alaikum USSD Kodlar botiga hush kelibsiz");
                    sendMessage.enableMarkdown(true);
                    sendMessage.setReplyMarkup(mainMenuButton.mainMenu());
                }
                default -> {
                    if (text.endsWith("MB")) {
                        sendMessage = telecomButton.mbPaket(message);
                    }else if (text.endsWith("daqiqa")){
                        sendMessage = telecomButton.daqPaket(message);
                    }else if (text.endsWith("SMS")){
                        sendMessage = telecomButton.smsPaket(message);
                    } else{
                        sendMessage = telecomButton.ussdPaket(message);
                    }
                }
            }
            codeMessage.setSendMessage(sendMessage);
            codeMessage.setCodeMessageType(CodeMessageType.MESSAGE);
        } else{
            codeMessage = start.unknownMessage(message);
        }
        return codeMessage;
    }
}


//if (data.startsWith("/mb/")){
//        sendContact = mbPaket.sendContact(data, String.valueOf(callback.getFrom().getId()));
//        }
//codeMessage.setSendContact(sendContact);
//        codeMessage.setCodeMessageType(CodeMessageType.CONTACT);