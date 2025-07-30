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
    

    static Scanner sc = new Scanner(System.in);
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
            {"Bulbasaur","Planta","Agua","30","7","80","10","30"},
            {"Charmander","Fuego","None","40","8","80","15","40"},
            {"Squirtle","Agua","None","60","9","80","15","60"},
            {"Pikachu","Electro","None","35","4","70","17","35"},
            {"Charizard","Fuego","Volador","100","20","90","8","100"},
            {"Mewtwo","Fuego","Volador","100","20","90","8","100"},
            {"Mew","Planta","Volador","100","20","90","20","100"},
            {"Jigglypuff","Electro","None","100","20","90","14","100"},
            {"Arceus","Agua","Volador","100","20","90","11","100"},
            {"Zapdos","Fuego","Volador","100","20","90","10","100"},
            {"Lugia","Electro","Volador","100","20","90","8","100"},
            {"Kyogre","Agua","Volador","100","20","90","8","100"},
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
            {"Baya Dragón", "Ataque", "20","3","3"},
            {"Proteína", "Ataque", "10","4","3"},
            {"Trozo de estrella", "Ataque","30","2","3"},
            {"Baya Roble", "Defensa", "20","3","3"},
            {"Hierro", "Defensa", "30","2","3"},
            {"Toxifruta", "Veneno", "10","3","3"},
            {"Gota Morada", "Veneno", "7","4","3"},
            {"Fragmento Vital", "Revivir", "0.5","0","2"},
            {"Infusión Vital","Regeneracion","7","4","3"}
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

        
        //Se van agregando segun pase el tiempo
        String objetosUsr1[][] = new String[3][objetos[0].length];
        String objetosUsr2[][] = new String[3][objetos[0].length];

            pokemonesRndm(objetosUsr1, objetos);
            pokemonesRndm(objetosUsr2, objetos);
            pokemonesRndm(pokemonesUsr1, pokemones);
            ataquesRndm(ataquesPokU1, ataques,pokemonesUsr1);
            pokemonesRndm(pokemonesUsr2, pokemones);
            ataquesRndm(ataquesPokU2, ataques,pokemonesUsr2);

            //objetosUsr = ataquesRndm(objetosUsr, objetos);

        pelea(pokemonesUsr1,pokemonesUsr2,ataquesPokU1,ataquesPokU2,objetosUsr1,objetosUsr2,"J1","J2");
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
    public static int pelea(String[][] pokemonesU1, String[][] pokemonesU2, String[][] ataquesPokU1, String[][] ataquesPokU2,String[][]objetosUsr1,String[][]objetosUsr2, String Jugador1, String Jugador2) {
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
            validarEfectosEnJugador(efectosPokemonesUsr1,pokemonesU1);
            validarEfectosEnJugador(efectosPokemonesUsr2,pokemonesU2);

            if(jugador1) {
                //Si el usuario 1 es mas veloz, se va a empezar con el usuario 1
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
                        pokActivoU2=validarVida(pokemonesUsuario2,pokemonesU2);
                    }
                    ataco=true;
                } 
                }while(!ataco); ///Se repite en caso de no haber usado un ataque o cambiado de pokemon
            }else {
                //Si el usuario 2 es mas veloz, se va a empezar con el usuario 2
                mostrarPokemon(pokemonesU1[pokActivoU1],ataquesPokAct2,pokemonesU2[pokActivoU2],turno,Jugador2);
                do{
                eleccion=validarDato(1, MAX_ATAQUES+2, "Elija la accion a realizar:");
                    if(eleccion==5){
                        cambiarPokemon(pokemonesU2, pokActivoU2);
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
                        pokActivoU1=validarVida(pokemonesUsuario1,pokemonesU1);
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
        if(vidaPokemon==0){
        p(pokemonAfectado[IDX_NOMBRE_POKEMON]+" ya no puede continuar");
        }
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
    public static int validarVida(int pokemonesRestantes, String[][] pokemonesUsr){
        int nuevoPok;
        do {
            nuevoPok=validarDato(1, MAX_POKEMONES, "Ingrese el pokemon que quiere usar:");
            if(!pokemonesUsr[nuevoPok-1][IDX_VIDA_POKEMON].equals("0")){
                p("El pokemon seleccionado ya no tiene vida, intente con otro pokemon");
                nuevoPok=-1;
            }
        }while (nuevoPok==-1);
        return nuevoPok-1;//Indice del pokemon seleccionado
    }


}