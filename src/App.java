import java.util.Arrays;
import java.util.Scanner;


public class App {

    //ARROZ CON WEBO y cebolla

    //Constantes
    static final int MAX_POKEMONES = 3;
    static final int MAX_ATAQUES = 3;

    static final int IDX_NOMBRE_POKEMON = 0;
    static final int IDX_TIPO1_POKEMON = 1;
    static final int IDX_TIPO2_POKEMON = 2;
    static final int IDX_VIDA_POKEMON = 3;
    static final int IDX_ATAQUE_POKEMON = 4;
    static final int IDX_DEFENSA_POKEMON = 5;
    static final int IDX_VELOCIDAD_POKEMON = 6;

    static final int IDX_DANOS =3;
    static final int IDX_NOMBRE_OBJETO = 0;
    static final int IDX_EFECTO_OBJETO = 1;
    static final int IDX_VALOR_EFECTO_OBJETO = 2;
    static final int IDX_ATRIBUTO_ATAQUE =  2;

    static Scanner sc = new Scanner(System.in);
    static int opcUsuario = 0, opcOrdenamiento = 0, pos = 0;

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



        String nombreUsuario = "David";
        //---------Datos del Juego--------------//
        String pokemones[][]={
            //Formato: Nombre, Tipo1, Tipo2, Vida, Ataque, Defensa, Velocidad
            {"Bulbasaur","Planta","Veneno","30","7","80","10"},
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
            //Formato: Nombre, Efecto, Valor, Duracion
            {"Frasco Vida", "Vida", "20"},
            {"Frasco Ataque", "Ataque", "20"},
            {"Frasco Defensa", "Defensa", "20"},
            {"Frasco Veneno", "Veneno", "20"},
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

        
        do{
        imprimirTablaDatos(pokemones);
        
        imprimirMenuOpciones();

        opcUsuario = sc.nextInt();
        sc.nextLine();

        String [] [] copiaPokemones = copiarMatriz(pokemones);
        switch (opcUsuario){
            case 1:
            System.out.println("\nUsted ha seleccionado ordenar alfabéticamente");
            pos = 0;
            imprimirMenuOrdenamiento();
            opcOrdenamiento = sc.nextInt();
            switch (opcOrdenamiento) {
                case 1:
                    System.out.println("\nUsted ha seleccionado ordenar por BubbleSort");
                    String [] [] matOrdenAlfabeticoUno = ordenarBurbuja(copiaPokemones, pos);
                    System.out.println("\nPokemones ordenados alfabéticamente: ");
                    imprimirTablaDatos(matOrdenAlfabeticoUno);
                    break;
                case 2:
                    System.out.println("\nUsted ha seleccionado ordenar por Selección");
                    String [] [] matOrdenAlfabeticoDos = ordenarSeleccion(copiaPokemones, pos);
                    System.out.println("\nPokemones ordenados alfabéticamente: ");
                    imprimirTablaDatos(matOrdenAlfabeticoDos);
                    break;
                case 3:
                    System.out.println("\nUsted ha seleccionado ordenar por Quicksort");
                    int inicio = 0, fin = copiaPokemones.length - 1;
                    String [] [] matOrdenAlfabeticoTres = ordenarQuicksort(copiaPokemones, inicio, fin, pos);
                    imprimirTablaDatos(matOrdenAlfabeticoTres);
                    break;
                case 4:
                    System.out.println("\nUsted ha regresado al menú principal");
                    break;
                default:
                    System.out.println("\nUsted ha ingresado una opción incorrecta");
                    break;
            }
            break;
            case 2:
            System.out.println("\nUsted ha seleccionado ordenar los pokemones por tipo Uno");
            pos = 1;
            imprimirMenuOrdenamiento();
            opcOrdenamiento = sc.nextInt();
            switch (opcOrdenamiento) {
                case 1:
                    System.out.println("\nUsted ha seleccionado ordenar por BubbleSort");
                    String [] [] matOrdenTipoUno = ordenarBurbuja(copiaPokemones, pos);
                    System.out.println("\nPokemones ordenados alfabéticamente: ");
                    imprimirTablaDatos(matOrdenTipoUno);
                    break;
                case 2:
                    System.out.println("\nUsted ha seleccionado ordenar por Selección");
                    String [] [] matOrdenTipoDos = ordenarSeleccion(copiaPokemones, pos);
                    System.out.println("\nPokemones ordenados alfabéticamente: ");
                    imprimirTablaDatos(matOrdenTipoDos);
                    break;
                case 3:
                    System.out.println("\nUsted ha seleccionado ordenar por Quicksort");
                    int inicio = 0, fin = copiaPokemones.length - 1;
                    String [] [] matOrdenTipoTres = ordenarQuicksort(copiaPokemones, inicio, fin, pos);
                    imprimirTablaDatos(matOrdenTipoTres);
                    break;
                case 4:
                    System.out.println("\nUsted ha regresado al menú principal");
                    break;
                default:
                    System.out.println("\nUsted ha ingresado una opción incorrecta");
                    break;
                }
            break;
        }
        }while (opcUsuario != 6);
            
        

        

        //Se van agregando segun pase el tiempo
        String objetosUsr[][] = new String[3][objetos[0].length];

            pokemonesUsr1= pokemonesRndm(pokemonesUsr1, pokemones);
            ataquesPokU1= ataquesRndm(ataquesPokU1, ataques,pokemonesUsr1);
            pokemonesUsr2= pokemonesRndm(pokemonesUsr2, pokemones);
            ataquesPokU2= ataquesRndm(ataquesPokU2, ataques,pokemonesUsr2);

            //objetosUsr = ataquesRndm(objetosUsr, objetos);

        pelea(pokemonesUsr1,pokemonesUsr2,ataquesPokU1,ataquesPokU2,"J1","J2", objetosUsr);
    }

