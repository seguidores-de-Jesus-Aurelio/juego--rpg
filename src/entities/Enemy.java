package entities;

import enums.Stats;

public class Enemy {
    private int vida;
    private Stats stats;

    public Enemy(int vidaInicial, Stats stats) {
        this.vida = vidaInicial;
        this.stats = stats;
    }

    public int atacar() {
        return stats.getAttack() + (int) (Math.random() * 10); // Añadiendo un daño aleatorio
    }

    public void recibirDanio(int dano) {
        vida -= dano;
    }

    public int getVida() {
        return vida;
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}
