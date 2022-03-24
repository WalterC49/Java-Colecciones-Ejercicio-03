/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Alumno;

/**
 *
 * @author Walter
 */
public class AlumnoServicio {
    public int notaFinal(Alumno alum){
        int notaF=0;
        for (Integer i : alum.getNotas()) {
            notaF+=i;
        }
        return notaF;
    }
}
