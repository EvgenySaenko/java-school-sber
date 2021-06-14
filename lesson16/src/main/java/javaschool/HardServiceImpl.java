package javaschool;

public class HardServiceImpl implements HardService{

    @Override
    public double doHardWork(String name, double item) {
        System.out.println("Вычисляем doHardWork " + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return item*50;
    }

    @Override
    public String doHardWorkForFile(String name, String item) {
        System.out.println("Вычисляем doHardWorkForFile " + name);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            sb.append(item);
        }
        return sb.toString();
    }
}
