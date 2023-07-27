import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Введите количество мест на стоянке");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int countParking = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Введите количество машин заезжающих на парковку");
        int countCars = Integer.parseInt(bufferedReader.readLine());
        Semaphore semaphore = new Semaphore(countParking);
        for (int i = 0; i < countCars; i++)
        {
            new Thread(new Car(semaphore),"car"+i).start();
        }
    }
}
