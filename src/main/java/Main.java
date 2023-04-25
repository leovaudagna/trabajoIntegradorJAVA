import Entidades.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Mensaje de bienvenida
        JOptionPane.showMessageDialog(null, "Bienvenidos al simulador de torneos", "PROYECTO INTEGRADOR", JOptionPane.INFORMATION_MESSAGE);



        //Instancia de objetos de RONDA, COMPETENCIA, JUGADOR

        Competencias competenciaElegida = new Competencias();
        Jugador jugador1 = new Jugador();
        Ronda ronda = new Ronda();


        //Elección de competencia:
        int opcionCompetencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué torneo desea simular?\n1- UEFA CHAMPIONS LEAGUE 2023\n2- MUNDIAL QATAR 2022", "COMENCEMOS", JOptionPane.INFORMATION_MESSAGE));
        ArrayList<Equipo> listaDeEquipos = new ArrayList<Equipo>();
        switch (opcionCompetencia) {
            case 1:
                for (int i = 0; i < 16; i++) {
                    listaDeEquipos.add(new Equipo(competenciaElegida.getCHAMPIONS()[i]));
                }
                JOptionPane.showMessageDialog(null, "Bienvenidos a la UEFA Champions League 2023", "UEFA CHAMPIONS LEAGUE 2023", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("UEFA Champions League\n");
                break;
            case 2:
                for (int i = 0; i < 16; i++) {
                    listaDeEquipos.add(new Equipo(competenciaElegida.getMUNDIAL()[i]));
                }
                JOptionPane.showMessageDialog(null, "Bienvenidos al Mundial Qatar 2022", "MUNDIAL QATAR 2022", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Mundial Qatar 2023\n");
                break;
        }


        jugador1.elegiEquipo(listaDeEquipos);

        //Instancia de objeto llaves
        Llave llaveIzquierda = new Llave();
        Llave llaveDerecha = new Llave();

        //Armar llaves:
        llaveIzquierda.armarLlave(listaDeEquipos, 0);
        llaveDerecha.armarLlave(listaDeEquipos, 8);


        //Metodos de octavos, cuartos, semi y final
        ronda.octavosDeFinal(llaveIzquierda, llaveDerecha);
        ronda.cuartosDeFinal(llaveIzquierda, llaveDerecha);
        ronda.semiFinal(llaveIzquierda, llaveDerecha);
        ronda.partidoFinal(llaveIzquierda, llaveDerecha);

        //MENSAJE FINAL PARA JUGADOR
        if (ronda.getEquipoGanador() == jugador1.getEquipoSeleccionado().getNombre()){
            JOptionPane.showMessageDialog(null, "Felicitaciones! Tu equipo [" + jugador1.getEquipoSeleccionado().getNombre() + "] fue el ganador!", ronda.getEquipoGanador() + " es el Campeón", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Ganaste la apuesta!");
        } else {
            JOptionPane.showMessageDialog(null, "Tu equipo [" + jugador1.getEquipoSeleccionado().getNombre() + "] no se consagró campeón.\n Mucha suerte para la próxima apuesta.", ronda.getEquipoGanador() + " es el Campeón", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Haz perdido la apuesta.");
        }

    }
}
