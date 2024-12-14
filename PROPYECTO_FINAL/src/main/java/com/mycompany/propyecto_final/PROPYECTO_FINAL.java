/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.propyecto_final;

import java.util.Scanner;

/**
 *
 * @author alexis
 */
public class PROPYECTO_FINAL {


  
    private int edad; // Edad del usuario
 
    private char genero; // Genero del usuario
    
    private double peso; // Peso del usuario en kg
    
    private double estatura; // Estatura del usuario en cm
    
    private double imc; // IMC calculado
    
    private int ritmoCardiaco; // Ritmo cardiaco del usuario
    
    private double temperatura; // Temperatura corporal
    
    private double glucosa; // Nivel de glucosa en sangre
    
    private double tmb; // Tasa metabólica basal
    
    private int presionSistolica; // Presión sistólica
    
    private int presionDiastolica; // Presión diastólica
    
    private int saturacionOxigeno; // Saturación de oxígeno en sangre
    
    private String nombreCompleto; // Nombre completo del usuario
    
    private boolean datosIMC = false;
    
    private boolean datosRitmoCardiaco = false;
    
    private boolean datosTemperatura = false;
    
    private boolean datosGlucosa = false;
    
    private boolean datosTMB = false;
    
    private boolean datosPresion = false;
    
    private boolean datosSaturacion = false;

    // Arreglo para almacenar los usuarios
    
    private static PROPYECTO_FINAL[] tickets = new PROPYECTO_FINAL[5]; // Suponemos un máximo de 5 usuarios
    
    private static int ticketIndex = 0;

    // Base de datos de pacientes (nombre de usuario y contraseña)
    private static String[][] pacientesRegistrados = {
        
        {"Paciente1", "1234"},
        {"Paciente2", "1234"},
        {"Paciente3", "1234"}
    };

    public static void main(String[] args) {
        
        Scanner scani = new Scanner(System.in);

        // Inicio de sesión
        System.out.println("----- Sistema de Inicio de Sesion -----");
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scani.nextLine();
        System.out.print("Ingrese su password: ");
        String clave = scani.nextLine();

        if (!validarCredenciales(usuario, clave)) {
            System.out.println("Credenciales inválidas. No se puede acceder al sistema.");
            
            return; // Termina el programa si las credenciales no son válidas
        }

        System.out.println("Inicio de sesion exitoso. Bienvenido, " + usuario + "!");

        boolean salir = false;

        while (!salir) {
            PROPYECTO_FINAL metodo = new PROPYECTO_FINAL();

            // Pedir nombre completo al inicio
            System.out.print("Ingrese su nombre completo: ");
            metodo.nombreCompleto = scani.nextLine();

            // Almacenar el ticket del nuevo usuario en el arreglo
            if (ticketIndex < tickets.length) {
                tickets[ticketIndex] = metodo;
                ticketIndex++;
            } else {
                System.out.println("No hay espacio para más usuarios.");
                
                break;
            }

            while (true) {
              
                System.out.println("----- Menu de Analisis -----");
                System.out.println("1. Analisis de IMC");
                System.out.println("2. Analisis de Ritmo Cardiaco");
                System.out.println("3. Analisis de Temperatura Corporal");
                System.out.println("4. Analisis de Glucosa");
                System.out.println("5. Analisis TMB");
                System.out.println("6. Analisis de presion sistolica y diastolica");
                System.out.println("7. Saturacion de oxigeno");
                System.out.println("8. Promedio de presion arterial");
                System.out.println("9. Todos");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opcion: ");

                int opcion = scani.nextInt();

                switch (opcion) {
                    case 1:
                        metodo.analisisIMC();
                        break;
                    case 2:
                        metodo.analisisRitmoCardiaco();
                        break;
                    case 3:
                        metodo.analisisTemperatura();
                        break;
                    case 4:
                        metodo.analisisGlucosa();
                        break;
                    case 5:
                        metodo.analisisTMB();
                        break;
                    case 6:
                        metodo.analisisPresion();
                        break;
                    case 7:
                        metodo.analisisSaturacionOxigeno();
                        break;
                    case 8:
                        metodo.analisisPromedioPresion();
                        break;
                    case 9:
                        // Realizar todos los análisis para todos los usuarios
                       
                        for (PROPYECTO_FINAL usuarioAnalisis : tickets) {
                        
                            if (usuarioAnalisis != null) {
                                usuarioAnalisis.analisisIMC();
                                usuarioAnalisis.analisisRitmoCardiaco();
                                usuarioAnalisis.analisisTemperatura();
                                usuarioAnalisis.analisisGlucosa();
                                usuarioAnalisis.analisisTMB();
                                usuarioAnalisis.analisisPresion();
                                usuarioAnalisis.analisisSaturacionOxigeno();
                                usuarioAnalisis.analisisPromedioPresion();
                            }
                        }
                        System.out.println("Todos los analisis han sido realizados para todos los usuarios.");
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del programa...");
        
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                }

                metodo.imprimirTicket();
                break; // Salir del ciclo interno para pedir el nombre de nuevo
            }
        }

        // Al finalizar, mostrar todos los tickets de espera
        System.out.println("\n----- TICKET DE TODOS LOS RESULTADOS -----");
        
        for (int i = 0; i < ticketIndex; i++) {
            tickets[i].imprimirTicket();
        }
    }

    // Método para validar credenciales
    
    public static boolean validarCredenciales(String usuario, String clave) {
    
        for (String[] paciente : pacientesRegistrados) {
        
            if (paciente[0].equals(usuario) && paciente[1].equals(clave)) {
            
                return true;
            }
        }
        return false;
    }

