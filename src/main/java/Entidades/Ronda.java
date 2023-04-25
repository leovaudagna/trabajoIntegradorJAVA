package Entidades;

import Enumeraciones.ResultadoEnum;
import javax.swing.*;
import java.util.List;

public class Ronda {

    private int nroRonda;
    private int cantidadDeEquiposEnRonda;
    private int cantidadDeEquiposEnLlave = 8;

    private String equipoGanador;

    public String getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(String equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public Ronda() {
    }

    public Ronda(int nroRonda, int cantidadDeEquiposEnRonda, int cantidadDeEquiposEnLlave) {
        this.nroRonda = nroRonda;
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }

    public int getNroRonda() {
        return nroRonda;
    }

    public void setNroRonda(int nroRonda) {
        this.nroRonda = nroRonda;
    }

    public int getCantidadDeEquiposEnRonda() {
        return cantidadDeEquiposEnRonda;
    }

    public void setCantidadDeEquiposEnRonda(int cantidadDeEquiposEnRonda) {
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
    }

    public int getCantidadDeEquiposEnLlave() {
        return cantidadDeEquiposEnLlave;
    }

    public void setCantidadDeEquiposEnLlave(int cantidadDeEquiposEnLlave) {
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }

    public void octavosDeFinal(Llave llaveIzquierda, Llave llaveDerecha){

        System.out.println("OCTAVOS DE FINAL: Llave izquierda");
        for (int i = 0; i < llaveIzquierda.getEquiposDeLaLlave().size(); i+=2){
            System.out.println("┌" + llaveIzquierda.getEquiposDeLaLlave().get(i).getNombre());
            System.out.println("└" + llaveIzquierda.getEquiposDeLaLlave().get(i+1).getNombre());
        }

        System.out.println("\n");

        System.out.println("OCTAVOS DE FINAL: Llave derecha");
        for (int i = 0; i < llaveDerecha.getEquiposDeLaLlave().size(); i+=2){
            System.out.println("┌" + llaveDerecha.getEquiposDeLaLlave().get(i).getNombre());
            System.out.println("└" + llaveDerecha.getEquiposDeLaLlave().get(i+1).getNombre());
        }
        System.out.println("\n");

        //Seteo de numero de ronda
        this.nroRonda = 1;

        //instancia de objeto partido para usar metodos
        Partido partido = new Partido();

        //Mensaje por pantalla de comienzo de octavos de final + mensaje en consola
        JOptionPane.showMessageDialog(null, "Comienzan los octavos de final", "Octavos de final", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Resultados: Octavos de final:");
        System.out.println("̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅ ");
        //Simular partidos
        for (int i = 0; i < cantidadDeEquiposEnLlave; i += 2){
            partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(i), llaveIzquierda.getEquiposDeLaLlave().get(i+1));
            partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(i), llaveDerecha.getEquiposDeLaLlave().get(i+1));
        }
        System.out.println("\n ------------------------  \n");
        //Remover equipos
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());

