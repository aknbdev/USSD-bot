package a.k.n.b.USSD.bot.menu.telecom;
import a.k.n.b.USSD.bot.db.MTMSTelecomDB;
import a.k.n.b.USSD.bot.model.Daq;
import a.k.n.b.USSD.bot.model.MB;
import a.k.n.b.USSD.bot.model.SMS;
import a.k.n.b.USSD.bot.model.USSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelecomRepository {
    @Autowired private MTMSTelecomDB mtmsRepository;

    public void handle() {
        MB mb = new MB();{
            mb.setMb("1000 MB");
            mb.setCost("9 000 SO'M");
            mb.setPeriod("30 kun");
            mb.setUssd("*147*10072*46699#");
            mtmsRepository.getMbMap().put(mb.getMb(), mb);
        }
        MB mb1 = new MB();{
            mb1.setMb("1500 MB");
            mb1.setCost("14 000 SO'M");
            mb1.setPeriod("30 kun");
            mb1.setUssd("*147*10073*46699#");
            mtmsRepository.getMbMap().put(mb1.getMb(), mb1);
        }
        MB mb2 = new MB();{
            mb2.setMb("3000 MB");
            mb2.setCost("18 000 SO'M");
            mb2.setPeriod("30 kun");
            mb2.setUssd("*147*10074*46699#");
            mtmsRepository.getMbMap().put(mb2.getMb(), mb2);
        }
        MB mb3 = new MB();{
            mb3.setMb("5000 MB");
            mb3.setCost("25 000 SO'M");
            mb3.setPeriod("30 kun");
            mb3.setUssd("*147*10075*46699#");
            mtmsRepository.getMbMap().put(mb3.getMb(), mb3);
        }
        MB mb4 = new MB();{
            mb4.setMb("8000 MB");
            mb4.setCost("35 000 SO'M");
            mb4.setPeriod("30 kun");
            mb4.setUssd("*147*10076*46699#");
            mtmsRepository.getMbMap().put(mb4.getMb(), mb4);
        }
        MB mb5 = new MB();{
            mb5.setMb("12000 MB");
            mb5.setCost("50 000 SO'M");
            mb5.setPeriod("30 kun");
            mb5.setUssd("*147*10077*46699#");
            mtmsRepository.getMbMap().put(mb5.getMb(), mb5);
        }
        MB mb6 = new MB();{
            mb6.setMb("16000 MB");
            mb6.setCost("60 000 SO'M");
            mb6.setPeriod("30 kun");
            mb6.setUssd("*147*10267*46699#");
            mtmsRepository.getMbMap().put(mb6.getMb(), mb6);
        }
        MB mb7 = new MB();{
            mb7.setMb("20000 MB");
            mb7.setCost("65 000 SO'M");
            mb7.setPeriod("30 kun");
            mb7.setUssd("*147*10078*46699#");
            mtmsRepository.getMbMap().put(mb7.getMb(), mb7);
        }
        MB mb8 = new MB();{
            mb8.setMb("30000 MB");
            mb8.setCost("75 000 SO'M");
            mb8.setPeriod("30 kun");
            mb8.setUssd("*147*10079*46699#");
            mtmsRepository.getMbMap().put(mb8.getMb(), mb8);
        }
        MB mb9 = new MB();{
            mb9.setMb("50000 MB");
            mb9.setCost("85 000 SO'M");
            mb9.setPeriod("30 kun");
            mb9.setUssd("*147*10080*46699#");
            mtmsRepository.getMbMap().put(mb9.getMb(), mb9);
        }
        MB mb10 = new MB();{
            mb10.setMb("75000 MB");
            mb10.setCost("110 000 SO'M");
            mb10.setPeriod("30 kun");
            mb10.setUssd("*147*10150*46699#");
            mtmsRepository.getMbMap().put(mb10.getMb(), mb10);
        }
        Daq daq = new Daq();{
            daq.setMinute("100 daqiqa");
            daq.setPrice("4 000 SO'M");
            daq.setPeriod("30 kun");
            daq.setUssd("*111*1*3*1#");
            mtmsRepository.getDaqMap().put(daq.getMinute(), daq);
        }
        Daq daq1 = new Daq();{
            daq1.setMinute("300 daqiqa");
            daq1.setPrice("10 000 SO'M");
            daq1.setPeriod("30 kun");
            daq1.setUssd("*111*1*3*2#");
            mtmsRepository.getDaqMap().put(daq1.getMinute(), daq1);
        }
        Daq daq2 = new Daq();{
            daq2.setMinute("600 daqiqa");
            daq2.setPrice("16 000 SO'M");
            daq2.setPeriod("30 kun");
            daq2.setUssd("*111*1*3*3#");
            mtmsRepository.getDaqMap().put(daq2.getMinute(), daq2);
        }
        Daq daq3 = new Daq();{
            daq3.setMinute("1200 daqiqa");
            daq3.setPrice("24 000 SO'M");
            daq3.setPeriod("30 kun");
            daq3.setUssd("*111*1*3*4#");
            mtmsRepository.getDaqMap().put(daq3.getMinute(), daq3);
        }
        SMS sms = new SMS();{
            sms.setSms("10 SMS");
            sms.setPrice("420 SO'M");
            sms.setPeriod("30 kun");
            sms.setUssd("*111*1*1*1#");
            mtmsRepository.getSmsMap().put(sms.getSms(), sms);
        }
        SMS sms1 = new SMS();{
            sms1.setSms("50 SMS");
            sms1.setPrice("1 680 SO'M");
            sms1.setPeriod("30 kun");
            sms1.setUssd("*111*1*1*2#");
            mtmsRepository.getSmsMap().put(sms1.getSms(), sms1);
        }
        SMS sms2 = new SMS();{
            sms2.setSms("200 SMS");
            sms2.setPrice("5 200 SO'M");
            sms2.setPeriod("30 kun");
            sms2.setUssd("*111*1*1*3#");
            mtmsRepository.getSmsMap().put(sms2.getSms(), sms2);
        }
        SMS sms3 = new SMS();{
            sms3.setSms("500 SMS");
            sms3.setPrice("9 500 SO'M");
            sms3.setPeriod("30 kun");
            sms3.setUssd("*111*1*1*4#");
            mtmsRepository.getSmsMap().put(sms3.getSms(), sms3);
        }
        USSD ussd = new USSD();{
            ussd.setUssd("*100#");
            ussd.setName("Hisobni boshqarish");
            ussd.setData("""
					Xisobingizni boshqarish uchun
					Bu yerda siz xisobingiz xaqida ma'lumotlar
					olishingiz va xizmatlarga ulanishingiz mumkin""");
            mtmsRepository.getUssdMap().put(ussd.getName(), ussd);
        }
        USSD ussd1 = new USSD();{
            ussd1.setUssd("*150#");
            ussd1.setName("Qarz olish xizmati");
            ussd1.setData("""
					Bu xizmatdan foydalanib, qarzga
					shaxsiy xisobingizni to'ldirishingiz mumkin
					Xizmat pullik""");
            mtmsRepository.getUssdMap().put(ussd1.getName(), ussd1);
        }
        USSD ussd2 = new USSD();{
            ussd2.setUssd("*100*1#");
            ussd2.setName("Balansni tekshirish");
            ussd2.setData("""
					Xisobingizdagi mablag' qoldiqni ko'rish
					uchun ushbu kodni yuboring""");
            mtmsRepository.getUssdMap().put(ussd2.getName(), ussd2);
        }
        USSD ussd3 = new USSD();{
            ussd3.setUssd("*100*2#");
            ussd3.setName("Qoldiqni tekshirish");
            ussd3.setData("""
					Xisobingizda qolgan daqiqalar, SMSlar,
					hamda trafik qoldiqlarini ko'rishingiz mumkin""");
            mtmsRepository.getUssdMap().put(ussd3.getName(), ussd3);
        }
        USSD ussd4 = new USSD();{
            ussd4.setUssd("*100*4#");
            ussd4.setName("Mening raqamim");
            ussd4.setData("""
					Telefon raqamingizni aniqlash uchun,
					ushbu kodni yuboring""");
            mtmsRepository.getUssdMap().put(ussd4.getName(), ussd4);
        }
        USSD ussd5 = new USSD();{
            ussd5.setUssd("*100*5#");
            ussd5.setName("Mening raqamlarim");
            ussd5.setData("""
					Pasportingizga ro'yhatdan o'tgan hamma telefon
					raqamlarni ro'yhatini olishingiz mumkin""");
            mtmsRepository.getUssdMap().put(ussd5.getName(), ussd5);
        }
        USSD ussd6 = new USSD();{
            ussd6.setUssd("*100*2*7*1#");
            ussd6.setName("4G LTE Yoqish");
            ussd6.setData("Sim kartangizda 4G 'LTE' xizmatini yoqishingiz mumkin");
            mtmsRepository.getUssdMap().put(ussd6.getName(), ussd6);
        }
        USSD ussd7 = new USSD();{
            ussd7.setUssd("*100*2*7*2#");
            ussd7.setName("4G LTE O'chirish");
            ussd7.setData("Sim kartangizda 4G 'LTE' xizmatini o'chirishingiz mumkin");
            mtmsRepository.getUssdMap().put(ussd7.getName(), ussd7);
        }
        USSD ussd8 = new USSD();{
            ussd8.setUssd("*555#");
            ussd8.setName("Restart xizmati");
            ussd8.setData("""
					Oylik trafik bo'yicha limitlaringiz tugasa
					shu kodni tering va oyning boshini kutib
					o'tirmasdan, tarifingiz to'lovini to'lab
					limitlarga ega bo'ling""");
            mtmsRepository.getUssdMap().put(ussd8.getName(), ussd8);
        }
        USSD ussd9 = new USSD();{
            ussd9.setUssd("*105#");
            ussd9.setName("Tarif bo'yicha qoldiq");
            ussd9.setData("""
					Tarif reja bo'yicha qolgan daqiqa, SMS
					va trafikni ko'rish""");
            mtmsRepository.getUssdMap().put(ussd9.getName(), ussd9);
        }
        USSD ussd10 = new USSD();{
            ussd10.setUssd("*199#");
            ussd10.setName("Barcha pullik xizmatlarni o'chirish");
            ussd10.setData("""
					Barcha pullik xizmatlarni bitta USSD kod orqali o'chiring""");
            mtmsRepository.getUssdMap().put(ussd10.getName(), ussd10);
        }
    }
}
