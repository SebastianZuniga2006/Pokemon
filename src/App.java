import java.util.Arrays;
import java.util.Scanner;


public class App {

    //ARROZ CON WEBO y cebolla

    //Constantes del juego
    static final int MAX_POKEMONES = 3;
    static final int MAX_ATAQUES = 3;

    //Constantes de los arrelgos de pokemones
    static final int IDX_NOMBRE_POKEMON = 0;
    static final int IDX_TIPO1_POKEMON = 1;
    static final int IDX_TIPO2_POKEMON = 2;
    static final int IDX_VIDA_POKEMON = 3;
    static final int IDX_ATAQUE_POKEMON = 4;
    static final int IDX_DEFENSA_POKEMON = 5;
    static final int IDX_VELOCIDAD_POKEMON = 6;

    //Constantes de los arrelgos de ataques
    static final int IDX_DANOS =3;
    static final int IDX_NOMBRE_OBJETO = 0;
    static final int IDX_EFECTO_OBJETO = 1;
    static final int IDX_VALOR_EFECTO_OBJETO = 2;
    static final int IDX_ATRIBUTO_ATAQUE =  2;

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

    public static void pFilasMismaColumna(String[][] arg, int columna, boolean enumerado) {
        if (enumerado) {
           for(int i =0; i < arg.length; i++) {
                if(arg[i][columna].compareTo(null)!=0) {
                    System.out.println((i+1) + ". " + arg[i][columna]);
                }
                
            } 
        } else {
            for(int i =0; i < arg.length; i++) {
                if((arg[i][columna].compareTo(null)!=0)) {
                    System.out.println(arg[i][columna]);
                }
                
        }
        }
        
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
            //Formato: Nombre, Tipo1, Tipo2, Vida, Ataque, Defensa, Velocidad
            {"Bulbasaur","Planta","Agua","30","7","80","10"},
            {"Charmander","Fuego","None","40","8","80","15"},
            {"Squirtle","Agua","None","60","9","80","15"},
            {"Pikachu","Electro","None","35","4","70","17"},
            {"Charizard","Fuego","Volador","100","20","90","8"},
            {"Mewtwo","Fuego","Volador","100","20","90","8"},
            {"Mew","Planta","Volador","100","20","90","20"},
            {"Jigglypuff","Electro","None","100","20","90","14"},
            {"Arceus","Agua","Volador","100","20","90","11"},
            {"Zapdos","Fuego","Volador","100","20","90","10"},
            {"Lugia","Electro","Volador","100","20","90","8"},
            {"Kyogre","Agua","Volador","100","20","90","8"},
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
            //Formato: Nombre, Efecto, Valor
            {"Frasco Vida", "Vida", "20"},
            {"Frasco Ataque", "Ataque", "20"},
            {"Frasco Defensa", "Defensa", "20"},
            {"Frasco Veneno", "Veneno", "20"},
            {"Revivir", "Revivir", "20"},
            //{"Piedra evolución", "Evolución", "0"},
            {"Baya", "Vida", "10"},
            {"Super Poción", "Vida", "30"},
            {"Trozo de estrella", "Ataque","30"},
            {"Proteína", "Ataque", "30"},
            {"Hierro", "Defensa", "30"}
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
        String objetosUsr[][] = new String[3][objetos[0].length];

            pokemonesRndm(objetosUsr, objetos);
            pokemonesRndm(pokemonesUsr1, pokemones);
            ataquesRndm(ataquesPokU1, ataques,pokemonesUsr1);
            pokemonesRndm(pokemonesUsr2, pokemones);
            ataquesRndm(ataquesPokU2, ataques,pokemonesUsr2);

            //objetosUsr = ataquesRndm(objetosUsr, objetos);

        pelea(pokemonesUsr1,pokemonesUsr2,ataquesPokU1,ataquesPokU2,"J1","J2", objetosUsr);

        pArg(pokemonesUsr1);
        pArg(pokemonesUsr2);

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
    public static int pelea(String[][] pokemonesU1, String[][] pokemonesU2, String[][] ataquesPokU1, String[][] ataquesPokU2, String Jugador1, String Jugador2, String[][]objetosUsr) {
        //Siempre se usa e primer poquemon de cada usario para empezar la pelea

        int pokemonesUsuario1 = MAX_POKEMONES; //pokemones vivos de cada usario
        int pokemonesUsuario2 = MAX_POKEMONES;

        String efectosPokemonesUsr1 [][] = new String[MAX_POKEMONES][objetosUsr.length];
        String efectosPokemonesUsr2 [][] = new String[MAX_POKEMONES][objetosUsr.length];
        //Turno, pokmon activo de cada usario,, elecion del usario en su turno
        int turno = 0;        int pokActivoU1 = 0;        int pokActivoU2 = 0;        int eleccion=0;

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
                    if(!usoObjeto){
                    p("Elija el objeto que quiere usar:");
                    pFilasMismaColumna(objetosUsr,0,true);
                    eleccion=validarDato(1, objetosUsr.length, "Elija el objeto que quiere usar:");
                    usarObjeto(eleccion,pokemonesU1[pokActivoU1],pokemonesU2[pokActivoU2],efectosPokemonesUsr1[pokActivoU1],efectosPokemonesUsr2[pokActivoU2],objetosUsr);
                    usoObjeto=true;
                    }else p("Solo se puede usar un objeto por turno");
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
                        pokActivoU2=cambiarPokemon(pokemonesU2, pokActivoU2);
                        ataco=true;
                    }else if(eleccion==4){
                        if(!usoObjeto){
                        p("Elija el objeto que quiere usar:");
                        pFilasMismaColumna(objetosUsr,0,true);
                        eleccion= validarDato(1, objetosUsr.length, "Elija el objeto que quiere usar:");
                        usarObjeto(eleccion,pokemonesU1[pokActivoU1],pokemonesU2[pokActivoU2],efectosPokemonesUsr1[pokActivoU1],efectosPokemonesUsr2[pokActivoU2],objetosUsr);
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


    public static void usarObjeto(int eleccion, String[]pokemonAtacante, String []pokemonEnem,String[] efectosPkmnAtac,String[] efectosPkmEnem, String[][] objetosUsr){
        String objetoUsado = objetosUsr[eleccion-1][IDX_NOMBRE_OBJETO];
        String efectoObjeto = objetosUsr[eleccion-1][IDX_EFECTO_OBJETO];
        int valorEfectoObjeto = Integer.parseInt(objetosUsr[eleccion-1][IDX_VALOR_EFECTO_OBJETO]);
        int vidaPokemonAtacante = Integer.parseInt(pokemonAtacante[IDX_VIDA_POKEMON]);

        if (objetoUsado.compareTo("Frasco Vida")==0) {
            vidaPokemonAtacante+=valorEfectoObjeto;
            pokemonAtacante[IDX_VIDA_POKEMON] = Integer.toString(vidaPokemonAtacante);
        } else if (objetoUsado.compareTo("Frasco Ataque")==0
                  ||objetoUsado.compareTo("Frasco Defensa")==0) {
            for (int i = 0; i <efectosPkmnAtac.length;i++){
                if (efectosPkmnAtac[i].compareTo(null)==0
                || efectosPkmnAtac[i].substring(1).compareTo("Ataque")==0
                || efectosPkmnAtac[i].substring(1).compareTo("Defensa")==0) {
                    efectosPkmnAtac[i] = 3 + efectoObjeto;
                    //3 es la duracion que dura el efecto y que ira reduciendose por turnos
                    break;
                }
            }
        } else if (objetoUsado.compareTo("Frasco Veneno")==0){
            for (int i = 0; i <efectosPkmEnem.length;i++){
                if (efectosPkmEnem[i].compareTo(null)==0
                || efectosPkmEnem[i].substring(1).compareTo("Veneno")==0) {
                    efectosPkmEnem[i] = 3 + efectoObjeto;
                    //3 es la duracion que dura el efecto y que ira reduciendose por turnos
                    break;
                }
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