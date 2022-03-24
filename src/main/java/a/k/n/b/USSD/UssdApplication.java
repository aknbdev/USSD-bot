package a.k.n.b.USSD;
import a.k.n.b.USSD.bot.menu.beeline.BeelineRepository;
import a.k.n.b.USSD.bot.menu.mobiuz.MobiuzRepository;
import a.k.n.b.USSD.bot.menu.telecom.TelecomRepository;
import a.k.n.b.USSD.bot.menu.ucell.UcellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UssdApplication implements CommandLineRunner {
	@Autowired private TelecomRepository telecomDB;
	@Autowired private BeelineRepository beelineDB;
	@Autowired private MobiuzRepository mobiuzDB;
	@Autowired private UcellRepository ucellDB;

	public static void main(String[] args) {
		SpringApplication.run(UssdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		telecomDB.handle();
		beelineDB.handle();
		mobiuzDB.handle();
		ucellDB.handle();
	}
}
