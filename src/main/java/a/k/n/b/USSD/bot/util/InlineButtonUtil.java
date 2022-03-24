package a.k.n.b.USSD.bot.util;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class InlineButtonUtil {

    public static InlineKeyboardButton button (String text, String callback, String url){
        InlineKeyboardButton inlineButton = new InlineKeyboardButton(text);
        inlineButton.setUrl(url);
        inlineButton.setCallbackData(callback);
        return inlineButton;
    }

    public static List<InlineKeyboardButton> row (InlineKeyboardButton... inlineKeyboardButtons){
        return new LinkedList<>(Arrays.asList(inlineKeyboardButtons));
    }

    @SafeVarargs
    public static List<List<InlineKeyboardButton>> rows (List<InlineKeyboardButton>... rows){
        return new LinkedList<>(Arrays.asList(rows));
    }

    public static InlineKeyboardMarkup rowsList(List<List<InlineKeyboardButton>> rowsList){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowsList);
        return inlineKeyboardMarkup;
    }
}
