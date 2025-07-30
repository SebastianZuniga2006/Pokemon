import java.util.Arrays;
import java.util.Scanner;

public class App {

    //ARROZ CON WEBO y cebolla

    //Constantes del juego
    static final int MAX_POKEMONES = 3;
    static final int MAX_ATAQUES = 3;
    static final int MAX_OBJETOS = 3;

    //Constantes de los arrelgos de pokemones
    static final int IDX_NOMBRE_POKEMON = 0;
    static final int IDX_TIPO1_POKEMON = 1;
    static final int IDX_TIPO2_POKEMON = 2;
    static final int IDX_VIDA_POKEMON = 3;
    static final int IDX_ATAQUE_POKEMON = 4;
    static final int IDX_DEFENSA_POKEMON = 5;
    static final int IDX_VELOCIDAD_POKEMON = 6;
    static final int IDX_VIDA_MAXIMA_POKEMON = 7;

    //Constantes de los arrelgos de ataques
    static final int IDX_DANOS =3;
    static final int IDX_ATRIBUTO_ATAQUE =  2;

    static final int IDX_NOMBRE_OBJETO = 0;
    static final int IDX_EFECTO_OBJETO = 1;
    static final int IDX_VALOR_EFECTO_OBJETO = 2;
    static final int IDX_DURACION_EFECTO_OBJETO = 3;
    static final int IDX_CANTIDAD_OBJETO =  4;
    static final int cantMaxima = 0;

    static Scanner sc = new Scanner(System.in);
    static int opcGeneral = 0, opcUsuario = 0, opcOrdenamiento = 0, pos = 0;
    static String nombrePokemon = " ";

    int input=sc.nextInt();

    //Funciones acortadas para imprimir 
    public static void p(String s) {
        System.out.println(s);
    }
    public static void pArg(String[][] arg) {
        for(String fila[] : arg) {
        System.out.println(Arrays.toString(fila));
        }
    }

    public static int validarDato(int minimo, int maximo, String mensaje){
        int dato;
        p(mensaje);
        do{
           dato=Integer.parseInt(sc.nextLine());
            if(dato>maximo||dato<minimo){
                p("El dato ingresado es incorrecto, intente de nuevo");
                dato=-1;
            }
        }while(dato==-1);
        return dato;
    }



    

