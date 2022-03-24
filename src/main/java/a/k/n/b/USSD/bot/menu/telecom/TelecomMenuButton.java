package a.k.n.b.USSD.bot.menu.telecom;
import com.vdurmont.emoji.EmojiParser;
import a.k.n.b.USSD.bot.db.MTMSTelecomDB;
import a.k.n.b.USSD.bot.model.Daq;
import a.k.n.b.USSD.bot.model.MB;
import a.k.n.b.USSD.bot.model.SMS;
import a.k.n.b.USSD.bot.model.USSD;
import a.k.n.b.USSD.bot.util.ButtonUtil;
import a.k.n.b.USSD.bot.util.InlineButtonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class TelecomMenuButton {
    @Autowired private MTMSTelecomDB mtmsRepository;
    public ReplyKeyboard telecomMainMenu() {
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button(EmojiParser.parseToUnicode(":globe_with_meridians:") + " Internet paketlar"),
                                ButtonUtil.button(EmojiParser.parseToUnicode(":clock4:") + " Daqiqa paketlar")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button(EmojiParser.parseToUnicode(":envelope:") + " SMS paketlar"),
                                ButtonUtil.button(EmojiParser.parseToUnicode(":hash:") + " USSD Kodlar")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("\uD83D\uDD1D Asosiy oynaga qaytish")
                        )
                )
        );
    }

    public ReplyKeyboard telecomIntPaket() {
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button("1000 MB"),
                                ButtonUtil.button("1500 MB"),
                                ButtonUtil.button("3000 MB")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("5000 MB"),
                                ButtonUtil.button("8000 MB"),
                                ButtonUtil.button("12000 MB")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("16000 MB"),
                                ButtonUtil.button("20000 MB"),
                                ButtonUtil.button("30000 MB")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("50000 MB"),
                                ButtonUtil.button("75000 MB")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("\uD83D\uDD19 Orqaga qaytish")
                        )
                )
        );
    }

    public ReplyKeyboard telecomDaqiqaPaket() {
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button("100 daqiqa"),
                                ButtonUtil.button("300 daqiqa")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("600 daqiqa"),
                                ButtonUtil.button("1200 daqiqa")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("\uD83D\uDD19 Orqaga qaytish")
                        )
                )
        );
    }

    public ReplyKeyboard telecomSMSPaket() {
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button("10 SMS"),
                                ButtonUtil.button("50 SMS")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("200 SMS"),
                                ButtonUtil.button("500 SMS")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("\uD83D\uDD19 Orqaga qaytish")
                        )
                )
        );
    }

    public ReplyKeyboard telecomUssdPaket() {
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button("Hisobni boshqarish"),
                                ButtonUtil.button("Qarz olish xizmati")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("Balansni tekshirish"),
                                ButtonUtil.button("Qoldiqni tekshirish")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("Mening raqamim"),
                                ButtonUtil.button("Mening raqamlarim")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("4G LTE Yoqish"),
                                ButtonUtil.button("4G LTE O'chirish")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("Restart xizmati"),
                                ButtonUtil.button("Tarif bo'yicha qoldiq")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("Barcha pullik xizmatlarni o'chirish")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("\uD83D\uDD19 Orqaga qaytish")
                        )
                )
        );
    }

    public SendMessage mbPaket(Message message) {
        SendMessage sendMessage = new SendMessage();
        String text = message.getText();
        MB mb = mtmsRepository.getMbMap().get(text);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if (mb!=null){
            sendMessage.enableHtml(true);
            sendMessage.setText(
                    "Uzmobile foydalanuvchisi uchun <b>" + mb.getMb() + "</b> paketi" +
                            "\n\n<b>Paket hajmi:</b> " + mb.getMb() +
                            "\n<b>Paket narxi:</b> " + mb.getCost() +
                            "\n<b>Muddati:</b> " + mb.getPeriod() // +
                            // "\n\n\uD83D\uDC49 <code>" + mb.getUssd() +"</code> \uD83D\uDC48"
            );
            String[] ussd = mb.getUssd().split("[*#]");
            StringBuilder index = new StringBuilder();
            index.append("https://maxvell.uz/?code=");
            int size = ussd.length;
            for (int i = 1; i<size; i++){
                index.append("%2A");
                index.append(ussd[i]);
            }
            index.append("%23"); // result = https://maxvell.uz/?code=%2A#%2A#%2A#%23
            sendMessage.setReplyMarkup(
                    InlineButtonUtil.rowsList(
                            InlineButtonUtil.rows(
                                    InlineButtonUtil.row(
                                            InlineButtonUtil.button("✅ FAOLLASHTIRISH ✅", "", index.toString())
                                    )
                            )
                    )
            );
        } else {
            sendMessage.setText("Error 404.\n⚠ Tugmani bosing!");
        }
        return sendMessage;
    }

    public SendMessage daqPaket(Message message) {
        SendMessage sendMessage = new SendMessage();
        String text = message.getText();
        Daq daq = mtmsRepository.getDaqMap().get(text);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if (daq!=null){
            sendMessage.enableHtml(true);
            sendMessage.setText(
                    "Uzmobile foydalanuvchisi uchun <b>" + daq.getMinute() + "</b> paketi" +
                            "\n\n<b>Paket hajmi:</b> " + daq.getMinute() +
                            "\n<b>Paket narxi:</b> " + daq.getPrice() +
                            "\n<b>Muddati:</b> " + daq.getPeriod() // +
                            // "\n\n\uD83D\uDC49 <code>" + daq.getUssd() + "</code> \uD83D\uDC48"
            );
            String[] ussd = daq.getUssd().split("[*#]");
            StringBuilder index = new StringBuilder();
            index.append("https://maxvell.uz/?code=");
            int size = ussd.length;
            for (int i = 1; i<size; i++){
                index.append("%2A");
                index.append(ussd[i]);
            }
            index.append("%23"); // result = https://maxvell.uz/?code=%2A#%2A#%2A#%23
            sendMessage.setReplyMarkup(
                    InlineButtonUtil.rowsList(
                            InlineButtonUtil.rows(
                                    InlineButtonUtil.row(
                                            InlineButtonUtil.button("✅ FAOLLASHTIRISH ✅", "", index.toString())
                                    )
                            )
                    )
            );
        } else {
            sendMessage.setText("Error 404.\n⚠ Tugmani bosing!");
        }
        return sendMessage;
    }

    public SendMessage smsPaket(Message message) {
        SendMessage sendMessage = new SendMessage();
        String text = message.getText();
        SMS sms = mtmsRepository.getSmsMap().get(text);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if (sms!=null){
            sendMessage.enableHtml(true);
            sendMessage.setText(
                    "Uzmobile foydalanuvchisi uchun <b>" + sms.getSms() + "</b> paketi" +
                            "\n\n<b>Paket hajmi:</b> " + sms.getSms() +
                            "\n<b>Paket narxi:</b> " + sms.getPrice() +
                            "\n<b>Muddati:</b> " + sms.getPeriod() // +
                            // "\n\n\uD83D\uDC49 <code>" + sms.getUssd() + "</code> \uD83D\uDC48"
            );
            String[] ussd = sms.getUssd().split("[*#]");
            StringBuilder index = new StringBuilder();
            index.append("https://maxvell.uz/?code=");
            int size = ussd.length;
            for (int i = 1; i<size; i++){
                index.append("%2A");
                index.append(ussd[i]);
            }
            index.append("%23"); // result = https://maxvell.uz/?code=%2A#%2A#%2A#%23
            sendMessage.setReplyMarkup(
                    InlineButtonUtil.rowsList(
                            InlineButtonUtil.rows(
                                    InlineButtonUtil.row(
                                            InlineButtonUtil.button("✅ FAOLLASHTIRISH ✅", "", index.toString())
                                    )
                            )
                    )
            );
        } else {
            sendMessage.setText("Error 404.\n⚠ Tugmani bosing!");
        }
        return sendMessage;
    }

    public SendMessage ussdPaket(Message message) {
        SendMessage sendMessage = new SendMessage();
        String text = message.getText();
        USSD ussd = mtmsRepository.getUssdMap().get(text);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if (ussd!=null){
            sendMessage.enableHtml(true);
            sendMessage.setText(
                    "Uzmobile foydalanuvchisi uchun <b>" + ussd.getName() + "</b>" +
                            "\n\n<b>Ma'lumot:</b> " + ussd.getData() // +
                            // "\n\n\uD83D\uDC49 <code>" + ussd.getUssd() + "</code> \uD83D\uDC48"
            );
            String[] ussd1 = ussd.getUssd().split("[*#]");
            StringBuilder index = new StringBuilder();
            index.append("https://maxvell.uz/?code=");
            int size = ussd1.length;
            for (int i = 1; i<size; i++){
                index.append("%2A");
                index.append(ussd1[i]);
            }
            index.append("%23"); // result = https://maxvell.uz/?code=%2A#%2A#%2A#%23
            sendMessage.setReplyMarkup(
                    InlineButtonUtil.rowsList(
                            InlineButtonUtil.rows(
                                    InlineButtonUtil.row(
                                            InlineButtonUtil.button("✅ FAOLLASHTIRISH ✅", "", index.toString())
                                    )
                            )
                    )
            );
        } else{
            sendMessage.setText("⚠️ Kutilmagan buyruq...");
        }
        return sendMessage;
    }
}