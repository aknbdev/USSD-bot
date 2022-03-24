package a.k.n.b.USSD.bot.dto;
import a.k.n.b.USSD.bot.enums.MenuType;
import a.k.n.b.USSD.bot.model.Check;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class MenuState {
    private Map<Long, MenuType> menuMap = new HashMap<>();
    private Map<Long, Check> checkMap = new HashMap<>();
}
