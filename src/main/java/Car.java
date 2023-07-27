import java.util.concurrent.Semaphore;

public class Car extends Thread
{
    private Semaphore semaphore;
    public Car(Semaphore semaphore)
    {
        this.semaphore = semaphore;
    }
    @Override
    public void run()
    {
        try
        {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" вьезжает на парковку");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" выезжает с парковки");
            semaphore.release();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
