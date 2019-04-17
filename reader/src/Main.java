import io.mappedbus.MappedBusReader;
import io.mappedbus.MappedBusMessage;

public class Main {
    public static void main(String[] args) {
        try {
            MappedBusReader reader = new MappedBusReader("C:/Users/home1/Desktop/учеба/Паралелльное программирование/lab_7/tmp/test-message", 2000000L, 12);
            reader.open();

            PriceUpdate priceUpdate = new PriceUpdate();

            MappedBusMessage message = null;

            while (true) {
                if (reader.next()) {
                    boolean recovered = reader.hasRecovered();
                    int type = reader.readType();
                    switch (type) {
                        case PriceUpdate.TYPE:
                            message = priceUpdate;
                            break;
                        default:
                            throw new RuntimeException("Unknown type: " + type);
                    }
                    reader.readMessage(message);
                    System.out.println("Read: " + message + ", hasRecovered=" + recovered);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}