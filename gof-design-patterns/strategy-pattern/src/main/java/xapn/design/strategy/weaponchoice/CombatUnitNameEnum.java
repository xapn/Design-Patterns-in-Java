/**
 * 
 */
package xapn.design.strategy.weaponchoice;

/**
 * Combat Unit name enumeration.
 * 
 * @author Xavier Pigeon
 */
public enum CombatUnitNameEnum {
    
    FIGHTER_AIRCRAFT("Fighter Aircraft"), SOLDIER("Soldier"), SUBMARINE("Ballistic Missile Submarine"), UNKNOWN(
            "Unknown");
    
    private String name;
    
    /**
     * Default constructor.
     * 
     * @param name
     */
    private CombatUnitNameEnum(String name) {
        this.name = name;
    }
    
    /**
     * Getter for the field {@code name}.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
}