    public static void limpiarPantalla() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    //---------FUNCION MAIN--------------//
    public static void main(String[] args){

        //String nombreUsuario = "David";
        //---------Datos del Juego--------------//
        String pokemones[][]={
            //Formato: Nombre, Tipo1, Tipo2, Vida, Ataque, Defensa, Velocidad, Vida Maxima
            {"Bulbasaur","Planta","Agua","30","7","50","10","30"},
            {"Charmander","Fuego","None","40","8","43","15","40"},
            {"Squirtle","Agua","None","60","9","48","15","60"},
            {"Pikachu","Electro","None","40","4","45","17","35"},
            {"Charizard","Fuego","Volador","90","35","40","10","100"},
            {"Mewtwo","Fuego","Volador","100","40","40","3","100"},
            {"Mew","Planta","Volador","80","50","30","20","80"},
            {"Jigglypuff","Electro","None","110","30","35","14","110"},
            {"Arceus","Agua","Volador","100","35","45","11","100"},
            {"Zapdos","Fuego","Volador","85","38","60","10","85"},
            {"Lugia","Electro","Volador","90","35","55","8","90"},
            {"Kyogre","Agua","Volador","80","40","50","8","80"},
        };

        String ataques[][]={
            //Formato: idAtaque, Nombre, Tipo, Daño
            //Se usa el idAtaque para evitar repetidos
            //Tambien se podrian separar por tipo para hacer mas facil la busqueda
            {"1","Ataque Furia", "Normal", "40"},
            {"2","Impactrueno","Electro","55"},
            {"3","Colminllo Igneo","Fuego","44"},
            {"4","Pirotecnia","Fuego","54"},
            {"5","Hidrocañón","Agua","46"},
            {"6","Acua Cola","Agua","40"},
            {"7","Pistola Agua","Agua","35"},
            {"8","Planta Feroz","Planta","35"},
            {"9","Rayo Solar","Planta","40"},
            {"10","Bomba lodo", "Planta","52"},
            {"11","Caida Picada", "Volador", "40"},
            {"12","Ataque Fuego", "Fuego", "42"},
            {"13","Ataque Planta", "Planta", "40"},
            {"14","Ataque Volador", "Volador", "40"},
            {"15","Alto Impacto", "Electro", "40"},
            {"16","Electrocargado", "Electro", "70"},
            {"17","Sobrecarga", "Electro", "50"},
            {"18","Caza furtiva", "Volador", "50"},
            {"19","Picada", "Volador", "40"},
            {"20","Tormenta", "Electro", "55"}
        };
  
        String objetos[][]={
            //Formato: Nombre, Efecto, Valor, duracion, cantidad
            {"Rociavida", "Vida", "20","0","3"},
            {"Baya Dragon", "Ataque", "20","3","3"},
            {"Proteína", "Ataque", "10","4","3"},
            {"Trozo de estrella", "Ataque","30","2","3"},
            {"Baya Roble", "Defensa", "20","3","3"},
            {"Hierro", "Defensa", "30","2","3"},
            {"Toxifruta", "Veneno", "10","3","3"},
            {"Gota Morada", "Veneno", "7","4","3"},
            {"Fragmento Vital", "Revivir", "0.5","0","2"},
            {"Infusion Vital","Regeneracion","7","4","3"}
            //{"Piedra evolución", "Evolución", "0",""},
            //{"Baya", "Vida", "10","0"},
            //{"Curavita", "Vida", "30","0"},
        };

        //-------------------------------------//

        //---------Datos del Usuario--------------//
        //Formato Nivel, ExP, Dinero
        //double usuarioDatos[] ={1,0,100};
        
        //Formato: Pokemon, Tipo1, Tipo2, Vida, Ataque, Defensa, Especial, Velocidad,Ataque1 Ataque2, Ataque 3 
        String pokemonesUsr1[][] = new String[MAX_POKEMONES][pokemones[0].length];
        String pokemonesUsr2[][] = new String[MAX_POKEMONES][pokemones[0].length];

        String ataquesPokU1[][] = new String[MAX_POKEMONES*MAX_ATAQUES][ataques[0].length];
        String ataquesPokU2[][] = new String[MAX_POKEMONES*MAX_ATAQUES][ataques[0].length];

        String objetosUsr1[][] = new String[3][objetos[0].length];
        String objetosUsr2[][] = new String[3][objetos[0].length];

        imprimirBienvenida(pokemones);

        System.out.println("\nJugador 1, elige tus pokemones.");
        pokemonesUsr1 = elegirPokemonesYObjetos(pokemones, MAX_POKEMONES);

        System.out.println("\nJugador 2, elige tus pokemones.");
        pokemonesUsr2 = elegirPokemonesYObjetos(pokemones, MAX_POKEMONES);

        System.out.println("¡Excelente elección para ambos! Ahora, elijan sus objetos.");

        System.out.println("\nJugador 1, elige tus objetos.");
        objetosUsr1 = elegirPokemonesYObjetos(objetos, MAX_OBJETOS);


        System.out.println("\nJugador 2, elige tus objetos.");
        pokemonesUsr2 = elegirPokemonesYObjetos(objetos, MAX_OBJETOS);

        System.out.println("¡Muy bien! Ahora sí empecemos.");
        imprimirMenuGeneral();
        
        opcGeneral = sc.nextInt();
        sc.nextLine();

        switch(opcGeneral){
            case 1:
            System.out.println("\nUsted ha seleccionado observar los pokemones de cada jugador.\n");
            System.out.println("\nJugador 1: ");
            imprimirTablaDatos(pokemonesUsr1);

            System.out.println("\nJugador 2; ");
            imprimirTablaDatos(pokemonesUsr2);
            break;

            case 2:
            System.out.println("\nUsted ha seleccionado observar los objetos de cada jugador.\n");
            System.out.println("\nJugador 1: ");
            imprimirTablaDatos(objetosUsr1);

            System.out.println("\nJugador 2: ");
            imprimirTablaDatos(objetosUsr2);
            break;

            case 3:
            System.out.println("\nUsted ha seleccionado visualizar una lista con todos los pokemones.");
            imprimirTablaDatos(pokemones);
            break;

            case 4:
            System.out.println("Usted ha seleccionado realizar ordenamientos y búsquedas de acuerdo a ciertos criteros");
            do{
            imprimirMenuOpciones();

            opcUsuario = sc.nextInt();
            sc.nextLine();

            String [] [] copiaPokemones = copiarMatriz(pokemones);
            switch (opcUsuario){
            case 1:
            System.out.println("\nUsted ha seleccionado ordenar alfabéticamente");
            pos = 0;
            do{
            imprimirMenuOrdenamiento();
            opcOrdenamiento = sc.nextInt();
            switch (opcOrdenamiento) {
                case 1:
                    System.out.println("\nUsted ha seleccionado ordenar por BubbleSort");
                    String [] [] matOrdenAlfabeticoUno = ordenarBurbujaString(copiaPokemones, pos);
                    System.out.println("\nPokemones ordenados alfabéticamente: ");
                    imprimirTablaDatos(matOrdenAlfabeticoUno);
                    break;
                case 2:
                    System.out.println("\nUsted ha seleccionado ordenar por Selección");
                    String [] [] matOrdenAlfabeticoDos = ordenarSeleccionString(copiaPokemones, pos);
                    System.out.println("\nPokemones ordenados alfabéticamente: ");
                    imprimirTablaDatos(matOrdenAlfabeticoDos);
                    break;
                case 3:
                    System.out.println("\nUsted ha seleccionado ordenar por Quicksort");
                    int inicio = 0, fin = copiaPokemones.length - 1;
                    String [] [] matOrdenAlfabeticoTres = ordenarQuicksortString(copiaPokemones, inicio, fin, pos);
                    imprimirTablaDatos(matOrdenAlfabeticoTres);
                    break;
                case 4:
                    System.out.println("\nUsted ha regresado al menú principal");
                    break;
                default:
                    System.out.println("\nUsted ha ingresado una opción incorrecta");
                    break;
            }
            }while (opcOrdenamiento != 4);
            break;
            case 2:
            System.out.println("\nUsted ha seleccionado ordenar los pokemones por tipo Uno");
            pos = 1;

            do{
            imprimirMenuOrdenamiento();
            opcOrdenamiento = sc.nextInt();
            switch (opcOrdenamiento) {
                case 1:
                    System.out.println("\nUsted ha seleccionado ordenar por BubbleSort");
                    String [] [] matOrdenTipoUno = ordenarBurbujaString(copiaPokemones, pos);
                    System.out.println("\nPokemones ordenados por tipo Uno: ");
                    imprimirTablaDatos(matOrdenTipoUno);
                    break;
                case 2:
                    System.out.println("\nUsted ha seleccionado ordenar por Selección");
                    String [] [] matOrdenTipoDos = ordenarSeleccionString(copiaPokemones, pos);
                    System.out.println("\nPokemones ordenados por tipo Uno: ");
                    imprimirTablaDatos(matOrdenTipoDos);
                    break;
                case 3:
                    System.out.println("\nUsted ha seleccionado ordenar por Quicksort");
                    int inicio = 0, fin = copiaPokemones.length - 1;
                    String [] [] matOrdenTipoTres = ordenarQuicksortString(copiaPokemones, inicio, fin, pos);
                    System.out.println("\nPokemones ordenados por tipo Uno: ");
                    imprimirTablaDatos(matOrdenTipoTres);
                    break;
                case 4:
                    System.out.println("\nUsted ha regresado al menú principal");
                    break;
                default:
                    System.out.println("\nUsted ha ingresado una opción incorrecta");
                    break;
                }
            }while (opcOrdenamiento != 4);
            break;
            case 3:
            System.out.println("\nUsted ha decidido ordenar los pokemones por vida.");
            pos = 3;

            do{
            imprimirMenuOrdenamiento();
            opcOrdenamiento = sc.nextInt();
            switch (opcOrdenamiento) {
                case 1:
                System.out.println("\nUsted ha seleccionado ordenar por BubbleSort");
                String [] [] matrizOrdenVidaUno = ordenarBurbujaInt(copiaPokemones, pos);
                System.out.println("\nPokemones ordenados por puntos de vida:");
                imprimirTablaDatos(matrizOrdenVidaUno);
                break;
                case 2:
                System.out.println("\nUsted ha seleccionado ordenar por Selección");
                String [] [] matrizOrdenVidaDos = ordenarSeleccionInt(copiaPokemones, pos);
                System.out.println("\nPokemones ordenados por puntos de vida:");
                imprimirTablaDatos(matrizOrdenVidaDos);
                break;
                case 3:
                System.out.println("\nUsted ha seleccionado ordenar por Quicksort");
                int inicio = 0, fin = copiaPokemones.length - 1;
                String [] [] matrizOrdenVidaTres = ordenarQuicksortInt(copiaPokemones, inicio, fin, pos);
                System.out.println("\nPokemones ordenados por puntos de vida:");
                imprimirTablaDatos(matrizOrdenVidaTres);
                break;
            }
            }while (opcOrdenamiento != 4);
            break;
            case 4:
            System.out.println("\nUsted ha decidido ordenar los pokemones por ataque.");
            pos = 4;

            do{
            imprimirMenuOrdenamiento();
            opcOrdenamiento = sc.nextInt();
            switch (opcOrdenamiento) {
                case 1:
                System.out.println("\nUsted ha seleccionado ordenar por BubbleSort");
                String [] [] matrizOrdenAtaqueUno = ordenarBurbujaInt(copiaPokemones, pos);
                System.out.println("\nPokemones ordenados por puntos de vida:");
                imprimirTablaDatos(matrizOrdenAtaqueUno);
                break;
                case 2:
                System.out.println("\nUsted ha seleccionado ordenar por Selección");
                String [] [] matrizOrdenAtaqueDos = ordenarSeleccionInt(copiaPokemones, pos);
                System.out.println("\nPokemones ordenados por puntos de vida:");
                imprimirTablaDatos(matrizOrdenAtaqueDos);
                break;
                case 3:
                System.out.println("\nUsted ha seleccionado ordenar por Quicksort");
                int inicio = 0, fin = copiaPokemones.length - 1;
                String [] [] matrizOrdenAtaqueTres = ordenarQuicksortInt(copiaPokemones, inicio, fin, pos);
                System.out.println("\nPokemones ordenados por puntos de vida:");
                imprimirTablaDatos(matrizOrdenAtaqueTres);
                break;
            }
            }while (opcOrdenamiento != 4);
            break;
            case 5:
            System.out.println("\nUsted ha seleccionado conocer más sobre un pokemon determinado.");
            System.out.print("Pokemon a buscar: ");
            nombrePokemon = sc.nextLine();

            int posPokemon = buscarPokemonYObjeto(pokemones, nombrePokemon);
            if (posPokemon != -1){
                imprimirDatosPokemon(pokemones, nombrePokemon, posPokemon);
            }else{
                imprimirMensajeError();
            }
            break;
            case 6:
            System.out.println("\nUsted ha salido del menú de ordenamiento y búsqueda de pokemones.");
            break;
            default:
            System.out.println("\nUsted ha ingresado una opción incorrecta.");
            break;
            }
            }while (opcUsuario != 6);
            break;

            case 5:
            System.out.println("\nUsted ha seleccionado comenzar una pelea\n");
            //Se van agregando segun pase el tiempo
        

            pokemonesRndm(objetosUsr1, objetos);
            pokemonesRndm(objetosUsr2, objetos);
            pokemonesRndm(pokemonesUsr1, pokemones);
            ataquesRndm(ataquesPokU1, ataques,pokemonesUsr1);
            pokemonesRndm(pokemonesUsr2, pokemones);
            ataquesRndm(ataquesPokU2, ataques,pokemonesUsr2);

            //objetosUsr = ataquesRndm(objetosUsr, objetos);

            pelea(pokemonesUsr1,pokemonesUsr2,ataquesPokU1,ataquesPokU2,objetosUsr1,objetosUsr2,"J1","J2");

            case 6:
            System.out.println("---------------------- AVENTURA FINALIZADA ----------------------");
            System.out.println("¡Esperamos volver a verlos pronto, estimados usuarios!");
            break;

            default:
            System.out.println("Usted ha seleccionado una opción incorrecta");
            break;
        }
    }

