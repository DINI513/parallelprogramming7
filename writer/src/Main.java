import io.mappedbus.MappedBusWriter;

public class Main {

    public static void main(String[] args) {
        try {
            MappedBusWriter writer = new MappedBusWriter("C:/Users/home1/Desktop/учеба/Паралелльное программирование/lab_7/tmp/test-message", 2000000L, 12);
            writer.open();

            PriceUpdate priceUpdate = new PriceUpdate();

            for (int i = 0; i < 1000; i++) {
                priceUpdate.setSource(1);
                priceUpdate.setPrice(i * 2);
                priceUpdate.setQuantity(i * 4);
                writer.write(priceUpdate);
                Thread.sleep(1000);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}