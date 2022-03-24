package a.k.n.b.USSD.bot.util;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.LinkedList;
import java.util.List;

@Component
public class ButtonUtil {
    public static KeyboardButton button(String text){
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText(text);
        return keyboardButton;
    }

    public static KeyboardRow row(KeyboardButton... row){
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.addAll(List.of(row));
        return keyboardRow;
    }

    public static List<KeyboardRow> rows(KeyboardRow... rows){
        return new LinkedList<>(List.of(rows));
    }

    public static ReplyKeyboardMarkup keyboardMarkup(List<KeyboardRow> collection){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(collection);
        return replyKeyboardMarkup;
    }
}
