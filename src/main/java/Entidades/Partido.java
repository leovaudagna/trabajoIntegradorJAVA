package Entidades;

import Enumeraciones.ResultadoEnum;

import java.util.Arrays;
import java.util.Random;

public class Partido {
    private int golesEquipoLocal;
    private int golesEquipoVisitante;

    private boolean definicionPenales = false;

    private int golesEquipoLocalTemp;
    private int golesEquipoVisitanteTemp;

    public Partido() {
    }



    public int getGolesEquipoVisitanteTemp() {
        return golesEquipoVisitanteTemp;
    }

    public void setGolesEquipoVisitanteTemp(int golesEquipoVisitanteTemp) {
        this.golesEquipoVisitanteTemp = golesEquipoVisitanteTemp;
    }

    public Partido(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public boolean isdefinicionPenales() {
        return definicionPenales;
    }

    public void setdefinicionPenales(boolean definicionPenales) {
        this.definicionPenales = definicionPenales;
    }

    public int getGolesEquipoLocalTemp() {
        return golesEquipoLocalTemp;
    }

    public void setGolesEquipoLocalTemp(int golesEquipoLocalTemp) {
        this.golesEquipoLocalTemp = golesEquipoLocalTemp;
    }

    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante){

        //Instancia de random para generar resultados aleatorios en los partidos.
        Random random = new Random();
        setGolesEquipoLocal(random.nextInt(5));
        setGolesEquipoVisitante(random.nextInt(5));

        //Si el partido termina en empate, entra en en definicion de penales.
        while (definicionPenales && (this.golesEquipoLocal == this.golesEquipoVisitante)){
            setGolesEquipoLocal(random.nextInt(5));
            setGolesEquipoVisitante(random.nextInt(5));
        }

        if (!definicionPenales){
            //Muestra un mensaje con el resultado del partido
            //JOptionPane.showMessageDialog(null, equipoLocal.getNombre() + " [" + this.golesEquipoLocal
            //        + " - " + this.golesEquipoVisitante + "] " + equipoVisitante.getNombre(), "RESULTADO", JOptionPane.INFORMATION_MESSAGE);

            //Resultado por consola:
            System.out.println(equipoLocal.getNombre() + " [" + this.golesEquipoLocal + " - " + this.golesEquipoVisitante + "] " + equipoVisitante.getNombre());
        } else {
            String resultadoLocal[] = {"X", "X", "X", "X", "X"};
            for (int i = 0; i < this.golesEquipoLocal; i++){
                resultadoLocal[i] = "0";
            }

            String resultadoVisitante[] = {"X", "X", "X", "X", "X"};
            for (int i = 0; i < this.golesEquipoVisitante; i++){
                resultadoVisitante[i] = "0";
            }

            //Alterar orden de los goles de los penales
            Random randomPenalesLocal = new Random();

            for (int i = 0; i < resultadoLocal.length; i++) {
                int cambioDeOrdenRandom = randomPenalesLocal.nextInt(resultadoLocal.length);
                String temp = resultadoLocal[cambioDeOrdenRandom];
                resultadoLocal[cambioDeOrdenRandom] = resultadoLocal[i];
                resultadoLocal[i] = temp;
            }

            for (int i = 0; i < resultadoVisitante.length; i++) {
                int cambioDeOrdenRandom = randomPenalesLocal.nextInt(resultadoVisitante.length);
                String temp = resultadoVisitante[cambioDeOrdenRandom];
                resultadoVisitante[cambioDeOrdenRandom] = resultadoVisitante[i];
                resultadoVisitante[i] = temp;
            }

            //Mostar los resultados de los penales
            //JOptionPane.showMessageDialog(null, equipoLocal.getNombre() + ": " + Arrays.toString(resultadoLocal) + " (" + golesEquipoLocal + "). / Final: (" + (golesEquipoLocal + golesEquipoLocalTemp) + ") \n" +
            //        equipoVisitante.getNombre() + ": " + Arrays.toString(resultadoVisitante) + " (" + golesEquipoVisitante + "). / Final: (" + (golesEquipoVisitante + golesEquipoVisitanteTemp) + ")", "Resultado PENALES", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("      " + equipoLocal.getNombre() + ": " + Arrays.toString(resultadoLocal) + " (" + golesEquipoLocal + "). / Final: (" + (golesEquipoLocal + golesEquipoLocalTemp) + ") \n" +
                    "      " + equipoVisitante.getNombre() + ": " + Arrays.toString(resultadoVisitante) + " (" + golesEquipoVisitante + "). / Final: (" + (golesEquipoVisitante + golesEquipoVisitanteTemp) + ")");

            if(this.golesEquipoLocal > this.golesEquipoVisitante){
                equipoVisitante.setAutorizacion(false);
                equipoVisitante.setResultadoEnElPartido(ResultadoEnum.PERDEDOR);
                equipoLocal.setResultadoEnElPartido(ResultadoEnum.GANADOR);
                return equipoLocal;
            } else {
                equipoLocal.setAutorizacion(false);
                equipoVisitante.setResultadoEnElPartido(ResultadoEnum.GANADOR);
                equipoLocal.setResultadoEnElPartido(ResultadoEnum.PERDEDOR);
                return equipoVisitante;
            }


        }



        //Suma goles a los equipos
        equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
        equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);

        //Logica del partido
        if (this.golesEquipoLocal > this.golesEquipoVisitante){
            equipoVisitante.setAutorizacion(false);
            equipoVisitante.setResultadoEnElPartido(ResultadoEnum.PERDEDOR);
            equipoLocal.setResultadoEnElPartido(ResultadoEnum.GANADOR);
            //JOptionPane.showMessageDialog(null, "Ganó ►" + equipoLocal.getNombre() + "◄");
            return equipoLocal;
        } else if (this.golesEquipoLocal == this.golesEquipoVisitante){
            //JOptionPane.showMessageDialog(null, "Fin del segundo tiempo suplementario entre" + equipoLocal.getNombre() + " y " + equipoVisitante.getNombre() + ". Hay PENALES!", "Fin del segundo tiempo suplementario! - Penales" +
            //        this.golesEquipoLocal + " - " + this.golesEquipoVisitante, JOptionPane.INFORMATION_MESSAGE);
            System.out.println("*** Definición por penales ***");
            equipoLocal.setResultadoEnElPartido(ResultadoEnum.EMPATE);
            equipoVisitante.setResultadoEnElPartido(ResultadoEnum.EMPATE);

            //Sumar goles a cada equipo para mostrar el global luego de los penales:
            setGolesEquipoLocalTemp(golesEquipoLocal);
            setGolesEquipoVisitanteTemp(golesEquipoVisitante);

            //Para que entre en definición por penales
            setdefinicionPenales(true);

            //Repetir el buble pero entre al condicional de penales
            simularPartido(equipoLocal, equipoVisitante);
        } else {
            equipoLocal.setAutorizacion(false);
            equipoVisitante.setResultadoEnElPartido(ResultadoEnum.GANADOR);
            equipoLocal.setResultadoEnElPartido(ResultadoEnum.PERDEDOR);
            //JOptionPane.showMessageDialog(null, "Ganó ►" + equipoVisitante.getNombre() + "◄");
            return equipoVisitante;
        }

        //Setter goles temporales a 0 por proximo partido de empate
        setGolesEquipoLocalTemp(0);
        setGolesEquipoVisitanteTemp(0);

        setdefinicionPenales(false);
        return null;
    }


}
