import java.util.*;
//Se declara que la clase se extiende de una clase padre
public class Buscaminas extends Heren{
    //se declara el constructor
    public Buscaminas(){
    }
    //acceso a las variables de herencia
    public Buscaminas(String nombre, String gamertag, int id){
        super(nombre,gamertag,id);
    }
    //se declara el scanner
    Scanner entrada = new Scanner (System.in);
    //metodo para invocar al juego (dificultad facil)
    //juego basado en el de Mitchel Hdz ((2016))
	public void juego(){
		
		//se crea un array, de 215x15, el cual sera nuesto "Tablero", aunque no se representara graficamente
		int tablero [][]= new int[15][15];
		double w=0;
  		double z=0;
		int ntminas=0;
		int intento=75;
		int tminas=10;
		
		for(int j=0;j<15;j++)
			for (int i=0;i<15;i++)
				tablero [j][i]=0;
		
		do  {  
            //se usa math randmon para que la pocision en la que se encuentran las minas sea diferente
     			w=Math.random()*15;
        		z=Math.random()*15;  
           		w=(int)w;
           		z=(int)z;
           		if  (z!=0 && w!=0 && z!=15-1 && w!=15-1){
             	tablero[(int)w][(int) z ]=1;
              	ntminas++;
           			}
       		}while (ntminas<=10);
       
               //se hace uso de la herencia
        System.out.println("\n****************************************************************");
        System.out.println("\nHola "+getGamertag()+"                                          *");
        System.out.println("\nSuerte "+getNombre()+"                                          *");
        System.out.println("\nTu ID es: "+getId()+"                                          *");
        System.out.println("\n****************************************************************");
       	System.out.println("  Ingresa una coordenada, seleccionando dos numeros del 1 al 15");
       	do {
       		int x=0,y=0;            //por este medio se repetira el programa en 0 cada turno
       		int nminas = 0;
       		
       		do{
       			 System.out.println("\n-******************************************************");
       			 System.out.println("\n	Intento :"+intento+" , Ingrese una coordenada? \n");
       			 System.out.print("		Fila:  ");
       			 x=entrada.nextInt();
       			 System.out.println();
       			 System.out.print("		Columna:  ");
       			 y=entrada.nextInt();
       			 
       			 if(x==0 || y==0 || x>15 || y>15)
       			 	System.out.println("\n	==>Ojo a la comedia<== \n");
       		}while (x==0 || y==0 || x>15 || y>15);
       		
       		x=x-1;
       		y=y-1;
               //**Operacion con base en la de Mitchell Hdz creada hace 6 años**
               //Se diseña un modelo por el medio del que se determinara el numero de minas cercanas, o si diste a una mina
               //esto se hace dependiendo de la coordenada que hayas ingresado
               //nunca sera igual gracias al math random
       		if(tablero [x][y]==0){
       			
       			if (x==0&&y==0){
       				if(x+1>=0 && x+1<15 && y<15)
       					nminas=nminas+tablero [x+1][y];
       				if(x+1>=0 && x+1<15 && y+1<15 && y+1>=0)
       					nminas=nminas+tablero [x+1][y+1];
       				if(x>=0 && x<15 && y+1<15 && y+1>= 0)
       					nminas=nminas+tablero [x][y+1];
       			}
       			else {
       				if(y==0){
       					if(x+1>=0 && x+1<15 && y<15)
       						nminas=nminas+tablero [x+1][y];
       					if(x-1>=0 && x-1<15 && y<15)
       						nminas=nminas+tablero [x-1][y];
       					if(x-1>=0 && x-1<15 && y+1<15 && y+1>=0)
       						nminas=nminas+tablero [x-1][y+1];
       					if(x>=0 && x<15 && y+1<15 && y+1>= 0)
       						nminas=nminas+tablero [x][y+1];
       					if(x+1>=0 && x+1<15 && y+1<15 && y+1>=0)
       						nminas=nminas+tablero [x+1][y+1];
       					
       				}
       				
       				else{
       				
       					if(x-1>=0 && x-1<15 && y-1<15)
       						nminas=nminas+tablero [x-1][y-1];
       					if(x>=0 && x<15 && y-1<15)
       						nminas=nminas+tablero [x][y-1];
       					if(x+1>=0 && x+1<15 && y-1<15)
       						nminas=nminas+tablero [x+1][y-1];
       					if(x+1>=0 && x+1<15 && y<15)
       						nminas=nminas+tablero [x+1][y];
       					if(x-1>=0 && x-1<15 && y<15)
       						nminas=nminas+tablero [x-1][y];
       					if(x-1>=0 && x-1<15 && y+1<15 && y+1>=0)
       						nminas=nminas+tablero [x-1][y+1];
       					if(x>=0 && x<15 && y+1<15 && y+1>= 0)
       						nminas=nminas+tablero [x][y+1];
       					if(x+1>=0 && x+1<15 && y+1<15 && y+1>=0)
       						nminas=nminas+tablero [x+1][y+1];
       					}
       			 }
       			 System.out.print("\n	Mina no encontrada. ");
       			 
       			 if(intento>tminas)
       			 	 System.out.print("	Alrededor hay: "+ nminas);
       			 System.out.println("\n	Intentos restantes: "+(intento-1));
       		}
       		else
       			{
       				tminas = tminas-1;
       				System.out.println("\n	Acertaste!, Mina Eliminada Restan "+tminas+" Minas");
       				System.out.println("\n	Intentos restantes: "+(intento-1));
       			}
       	
          intento=intento-1;
      }while (intento>=tminas && intento>0 && tminas>0);	
 	   
       	if(tminas==0)
       		yay();
       	
       	if(tminas>intento)
       		efe();
       	
       	if(intento==0)
       		efe2();
        }
        //Creo metodos sencillos para disminuir la complejidad del metodo principal, ya que codeFactor me pone una mala calificación si es demasiado complejo D:
        public void efe(){
            System.out.println("Perdiste, hay mas minas que intentos, F");
        }
        public void efe2(){
            System.out.println("Perdiste, te quedaste sin intentos :(");
        }
        public void yay(){
            System.out.println("Felicidades, desactivaste todas las minas, ganaste :D");
        }
       
       
       
       
       
       
        public void juego1(){
		
            //se crea un array, de 20x20, el cual sera nuesto "Tablero", aunque no se representara graficamente
            int tablero [][]= new int[20][20];
            
            double w=0;
              double z=0;
            
            int ntminas=0;
            int intento=75;
            
            int tminas=10;
            
            for(int j=0;j<20;j++)
                for (int i=0;i<20;i++)
                    tablero [j][i]=0;
            
            do  {  
                     w=Math.random()*20;
                    z=Math.random()*20;  
                       w=(int)w;
                       z=(int)z;
                       if  (z!=0 && w!=0 && z!=20-1 && w!=20-1){
                     tablero[(int)w][(int) z ]=1;
                      ntminas++;
                           }
                   }while (ntminas<=10);
          
            System.out.println("\n****************************************************************");
            System.out.println("\nHola "+getGamertag()+"                                         *");
            System.out.println("\nSuerte "+getNombre()+"                                         *");
            System.out.println("\nTu ID es: "+getId()+"                                          *");
            System.out.println("\n****************************************************************");
               System.out.println("  Ingresa una coordenada, seleccionando dos numeros del 1 al 20");
               do {
                   int x=0,y=0;
                   int nminas = 0;
                   
                   do{
                        System.out.println("\n-******************************************************");
                        System.out.println("\n	Intento :"+intento+" , Ingrese una coordenada? \n");
                        System.out.print("		Fila:  ");
                        x=entrada.nextInt();
                        System.out.println();
                        System.out.print("		Columna:  ");
                        y=entrada.nextInt();
                        
                        if(x==0 || y==0 || x>20 || y>20)
                            System.out.println("\n	==>Ojo a la comedia<== \n");
                   }while (x==0 || y==0 || x>20 || y>20);
                   
                   x=x-1;
                   y=y-1;
                   
                   if(tablero [x][y]==0){
                       
                       if (x==0&&y==0){
                           if(x+1>=0 && x+1<20 && y<20)
                               nminas=nminas+tablero [x+1][y];
                           if(x+1>=0 && x+1<20 && y+1<20 && y+1>=0)
                               nminas=nminas+tablero [x+1][y+1];
                           if(x>=0 && x<20 && y+1<20 && y+1>= 0)
                               nminas=nminas+tablero [x][y+1];
                       }
                       else {
                           if(y==0){
                               if(x+1>=0 && x+1<20 && y<20)
                                   nminas=nminas+tablero [x+1][y];
                               if(x-1>=0 && x-1<20 && y<20)
                                   nminas=nminas+tablero [x-1][y];
                               if(x-1>=0 && x-1<20 && y+1<20 && y+1>=0)
                                   nminas=nminas+tablero [x-1][y+1];
                               if(x>=0 && x<20 && y+1<20 && y+1>= 0)
                                   nminas=nminas+tablero [x][y+1];
                               if(x+1>=0 && x+1<20 && y+1<20 && y+1>=0)
                                   nminas=nminas+tablero [x+1][y+1];
                               
                           }
                           
                           else{
                           
                               if(x-1>=0 && x-1<20 && y-1<20)
                                   nminas=nminas+tablero [x-1][y-1];
                               if(x>=0 && x<20 && y-1<20)
                                   nminas=nminas+tablero [x][y-1];
                               if(x+1>=0 && x+1<20 && y-1<20)
                                   nminas=nminas+tablero [x+1][y-1];
                               if(x+1>=0 && x+1<20 && y<20)
                                   nminas=nminas+tablero [x+1][y];
                               if(x-1>=0 && x-1<20 && y<20)
                                   nminas=nminas+tablero [x-1][y];
                               if(x-1>=0 && x-1<20 && y+1<20 && y+1>=0)
                                   nminas=nminas+tablero [x-1][y+1];
                               if(x>=0 && x<20 && y+1<20 && y+1>= 0)
                                   nminas=nminas+tablero [x][y+1];
                               if(x+1>=0 && x+1<20 && y+1<20 && y+1>=0)
                                   nminas=nminas+tablero [x+1][y+1];
                               }
                        }
                        System.out.print("\n	Mina no encontrada. ");
                        
                        if(intento>tminas)
                             System.out.print("	Alrededor hay: "+ nminas);
                        System.out.println("\n	Intentos restantes: "+(intento-1));
                   }
                   else
                       {
                           tminas = tminas-1;
                           System.out.println("\n	Acertaste!, Mina Eliminada Restan "+tminas+" Minas");
                           System.out.println("\n	Intentos restantes: "+(intento-1));
                       }
               
              intento=intento-1;
          }while (intento>=tminas && intento>0 && tminas>0);	
            
               if(tminas==0)
                   yay();
               
               if(tminas>intento)
                   efe();
               
               if(intento==0)
                   efe2();
            }
            
            
            
            
            