    private static void imprimirMenuGeneral() {
        System.out.println("===================== MENU GENERAL =====================");
        System.out.println("1.- Mostrar un listado con los pokemones de cada jugador.");
        System.out.println("2.- Mostrar un listado con los objetos de cada jugador.");
        System.out.println("3.- Mostrar un listado con todos los pokemones");
        System.out.println("4.- Ordenar de acuerdo a ciertos criterios y conocer a detalle sobre cada pokemon");
        System.out.println("5.- Pelea");
        System.out.println("6.- Salir");
        System.out.println("Seleccione una opción: ");
    }
    private static String[] [] elegirPokemonesYObjetos(String[][] matABuscar, int cantMaxima) {
        
        String [] [] matJugador = new String [cantMaxima] [matABuscar[0].length];
        int pos = 0;
        for (int i = 0; i < cantMaxima; i++){
            do{
                System.out.println("Elección No. "  + (i + 1));
                matJugador[i][0] = sc.nextLine();
                pos = buscarPokemonYObjeto(matABuscar, matJugador[i][0]);
                if (pos == -1){
                    imprimirMensajeError();
                }
            }while (pos == -1);
            llenarArrPokemones(matABuscar, matJugador, i, pos);
        }
        return matJugador;
    }

    private static void llenarArrPokemones(String[][] matABuscar, String[][] matJugador, int filaJugador, int itemElegido) {
        for (int j = 0; j < matABuscar[0].length; j++){
            matJugador[filaJugador][j] = matABuscar[itemElegido][j]; 
        }
    }

    public static void imprimirBienvenida(String [] [] pokemones) {
       System.out.println("===================== POKEMON SPACE AND EARTH =====================");
       System.out.println("                  --- An unbelievable adventure ---");
       System.out.println("¡Sean bienvenidos a Pokemon Space and Earth!");
       System.out.println("Para empezar, los jugadores deberán escoger sus pokemones. Estos son todos los pokemones del juego: \n");
       imprimirTablaDatos(pokemones);
    }
    
    private static void imprimirMensajeError() {
        System.out.println("------------- ERROR -------------");
        System.out.println("No se ha encontrado el item ingresado.");
    }
    private static void imprimirDatosPokemon(String[][] pokemones, String nombrePokemon2, int posPokemon) {
        System.out.println("----------- " + nombrePokemon.toUpperCase() + " -----------");
        System.out.println("Tipo1: " + pokemones[posPokemon][1]);
        System.out.println("Tipo 2: " + pokemones[posPokemon][2]);
        System.out.println("Vida: " + pokemones[posPokemon][3]);
        System.out.println("Ataque: " + pokemones[posPokemon][4]);
        System.out.println("Defensa: " + pokemones[posPokemon][5]);
        System.out.println("Velocidad: " + pokemones[posPokemon][6]);
        System.out.println("Vida máxima: " + pokemones[posPokemon][7]);
    }
    private static int buscarPokemonYObjeto(String[][] pokemones, String pokemonABuscar) {

        int n = pokemones.length;
        for(int i = 0; i < n; i++){
            if (pokemones[i][0].equalsIgnoreCase(pokemonABuscar)){
                return i;
            }
        }

        return -1;
    }
    private static String[][] ordenarBurbujaInt(String[][] copiaPokemones, int posInt) {
        int n = copiaPokemones.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++){
            intercambio = false;

            for (int j = 0; j < n - 1 - i; j++){
                if (Integer.parseInt(copiaPokemones[j][posInt]) > Integer.parseInt(copiaPokemones[j + 1][posInt])){
                    intercambiarPos(copiaPokemones, j, j + 1);
                    intercambio = true;
                }
            }

            if (!intercambio) break;
        }