        this.cantidadDeEquiposEnLlave = 4;

    }

    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha){

        //Seteo de numero de ronda
        this.nroRonda = 2;

        System.out.println("CUARTOS DE FINAL: Llave izquierda");
        for (int i = 0; i < this.cantidadDeEquiposEnLlave; i+=2){
            System.out.println("┌" + llaveIzquierda.getEquiposDeLaLlave().get(i).getNombre());
            System.out.println("└" + llaveIzquierda.getEquiposDeLaLlave().get(i+1).getNombre());
        }

        System.out.println("\n");

        System.out.println("CUARTOS DE FINAL: Llave derecha");
        for (int i = 0; i < this.cantidadDeEquiposEnLlave; i+=2){
            System.out.println("┌" + llaveDerecha.getEquiposDeLaLlave().get(i).getNombre());
            System.out.println("└" + llaveDerecha.getEquiposDeLaLlave().get(i+1).getNombre());
        }
        System.out.println("\n");

        //instancia de objeto partido para usar metodos
        Partido partido = new Partido();

        //Mensaje por pantalla de comienzo de octavos de final
        JOptionPane.showMessageDialog(null, "Comienzan los cuartos de final", "Cuartos de final", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Resultados: Cuartos de final:");
        System.out.println("̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅ ");
        //Simular partidos
        for (int i = 0; i < cantidadDeEquiposEnLlave; i += 2){
            partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(i), llaveIzquierda.getEquiposDeLaLlave().get(i+1));
            partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(i), llaveDerecha.getEquiposDeLaLlave().get(i+1));
        }
        System.out.println("\n ------------------------  \n");

        //Remover equipos
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());

        this.cantidadDeEquiposEnLlave = 2;
    }

    public void semiFinal(Llave llaveIzquierda, Llave llaveDerecha){

        //Seteo de numero de ronda
        this.nroRonda = 3;

        System.out.println("SEMIFINAL: Llave izquierda");
        for (int i = 0; i < this.cantidadDeEquiposEnLlave; i+=2){
            System.out.println("┌" + llaveIzquierda.getEquiposDeLaLlave().get(i).getNombre());
            System.out.println("└" + llaveIzquierda.getEquiposDeLaLlave().get(i+1).getNombre());
        }

        System.out.println("\n");

        System.out.println("SEMIFINAL: Llave derecha");
        for (int i = 0; i < this.cantidadDeEquiposEnLlave; i+=2){
            System.out.println("┌" + llaveDerecha.getEquiposDeLaLlave().get(i).getNombre());
            System.out.println("└" + llaveDerecha.getEquiposDeLaLlave().get(i+1).getNombre());
        }
        System.out.println("\n");

        //instancia de objeto partido para usar metodos
        Partido partido = new Partido();

        //Mensaje por pantalla de comienzo de octavos de final + mensaje por consola
        JOptionPane.showMessageDialog(null, "Comienzan las semifinales", "Semi-final", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Resultados: Semifinales:");
        System.out.println("̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅");

        //Simular partidos
        partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(0), llaveIzquierda.getEquiposDeLaLlave().get(1));
        partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(0), llaveDerecha.getEquiposDeLaLlave().get(1));
        System.out.println("\n ------------------------  \n");
        //Remover equipos
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());

        this.cantidadDeEquiposEnLlave = 1;
    }

    public void partidoFinal(Llave llaveIzquierda, Llave llaveDerecha){
        //Seteo de numero de ronda
        this.nroRonda = 4;

        System.out.println("FINAL: \n" + "┌" + llaveIzquierda.getEquiposDeLaLlave().get(0).getNombre() + "\n└" + llaveDerecha.getEquiposDeLaLlave().get(0).getNombre() + "\n");


        //instancia de objeto partido para usar metodos
        Partido partido = new Partido();

        //Mensaje por pantalla de comienzo de octavos de final
        JOptionPane.showMessageDialog(null, "Comienza la final", "Final", JOptionPane.INFORMATION_MESSAGE);
        System.out.print("Resultado:");
        //Simular partidos
        Equipo equipo = partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(0), llaveDerecha.getEquiposDeLaLlave().get(0));
        if (llaveIzquierda.getEquiposDeLaLlave().get(0).getResultadoEnElPartido() == ResultadoEnum.GANADOR){
            setEquipoGanador(llaveIzquierda.getEquiposDeLaLlave().get(0).getNombre());
        } else {
            setEquipoGanador(llaveDerecha.getEquiposDeLaLlave().get(0).getNombre());
        }

        //Mensaje de GANADOR:
        System.out.println("\n ------------------------  \n");
        System.out.println("El CAMPEÓN es: ►►" + this.equipoGanador + "◄◄");
    }

    //Remover metodos
    public void removerEquipos(List<Equipo> equipos){
        int contadorEquiposPorLlave = cantidadDeEquiposEnLlave;
        for(int i = 0; i < contadorEquiposPorLlave; i++){
            Equipo equipoAuxiliar = equipos.get(i);
            if (!equipoAuxiliar.isAutorizacion()) {
                equipos.remove(equipoAuxiliar);
                contadorEquiposPorLlave--;
            }
        }
    }
}
