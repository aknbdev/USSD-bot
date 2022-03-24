package a.k.n.b.USSD.bot.menu.beeline;
import a.k.n.b.USSD.bot.db.MTMSBeelineDB;
import a.k.n.b.USSD.bot.model.Daq;
import a.k.n.b.USSD.bot.model.MB;
import a.k.n.b.USSD.bot.model.SMS;
import a.k.n.b.USSD.bot.model.USSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeelineRepository {
    @Autowired private MTMSBeelineDB mtmsBeelineRepository;

    public void handle() {
        MB mb = new MB();{
            mb.setMb("1000 MB");
            mb.setCost("10 300 SO'M");
            mb.setPeriod("30 kun");
            mb.setUssd("*1*01*6064#");
            mtmsBeelineRepository.getMbMap().put(mb.getMb(), mb);
        }
        MB mb7 = new MB();{
            mb7.setMb("2000 MB");
            mb7.setCost("15 300 SO'M");
            mb7.setPeriod("30 kun");
            mb7.setUssd("*1*02*6064#");
            mtmsBeelineRepository.getMbMap().put(mb7.getMb(), mb7);
        }
        MB mb1 = new MB();{
            mb1.setMb("5000 MB");
            mb1.setCost("25 300 SO'M");
            mb1.setPeriod("30 kun");
            mb1.setUssd("*1*05*6064#");
            mtmsBeelineRepository.getMbMap().put(mb1.getMb(), mb1);
        }
        MB mb2 = new MB();{
            mb2.setMb("10000 MB");
            mb2.setCost("40 300 SO'M");
            mb2.setPeriod("30 kun");
            mb2.setUssd("*1*10*6064#");
            mtmsBeelineRepository.getMbMap().put(mb2.getMb(), mb2);
        }
        MB mb3 = new MB();{
            mb3.setMb("20000 MB");
            mb3.setCost("65 300 SO'M");
            mb3.setPeriod("30 kun");
            mb3.setUssd("*1*20*6064#");
            mtmsBeelineRepository.getMbMap().put(mb3.getMb(), mb3);
        }
        MB mb4 = new MB();{
            mb4.setMb("30000 MB");
            mb4.setCost("75 300 SO'M");
            mb4.setPeriod("30 kun");
            mb4.setUssd("*1*30*6064#");
            mtmsBeelineRepository.getMbMap().put(mb4.getMb(), mb4);
        }
        MB mb5 = new MB();{
            mb5.setMb("50000 MB");
            mb5.setCost("90 300 SO'M");
            mb5.setPeriod("30 kun");
            mb5.setUssd("*1*50*6064#");
            mtmsBeelineRepository.getMbMap().put(mb5.getMb(), mb5);
        }
        MB mb6 = new MB();{
            mb6.setMb("75000 MB");
            mb6.setCost("110 300 SO'M");
            mb6.setPeriod("30 kun");
            mb6.setUssd("*1*75*6064#");
            mtmsBeelineRepository.getMbMap().put(mb6.getMb(), mb6);
        }
        Daq daq = new Daq();{
            daq.setMinute("200 daqiqa");
            daq.setPrice("10 000 SO'M");
            daq.setPeriod("""
                    30 kun""");
            daq.setUssd("*110*500#"); // done
            mtmsBeelineRepository.getDaqMap().put(daq.getMinute(), daq);
        }
        Daq daq1 = new Daq();{
            daq1.setMinute("400 daqiqa");
            daq1.setPrice("18 000 SO'M");
            daq1.setPeriod("""
                    30 kun""");
            daq1.setUssd("*110*501#"); // done
            mtmsBeelineRepository.getDaqMap().put(daq1.getMinute(), daq1);
        }
        Daq daq2 = new Daq();{
            daq2.setMinute("600 daqiqa");
            daq2.setPrice("25 000 SO'M");
            daq2.setPeriod("""
                    30 kun""");
            daq2.setUssd("*110*502#"); // done
            mtmsBeelineRepository.getDaqMap().put(daq2.getMinute(), daq2);
        }
        SMS sms = new SMS();{
            sms.setSms("100 SMS");
            sms.setPrice("5 263 SO'M");
            sms.setPeriod("30 kun");
            sms.setUssd("*110*044#");
            mtmsBeelineRepository.getSmsMap().put(sms.getSms(), sms);
        }
        SMS sms1 = new SMS();{
            sms1.setSms("500 SMS");
            sms1.setPrice("13 683 SO'M");
            sms1.setPeriod("30 kun");
            sms1.setUssd("*110*045#");
            mtmsBeelineRepository.getSmsMap().put(sms1.getSms(), sms1);
        }
        SMS sms2 = new SMS();{
            sms2.setSms("1000 SMS");
            sms2.setPrice("22 103 SO'M");
            sms2.setPeriod("30 kun");
            sms2.setUssd("*110*046#");
            mtmsBeelineRepository.getSmsMap().put(sms2.getSms(), sms2);
        }
        USSD ussd = new USSD();{
            ussd.setUssd("*102#");
            ussd.setName("Hisobni tekshirish");
            ussd.setData("""
					Xisobingizdagi qoldiqni ko'rish uchun ushbu kodni yuborishingiz mumkin""");
            mtmsBeelineRepository.getUssdMap().put(ussd.getName(), ussd);
        }
        USSD ussd1 = new USSD();{
            ussd1.setUssd("*101#");
            ussd1.setName("MB qoldig'i (IJT. TARM.)");
            ussd1.setData("""
                    Ijtimoiy tarmoqlar uchun berilgan trafik qoldig'ini ko'rish uchun""");
            mtmsBeelineRepository.getUssdMap().put(ussd1.getName(), ussd1);
        }
        USSD ussd2 = new USSD();{
            ussd2.setUssd("*103#");
            ussd2.setName("MB qoldig'i");
            ussd2.setData("""
                    Sotib olingan internet trafik paketlari, hamda bonus trafik qoldiqlarini ko'rish""");
            mtmsBeelineRepository.getUssdMap().put(ussd2.getName(), ussd2);
        }
        USSD ussd3 = new USSD();{
            ussd3.setUssd("*109#");
            ussd3.setName("MB qoldig'i (TAS-IX)");
            ussd3.setData("""
                    Tas-ix tarmog'i ichida ishlatish uchun sotib olingan internet trafik paketlari, hamda bonus trafik qoldiqlarini ko'rish""");
            mtmsBeelineRepository.getUssdMap().put(ussd3.getName(), ussd3);
        }
        USSD ussd4 = new USSD();{
            ussd4.setUssd("*104* karta raqami #");
            ussd4.setName("Express to'lov");
            ussd4.setData("""
                    Express to'lov kartalari orqali hisobingizni to'ldirish.""");
            mtmsBeelineRepository.getUssdMap().put(ussd4.getName(), ussd4);
        }
        USSD ussd5 = new USSD();{
            ussd5.setUssd("*105#");
            ussd5.setName("SMSlar qoldig'i");
            ussd5.setData("""
                    Hisobingizda qolgan bepul SMSlar haqida ma'lumot""");
            mtmsBeelineRepository.getUssdMap().put(ussd5.getName(), ussd5);
        }
        USSD ussd6 = new USSD();{
            ussd6.setUssd("*106#");
            ussd6.setName("Daqiqalar qoldig'i");
            ussd6.setData("""
                    Hisobingizda qolgan bepul daqiqalar haqida ma'lumot""");
            mtmsBeelineRepository.getUssdMap().put(ussd6.getName(), ussd6);
        }
        USSD ussd7 = new USSD();{
            ussd7.setUssd("*148#");
            ussd7.setName("Raqamni aniqlash");
            ussd7.setData("""
                    SIM kartangizning telefon raqamini aniqlash uchun ushbu kodni yuboring""");
            mtmsBeelineRepository.getUssdMap().put(ussd7.getName(), ussd7);
        }
        USSD ussd8 = new USSD();{
            ussd8.setUssd("*110*05#");
            ussd8.setName("Tarif rejam");
            ussd8.setData("""
                    Xozirda qaysi tarif rejada bo'lganingizni tekshirish uchun ushbu kodni yuboring. Javobi SMS tariqasida keladi""");
            mtmsBeelineRepository.getUssdMap().put(ussd8.getName(), ussd8);
        }
        USSD ussd9 = new USSD();{
            ussd9.setUssd("*110*09#");
            ussd9.setName("Qo'shimcha xizmatlar");
            ussd9.setData("""
                    Yoqilgan qo'shimcha xizmatlar ro'yxatini ko'rish. Javobi SMS orqali keladi""");
            mtmsBeelineRepository.getUssdMap().put(ussd9.getName(), ussd9);
        }
        USSD ussd10 = new USSD();{
            ussd10.setUssd("*303#");
            ussd10.setName("Mening raqamlarim");
            ussd10.setData("""
                    Pasportingizga ro'yxatdan o'tgan hamma telefon raqamlarni ro'yxatini olish. Javobi SMS orqali keladi""");
            mtmsBeelineRepository.getUssdMap().put(ussd10.getName(), ussd10);
        }
    }
}
