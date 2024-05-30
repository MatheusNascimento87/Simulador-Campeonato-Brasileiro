package Entidades;

public class Partida {
	public Time time1;
	public Time time2;
	public int golsTime1;
	public int golsTime2;

	public Partida(Time time1, Time time2) {
		this.time1 = time1;
		this.time2 = time2;
		this.golsTime1 = 0;
		this.golsTime2 = 0;
	}

	public void jogar() {
		golsTime1 = (int)(Math.random()*5);
		golsTime2 = (int)(Math.random()*5);
		
		if(golsTime1 > golsTime2) {
			time1.venceu();
			time2.perdeu();
			System.out.println(time1.getNome() + " "+ golsTime1+ "x"+ golsTime2+ " "+ time2.getNome());
		}else if(golsTime1 == golsTime2) {
			time1.empatou();
			time2.empatou();
			System.out.println(time1.getNome() + " "+ golsTime1+ "x"+ golsTime2+ " "+ time2.getNome());
		}else {
			time2.venceu();
			time1.perdeu();
			System.out.println(time1.getNome() + " "+ golsTime1+ "x"+ golsTime2+ " "+ time2.getNome());
		}
	}

	public String toString() {
		return time1.getNome() + " vs " + time2.getNome();
	}
}
