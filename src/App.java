import java.util.Arrays;
import java.util.Scanner;


public class App {

    //ARROZ CON WEBO y cebolla

    //Constantes
    static final int MAX_POKEMONES = 3;
    static final int MAX_ATAQUES = 3;
    static final int MAX_OBJETOS = 3;

    static final int IDX_NOMBRE_POKEMON = 0;
    static final int IDX_TIPO1_POKEMON = 1;
    static final int IDX_TIPO2_POKEMON = 2;
    static final int IDX_VIDA_POKEMON = 3;
    static final int IDX_ATAQUE_POKEMON = 4;
    static final int IDX_DEFENSA_POKEMON = 5;
    static final int IDX_VELOCIDAD_POKEMON = 6;
    static final int IDX_VIDA_MAXIMA_POKEMON = 7;

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

    

    public static void limpiarPantalla() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    //---------FUNCION MAIN--------------//
    public static void main(String[] args){



        String nombreUsuario = "David";
        //---------Datos del Juego--------------//
        String pokemones[][]={
            //Formato: Nombre, Tipo1, Tipo2, Vida, Ataque, Defensa, Velocidad, Vida Maxima
            {"Bulbasaur","Planta","Veneno","30","7","80","10","30"},
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
            {"1","Ataque Furia", "Normal", "20"},
            {"2","Impactrueno","Electro","35"},
            {"3","Colminllo Igneo","Fuego","24"},
            {"4","Pirotecnia","Fuego","34"},
            {"5","Hidrocañón","Agua","26"},
            {"6","Acua Cola","Agua","20"},
            {"7","Pistola Agua","Agua","15"},
            {"8","Planta Feroz","Planta","100","24"},
            {"9","Rayo Solar","Planta","100","35"},
            {"10","Bomba lodo", "Planta","32"},
            {"11","Caida Picada", "Volador", "20"},
            {"12","Ataque Fuego", "Fuego", "22"},
            {"13","Ataque Planta", "Planta", "20"},
            {"14","Ataque Volador", "Volador", "20"},
            {"15","Alto Impacto", "Electro", "30"},
            {"16","Electrocargado", "Electro", "50"},
            {"17","Sobrecarga", "Electro", "40"},
            {"18","Caza furtiva", "Volador", "30"},
            {"19","Picada", "Volador", "20"},
            {"20","Tormenta", "Electro", "35"}
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
            {"Fragmento Vital", "Revivir", "0.5","0","2"}
            //{"Piedra evolución", "Evolución", "0",""},
            //{"Baya", "Vida", "10","0"},
            //{"Curavita", "Vida", "30","0"},
        };

        //-------------------------------------//

        //---------Datos del Usuario--------------//
        //Formato Nivel, ExP, Dinero
        double usuarioDatos[] ={1,0,100};
        
        //Formato: Pokemon, Tipo1, Tipo2, Vida, Ataque, Defensa, Especial, Velocidad,Ataque1 Ataque2, Ataque 3 
        String pokemonesUsr1[][] = new String[MAX_POKEMONES][pokemones[0].length];
        String pokemonesUsr2[][] = new String[MAX_POKEMONES][pokemones[0].length];

        String ataquesPokU1[][] = new String[MAX_POKEMONES*MAX_ATAQUES][ataques[0].length];
        String ataquesPokU2[][] = new String[MAX_POKEMONES*MAX_ATAQUES][ataques[0].length];

        
        //Se van agregando segun pase el tiempo
        String objetosUsr1[][] = new String[3][objetos[0].length];
        String objetosUsr2[][] = new String[3][objetos[0].length];

            pokemonesUsr1= pokemonesRndm(pokemonesUsr1, pokemones);
            ataquesPokU1= ataquesRndm(ataquesPokU1, ataques,pokemonesUsr1);
            pokemonesUsr2= pokemonesRndm(pokemonesUsr2, pokemones);
            ataquesPokU2= ataquesRndm(ataquesPokU2, ataques,pokemonesUsr2);

            //objetosUsr = ataquesRndm(objetosUsr, objetos);

        pelea(pokemonesUsr1,pokemonesUsr2,ataquesPokU1,ataquesPokU2,objetosUsr1,objetosUsr2,"J1","J2");
    }

