package a.k.n.b.USSD.bot.dto;
import a.k.n.b.USSD.bot.enums.MenuType;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Component
@Data
public class Menu {
    private Map<Long, MenuType> menuMap = new HashMap<>();
    private HashSet<Long> set = new HashSet<>();
}
