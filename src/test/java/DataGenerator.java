import com.github.javafaker.Faker;
import lombok.Value;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {


        public static String generateDate(int shift) {
            return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    public static String generateCity() {
        var cities = new String[]{"Владивосток", "Хабаровск", "Якутск",
                "Благовещенск", "Улан-Удэ", "Чита", "Нижний Новгород", "Самара",
                "Казань", "Уфа", "Пермь", "Саратов", "Ижевск",
                "Ульяновск", "Оренбург", "Пенза",  "Киров",
                "Чебоксары", "Саранск",  "Йошкар-Ола",
                 "Казань", "Санкт-Петербург", "Калининград", "Архангельск",
                "Новосибирск", "Мурманск", "Вологда", "Петрозаводск", "Сыктывкар"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {

        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {

        String city;
        String name;
        String phone;
    }

}
