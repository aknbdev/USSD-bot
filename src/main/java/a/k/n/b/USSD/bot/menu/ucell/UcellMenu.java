package a.k.n.b.USSD.bot.menu.ucell;
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
public class UcellMenu {
    @Autowired private Menu menu;
    @Autowired private Start start;
    @Autowired private MainMenuButton mainMenuButton;
    @Autowired private UcellMenuButton ucellMenuButton;

    public CodeMessage handle(Message message) {
        CodeMessage codeMessage = new CodeMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        if (message.hasText()){
            String text = message.getText();

            switch (text){
                case "/start" ->{
                    codeMessage = start.handle(message);
                    return codeMessage;
                } case "Ucell", "\uD83D\uDD19 Orqaga qaytish" ->{
                    sendMessage.setText("Ucell foydalanuvchisi uchun maxsus xizmatlar");
                    sendMessage.setReplyMarkup(ucellMenuButton.ucellMainButtons());
                } case "\uD83C\uDF10 Internet paketlar" ->{
                    sendMessage.enableMarkdownV2(true);
                    sendMessage.setText("Bir oylik *MB* hajmini tanlang");
                    sendMessage.setReplyMarkup(ucellMenuButton.ucellIntPaket());
                } case "\uD83D\uDD53 Daqiqa paketlar" ->{
                    sendMessage.enableMarkdownV2(true);
                    sendMessage.setText("Bir oylik *Daqiqa* hajmini tanlang");
                    sendMessage.setReplyMarkup(ucellMenuButton.ucellDaqiqaPaket());
                } case "✉ SMS paketlar" ->{
                    sendMessage.enableMarkdownV2(true);
                    sendMessage.setText("Bir oylik *SMS* hajmini tanlang");
                    sendMessage.setReplyMarkup(ucellMenuButton.ucellSMSPaket());
                } case "#⃣ USSD Kodlar" ->{
                    sendMessage.enableMarkdownV2(true);
                    sendMessage.setText("Bir oylik *SMS* hajmini tanlang");
                    sendMessage.setReplyMarkup(ucellMenuButton.ucellUssdPaket());
                } case "\uD83D\uDD1D Asosiy oynaga qaytish" ->{
                    menu.getMenuMap().remove(message.getChatId());
                    sendMessage.setText("Assalomu Alaikum USSD Kodlar botiga hush kelibsiz");
                    sendMessage.enableMarkdown(true);
                    sendMessage.setReplyMarkup(mainMenuButton.mainMenu());
                }default -> {
                    if (text.endsWith("MB")) sendMessage = ucellMenuButton.mbPaket(message);

                    else if (text.endsWith("daqiqa")) sendMessage = ucellMenuButton.daqPaket(message);

                    else if (text.endsWith("SMS")) sendMessage = ucellMenuButton.smsPaket(message);

                    else sendMessage = ucellMenuButton.ussdPaket(message);
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
