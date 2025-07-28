import java.util.Arrays;
import java.util.Scanner;


public class App {

    //Constantes
    static final int MAX_POKEMONES = 3;
    static final int MAX_ATAQUES = 3;
    static final int IDX_NOMBRE_POKEMON = 0;
    static final int IDX_VIDA_POKEMON = 3;
    static final int IDX_ATAQUE_POKEMON = 4;
    static final int IDX_DEFENSA_POKEMON = 5;
    static final int IDX_VELOCIDAD_POKEMON = 6;
    static final int IDX_DANOS =3;

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
    public static void main(String[] args) throws Exception {



        String nombreUsuario = "David";
        //---------Datos del Juego--------------//
        String pokemones[][]={
            //Formato: Nombre, Tipo1, Tipo2, Vida, Ataque, Defensa, Velocidad
            {"Bulbasaur","Hierba","Veneno","20","7","80","10"},
            {"Charmander","Fuego","None","40","8","80","15"},
            {"Squirtle","Agua","None","60","9","80","15"},
            {"Pikachu","Electro","None","35","4","70","17"},
            {"Charizard","Fuego","Volador","100","20","90","8"},
            {"Mewtwo","Fuego","Volador","100","20","90","8"},
            {"Mew","Psíquico","None","100","20","90","20"},
            {"Jigglypuff","Psíquico","None","100","20","90","14"},
            {"Arceus","Fuego","Volador","100","20","90","11"},
            {"Zapdos","Fuego","Volador","100","20","90","10"},
            {"Lugia","Electro","Volador","100","20","90","8"},
            {"Kyogre","Agua","Volador","100","20","90","8"},
        };

        String ataques[][]={
            //Formato: idAtaque(para evitar ataques repetidos),  Nombre, Tipo1, Daño, Precisión, Efecto
            //Tambien se podrian separar por tipo para hacer mas facil la busqueda
            {"1","Ataque Furia", "Normal", "20", "100", "None"},
            {"2","Impactrueno","Electro","40","100","None"},
            {"3","Colminllo Igneo","Fuego","60","100","None"},
            {"4","Pirotecnia","Fuego","80","100","None"},
            {"5","Hidrocañón","Agua","100","100","None"},
            {"6","Acua Cola","Agua","100","100","None"},
            {"7","Pistola Agua","Agua","100","100","None"},
            {"8","Planta Feroz","Planta","100","100","None"},
            {"9","Rayo Solar","Planta","100","100","None"},
            {"10","Bomba lodo", "Planta","100","100","Veneno"},
            {"11","Caida Picada", "Volador", "100", "100", "None"},
            {"12","Ataque Fuego", "Fuego", "100", "100", "None"},
            {"13","Ataque Planta", "Planta", "100", "100", "None"},
            {"14","Ataque Volador", "Volador", "100", "100", "None"},
            {"15","Alto Impacto", "Electro", "100", "100", "None"}
        };

        String objetos[][]={
            //Formato: Nombre, Efecto, Valor, Duracion
            {"Poké Ball", "Pokemon", "10"},
            {"Frasco Vida", "Vida", "20"},
            {"Frasco Ataque", "Ataque", "20"},
            {"Frasco Defensa", "Defensa", "20"},
            {"Frasco Velocidad", "Velocidad", "20"},
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
        String objetosUsr[][] = new String[3][objetos[0].length];

            pokemonesUsr1= pokemonesRndm(pokemonesUsr1, pokemones);
            ataquesPokU1= ataquesRndm(ataquesPokU1, ataques);
            pokemonesUsr2= pokemonesRndm(pokemonesUsr2, pokemones);
            ataquesPokU2= ataquesRndm(ataquesPokU2, ataques);

            //objetosUsr = ataquesRndm(objetosUsr, objetos);


        pArg(pokemonesUsr1);
        pArg(ataquesPokU1); 
        pArg(pokemonesUsr2);
        pArg(ataquesPokU2);
        p(Arrays.toString(usuarioDatos));

        pelea(pokemonesUsr1,pokemonesUsr2,ataquesPokU1,ataquesPokU2,"David","Balto");
    }

    public static String[][] pokemonesRndm(String pokemonesU[][], String pokemonesGen[][]) {
    
        for(int i=0; i<pokemonesU.length; i++) {
            int random = (int)(Math.random()*pokemonesGen.length);
            String[] pokemon = pokemonesGen[random];
            pokemonesU[i] = pokemon;
        }

        return pokemonesU;
    }

    public static String[][] ataquesRndm(String ataquesPok[][], String ataquesGen[][]) {
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
                    /*            
                    *HashSet<Integer> repetidos = new HashSet<Integer>();
                    *repetidos.add(random);
                    do while(repetidos.contains(random));
                    */

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


    public static int pelea(String[][] pokemonesU1, String[][] pokemonesU2, String[][] ataquesPokU1, String[][] ataquesPokU2, String Jugador1, String Jugador2) {
        //Siempre se usa e primer poquemon de cada usario para empezar la pelea
        int pokemonesUsuario1 = MAX_POKEMONES; //pokemones vivos de cada usario
        int pokemonesUsuario2 = MAX_POKEMONES;
        int turno = 0;
        int pokActivoU1 = 0;
        int pokActivoU2 = 0;
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
            if(jugador1) {
                //Si el usuario 1 es mas veloz, se va a empezar con el usuario 1
                mostrarPokemon(pokemonesU1[pokActivoU1],ataquesPokAct1,pokemonesU2[pokActivoU2],turno,Jugador1);
                eleccion=sc.nextInt();
                if(eleccion==5){
                    do{
                    p("Escriba la posicion del pokemon que quieres usar");
                    eleccion=sc.nextInt()-1;
                    }while(eleccion<0||eleccion>=MAX_POKEMONES||eleccion==pokActivoU1);
                }else{
                    atacar(eleccion,pokemonesU1[pokActivoU1],ataquesPokAct1[eleccion],pokemonesU2[pokActivoU2],turno);
                }
            }else {
                //Si el usuario 2 es mas veloz, se va a empezar con el usuario 2
                mostrarPokemon(pokemonesU1[pokActivoU1],ataquesPokAct2,pokemonesU2[pokActivoU1],turno,Jugador2);
                eleccion=sc.nextInt();
                if(eleccion==5){
                    do{
                    p("Escriba la posicion del pokemon que quieres usar");
                    eleccion=sc.nextInt()-1;
                    }while(eleccion<0||eleccion>=MAX_POKEMONES||eleccion==pokActivoU1);
                }else{
                    atacar(eleccion,pokemonesU2[pokActivoU2],ataquesPokAct2[eleccion],pokemonesU1[pokActivoU1],turno);
                }
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

    public static void atacar(int eleccion, String[]pokemonAtacante, String[] ataquePokemon,String []pokemonAfectado, int turno) {

        int vidaPokemon = Integer.parseInt(pokemonAfectado[IDX_VIDA_POKEMON]);

        int danioPokemon = Integer.parseInt(ataquePokemon[IDX_DANOS]);
        int defensaPokemon = Integer.parseInt(pokemonAfectado[IDX_DEFENSA_POKEMON]);
        int danioHabilidad = Integer.parseInt(ataquePokemon[IDX_DANOS]);

        vidaPokemon-= danioHabilidad*danioPokemon/defensaPokemon;
        if(vidaPokemon<0)vidaPokemon=0;
        p("El ataque de "+ataquePokemon[IDX_NOMBRE_POKEMON]+" inflige "+danioPokemon+" PS de danio y "+danioHabilidad+" PS de danio habilidad");

    }

}