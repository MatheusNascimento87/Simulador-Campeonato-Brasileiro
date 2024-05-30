package Main;
import Entidades.Time;
import Entidades.Partida;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class CampeonatoBrasileiro {

	public static void main(String[] args) {
		List<Time> times = new ArrayList<>(); //Lista de times
		times.add(new Time("Flamengo"));
		times.add(new Time("Palmeiras"));
		times.add(new Time("Corinthians"));
		times.add(new Time("Athletico Paranaense"));
		times.add(new Time("Bahia"));
		times.add(new Time("Botafogo"));
		times.add(new Time("São Paulo"));
		times.add(new Time("Cruzeiro"));
		times.add(new Time("Atlético-MG"));
		times.add(new Time("RB Bragantino"));
		times.add(new Time("Internacional"));
		times.add(new Time("Fortaleza"));
		times.add(new Time("Grêmio"));
		times.add(new Time("Vasco"));
		times.add(new Time("Criciúma"));
		times.add(new Time("Juventude"));
		times.add(new Time("Fluminense"));
		times.add(new Time("Vitória"));
		times.add(new Time("Atlético-GO"));
		times.add(new Time("Cuiabá"));
		
		List<Partida> calendario = gerarCalendario(times); // gerar calendário
		
		//jogar todas as partidas
		for(Partida partida : calendario) {
			partida.jogar();
		}
		times.sort(Comparator.comparingInt(Time::getPontos).reversed());
		//exibir tabela do primeiro turno
		System.out.println("---------------------------------------------------------------------");
		System.out.println("FIM DO PRIMEIRO TURNO: ");
		exibirTabela(times);
		System.out.println("---------------------------------------------------------------------");
		//jogar novamente o Returno
		for(Partida partida : calendario) {
			partida.jogar();	
		}
		times.sort(Comparator.comparingInt(Time::getPontos).reversed());
		//exibir a tabela final
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Tabela final: ");
		exibirTabela(times);
		System.out.println("---------------------------------------------------------------------");
		
	}
	public static void exibirTabela(List<Time> times) {
		for(int i =0;i<times.size();i++) {
			System.out.println((i+1)+ ". "+ times.get(i));
		}
	}
	public static List<Partida> gerarCalendario(List<Time> times){
		int n = times.size();
		List<Partida> calendario = new ArrayList<>();
		
		//Round-robin para campeonato com número par de times
		for(int rodada = 0; rodada< n-1; rodada++) {
			for(int i = 0; i<n/2;i++) {
				Time time1= times.get(i);
				Time time2 = times.get(n-1-i);
				calendario.add(new Partida(time1,time2));
			}
			//rotacionar times (exceto o primeiro)
			List<Time> newTimes = new ArrayList<>(times);
				Time fixado = newTimes.remove(0);
				Collections.rotate(newTimes,1);
				newTimes.add(0,fixado);
				times =  newTimes;
			}
			return calendario;
		}
	}

