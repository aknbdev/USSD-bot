package a.k.n.b.USSD.bot.menu.ucell;
import a.k.n.b.USSD.bot.db.MTMSUcellDB;
import a.k.n.b.USSD.bot.model.Daq;
import a.k.n.b.USSD.bot.model.MB;
import a.k.n.b.USSD.bot.model.SMS;
import a.k.n.b.USSD.bot.model.USSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UcellRepository {
    @Autowired private MTMSUcellDB mtmsRepository;
    public void handle(){
        MB mb = new MB();{
            mb.setMb("1000 MB");
            mb.setCost("8 900 SO'M");
            mb.setPeriod("30 kun");
            mb.setUssd("*558*1*1*16930#");
            mtmsRepository.getMbMap().put(mb.getMb(), mb);
        }
        MB mb1 = new MB();{
            mb1.setMb("1500 MB");
            mb1.setCost("13 000 SO'M");
            mb1.setPeriod("30 kun");
            mb1.setUssd("*558*1*2*16930#");
            mtmsRepository.getMbMap().put(mb1.getMb(), mb1);
        }
        MB mb2 = new MB();{
            mb2.setMb("2000 MB");
            mb2.setCost("15 000 SO'M");
            mb2.setPeriod("30 kun");
            mb2.setUssd("*558*1*3*16930#");
            mtmsRepository.getMbMap().put(mb2.getMb(), mb2);
        }
        MB mb3 = new MB();{
            mb3.setMb("4000 MB");
            mb3.setCost("25 000 SO'M");
            mb3.setPeriod("30 kun");
            mb3.setUssd("*558*1*4*16930#");
            mtmsRepository.getMbMap().put(mb3.getMb(), mb3);
        }
        MB mb4 = new MB();{
            mb4.setMb("7000 MB");
            mb4.setCost("35 000 SO'M");
            mb4.setPeriod("30 kun");
            mb4.setUssd("*558*1*5*16930#");
            mtmsRepository.getMbMap().put(mb4.getMb(), mb4);
        }
        MB mb5 = new MB();{
            mb5.setMb("10000 MB");
            mb5.setCost("45 000 SO'M");
            mb5.setPeriod("30 kun");
            mb5.setUssd("*558*1*13*16930#");
            mtmsRepository.getMbMap().put(mb5.getMb(), mb5);
        }
        MB mb12 = new MB();{
            mb12.setMb("13000 MB");
            mb12.setCost("55 000 SO'M");
            mb12.setPeriod("30 kun");
            mb12.setUssd("*558*1*6*16930#");
            mtmsRepository.getMbMap().put(mb12.getMb(), mb12);
        }
        MB mb6 = new MB();{
            mb6.setMb("20000 MB");
            mb6.setCost("65 000 SO'M");
            mb6.setPeriod("30 kun");
            mb6.setUssd("*558*1*7*16930#");
            mtmsRepository.getMbMap().put(mb6.getMb(), mb6);
        }
        MB mb7 = new MB();{
            mb7.setMb("30000 MB");
            mb7.setCost("75 000 SO'M");
            mb7.setPeriod("30 kun");
            mb7.setUssd("*558*1*8*16930#");
            mtmsRepository.getMbMap().put(mb7.getMb(), mb7);
        }
        MB mb8 = new MB();{
            mb8.setMb("50000 MB");
            mb8.setCost("85 000 SO'M");
            mb8.setPeriod("30 kun");
            mb8.setUssd("*558*1*9*16930#");
            mtmsRepository.getMbMap().put(mb8.getMb(), mb8);
        }
        MB mb9 = new MB();{
            mb9.setMb("80000 MB");
            mb9.setCost("115 000 SO'M");
            mb9.setPeriod("30 kun");
            mb9.setUssd("*558*1*10*16930#");
            mtmsRepository.getMbMap().put(mb9.getMb(), mb9);
        }
        MB mb10 = new MB();{
            mb10.setMb("90000 MB");
            mb10.setCost("135 000 SO'M");
            mb10.setPeriod("30 kun");
            mb10.setUssd("*558*1*11*16930#");
            mtmsRepository.getMbMap().put(mb10.getMb(), mb10);
        }
        MB mb11 = new MB();{
            mb11.setMb("138000 MB");
            mb11.setCost("188 000 SO'M");
            mb11.setPeriod("30 kun");
            mb11.setUssd("*558*1*12*16930#");
            mtmsRepository.getMbMap().put(mb11.getMb(), mb11);
        }
        Daq daq = new Daq();{
            daq.setMinute("200 daqiqa");
            daq.setPrice("4 000 SO'M");
            daq.setPeriod("""
                    30 kun
                    <b>Dushanba - Juma:</b> 100 daqiqa.
                    <b>Shanba - Yakshanba:</b> 100 daqiqa.""");
            daq.setUssd("*130#");
            mtmsRepository.getDaqMap().put(daq.getMinute(), daq);
        }
        Daq daq1 = new Daq();{
            daq1.setMinute("600 daqiqa");
            daq1.setPrice("8 000 SO'M");
            daq1.setPeriod("""
                    30 kun
                    <b>Dushanba - Juma:</b> 300 daqiqa.
                    <b>Shanba - Yakshanba:</b> 300 daqiqa.""");
            daq1.setUssd("*130#");
            mtmsRepository.getDaqMap().put(daq1.getMinute(), daq1);
        }
        Daq daq2 = new Daq();{
            daq2.setMinute("1200 daqiqa");
            daq2.setPrice("12 000 SO'M");
            daq2.setPeriod("""
                    30 kun
                    <b>Dushanba - Juma:</b> 600 daqiqa.
                    <b>Shanba - Yakshanba:</b> 600 daqiqa.""");
            daq2.setUssd("*130#");
            mtmsRepository.getDaqMap().put(daq2.getMinute(), daq2);
        }
        SMS sms = new SMS();{
            sms.setSms("50 SMS");
            sms.setPrice("1 684 SO'M");
            sms.setPeriod("30 kun");
            sms.setUssd("*147*1*1#");
            mtmsRepository.getSmsMap().put(sms.getSms(), sms);
        }
        SMS sms1 = new SMS();{
            sms1.setSms("150 SMS");
            sms1.setPrice("4 210 SO'M");
            sms1.setPeriod("30 kun");
            sms1.setUssd("*147*1*2#");
            mtmsRepository.getSmsMap().put(sms1.getSms(), sms1);
        }
        SMS sms2 = new SMS();{
            sms2.setSms("500 SMS");
            sms2.setPrice("10 525 SO'M");
            sms2.setPeriod("30 kun");
            sms2.setUssd("*147*1*3#");
            mtmsRepository.getSmsMap().put(sms2.getSms(), sms2);
        }
        USSD ussd = new USSD();{
            ussd.setUssd("*100#");
            ussd.setName("Balans va tarif");
            ussd.setData("""
					Xisobingizdagi qolgan mablag'
					va tarifingizni tekshirishingiz mumkin""");
            mtmsRepository.getUssdMap().put(ussd.getName(), ussd);
        }
        USSD ussd1 = new USSD();{
            ussd1.setUssd("*111#");
            ussd1.setName("USSD menyu");
            ussd1.setData("""
                    Menyudan foydalanib, siz hamma ma'lumotlarni olsangiz boladi
                    Masalan, raqam kimni nomiga royxatdan o'tganligi,
                    tarifni o'zgartirish va hokazo""");
            mtmsRepository.getUssdMap().put(ussd1.getName(), ussd1);
        }
        USSD ussd2 = new USSD();{
            ussd2.setUssd("*120#");
            ussd2.setName("Tarif rejani o'zgartirish");
            ussd2.setData("""
                    Bor tarif rejalar ro'yxati va o'z tarif
                    rejangizni o'zgartirish xizmati""");
            mtmsRepository.getUssdMap().put(ussd2.getName(), ussd2);
        }
        USSD ussd3 = new USSD();{
            ussd3.setUssd("*900#");
            ussd3.setName("Yagona xisob");
            ussd3.setData("""
                    Hisobingizdagi qolgan mablag', qoldiq daqiqalar,
                    megabaytlar va SMSlarni bitta smsda
                    olishingiz mumkin""");
            mtmsRepository.getUssdMap().put(ussd3.getName(), ussd3);
        }
        USSD ussd4 = new USSD();{
            ussd4.setUssd("*102#");
            ussd4.setName("Qoldiq SMS va Daqiqa");
            ussd4.setData("""
                    Tarif rejangiz doirasida daqiqa va
                    megabaytlar qoldig'i""");
            mtmsRepository.getUssdMap().put(ussd4.getName(), ussd4);
        }
        USSD ussd5 = new USSD();{
            ussd5.setUssd("*103#");
            ussd5.setName("MB'lar qoldig'i");
            ussd5.setData("""
                    Tarif rejangiz doirasida qolgan
                    megabaytlarni tekshirish""");
            mtmsRepository.getUssdMap().put(ussd5.getName(), ussd5);
        }
        USSD ussd6 = new USSD();{
            ussd6.setUssd("*500*1#");
            ussd6.setName("4G'ni sinab ko'r");
            ussd6.setData("""
                    42 so'm evaziga 5000 MB bonus 4G internet trafigini oling
                    Bonus trafik 30 kun faol.""");
            mtmsRepository.getUssdMap().put(ussd6.getName(), ussd6);
        }
        USSD ussd7 = new USSD();{
            ussd7.setUssd("*500*2#");
            ussd7.setName("4G'ni sinab ko'r (TUNGI)");
            ussd7.setData("""
                    1 000 so'm evaziga 5000 MB bonus 4G internet trafigini oling
                    Bonus trafik 30 kun faol.""");
            mtmsRepository.getUssdMap().put(ussd7.getName(), ussd7);
        }
        USSD ussd8 = new USSD();{
            ussd8.setUssd("*222#");
            ussd8.setName("Restart xizmati");
            ussd8.setData("""
                    Tarifingizga kiritilgan daqiqa, Internet va SMSlar tugab qoldimi?
                    Restart xizmatidan foydalaning va oy tugamasidan tarifingizni
                    baxosini qayta to'lab, hamma paketlarga ega bo'ling""");
            mtmsRepository.getUssdMap().put(ussd8.getName(), ussd8);
        }
        USSD ussd9 = new USSD();{
            ussd9.setUssd("*450#");
            ussd9.setName("Men kimman?");
            ussd9.setData("""
                    Telefon raqam ro'yxatdan o'tgan fuqaro haqida ma'lumot""");
            mtmsRepository.getUssdMap().put(ussd9.getName(), ussd9);
        }
        USSD ussd10 = new USSD();{
            ussd10.setUssd("*515#");
            ussd10.setName("Internet avans");
            ussd10.setData("""
                    Internet uchun pul yo'qmi?
                    Qarzga olib turing""");
            mtmsRepository.getUssdMap().put(ussd10.getName(), ussd10);
        }
        USSD ussd11 = new USSD();{
            ussd11.setUssd("*911#");
            ussd11.setName("Mobil avans");
            ussd11.setData("""
                    Qarzga hisobni to'ldirish""");
            mtmsRepository.getUssdMap().put(ussd11.getName(), ussd11);
        }
        USSD ussd12 = new USSD();{
            ussd12.setUssd("*911#");
            ussd12.setName("Mobil Avans qoldig'i");
            ussd12.setData("""
                    Qrzingizni yoki qarz qoldig'ini tekshirish""");
            mtmsRepository.getUssdMap().put(ussd12.getName(), ussd12);
        }
        USSD ussd13 = new USSD();{
            ussd13.setUssd("*311#");
            ussd13.setName("Raqam yashirish");
            ussd13.setData("""
                    Raqamingizni yashirin qilib olishingiz mumkin""");
            mtmsRepository.getUssdMap().put(ussd13.getName(), ussd13);
        }
    }
}
