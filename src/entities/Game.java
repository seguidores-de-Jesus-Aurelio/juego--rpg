package entities;

import enums.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private Player jugador;
    private Enemy enemigo;
    private JTextArea textoArea;

    public Game() {
        // Inicialización de estadísticas y personajes


        jugador = new Player();
        enemigo = new Enemy();

        // Configuración de la ventana
        setTitle("Juego de Combate");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textoArea = new JTextArea();
        textoArea.setEditable(false);
        add(new JScrollPane(textoArea), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton ataqueFisico = new JButton("Ataque Físico");
        JButton ataqueMagico = new JButton("Ataque Mágico");

        ataqueFisico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(false);
            }
        });

        ataqueMagico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(true);
            }
        });

        panelBotones.add(ataqueFisico);
        panelBotones.add(ataqueMagico);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarTextoArea();
    }

    private void realizarAtaque(boolean ataqueMagico) {
        if (jugador.estaVivo() && enemigo.estaVivo()) {
            int danoJugador = jugador.atacar(ataqueMagico);
            enemigo.recibirDanio(danoJugador);
            textoArea.append("Atacas al enemigo y le haces " + danoJugador + " de daño.\n");

            if (!enemigo.estaVivo()) {
                textoArea.append("¡Has derrotado al enemigo!\n");
                return;
            }

            int danoEnemigo = enemigo.atacar();
            jugador.recibirDanio(danoEnemigo);
            textoArea.append("El enemigo te ataca y te hace " + danoEnemigo + " de daño.\n");

            if (!jugador.estaVivo()) {
                textoArea.append("¡Has sido derrotado por el enemigo!\n");
            }
        }
        actualizarTextoArea();
    }

    private void actualizarTextoArea() {
        textoArea.append("Tu vida: " + jugador.getVida() + " | Vida del enemigo: " + enemigo.getVida() + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Game juego = new Game();
                juego.setVisible(true);
            }
        });
    }
}