    public static void imprimirMenuOrdenamiento() {
        System.out.println("===================== MENU DE ORDENAMIENTO =====================");
        System.out.println("1.- Ordenar por BubbleSort");
        System.out.println("2.- Ordenar por Selección");
        System.out.println("3.- Ordenar por Quicksort");
        System.out.println("4.- Salir");
    }
    public static String[][] ordenarQuicksort(String[][] copiaPokemones, int inicio, int fin, int pos3) {
        if (inicio < fin){
            int pivote = particionar (copiaPokemones, inicio, fin, pos3);
            ordenarQuicksort(copiaPokemones, inicio, pivote - 1, pos3);
            ordenarQuicksort(copiaPokemones, pivote + 1, fin, pos3);
        }
        return copiaPokemones;
    }
    public static int particionar(String[][] copiaPokemones, int inicio, int fin, int pos3) {
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
    public static String[][] ordenarSeleccion(String[][] copiaPokemones, int pos2) {
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
    public static String[][] ordenarBurbuja(String[][] copiaPokemones, int pos) {
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

    public static void imprimirMenuOpciones() {
		System.out.println("=================== MENU DE OPERACIONES ===================");
		System.out.println("1.- Ordenar en orden alfabético");
		System.out.println("2.- Ordenar los pokemons por tipo");
		System.out.println("3.- Ordenar los pokémons por ataque");
		System.out.println("4.- Ordenar los pokémons por defensa");
		System.out.println("5.- Ordenar los pokémons por velocidad");
		System.out.println("6.- Salir");
		System.out.print("Seleccione una opción: ");
	}


	public static void imprimirTablaDatos(String[] [] copiaMatriz) {
		System.out.printf("\n%-20s %-15s %-15s %-10s %-10s %-10s %-10s \n", "Nombre", "Tipo1", "Tipo2", "Vida", "Ataque", "Defensa", "Velocidad");
		System.out.println("======================================================================================================");
		
		for (int i = 0; i < copiaMatriz.length; i++) {
                System.out.printf("%-20s %-15s %-15s %-10s %-10s %-10s %-10s\n",
                          copiaMatriz[i][0], copiaMatriz[i][1], copiaMatriz[i][2],
                          copiaMatriz[i][3], copiaMatriz[i][4], copiaMatriz[i][5], copiaMatriz[i][6]);
        }
	}
		
	


    public static int pelea(String[][] pokemonesU1, String[][] pokemonesU2, String[][] ataquesPokU1, String[][] ataquesPokU2, String Jugador1, String Jugador2, String[][]objetosUsr) {
        //Siempre se usa e primer poquemon de cada usario para empezar la pelea
        int pokemonesUsuario1 = MAX_POKEMONES; //pokemones vivos de cada usario
        int pokemonesUsuario2 = MAX_POKEMONES;
        String efectosPokemonesUsr1 [][] = new String[MAX_POKEMONES][objetosUsr.length];
        String efectosPokemonesUsr2 [][] = new String[MAX_POKEMONES][objetosUsr.length];
        int turno = 0;        int pokActivoU1 = 0;        int pokActivoU2 = 0;
        int eleccion=0;

        String efectosjugador1[][]= new String[MAX_POKEMONES][10];
        String efectosjugador2[][]= new String[MAX_POKEMONES][10];

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
                    cambiarPokemon(pokemonesU1, pokActivoU1);//Cambio de pokemon
                } else if (eleccion == 4) {
                    //Cuando se elija 4.
                    p("Elija el objeto que quiere usar:");
                    pFilasMismaColumna(objetosUsr,0,true);
                    eleccion=Integer.parseInt(sc.nextLine());
                    usarObjeto(eleccion,pokemonesU1[pokActivoU1],pokemonesU2[pokActivoU2],efectosPokemonesUsr1[pokActivoU1],efectosPokemonesUsr2[pokActivoU2],objetosUsr);
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
                    }else if(eleccion==4){
                        p("Elija el objeto que quiere usar:");
                    pFilasMismaColumna(objetosUsr,0,true);
                    eleccion=Integer.parseInt(sc.nextLine());
                    usarObjeto(eleccion,pokemonesU1[pokActivoU1],pokemonesU2[pokActivoU2],efectosPokemonesUsr1[pokActivoU1],efectosPokemonesUsr2[pokActivoU2],objetosUsr);
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
}