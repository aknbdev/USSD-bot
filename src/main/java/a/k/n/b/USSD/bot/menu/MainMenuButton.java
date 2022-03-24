package a.k.n.b.USSD.bot.menu;
import a.k.n.b.USSD.bot.util.ButtonUtil;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
public class MainMenuButton {
    public ReplyKeyboardMarkup mainMenu(){
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button("UZMOBILE"),
                                ButtonUtil.button("Ucell")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("mobiuz"),
                                ButtonUtil.button("Beeline")
                        )
                )
        );
    }
}
