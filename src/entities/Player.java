package entities;

import enums.Stats;

import java.util.HashMap;

public class Player {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Player() {
        this.name = "Jugador";
        this.stats = new HashMap<>();
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.HP, 100);
    }

    public int atacar(boolean ataqueMagico) {
        int baseDamage = ataqueMagico ? stats.getIntelligence() : stats.getAttack();
        return baseDamage + (int) (Math.random() * 10); // Añadiendo un daño aleatorio
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