    public static String[][] pokemonesRndm(String pokemonesU[][], String pokemonesGen[][]) {
    
        for(int i=0; i<pokemonesU.length; i++) {
            int random = (int)(Math.random()*pokemonesGen.length);
            String[] pokemon = pokemonesGen[random];
            pokemonesU[i] = pokemon;
        }

        return pokemonesU;
    }

    public static String[][] ataquesRndm(String ataquesPok[][], String ataquesGen[][],String[][] pokemones) {
        //Por las dudas :), si el usuario tiene mas ataques que el generador, devuelve el arrelgo sin modificar
        if(ataquesGen.length<ataquesPok.length) {
            System.out.println("El número de ataques generados es menor que el número de ataques del usuario");
            return ataquesPok;
        }
        
        //Un i<Cantidad de pokemones= ataques totales/ ataques por pokemon
        for(int i=0; i<ataquesPok.length/MAX_ATAQUES; i++) {
            for(int j=0; j<MAX_ATAQUES; j++) {
                int random;
                boolean repetido=false;
                do{ 
                    repetido=false;
                    random = (int)(Math.random()*ataquesGen.length);
                    for(int c=0; c<j; c++) {
                        if(ataquesPok[i*MAX_ATAQUES+c][0]==ataquesGen[random][0] ) {
                            repetido=true;
                            break;
                        }
                    }
                }while(repetido);
                String[] ataque = ataquesGen[random];
                ataquesPok[i*MAX_ATAQUES+j] = ataque;
            }
        }
            
        return ataquesPok;
    }


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
        if(Integer.parseInt(pokemonesU1[0][IDX_VELOCIDAD_POKEMON])<=Integer.parseInt(pokemonesU2[0][IDX_VELOCIDAD_POKEMON]))jugador1=false;
        do{
            String ataquesPokAct1[][]={
                ataquesPokU1[0+pokActivoU1*3],
                ataquesPokU1[1+pokActivoU1*3],
                ataquesPokU1[2+pokActivoU1*3],
            };
            String ataquesPokAct2[][]={
                ataquesPokU1[0+pokActivoU2*3],
                ataquesPokU1[1+pokActivoU2*3],
                ataquesPokU1[2+pokActivoU2*3],
            };
        
            turno++;
            validarEfectosEnJugadores();

            if(jugador1) {
                //Si el usuario 1 es mas veloz, se va a empezar con el usuario 1
                mostrarPokemon(pokemonesU1[pokActivoU1],ataquesPokAct1,pokemonesU2[pokActivoU2],turno,Jugador1);
                eleccion=sc.nextInt();
                if(eleccion==5){
                    cambiarPokemon(pokemonesU1, pokActivoU1);//Cambio de pokemon
                } else if (eleccion == 4) {
                    //Cuando se elija 4.
                    if (objetosRestantesUsr1==0) {
                        p("No hay objetos disponibles para usar");
                    } else {
                        p("Elija el objeto que quiere usar:");
                        imprimirObjetosEnumarado(objetosUsr1);
                        //Validacion eleccion entre 1 y objetosRestantes
                        eleccion=Integer.parseInt(sc.nextLine());
                        //TU BOOLEAN PARA FINALIZAR TURNO
                        boolean tuBandera = usarObjeto(eleccion,pokActivoU1,pokActivoU2,pokemonesU1,pokemonesU2,efectosPokemonesUsr1,efectosPokemonesUsr2,objetosUsr1,pokemonesUsuario1);
                    }
                    
                } else{
                    atacar(eleccion,pokemonesU1[pokActivoU1],ataquesPokAct1[eleccion],pokemonesU2[pokActivoU2]);
                }
            }else {
                //Si el usuario 2 es mas veloz, se va a empezar con el usuario 2
                mostrarPokemon(pokemonesU1[pokActivoU1],ataquesPokAct2,pokemonesU2[pokActivoU1],turno,Jugador2);
                eleccion=sc.nextInt();
                do{
                    if(eleccion==5){
                        cambiarPokemon(pokemonesU2, pokActivoU2);
                    }else if (eleccion == 4) {
                    //Cuando se elija 4.
                    if (objetosRestantesUsr2==0) {
                        p("No hay objetos disponibles para usar");
                    } else {
                        p("Elija el objeto que quiere usar:");
                        imprimirObjetosEnumarado(objetosUsr2);
                        //Validacion eleccion entre 1 y objetosRestantes
                        eleccion=Integer.parseInt(sc.nextLine());
                        //TU BOOLEAN PARA FINALIZAR TURNO
                        boolean tuBandera = usarObjeto(eleccion,pokActivoU2,pokActivoU1,pokemonesU2,pokemonesU1,efectosPokemonesUsr2,efectosPokemonesUsr1,objetosUsr2,pokemonesUsuario2);
                    }
                    
                }else{
                        atacar(eleccion,pokemonesU2[pokActivoU2],ataquesPokAct2[eleccion],pokemonesU1[pokActivoU1]);
                    }
                }while(eleccion<0 || eleccion>=MAX_ATAQUES+2);
            }
 
            jugador1=!jugador1;
        
        }while((pokemonesUsuario1>0)&&(pokemonesUsuario2>0));
        return 0;
    }

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

    public static String atacar(int eleccion, String[]pokemonAtacante, String[] ataquePokemon,String []pokemonAfectado) {

        int vidaPokemon = Integer.parseInt(pokemonAfectado[IDX_VIDA_POKEMON]);

        int danioPokemon = Integer.parseInt(ataquePokemon[IDX_DANOS]);
        int defensaPokemonA = Integer.parseInt(pokemonAfectado[IDX_DEFENSA_POKEMON]);
        int danioHabilidad = Integer.parseInt(ataquePokemon[IDX_DANOS]);
        double ventajaAtaque = ventajaAtributo(ataquePokemon[IDX_ATRIBUTO_ATAQUE], pokemonAfectado[IDX_TIPO1_POKEMON],pokemonAfectado[IDX_TIPO2_POKEMON]);

        double danio = ((danioHabilidad*danioPokemon)/defensaPokemonA)*ventajaAtaque;
        vidaPokemon-= danio;
        if(vidaPokemon<0)vidaPokemon=0;
        if(ventajaAtaque>1)p("El ataque de "+pokemonAtacante[IDX_NOMBRE_POKEMON]+" es efectivo");
        else if(ventajaAtaque<1)p("El ataque de "+pokemonAtacante[IDX_NOMBRE_POKEMON]+" es debil");
        p("El ataque de "+pokemonAtacante[IDX_NOMBRE_POKEMON]+" inflige "+danio+" PS de danio");
        return Integer.toString(vidaPokemon);
    }
 
    public static int cambiarPokemon(String[][]pokemones, int pokemonAct){
        int posicion=0;
        do{
            p("Escriba la posicion del pokemon que quieres usar");
                posicion=sc.nextInt()-1;
            if(pokemones[pokemonAct][IDX_VIDA_POKEMON].equals("0")){
                p("Ese pokemon no tiene vida, intente de nuevo");posicion=-1;
            }
        }while(posicion<0||posicion>=MAX_POKEMONES||posicion==pokemonAct);
        pokemonAct=posicion;

        return posicion;
    }

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

    public static void validarEfectosEnJugadores(){}

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
    public static void imprimirObjetosEnumarado(String[][] objetosUsr) {

        for(int i =0; i < objetosUsr.length; i++) {
            if(!objetosUsr[i][IDX_CANTIDAD_OBJETO].equals("0")) {
                p((i+1) + ". " + objetosUsr[i][IDX_NOMBRE_OBJETO]);
            }
                
            } 

        
    }
}