    // Métodos de análisis
    public void imprimirTicket() {
        
        System.out.println("\n----- TICKET DE RESULTADOS -----");
        
        System.out.println("Nombre Completo: " + nombreCompleto);
        
        System.out.println("Edad: " + edad);
        
        System.out.println("Genero: " + (genero == 'M' || genero == 'm' ? "Masculino" : "Femenino"));

        if (datosIMC) System.out.println("IMC: " + String.format("%.2f", imc));
        
        if (datosRitmoCardiaco) System.out.println("Ritmo Cardiaco: " + ritmoCardiaco + " bpm");
        
        if (datosTemperatura) System.out.println("Temperatura Corporal: " + temperatura + " °C");
        
        if (datosGlucosa) System.out.println("Glucosa en sangre: " + glucosa + " mg/dL");
        
        if (datosTMB) System.out.println("Tasa Metabolica Basal (TMB): " + String.format("%.2f", tmb) + " calorias");
        
        if (datosPresion) System.out.println("Presion Arterial: " + presionSistolica + "/" + presionDiastolica + " mmHg");
        
        if (datosSaturacion) System.out.println("Saturación de Oxigeno: " + saturacionOxigeno + "%");
        System.out.println("--------------------------------");
    }

    public void analisisIMC() {
        
        if (!datosIMC) {
        
            Scanner scani = new Scanner(System.in);
            
            System.out.println("Ingrese su estatura (Cm):");
        
            estatura = scani.nextInt();
            System.out.println("Ingrese su peso (Kg):");
            
            peso = scani.nextInt();
            
            double alturaMetros = estatura / 100; // Convertir a metros
            
            imc = peso / (alturaMetros * alturaMetros);
            System.out.println("IMC calculado: " + String.format("%.2f", imc));
            
            datosIMC = true;
        
        } else {
            System.out.println("El análisis de IMC ya fue realizado.");
        }
    }

    public void analisisRitmoCardiaco() {
        
        
        if (!datosRitmoCardiaco) {
            
            Scanner scani = new Scanner(System.in);
        
            System.out.print("Ingrese su ritmo cardiaco (latidos por minuto): ");
        
            ritmoCardiaco = scani.nextInt();
            
            datosRitmoCardiaco = true;
        
        } else {
            System.out.println("El analisis de Ritmo Cardiaco ya fue realizado.");
        }
    }

    public void analisisTemperatura() {
        
        if (!datosTemperatura) {
        
            Scanner scani = new Scanner(System.in);
            
            System.out.print("Ingrese su temperatura corporal (Grados Centigrados): ");
            
            temperatura = scani.nextDouble();
            
            datosTemperatura = true;
        
        
        } else {
            System.out.println("El analisis de Temperatura Corporal ya fue realizado.");
        }
    }

    public void analisisGlucosa() {
        
   
        if (!datosGlucosa) {
        
            Scanner scani = new Scanner(System.in);
            
            System.out.print("Ingrese su nivel de glucosa en sangre (mg/dL): ");
            
            glucosa = scani.nextDouble();
            
            datosGlucosa = true;
        
        } else {
            System.out.println("El analisis de Glucosa ya fue realizado.");
        }
    }

    public void analisisTMB() {
        
        if (!datosTMB) {
         
            Scanner scani = new Scanner(System.in);
            System.out.println("Ingrese su genero (F/M):");
           
            genero = scani.next().charAt(0);
            System.out.println("Ingrese su peso (kg):");
            
            peso = scani.nextInt();
            System.out.println("Ingrese su estatura (cm):");
            
            estatura = scani.nextInt();
            System.out.println("Ingrese su edad:");
            
            edad = scani.nextInt();
        
            switch (genero) {
            
                case 'M', 'm' -> tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) + 5;
                
                case 'F', 'f' -> tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) - 161;
               
                default -> {
                    System.out.println("Genero no válido para calcular la TMB.");
                   
                    return;
                }
            }
            System.out.println("Tasa Metabolica Basal (TMB): " + String.format("%.2f", tmb) + " calorias diarias");
            
            datosTMB = true;
        
        } else {
            System.out.println("El analisis de TMB ya fue realizado.");
        }
    }

    public void analisisPresion() {
        
        if (!datosPresion) {
        
            Scanner scani = new Scanner(System.in);
            System.out.print("Ingrese su presion sistolica (mmHg): ");
        
            presionSistolica = scani.nextInt();
            
            System.out.print("Ingrese su presion diastolica (mmHg): ");
            
            presionDiastolica = scani.nextInt();
            
            datosPresion = true;
        
        } else {
            System.out.println("El analisis de Presion Arterial ya fue realizado.");
        }
    }

    public void analisisSaturacionOxigeno() {
       
        if (!datosSaturacion) {
            
            Scanner scani = new Scanner(System.in);
            
            System.out.print("Ingrese el valor de SpO₂ (%): ");
        
            saturacionOxigeno = scani.nextInt();
        
            datosSaturacion = true;
        
        } else {
            System.out.println("El analisis de Saturación de Oxigeno ya fue realizado.");
        }
    }

    public void analisisPromedioPresion() {
       
        Scanner scani = new Scanner(System.in);
        
        System.out.print("Ingrese su presion sistolica (mmHg): ");
        
        int sistolica = scani.nextInt();
        
        System.out.print("Ingrese su presion diastolica (mmHg): ");
       
        int diastolica = scani.nextInt();
        
        double ppa = diastolica + (sistolica - diastolica) / 3.0;
        System.out.println("Promedio de Presion Arterial (PPA): " + String.format("%.2f", ppa) + " mmHg");
    }
}