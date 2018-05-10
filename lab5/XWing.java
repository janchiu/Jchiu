class XWing {

   // Properties of the class...
   private int     shields;
   private int     weapon;
   private boolean dead;

   // Constructor of the class...
   public XWing() {
      shields = 1000;
      weapon  = 10;
   }

   // Methods of the class...
   public int getWeapon() {
      return weapon;
   }
   public boolean isDead() {
      return dead;
   }
   public void hit(int damage) {
      shields = shields - damage;
      if (shields < 0) {
         System.out.println("BOOM!!!");
         dead = true;
      }
   }
}