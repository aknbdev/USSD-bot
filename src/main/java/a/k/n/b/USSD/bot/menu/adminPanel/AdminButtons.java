package a.k.n.b.USSD.bot.menu.adminPanel;
import a.k.n.b.USSD.bot.util.ButtonUtil;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class AdminButtons {

    public ReplyKeyboard panel() {
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button("ADVERTISEMENT")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("\uD83E\uDDD1\u200D\uD83D\uDCBB User_Mode"),
                                ButtonUtil.button("\uD83D\uDCCA Statics")
                        ),
                        ButtonUtil.row(
                                ButtonUtil.button("➕ Add Users"),
                                ButtonUtil.button("\uD83D\uDCCB USERS ID")
                        )
                )
        );
    }

    public ReplyKeyboard yesNo() {
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button("Send"),
                                ButtonUtil.button("Cancel")
                        )
                )
        );
    }

    public ReplyKeyboard no() {
        return ButtonUtil.keyboardMarkup(
                ButtonUtil.rows(
                        ButtonUtil.row(
                                ButtonUtil.button("Cancel")
                        )
                )
        );
    }
}
