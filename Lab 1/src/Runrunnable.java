import java.util.Scanner;

public class Runrunnable implements Runnable{
	
	
	public int limiteSuperior;

	public long milis;
	
	public boolean par;
	
	public Runrunnable(int n, long ms, boolean par) {
		limiteSuperior = n;
		milis = ms;
		this.par = par;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Por favor ingrese el limite superior");
		int limite = scan.nextInt();
		System.out.println("Por favor ingrese la cantidad de milisegundos de retraso");
		long milis = scan.nextLong();
		Thread t1 = new Thread(new Runrunnable(limite, milis, true));
		Thread t2 = new Thread(new Runrunnable(limite, milis, false));
		t1.start();
		t2.start();
		scan.close();

	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= limiteSuperior; i++) {
				if(i%2 == 0 && par) {
					System.out.println(i);
					Thread.sleep(milis);
				}
				else if(i%2 == 1 && !par) {
					System.out.println(i);
					Thread.sleep(milis);
				}
			}
		}
		catch(Exception e) {
			System.out.println("ERROR");
		}
		
	}

}
