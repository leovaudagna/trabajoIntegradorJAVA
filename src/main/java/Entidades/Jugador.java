package Entidades;

import javax.swing.*;
import java.util.List;

public class Jugador {

    private Equipo equipoSeleccionado;

    public Jugador() {
    }

    public Jugador(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public void elegiEquipo(List<Equipo> listaEquipos){
        String mensajeListaDeLoEquipos = "Equipos: \n";
        for (int i = 0; i < listaEquipos.size(); i++){
            mensajeListaDeLoEquipos += (i+1) + ". " + listaEquipos.get(i).getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null, mensajeListaDeLoEquipos, "Seleccione su equipo", JOptionPane.INFORMATION_MESSAGE);

        Integer indiceEquipo = 0;

        do {
            indiceEquipo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el indice del equipo que quiere seleccionar: ", "Selección de equipo", JOptionPane.INFORMATION_MESSAGE)) - 1;
        } while (indiceEquipo < 0 || indiceEquipo > 15);

        JOptionPane.showMessageDialog(null, "Seleccionaste a: " + listaEquipos.get(indiceEquipo).getNombre());
        this.equipoSeleccionado = listaEquipos.get(indiceEquipo);
    }

}
