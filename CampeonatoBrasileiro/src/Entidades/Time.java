package Entidades;

public class Time {
	private String nome;
	private int pontos;
	private int vitorias;
	private int empates;
	private int derrotas;
	
	public Time(String nome) {
		this.nome = nome;
		this.pontos=0;
		this.vitorias=0;
		this.empates=0;
		this.derrotas=0;
	}
	public int getPontos() {
		return pontos;
	}
	public String getNome() {
		return nome;
	}
	public int getVitorias() {
		return vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public int derrotas() {
		return derrotas;
	}
	
	public void venceu() {
		vitorias++;
		pontos += 3;
	}
	public void perdeu() {
		derrotas++;
	}
	public void empatou() {
		empates++;
		pontos+=1;
	}
	public String toString() {
		return nome+ "- pontos:"+pontos+ "| vitorias: "+ vitorias+ "| Empates: " + empates+ "| Derrotas: " + derrotas;
	}
	
}