            public void juego2(){
		
                //se crea un array, de 30x30, el cual sera nuesto "Tablero", aunque no se representara graficamente
                int tablero [][]= new int[30][30];
                
                double w=0;
                  double z=0;
                
                int ntminas=0;
                int intento=70;
                
                int tminas=10;
                
                for(int j=0;j<20;j++)
                    for (int i=0;i<20;i++)
                        tablero [j][i]=0;
                
                do  {  
                         w=Math.random()*30;
                        z=Math.random()*30;  
                           w=(int)w;
                           z=(int)z;
                           if  (z!=0 && w!=0 && z!=30-1 && w!=30-1){
                         tablero[(int)w][(int) z ]=1;
                          ntminas++;
                               }
                       }while (ntminas<=10);
               
              
                System.out.println("\n****************************************************************");
                System.out.println("\nHola "+getGamertag()+"                                         *");
                System.out.println("\nSuerte "+getNombre()+"                                         *");
                System.out.println("\nTu ID es: "+getId()+"                                          *");
                System.out.println("\n****************************************************************");
                   System.out.println("  Ingresa una coordenada, seleccionando dos numeros del 1 al 30");
                   do {
                       int x=0,y=0;
                       int nminas = 0;
                       
                       do{
                            System.out.println("\n-******************************************************");
                            System.out.println("\n	Intento :"+intento+" , Ingrese una coordenada? \n");
                            System.out.print("		Fila:  ");
                            x=entrada.nextInt();
                            System.out.println();
                            System.out.print("		Columna:  ");
                            y=entrada.nextInt();
                            
                            if(x==0 || y==0 || x>30 || y>30)
                                System.out.println("\n	==>Ojo a la comedia<== \n");
                       }while (x==0 || y==0 || x>30 || y>30);
                       
                       x=x-1;
                       y=y-1;
                       
                       if(tablero [x][y]==0){
                           
                           if (x==0&&y==0){
                               if(x+1>=0 && x+1<30 && y<30)
                                   nminas=nminas+tablero [x+1][y];
                               if(x+1>=0 && x+1<30 && y+1<30 && y+1>=0)
                                   nminas=nminas+tablero [x+1][y+1];
                               if(x>=0 && x<30 && y+1<30 && y+1>= 0)
                                   nminas=nminas+tablero [x][y+1];
                           }
                           else {
                               if(y==0){
                                   if(x+1>=0 && x+1<30 && y<30)
                                       nminas=nminas+tablero [x+1][y];
                                   if(x-1>=0 && x-1<30 && y<30)
                                       nminas=nminas+tablero [x-1][y];
                                   if(x-1>=0 && x-1<30 && y+1<30 && y+1>=0)
                                       nminas=nminas+tablero [x-1][y+1];
                                   if(x>=0 && x<30 && y+1<30 && y+1>= 0)
                                       nminas=nminas+tablero [x][y+1];
                                   if(x+1>=0 && x+1<30 && y+1<30 && y+1>=0)
                                       nminas=nminas+tablero [x+1][y+1];
                                   
                               }
                               
                               else{
                               
                                   if(x-1>=0 && x-1<30 && y-1<30)
                                       nminas=nminas+tablero [x-1][y-1];
                                   if(x>=0 && x<30 && y-1<30)
                                       nminas=nminas+tablero [x][y-1];
                                   if(x+1>=0 && x+1<30 && y-1<30)
                                       nminas=nminas+tablero [x+1][y-1];
                                   if(x+1>=0 && x+1<30 && y<30)
                                       nminas=nminas+tablero [x+1][y];
                                   if(x-1>=0 && x-1<30 && y<30)
                                       nminas=nminas+tablero [x-1][y];
                                   if(x-1>=0 && x-1<30 && y+1<30 && y+1>=0)
                                       nminas=nminas+tablero [x-1][y+1];
                                   if(x>=0 && x<30 && y+1<30 && y+1>= 0)
                                       nminas=nminas+tablero [x][y+1];
                                   if(x+1>=0 && x+1<30 && y+1<30 && y+1>=0)
                                       nminas=nminas+tablero [x+1][y+1];
                                   }
                            }
                            System.out.print("\n	Mina no encontrada. ");
                            
                            if(intento>tminas)
                                 System.out.print("	Alrededor hay: "+ nminas);
                            System.out.println("\n	Intentos restantes: "+(intento-1));
                       }
                       else
                           {
                               tminas = tminas-1;
                               System.out.println("\n	Acertaste!, Mina Eliminada Restan "+tminas+" Minas");
                               System.out.println("\n	Intentos restantes: "+(intento-1));
                           }
                   
                  intento=intento-1;
              }while (intento>=tminas && intento>0 && tminas>0);	
                
                   if(tminas==0)
                       yay();
                   
                   if(tminas>intento)
                       efe();
                   
                   if(intento==0)
                       efe2();
                }
                
                
                
                
                public void juego3(){
		
                    //se crea un array, de 40x40, el cual sera nuesto "Tablero", aunque no se representara graficamente
                    int tablero [][]= new int[40][40];
                    
                    double w=0;
                      double z=0;
                    
                    int ntminas=0;
                    int intento=70;
                    
                    int tminas=10;
                    
                    for(int j=0;j<40;j++)
                        for (int i=0;i<40;i++)
                            tablero [j][i]=0;
                    
                    do  {  
                             w=Math.random()*40;
                            z=Math.random()*40;  
                               w=(int)w;
                               z=(int)z;
                               if  (z!=0 && w!=0 && z!=40-1 && w!=40-1){
                             tablero[(int)w][(int) z ]=1;
                              ntminas++;
                                   }
                           }while (ntminas<=10);
                  
                    System.out.println("\n****************************************************************");
                    System.out.println("\nHola "+getGamertag()+"                                         *");
                    System.out.println("\nSuerte "+getNombre()+"                                         *");
                    System.out.println("\nTu ID es: "+getId()+"                                          *");
                    System.out.println("\n****************************************************************");
                       System.out.println("  Ingresa una coordenada, seleccionando dos numeros del 1 al 40");
                       do {
                           int x=0,y=0;
                           int nminas = 0;
                           
                           do{
                                System.out.println("\n-******************************************************");
                                System.out.println("\n	Intento :"+intento+" , Ingrese una coordenada? \n");
                                System.out.print("		Fila:  ");
                                x=entrada.nextInt();
                                System.out.println();
                                System.out.print("		Columna:  ");
                                y=entrada.nextInt();
                                
                                if(x==0 || y==0 || x>40 || y>40)
                                    System.out.println("\n	==>Ojo a la comedia<== \n");
                           }while (x==0 || y==0 || x>40 || y>40);
                           
                           x=x-1;
                           y=y-1;
                           
                           if(tablero [x][y]==0){
                               
                               if (x==0&&y==0){
                                   if(x+1>=0 && x+1<40 && y<40)
                                       nminas=nminas+tablero [x+1][y];
                                   if(x+1>=0 && x+1<40 && y+1<40 && y+1>=0)
                                       nminas=nminas+tablero [x+1][y+1];
                                   if(x>=0 && x<40 && y+1<40 && y+1>= 0)
                                       nminas=nminas+tablero [x][y+1];
                               }
                               else {
                                   if(y==0){
                                       if(x+1>=0 && x+1<40 && y<40)
                                           nminas=nminas+tablero [x+1][y];
                                       if(x-1>=0 && x-1<40 && y<40)
                                           nminas=nminas+tablero [x-1][y];
                                       if(x-1>=0 && x-1<40 && y+1<40 && y+1>=0)
                                           nminas=nminas+tablero [x-1][y+1];
                                       if(x>=0 && x<40 && y+1<40 && y+1>= 0)
                                           nminas=nminas+tablero [x][y+1];
                                       if(x+1>=0 && x+1<40 && y+1<40 && y+1>=0)
                                           nminas=nminas+tablero [x+1][y+1];
                                       
                                   }
                                   
                                   else{
                                   
                                       if(x-1>=0 && x-1<40 && y-1<40)
                                           nminas=nminas+tablero [x-1][y-1];
                                       if(x>=0 && x<40 && y-1<40)
                                           nminas=nminas+tablero [x][y-1];
                                       if(x+1>=0 && x+1<40 && y-1<40)
                                           nminas=nminas+tablero [x+1][y-1];
                                       if(x+1>=0 && x+1<40 && y<40)
                                           nminas=nminas+tablero [x+1][y];
                                       if(x-1>=0 && x-1<40 && y<40)
                                           nminas=nminas+tablero [x-1][y];
                                       if(x-1>=0 && x-1<40 && y+1<40 && y+1>=0)
                                           nminas=nminas+tablero [x-1][y+1];
                                       if(x>=0 && x<40 && y+1<40 && y+1>= 0)
                                           nminas=nminas+tablero [x][y+1];
                                       if(x+1>=0 && x+1<40 && y+1<40 && y+1>=0)
                                           nminas=nminas+tablero [x+1][y+1];
                                       }
                                }
                                System.out.print("\n	Mina no encontrada. ");
                                
                                if(intento>tminas)
                                     System.out.print("	Alrededor hay: "+ nminas);
                                System.out.println("\n	Intentos restantes: "+(intento-1));
                           }
                           else
                               {
                                   tminas = tminas-1;
                                   System.out.println("\n	Acertaste!, Mina Eliminada Restan "+tminas+" Minas");
                                   System.out.println("\n	Intentos restantes: "+(intento-1));
                               }
                       
                      intento=intento-1;
                  }while (intento>=tminas && intento>0 && tminas>0);	
                    
                       if(tminas==0)
                           yay();
                       
                       if(tminas>intento)
                           efe();
                       
                       if(intento==0)
                           efe2();


}
}