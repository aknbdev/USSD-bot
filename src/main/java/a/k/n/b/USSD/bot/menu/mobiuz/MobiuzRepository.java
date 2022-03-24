package a.k.n.b.USSD.bot.menu.mobiuz;
import a.k.n.b.USSD.bot.db.MTMSMobiuzDB;
import a.k.n.b.USSD.bot.model.Daq;
import a.k.n.b.USSD.bot.model.MB;
import a.k.n.b.USSD.bot.model.SMS;
import a.k.n.b.USSD.bot.model.USSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MobiuzRepository {
    @Autowired private MTMSMobiuzDB mtmsMobiuzRepository;

    public void handle(){
        MB mb = new MB();{
            mb.setMb("300 MB");
            mb.setCost("8 000 SO'M");
            mb.setPeriod("30 kun");
            mb.setUssd("*171*019*1*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb.getMb(), mb);
        }
        MB mb1 = new MB();{
            mb1.setMb("500 MB");
            mb1.setCost("9 000 SO'M");
            mb1.setPeriod("30 kun");
            mb1.setUssd("*171*019*7*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb1.getMb(), mb1);
        }
        MB mb2 = new MB();{
            mb2.setMb("1000 MB");
            mb2.setCost("11 000 SO'M");
            mb2.setPeriod("30 kun");
            mb2.setUssd("*171*019*2*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb2.getMb(), mb2);
        }
        MB mb3 = new MB();{
            mb3.setMb("2000 MB");
            mb3.setCost("17 000 SO'M");
            mb3.setPeriod("30 kun");
            mb3.setUssd("*171*019*5*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb3.getMb(), mb3);
        }
        MB mb4 = new MB();{
            mb4.setMb("3000 MB");
            mb4.setCost("25 000 SO'M");
            mb4.setPeriod("30 kun");
            mb4.setUssd("*171*019*3*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb4.getMb(), mb4);
        }
        MB mb5 = new MB();{
            mb5.setMb("5000 MB");
            mb5.setCost("33 000 SO'M");
            mb5.setPeriod("30 kun");
            mb5.setUssd("*171*019*4*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb5.getMb(), mb5);
        }
        MB mb6 = new MB();{
            mb6.setMb("10000 MB");
            mb6.setCost("50 000 SO'M");
            mb6.setPeriod("30 kun");
            mb6.setUssd("*171*019*6*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb6.getMb(), mb6);
        }
        MB mb7 = new MB();{
            mb7.setMb("20000 MB");
            mb7.setCost("55 000 SO'M");
            mb7.setPeriod("30 kun");
            mb7.setUssd("*171*019*8*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb7.getMb(), mb7);
        }
        MB mb8 = new MB();{
            mb8.setMb("30000 MB");
            mb8.setCost("65 000 SO'M");
            mb8.setPeriod("30 kun");
            mb8.setUssd("*171*019*9*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb8.getMb(), mb8);
        }
        MB mb9 = new MB();{
            mb9.setMb("50000 MB");
            mb9.setCost("75 000 SO'M");
            mb9.setPeriod("30 kun");
            mb9.setUssd("*171*019*10*011000146*1#");
            mtmsMobiuzRepository.getMbMap().put(mb9.getMb(), mb9);
        }
        Daq daq = new Daq();{
            daq.setMinute("60 daqiqa");
            daq.setPrice("4 000 SO'M");
            daq.setPeriod("""
                    30 kun""");
            daq.setUssd("*171*103*60*1*010300368*1#");
            mtmsMobiuzRepository.getDaqMap().put(daq.getMinute(), daq);
        }
        Daq daq1 = new Daq();{
            daq1.setMinute("120 daqiqa");
            daq1.setPrice("7 000 SO'M");
            daq1.setPeriod("""
                    30 kun""");
            daq1.setUssd("*171*103*120*1*010300368*1#");
            mtmsMobiuzRepository.getDaqMap().put(daq1.getMinute(), daq1);
        }
        Daq daq2 = new Daq();{
            daq2.setMinute("180 daqiqa");
            daq2.setPrice("10 000 SO'M");
            daq2.setPeriod("""
                    30 kun""");
            daq2.setUssd("*171*103*180*1*010300368*1#");
            mtmsMobiuzRepository.getDaqMap().put(daq2.getMinute(), daq2);
        }
        Daq daq3 = new Daq();{
            daq3.setMinute("300 daqiqa");
            daq3.setPrice("16 000 SO'M");
            daq3.setPeriod("""
                    30 kun""");
            daq3.setUssd("*171*103*300*1*010300368*1#");
            mtmsMobiuzRepository.getDaqMap().put(daq3.getMinute(), daq3);
        }
        Daq daq4 = new Daq();{
            daq4.setMinute("900 daqiqa");
            daq4.setPrice("37 000 SO'M");
            daq4.setPeriod("""
                    30 kun""");
            daq4.setUssd("*171*103*900*1*010300368*1#");
            mtmsMobiuzRepository.getDaqMap().put(daq4.getMinute(), daq4);
        }
        Daq daq5 = new Daq();{
            daq5.setMinute("1200 daqiqa");
            daq5.setPrice("45 000 SO'M");
            daq5.setPeriod("""
                    30 kun""");
            daq5.setUssd("*171*103*1200*1*010300368*1#");
            mtmsMobiuzRepository.getDaqMap().put(daq5.getMinute(), daq5);
        }
        Daq daq6 = new Daq();{
            daq6.setMinute("1800 daqiqa");
            daq6.setPrice("62 000 SO'M");
            daq6.setPeriod("""
                    30 kun""");
            daq6.setUssd("*171*103*1800*1*010300368*1#");
            mtmsMobiuzRepository.getDaqMap().put(daq6.getMinute(), daq6);
        }
        SMS sms = new SMS();{
            sms.setSms("100 SMS");
            sms.setPrice("4 500 SO'M");
            sms.setPeriod("30 kun");
            sms.setUssd("*171*018*1*010300368*1#");
            mtmsMobiuzRepository.getSmsMap().put(sms.getSms(), sms);
        }
        SMS sms1 = new SMS();{
            sms1.setSms("300 SMS");
            sms1.setPrice("10 500 SO'M");
            sms1.setPeriod("30 kun");
            sms1.setUssd("*171*018*2*010300368*1#");
            mtmsMobiuzRepository.getSmsMap().put(sms1.getSms(), sms1);
        }
        USSD ussd = new USSD();{
            ussd.setUssd("*100#");
            ussd.setName("Balans tekshirish");
            ussd.setData("""
					Balansingizdagi mablag'ni tekshiring.""");
            mtmsMobiuzRepository.getUssdMap().put(ussd.getName(), ussd);
        }
        USSD ussd1 = new USSD();{
            ussd1.setUssd("*102#");
            ussd1.setName("Trafik qoldig'i");
            ussd1.setData("""
                    Trafik qoldig'ini tekshirish""");
            mtmsMobiuzRepository.getUssdMap().put(ussd1.getName(), ussd1);
        }
        USSD ussd2 = new USSD();{
            ussd2.setUssd("*102*0#");
            ussd2.setName("Bonus internet qoldig'i");
            ussd2.setData("""
                    Bonusli internet to'plamlarini tekshirish""");
            mtmsMobiuzRepository.getUssdMap().put(ussd2.getName(), ussd2);
        }
        USSD ussd3 = new USSD();{
            ussd3.setUssd("*103#");
            ussd3.setName("Daqiqalar qoldig'i");
            ussd3.setData("""
                    Daqiqalar to'plami sotib olgan bo'lsangiz,
                    bu kodni ishlatib o'z hisobingizda qolgan
                    daqiqalarni ko'rishingiz mumkin""");
            mtmsMobiuzRepository.getUssdMap().put(ussd3.getName(), ussd3);
        }
        USSD ussd4 = new USSD();{
            ussd4.setUssd("*104#");
            ussd4.setName("SMS qoldig'i");
            ussd4.setData("""
                    SMS to'plami sotib olgan bo'lsangiz,
                    bu kodni ishlatib, o'z hisobingizda qolgan
                    SMSlar sonini tekshirishingiz mumkin.""");
            mtmsMobiuzRepository.getUssdMap().put(ussd4.getName(), ussd4);
        }
        USSD ussd5 = new USSD();{
            ussd5.setUssd("*200#");
            ussd5.setName("Tungi drive qoldig'i");
            ussd5.setData("""
                    Tungi Drive xizmati MBlar qoldig'ini
                    tekshirishingiz mumkin""");
            mtmsMobiuzRepository.getUssdMap().put(ussd5.getName(), ussd5);
        }
        USSD ussd6 = new USSD();{
            ussd6.setUssd("*203#");
            ussd6.setName("Tungi internet qoldig'i");
            ussd6.setData("""
                    Tungi internet to'plamlari xizmati
                    doirasidagi MBlar qoldig'ini tekshirish""");
            mtmsMobiuzRepository.getUssdMap().put(ussd6.getName(), ussd6);
        }
        USSD ussd7 = new USSD();{
            ussd7.setUssd("*204#");
            ussd7.setName("Kunlik internet qoldig'i");
            ussd7.setData("""
                    Tungi internet to'plamlari xizmati
                    doirasidagi MBlar qoldig'ini tekshirish""");
            mtmsMobiuzRepository.getUssdMap().put(ussd7.getName(), ussd7);
        }
        USSD ussd8 = new USSD();{
            ussd8.setUssd("*140#");
            ussd8.setName("Mening xizmatlarim");
            ussd8.setData("""
                    Faollashtirilgan xizmatlarni tekshirish
                    uchun ushbu koddan foydalaning""");
            mtmsMobiuzRepository.getUssdMap().put(ussd8.getName(), ussd8);
        }
        USSD ussd9 = new USSD();{
            ussd9.setUssd("*151#");
            ussd9.setName("Mening Raqamlarim");
            ussd9.setData("""
                    Telefon raqam ro'yxatdan o'tgan fuqaro haqida ma'lumot""");
            mtmsMobiuzRepository.getUssdMap().put(ussd9.getName(), ussd9);
        }
        USSD ussd10 = new USSD();{
            ussd10.setUssd("*166#");
            ussd10.setName("(Gap ko'p) xizmati");
            ussd10.setData("""
                    Tarmoq ichida cheksiz muloqot. Mobi 50
                    va yuqori tarif egalari uchun tekin.
                    Qolganlarga 10 000 so'm.""");
            mtmsMobiuzRepository.getUssdMap().put(ussd10.getName(), ussd10);
        }
        USSD ussd11 = new USSD();{
            ussd11.setUssd("*111*025#");
            ussd11.setName("Mening xarajatlarim");
            ussd11.setData("""
                    Sizning xarajatlaringiz""");
            mtmsMobiuzRepository.getUssdMap().put(ussd11.getName(), ussd11);
        }
        USSD ussd12 = new USSD();{
            ussd12.setUssd("*111*32#");
            ussd12.setName("Qarz olish");
            ussd12.setData("""
                    Xisobingizda mablag' qolmaganida,
                    qarz oling va aloqada qoling""");
            mtmsMobiuzRepository.getUssdMap().put(ussd12.getName(), ussd12);
        }
        USSD ussd13 = new USSD();{
            ussd13.setUssd("*111*320#");
            ussd13.setName("Qarz qoldig'i");
            ussd13.setData("""
                    Vada qilingan to'lov xizmati qoldig'ini tekshirish""");
            mtmsMobiuzRepository.getUssdMap().put(ussd13.getName(), ussd13);
        }
    }
}
