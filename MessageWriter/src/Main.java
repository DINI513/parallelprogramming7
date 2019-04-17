import io.mappedbus.MappedBusWriter;

public class Main {

    public static void main(String[] args) {
        try {
            MappedBusWriter writer = new MappedBusWriter("C:/Users/home1/Desktop/учеба/Паралелльное программирование/lab_7/tmp/test-message", 20000000000L, 12);
            writer.open();

            PriceUpdate priceUpdate = new PriceUpdate();

            for (int i = 0; i < 80000000; i++) {
                writer.write(priceUpdate);
            }

            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}