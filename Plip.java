/** 
   * Description : This programming assignment introduces a creature named Plip
               that move around using the move() method. The method is designed such that
               the creature moves in a certain direction unless it is adjacent to the border 
               and continues to move in opposite direction till it hit the other border and 
               continues. The life units decreases by two units with every move.
   *
   * Name : Reeya Dangol   
*/

/**
 * Class that represents a Plip creature
 */
 
public class Plip extends Creature
{

   //data fields
   
   /**
      * stores the units of life of Plip
   */
    
   private int lifeUnits;
      
   /**
      * keeps track of which direction the Plip is moving
   */
   private boolean plip_moves_east = true;


   /**
      * Initializes a object with all properties specified
      * @param lifeUnits the units of life the Plip has
      * @param x represents the x coordinate
      * @param y represents the y coordinate 
   */
   
   public Plip(int lifeUnits, int x, int y)
   {
   
      //Calls the constructor of the superclass Creature
      super(x, y);
      this.lifeUnits = lifeUnits;    
   }
   
   
   /**
      * method abstract in the superclass
      * enables the Plip creature to move around the world 
   */

   public void move()
   {  
   
      //Plip must have, at a minimum, two life units before it can move
      if (lifeUnits >= 2)
      {  
         //gets the value of x coordinate checks if it is greater than or equals to 19 (world's eastern boundary and beyond)
         if (getX() >= 19)
         {
            //the plip no longer moves east, for it is in the world's eastern boundary
            plip_moves_east = false;
            
            //the value of x coordinate is set to 19 (world's eastern boundary), as the world beyond is currently out of bound
            setX(19);   
         }
         
         //gets the value of x coordinate and checks if it is less than or equals to 0 (world's western boundary and beyond)
         else if (getX() <= 0)
         {
            //the plip starts to move east, for it is in the world's western boundary
            plip_moves_east = true;
            
            //the value of x coordinate is set to 0 (world's western boundary), as the world beyond is still out of bound
            setX(0);
         }
         
       
         if (plip_moves_east)
         {
            //x coordinate increases by 1 when it moves east
            setX(getX() + 1);
            
            //life unit decreases by 2 units when it moves
            lifeUnits -= 2;
         }
         else if (!plip_moves_east)
         {
            //x coordinate decreases by 1 when it moves west
            setX(getX() - 1);
            
            //life unit decreases by 2 units when it moves
            lifeUnits -= 2;
         }          
      }
           
   }
   
   
   /**
      * absorbs a life unit from the sun
   */
    
   public void absorb()
   {
   
      //Plip cannot absorb life units if it has zero life units
      if (lifeUnits > 0)
      {
         lifeUnits++;
      }  
      
      else if (lifeUnits < 0)
      {
         lifeUnits = 0;
      }
     
    } 
   
   
   /**
      * gets the units of life of the Plip 
      * @return the number of life units
   */
   
   public int getLife()
   {
      return lifeUnits;
   }
   
   
   /**
   	* a string that describes the Plip
   	* @return a string describing the Plip that is attractively labelled
	 */
   
   public String toString()
   {
      return "\nLifeUnits : " + lifeUnits + 
              "\nLocation (x , y): (" + getX() + " , " + getY() + ")";
   }
}
