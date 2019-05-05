import java.util.ArrayList;

/*
 * Classe representa uma MesaSinuca Singleton/
 */
public class MesaSinuca {

	Bola[] bolas = { new Bola(), new Bola(), new Bola() };

	Buraco[] buraco = { new Buraco(), new Buraco(), new Buraco(), new Buraco(), new Buraco(), new Buraco() };
	private static MesaSinuca mesa;

	private MesaSinuca() {
		bolas[1].setCor("vermelha");
		bolas[1].setNumero(2);
		bolas[2].setCor("azul");
		bolas[2].setNumero(6);
		bolas[3].setCor("preta");
		bolas[3].setNumero(8);

	}

	public static MesaSinuca obterMesa() {
		if (mesa == null) {

			mesa = new MesaSinuca();
		}
		return mesa;
	}

	private boolean encerradorDeJogadaVerificador() {
		int pois = 0;
		boolean vazio = false;
		for (int i = 0; i < bolas.length; i++) {
			if (bolas[i] == null) {
				pois++;
			}

		}
		if (pois == bolas.length) {
			vazio = true;
		}
		return vazio;
	}

	public void acertarBola(int bolaAlvo, int numero) {
		if (encerradorDeJogadaVerificador()) {
			if (acertarBolaVerificador(bolaAlvo)) {
				buraco[numero].getBolas().add(pegaBola(bolaAlvo));

			}
		} else {
			System.out.print("Nao existe bolas na mesa");
		}

	}

	private boolean acertarBolaVerificador(int bolaAlvo) {
		boolean bolaAlvoNoBuraco = false;
		for (int i = 0; i < bolas.length; i++) {
			if (bolas[i].getNumero() == bolaAlvo) {
				bolaAlvoNoBuraco = true;
			}
		}
		return bolaAlvoNoBuraco;
	}

	private Bola pegaBola(int Alvo) {
		Bola bolaAlvoNoBuraco = null;
		for (int i = 0; i < bolas.length; i++) {
			if (bolas[i].getNumero() == Alvo) {
				bolaAlvoNoBuraco = bolas[i];
			}
		}
		return bolaAlvoNoBuraco;
	}

	public void imprimirBolas() {
		System.out.println("Bolas Presentes");
		for (int i = 0; i < bolas.length; i++) {
			if (bolas[i] != null) {
				System.out.println(bolas[i].getNumero());
			}
		}
	}

	public Bola[] getBolas() {
		return bolas;
	}

	public void setBolas(Bola[] bolas) {
		this.bolas = bolas;
	}

	public Buraco[] getBuraco() {
		return buraco;
	}

	public void setBuraco(Buraco[] buraco) {
		this.buraco = buraco;
	}

	public static MesaSinuca getMesa() {
		return mesa;
	}

	public static void setMesa(MesaSinuca mesa) {
		MesaSinuca.mesa = mesa;
	}

}