        return copiaPokemones;
    }
    private static String[][] ordenarQuicksortInt(String[][] copiaPokemones, int inicio, int fin, int posInt) {
        if (inicio < fin){
            int pivote = particionarInt(copiaPokemones, inicio, fin, posInt);
            ordenarQuicksortInt(copiaPokemones, inicio, pivote - 1, posInt);
            ordenarQuicksortInt(copiaPokemones, pivote + 1, fin, posInt);
        }

        return copiaPokemones;
    }

    private static int particionarInt(String[][] copiaPokemones, int inicio, int fin, int posInt) {
        String pivote = copiaPokemones[fin][posInt];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++){
            if ((Integer.parseInt(copiaPokemones[j][posInt])) < (Integer.parseInt(pivote))){
                i++;
                intercambiarPos(copiaPokemones, i, j);
            }
        }

        intercambiarPos(copiaPokemones, i + 1, fin);

        return i + 1;
    }
    private static String[][] ordenarSeleccionInt(String[][] copiaPokemones, int posInt) {
        int n = copiaPokemones.length;

        for (int i = 0; i < n - 1; i++){
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++){
                if (Integer.parseInt(copiaPokemones[j][posInt]) < Integer.parseInt(copiaPokemones[indiceMinimo][posInt])){
                    indiceMinimo = j;
                }
            }

            intercambiarPos(copiaPokemones, i, indiceMinimo);
        }

        return copiaPokemones;
    }

   
    public static void imprimirMenuOrdenamiento() {
        System.out.println("===================== MENU DE ORDENAMIENTO =====================");
        System.out.println("1.- Ordenar por BubbleSort");
        System.out.println("2.- Ordenar por Selección");
        System.out.println("3.- Ordenar por Quicksort");
        System.out.println("4.- Salir");
        System.out.println("Seleccione una opción: ");
    }
    public static String[][] ordenarQuicksortString(String[][] copiaPokemones, int inicio, int fin, int pos3) {
        if (inicio < fin){
            int pivote = particionarString (copiaPokemones, inicio, fin, pos3);
            ordenarQuicksortString(copiaPokemones, inicio, pivote - 1, pos3);
            ordenarQuicksortString(copiaPokemones, pivote + 1, fin, pos3);
        }
        return copiaPokemones;
    }
    public static int particionarString(String[][] copiaPokemones, int inicio, int fin, int pos3) {
        String pivote = copiaPokemones[fin][pos3];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++){
            if ((copiaPokemones[j][pos3].compareTo(pivote)) < 0){
                i++;
                intercambiarPos(copiaPokemones, i, j);
            }
        }

        intercambiarPos(copiaPokemones, i + 1, fin);

        return i + 1;
    }
    public static String[][] ordenarSeleccionString(String[][] copiaPokemones, int pos2) {
       int n = copiaPokemones.length;

       for (int i = 0; i < n - 1; i++){
        int indiceMinimo = i;

        for (int j =i + 1; j < n; j++){
            if (copiaPokemones[j][pos2].compareTo(copiaPokemones[indiceMinimo][pos2]) < 0){
                indiceMinimo = j;
            }
        }

        intercambiarPos(copiaPokemones, i, indiceMinimo);
       }

       return copiaPokemones;
    }
    public static String[][] ordenarBurbujaString(String[][] copiaPokemones, int pos) {
        int n = copiaPokemones.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++){
            intercambio = false;

            for (int j = 0; j < n - 1 -i; j++){
                if (copiaPokemones[j][pos].compareTo(copiaPokemones[j + 1][pos]) > 0){
                    intercambiarPos(copiaPokemones, j , j + 1);
                    intercambio = true;
                }
            }

            if (!intercambio) break;
        }

        return copiaPokemones;
    }
    public static void intercambiarPos(String[][] copiaPokemones, int indx1, int indx2) {
        int n = copiaPokemones[0].length;
        for (int i = 0; i < n; i++){
            String temp = copiaPokemones[indx1][i];
            copiaPokemones[indx1] [i] = copiaPokemones[indx2][i];
            copiaPokemones[indx2][i] = temp;

        }
    }
    public static String[][] copiarMatriz(String[][] pokemones) {
        
        String [] [] copiaMatriz = new String [pokemones.length] [pokemones[0].length];
        
        for (int i = 0; i < pokemones.length; i++){
            for (int j = 0; j < pokemones[0].length; j++){
                copiaMatriz[i] [j] = pokemones [i] [j];
            }
        }

        return copiaMatriz;
    }

    /**
     * Funcion que asgina un pokemon aleatoriamente a cada usuario
     * @param pokemonesU //Array de Strings que va a contiener los pokemones del usuario
     * @param pokemonesGen //Array de Strings que contiene todos los pokemones posibles
     */
    public static void pokemonesRndm(String pokemonesU[][], String pokemonesGen[][]) {
    
        for(int i=0; i<pokemonesU.length; i++) {
            int random = (int)(Math.random()*pokemonesGen.length);
            String[] pokemon = pokemonesGen[random];
            pokemonesU[i] = pokemon;
        }
    }

    /**
     * Funcion que asigna los ataques aleatoriamente a cada pokemon
     * estos ataques se asignan a cada pokemon de acuerdo a su tipo
     * Dos ataques no se pueden repetir en un mismo pokemon
     * @param ataquesPok //Array de Strings que va a contener los ataques de los pokemones del usuario
     * @param ataquesGen //Array de Strings que contiene todos los ataques posibles
     * @param pokemones //Array de Strings que contiene los pokemones del usuario
     */
    public static void ataquesRndm(String ataquesPok[][], String ataquesGen[][],String[][] pokemones) {
        //Por las dudas :), si el usuario tiene mas ataques que el generador, devuelve el arrelgo sin modificar
        if(ataquesGen.length<ataquesPok.length) {
            System.out.println("El número de ataques generados es menor que el número de ataques del usuario");
            return;
        }
        
        //Un i<Cantidad de pokemones => Cantidad de pokemones=ataques totales/ ataques por pokemon
        for(int i=0; i<ataquesPok.length/MAX_ATAQUES; i++) {
            for(int j=0; j<MAX_ATAQUES; j++) {
                int random;
                boolean repetido=false;
                do{ 
                    repetido=false;
                    random = (int)(Math.random()*ataquesGen.length);
                    //Asigna ataques solo a los pokemones que tienen el mismo tipo de ataque
                    if(ataquesGen[random][IDX_ATRIBUTO_ATAQUE].equals(pokemones[i][IDX_TIPO1_POKEMON]) || 
                        ataquesGen[random][IDX_ATRIBUTO_ATAQUE].equals(pokemones[i][IDX_TIPO2_POKEMON])||
                        ataquesGen[random][IDX_ATRIBUTO_ATAQUE].equals("Normal")){
                        for(int c=0; c<j; c++) {
                            if(ataquesPok[i*MAX_ATAQUES+c][0]==ataquesGen[random][0] ) {
                                repetido=true;
                                break;
                            }
                        }
                    }else repetido=true;
                }while(repetido);
                String[] ataque = ataquesGen[random];
                ataquesPok[i*MAX_ATAQUES+j] = ataque;
            }
        }
            
    }

    public static void imprimirMenuOpciones() {
		System.out.println("=================== MENU DE OPERACIONES ===================");
		System.out.println("1.- Ordenar en orden alfabético");
		System.out.println("2.- Ordenar los pokemons por tipo");
		System.out.println("3.- Ordenar los pokémons por puntos de vida");
		System.out.println("4.- Ordenar los pokémons por ataque");
		System.out.println("5.- Conocer más sobre un pokemon");
		System.out.println("6.- Salir");
		System.out.print("Seleccione una opción: ");
	}


	public static void imprimirTablaDatos(String[] [] matriz) {
		System.out.printf("\n%-20s %-15s %-15s %-10s %-10s %-10s %-10s \n", "Nombre", "Tipo1", "Tipo2", "Vida", "Ataque", "Defensa", "Velocidad");
		System.out.println("======================================================================================================");
		
		for (int i = 0; i < matriz.length; i++) {
                System.out.printf("%-20s %-15s %-15s %-10s %-10s %-10s %-10s\n",
                          matriz[i][0], matriz[i][1], matriz[i][2],
                          matriz[i][3], matriz[i][4], matriz[i][5], matriz[i][6]);
        }
	}
		
	

        /**
     * Funcion de pelea entre 2 usuarios
     * @param pokemonesU1 //Array de Strings que contiene los pokemones del usuario 1
     * @param pokemonesU2 //Array de Strings que contiene los pokemones del usuario 2
     * @param ataquesPokU1 //Array de Strings que contiene los ataques de los pokemones del usuario 1
     * @param ataquesPokU2 //Array de Strings que contiene los ataques de los pokemones del usuario 2
     * @param Jugador1 //Nombre del usuario 1
     * @param Jugador2 //Nombre del usuario 2
     * @param objetosUsr //Array de Strings que contiene los objetos del usuarios
     * @return
     */
    public static int pelea(String[][] pokemonesU1, String[][] pokemonesU2, String[][] ataquesPokU1, String[][] ataquesPokU2, String[][]objetosUsr1,String[][]objetosUsr2, String Jugador1, String Jugador2) {
        //Siempre se usa e primer poquemon de cada usario para empezar la pelea

        int pokemonesUsuario1 = MAX_POKEMONES; //pokemones vivos de cada usario
        int pokemonesUsuario2 = MAX_POKEMONES;
        int objetosRestantesUsr1 = MAX_OBJETOS; //
        int objetosRestantesUsr2 = MAX_OBJETOS;
        String efectosPokemonesUsr1 [][] = new String[MAX_POKEMONES][(objetosUsr2.length+objetosUsr1.length)*3];
        String efectosPokemonesUsr2 [][] = new String[MAX_POKEMONES][(objetosUsr2.length+objetosUsr1.length)*3];
        int turno = 0;        int pokActivoU1 = 0;        int pokActivoU2 = 0;
        int eleccion=0;


        boolean jugador1=true;
        boolean ataco=false;
        boolean usoObjeto=false;

        if(Integer.parseInt(pokemonesU1[0][IDX_VELOCIDAD_POKEMON])<=Integer.parseInt(pokemonesU2[0][IDX_VELOCIDAD_POKEMON]))jugador1=false;
        do{
            String ataquesPokAct1[][]={
                ataquesPokU1[0+pokActivoU1*3],
                ataquesPokU1[1+pokActivoU1*3],
                ataquesPokU1[2+pokActivoU1*3],
            };
            String ataquesPokAct2[][]={
                ataquesPokU2[0+pokActivoU2*3],
                ataquesPokU2[1+pokActivoU2*3],
                ataquesPokU2[2+pokActivoU2*3],
            };
        
            turno++;
            //Ya ponlo donde necesites xd
           


            if(jugador1) {
                //Si el usuario 1 es mas veloz, se va a empezar con el usuario 1
                validarEfectosEnJugador(efectosPokemonesUsr1,pokemonesU1);
                pokActivoU1=validarVida(pokemonesUsuario1, pokemonesU1, pokActivoU1);
                mostrarPokemon(pokemonesU1[pokActivoU1],ataquesPokAct1,pokemonesU2[pokActivoU2],turno,Jugador1);
                do{
                eleccion=validarDato(1, MAX_ATAQUES+2, "Elija la accion a realizar:");
                if(eleccion==5){
                    pokActivoU1=cambiarPokemon(pokemonesU1, pokActivoU1);//Cambio de pokemon
                    ataco=true; //el cambiar de pokemon consume el turno
                } else if (eleccion == 4) {
                    //Cuando se elija 4.
                    if (objetosRestantesUsr1==0) {
                        p("No hay objetos disponibles para usar");
                    } else {
                        p("Elija el objeto que quiere usar:");
                        imprimirObjetosEnumerado(objetosUsr1);
                        //Validacion eleccion entre 1 y objetosRestantes
                        eleccion=validarDato(1, objetosRestantesUsr1, "Elija el objeto que quiere usar:");
                        usoObjeto = usarObjeto(eleccion,pokActivoU1,pokActivoU2,pokemonesU1,pokemonesU2,efectosPokemonesUsr1,efectosPokemonesUsr2,objetosUsr1,pokemonesUsuario1);
                    }
                    
                } else{
                    pokemonesU2[pokActivoU2][IDX_VIDA_POKEMON]=atacar(eleccion-1,pokemonesU1[pokActivoU1],ataquesPokAct1[eleccion-1],pokemonesU2[pokActivoU2]);
                    if(pokemonesU2[pokActivoU2][IDX_VIDA_POKEMON].equals("0") && pokemonesUsuario2>0){
                        pokemonesUsuario2--;
                        pokActivoU2=validarVida(pokemonesUsuario2,pokemonesU2,pokActivoU2);
                    }
                    ataco=true;
                } 
                }while(!ataco); ///Se repite en caso de no haber usado un ataque o cambiado de pokemon
            }else {
                validarEfectosEnJugador(efectosPokemonesUsr2,pokemonesU2);
                pokActivoU2=validarVida(pokemonesUsuario2, pokemonesU2, pokActivoU2);
                //Si el usuario 2 es mas veloz, se va a empezar con el usuario 2
                mostrarPokemon(pokemonesU1[pokActivoU1],ataquesPokAct2,pokemonesU2[pokActivoU2],turno,Jugador2);
                do{
                eleccion=validarDato(1, MAX_ATAQUES+2, "Elija la accion a realizar:");
                    if(eleccion==5){
                        pokActivoU2=cambiarPokemon(pokemonesU2, pokActivoU2);
                        ataco=true;
                    }else if (eleccion == 4) {
                    //Cuando se elija 4.
                    if (objetosRestantesUsr2==0) {
                        p("No hay objetos disponibles para usar");
                    } else if(!usoObjeto) {
                        p("Elija el objeto que quiere usar:");
                        imprimirObjetosEnumerado(objetosUsr2);
                        //Validacion eleccion entre 1 y objetosRestantes
                        eleccion= validarDato(1, objetosRestantesUsr2, "Elija el objeto que quiere usar:");
                        usoObjeto = usarObjeto(eleccion,pokActivoU2,pokActivoU1,pokemonesU2,pokemonesU1,efectosPokemonesUsr2,efectosPokemonesUsr1,objetosUsr2,pokemonesUsuario2);
                    }else p("Solo se puede usar un objeto por turno");
                }else{
                    pokemonesU1[pokActivoU1][IDX_VIDA_POKEMON]=atacar(eleccion-1,pokemonesU2[pokActivoU2],ataquesPokAct2[eleccion-1],pokemonesU1[pokActivoU1]);
                    if(pokemonesU2[pokActivoU2][IDX_VIDA_POKEMON].equals("0" )&& pokemonesUsuario1>0){
                        pokemonesUsuario1--;
                        pokActivoU1=validarVida(pokemonesUsuario1,pokemonesU1,pokActivoU1);
                    }
                    ataco=true;
                }        
                }while(!ataco);
            }
 
            jugador1=!jugador1;
            ataco=false;
            usoObjeto=false;
        
        }while((pokemonesUsuario1>0)&&(pokemonesUsuario2>0));
        return 0;
    }

    /**
     * Funcion que muestra los pokemones en pelea y los ataques del pokemone para la eleccion del usuario en ese turno
     * @param pokemon //Array de Strings que contiene el pokemones del usuario actual
     * @param ataquesPok //Array de Strings que contiene los ataques de los pokemones del usuario actual
     * @param pokemon2 //Array de Strings que contiene el pokemones del usuario enemigo
     * @param turno //Numero del turno actual
     * @param nombreJugador //Nombre del usuario actual
     */
    public static void mostrarPokemon(String[]pokemon, String[][]ataquesPok, String[]pokemon2, int turno, String nombreJugador) {
        //Mostrar pokemon y ataques de pokemos para eleccion del usuario
        limpiarPantalla();
        p("-------------Pelea-------------");
        p("           Turno "+turno);
        p("Juega: "+nombreJugador);
        p(pokemon[IDX_NOMBRE_POKEMON]+"  ("+pokemon[IDX_VIDA_POKEMON]+"PS)   VS    "+pokemon2[IDX_NOMBRE_POKEMON]+"("+pokemon2[IDX_VIDA_POKEMON]+"PS)");
        
        p("---Opciones de juego---");
        p("1."+ataquesPok[0][1]+"("+ataquesPok[0][2]+")    2."+ataquesPok[1][1]+"("+ataquesPok[1][2]+")");
        p("3."+ataquesPok[2][1]+"("+ataquesPok[2][2]+")    "+"4.usar objetos");
        p("5. Cambiar pokemon");
    }

    /**
     * Funcion que calcula el danio del ataque de un pokemon a otro en base a su
     * danio, defensa, danio del ataque ejecutado y ventajas de atributos
     * formula: danioPokemon = (danioHabilidad*danioPokemon/defensaPokemonA)*ventajaAtributo()
     * @param eleccion //Numero de ataque elegido
     * @param pokemonAtacante //Array de Strings que contiene los datos del pokemon del usuario actual
     * @param ataquePokemon //Array de Strings que contiene los datos del ataque del pokemon atacante
     * @param pokemonAfectado //Array de Strings que contiene los datos del pokemon que va a recibir el ataque
     * @return
     */
    public static String atacar(int eleccion, String[]pokemonAtacante, String[] ataquePokemon,String []pokemonAfectado) {

        int vidaPokemon = Integer.parseInt(pokemonAfectado[IDX_VIDA_POKEMON]);

        int danioPokemon = Integer.parseInt(pokemonAtacante[IDX_ATAQUE_POKEMON]);
        int defensaPokemonA = Integer.parseInt(pokemonAfectado[IDX_DEFENSA_POKEMON]);
        int danioHabilidad = Integer.parseInt(ataquePokemon[IDX_DANOS]);
        double ventajaAtaque = ventajaAtributo(ataquePokemon[IDX_ATRIBUTO_ATAQUE], pokemonAfectado[IDX_TIPO1_POKEMON],pokemonAfectado[IDX_TIPO2_POKEMON]);

        double danio = ((danioHabilidad*danioPokemon)/defensaPokemonA)*ventajaAtaque;
        vidaPokemon-= danio;
        if(vidaPokemon<0)vidaPokemon=0;
        p(pokemonAtacante[IDX_NOMBRE_POKEMON]+" usa "+ ataquePokemon[1]);
        if(ventajaAtaque>1)p("El ataque es efectivo");
        else if(ventajaAtaque<1)p("El ataque es debil");
        p(pokemonAtacante[IDX_NOMBRE_POKEMON]+" inflige "+(int)danio+" PS de danio");
        return Integer.toString(vidaPokemon);
    }
 
    /**
     * Funcion para realizar cambio el pokemon en pelea del usuario
     * @param pokemones //Array de Strings que contiene los pokemones del usuario
     * @param pokemonAct //Posicion del pokemon que se va a cambiar
     * @return //Nueva posicion del pokemon que se va a usar
     */
    public static int cambiarPokemon(String[][]pokemones, int pokemonAct){
        int posicion=0;
        do{
            posicion=validarDato(1, MAX_POKEMONES, "Ingrese la posicion del pokemon que quieres usar:"); 
            if(pokemones[posicion-1][IDX_VIDA_POKEMON].equals("0")){
                p("Ese pokemon no tiene vida, intente de nuevo");posicion=-1;
            }
        }while(posicion==-1);

        return posicion-1;
    }

    /**
     * Funcion que calcula la ventaja de los atributos de un ataque en base a un arrelgo base que especifica:
     * Elemento, Fuerte Contra, Debil Contra
     * Si el elemento de ataque es fuerte contra uno de los elementos de defensa, se suma al multiplicador de ventaja 0.5
     * Si el elemento de ataque es debil contra uno de los elementos de defensa, se resta al multiplicador de ventaja 0.5
     * tal que si el elemnto es fuerte contra un elemento y debil contra otro, el ataque no tiene ventaja
     * @param atributoAtaca //Atributo del ataque 
     * @param atributoAfectado1 //Atributo de defensa del pokemon afectado
     * @param atributoAfectado2 //Atributo de defensa del pokemon afectdor
     * @return //Multiplicador de ventaja
     */
    public static double ventajaAtributo(String atributoAtaca, String atributoAfectado1,String atributoAfectado2) {
        String ventajas[][]={
            //Formato: Atributo, FuerteContra, DebilContra
            {"Fuego", "Planta", "Agua"},
            {"Planta", "Agua", "Fuego"},
            {"Agua", "Fuego", "Planta"},
            {"Electro", "Volador", "Agua"},
            {"Volador", "Planta", "Electro"}
        };
        double ventaja=1;
        for(int i=0; i<ventajas.length; i++) {
            if(ventajas[i][0].equals(atributoAtaca)) {
                if(ventajas[i][1].equals(atributoAfectado1)||ventajas[i][1].equals(atributoAfectado2)) {
                    ventaja+=0.5;}
                if(ventajas[i][2].equals(atributoAfectado1)||ventajas[i][2].equals(atributoAfectado2)) {
                    ventaja-=0.5;
                }
            }
        }
        return ventaja;
    }


    public static boolean usarObjeto(int eleccion,int pokemonActvivoAtac,int pokemonActivoEnem, String[][]pokemonAtac, 
        String [][]pokemonEnem,String[][] efectosPkmnAtac,String[][] efectosPkmnEnem, String[][] objetosUsrAtac, int pokemonesVivosAtac){
        
        boolean usóObjeto = false;
        String efectoObjeto = objetosUsrAtac[eleccion-1][IDX_EFECTO_OBJETO];
        double valorEfectoObjeto = Integer.parseInt(objetosUsrAtac[eleccion-1][IDX_VALOR_EFECTO_OBJETO]);
        int cantidadObjetos = Integer.parseInt(objetosUsrAtac[eleccion-1][IDX_CANTIDAD_OBJETO]);
        int vidaPokemonAtacante = Integer.parseInt(pokemonAtac[pokemonActvivoAtac][IDX_VIDA_POKEMON]);
        int duracionTurnosEfecto = Integer.parseInt(objetosUsrAtac[eleccion-1][IDX_DURACION_EFECTO_OBJETO]);
        int revivirEleccion = 0;

        if (efectoObjeto.equals("Vida")) {
            vidaPokemonAtacante+=valorEfectoObjeto;
            if (vidaPokemonAtacante>=Integer.parseInt(pokemonAtac[pokemonActvivoAtac][IDX_VIDA_MAXIMA_POKEMON])) {
                pokemonAtac[pokemonActvivoAtac][IDX_VIDA_POKEMON] = pokemonAtac[pokemonActvivoAtac][IDX_VIDA_MAXIMA_POKEMON];
            } else{
                pokemonAtac[pokemonActvivoAtac][IDX_VIDA_POKEMON] = Integer.toString(vidaPokemonAtacante);
            }
            usóObjeto = true;

        } else if (efectoObjeto.equals("Ataque")
                  ||efectoObjeto.equals("Regeneracion")
                  ||efectoObjeto.equals("Defensa")) {
            for (int i = 0; i <efectosPkmnAtac[0].length;i+=3){
                if (efectosPkmnAtac[pokemonActvivoAtac][i].equals(null)
                || efectosPkmnAtac[pokemonActvivoAtac][i].equals(efectoObjeto)) {
                    efectosPkmnAtac[pokemonActvivoAtac][i] = efectoObjeto;
                    efectosPkmnAtac[pokemonActvivoAtac][i+1] = Integer.toString((int)valorEfectoObjeto);
                    efectosPkmnAtac[pokemonActvivoAtac][i+2] = Integer.toString(duracionTurnosEfecto);
                    break;
                }
            }
            usóObjeto = true;
        } else if (efectoObjeto.equals("Veneno")){
            for (int i = 0; i <efectosPkmnEnem[0].length;i++){
                if (efectosPkmnEnem[pokemonActivoEnem][i].equals(null)
                || efectosPkmnEnem[pokemonActivoEnem][i].equals(efectoObjeto)) {
                    efectosPkmnEnem[pokemonActivoEnem][i] = Integer.toString((int)valorEfectoObjeto);
                    efectosPkmnEnem[pokemonActivoEnem][i+1] = Integer.toString(duracionTurnosEfecto);
                    break;
                }
            }
            usóObjeto = true;
        } else if (efectoObjeto.equals("Revivir")){
            if (pokemonesVivosAtac!=MAX_POKEMONES) {
                p("Elija el pokemon a revivir:");
                imprimirColumnaEnumerado(pokemonAtac, IDX_NOMBRE_POKEMON);
                revivirEleccion=Integer.parseInt(sc.nextLine());
                if(revivirEleccion<1||revivirEleccion>MAX_POKEMONES||!pokemonAtac[revivirEleccion-1][IDX_VIDA_POKEMON].equals("0")){
                    p("No se pudo usar el objeto");
                } else {
                    double temp = Double.parseDouble(pokemonAtac[revivirEleccion-1][IDX_VIDA_MAXIMA_POKEMON])*valorEfectoObjeto;
                    pokemonAtac[revivirEleccion-1][IDX_VIDA_POKEMON]=Integer.toString((int)temp);
                    usóObjeto = true;
                }

            } else {
                p("No tienes pokemones para revivir");
            }
        }
        
        if (usóObjeto) {
            cantidadObjetos--;
            objetosUsrAtac[eleccion-1][IDX_CANTIDAD_OBJETO] = Integer.toString(cantidadObjetos);
            ordenarVerticalmenteObjetos(objetosUsrAtac);
            if (cantidadObjetos== 0) {
                
            }
        }
        

        
        return usóObjeto;
    };

    public static void validarEfectosEnJugador(String[][] efectosPokemns,String[][]pokemnsUsr){
        for(int j = 0; j < efectosPokemns.length;j++){
            for(int i = 0; i < efectosPokemns[0].length;i+=3){
                if (efectosPokemns[j][i].equals("Veneno")){
                    if (efectosPokemns[j][i+2]=="0"){
                        efectosPokemns[j][i] = null;
                        efectosPokemns[j][i+1] = null;
                        efectosPokemns[j][i+2] = null;
                    } else{
                        int temp = Integer.parseInt(pokemnsUsr[j][IDX_VIDA_POKEMON]);
                    temp -= Integer.parseInt(efectosPokemns[j][i+1]);
                    pokemnsUsr[j][IDX_VIDA_POKEMON]= Integer.toString(temp);
                    
                    //Elimina 1 a los turnos restantes de la duracion
                    efectosPokemns[j][i+2]=Integer.toString(Integer.parseInt(efectosPokemns[j][i+2])-1);
                    }
                    

                } else if (efectosPokemns[j][i].equals("Defensa")){
                    int temp = Integer.parseInt(pokemnsUsr[j][IDX_DEFENSA_POKEMON]);
                    if (efectosPokemns[j][i+2]=="0") {
                        efectosPokemns[j][i] = null;
                        efectosPokemns[j][i+1] = null;
                        efectosPokemns[j][i+2] = null;
                        temp-=Integer.parseInt(pokemnsUsr[j][IDX_DEFENSA_POKEMON]);
                        pokemnsUsr[j][IDX_DEFENSA_POKEMON]= Integer.toString(temp);
                    } else if (Integer.parseInt(efectosPokemns[j][i+2])<0) {
                        int duracionAux = Integer.parseInt(efectosPokemns[j][i+2]) + 1;
                        efectosPokemns[j][i+2] = Integer.toString(duracionAux);
                    } else {
                        temp+=Integer.parseInt(efectosPokemns[j][i+1]);
                        pokemnsUsr[j][IDX_DEFENSA_POKEMON]= Integer.toString(temp);
                    }
                } else if (efectosPokemns[j][i].equals("Regeneracion")){
                    if (efectosPokemns[j][i+2]=="0"){
                        efectosPokemns[j][i] = null;
                        efectosPokemns[j][i+1] = null;
                        efectosPokemns[j][i+2] = null;
                    } else{
                        int temp = Integer.parseInt(pokemnsUsr[j][IDX_VIDA_POKEMON]);
                    temp += Integer.parseInt(efectosPokemns[j][i+1]);
                    pokemnsUsr[j][IDX_VIDA_POKEMON]= Integer.toString(temp);
                    
                    //Elimina 1 a los turnos restantes de la duracion
                    efectosPokemns[j][i+2]=Integer.toString(Integer.parseInt(efectosPokemns[j][i+2])-1);
                    }
                } else if (efectosPokemns[j][i].equals("Ataque")){
                    int temp = Integer.parseInt(pokemnsUsr[j][IDX_ATAQUE_POKEMON]);
                    if (efectosPokemns[j][i+2]=="0") {
                        efectosPokemns[j][i] = null;
                        efectosPokemns[j][i+1] = null;
                        efectosPokemns[j][i+2] = null;
                        temp-=Integer.parseInt(pokemnsUsr[j][IDX_ATAQUE_POKEMON]);
                        pokemnsUsr[j][IDX_ATAQUE_POKEMON]= Integer.toString(temp);
                    } else if (Integer.parseInt(efectosPokemns[j][i+2])<0) {
                        int duracionAux = Integer.parseInt(efectosPokemns[j][i+2]) + 1;
                        efectosPokemns[j][i+2] = Integer.toString(duracionAux);
                    } else {
                        temp+=Integer.parseInt(efectosPokemns[j][i+1]);
                        pokemnsUsr[j][IDX_ATAQUE_POKEMON]= Integer.toString(temp);
                    }
                }

            }
        }
    }

    public static void ordenarVerticalmenteObjetos(String[][]objetosUsr){
        boolean huboCambio = false;
        for(int j = 0; j < objetosUsr.length - 1; j++){
            huboCambio = false;
            for(int i = 0; i < objetosUsr.length - 1 - j;i++) {
                if (Integer.parseInt(objetosUsr[i][IDX_CANTIDAD_OBJETO])<Integer.parseInt(objetosUsr[i+1][IDX_CANTIDAD_OBJETO])){
                    String temp[] = objetosUsr[i];
                    objetosUsr[i] = objetosUsr[i+1];
                    objetosUsr[i+1] = temp;
                    huboCambio = true;
                }
            }
            if (!huboCambio) break;
        }
    }

    public static void imprimirColumnaEnumerado(String[][] matriz, int columna) {
        for (int j = 0; j < matriz.length;j++){
            p((j+1) + ". " + matriz[j][columna]);
        }
    }
    public static void imprimirObjetosEnumerado(String[][] objetosUsr) {

        for(int i =0; i < objetosUsr.length; i++) {
            if(!objetosUsr[i][IDX_CANTIDAD_OBJETO].equals("0")) {
                p((i+1) + ". " + objetosUsr[i][IDX_NOMBRE_OBJETO]);
            }
                
            } 
    };

    /**
     * Funcion que valida si el usuario tiene vida para usar un objeto
     * @param pokemonesRestantes //Numero de pokemones que tiene el usuario
     * @param pokemonesUsr //Array de Strings que contiene los pokemones del usuario
     * @return //Numero del pokemon que se va a usar
     */
    public static int validarVida(int pokemonesRestantes, String[][] pokemonesUsr, int pokemonAct){
        int nuevoPok=pokemonAct;
        if(Integer.parseInt(pokemonesUsr[pokemonAct][IDX_VIDA_POKEMON])<=0){
        do {
            p(pokemonesUsr[pokemonAct][IDX_NOMBRE_POKEMON]+" ya no puede continuar");
            nuevoPok=validarDato(1, MAX_POKEMONES, "Ingrese el pokemon que quiere usar:");
            if(Integer.parseInt(pokemonesUsr[nuevoPok-1][IDX_VIDA_POKEMON])<=0){
                pokemonesUsr[nuevoPok-1][IDX_VIDA_POKEMON]="0";
                p("El pokemon seleccionado ya no tiene vida, intente con otro pokemon");
                nuevoPok=-1;
            }
        }while (nuevoPok==-1);
        nuevoPok--;
        }
        return nuevoPok;//Indice del pokemon seleccionado
    }


}