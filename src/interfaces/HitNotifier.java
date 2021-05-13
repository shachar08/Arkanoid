package interfaces;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */
/**
 * interface HitNotifier.
 * indicate that objects that implement it send notifications when they are being hit */
public interface HitNotifier {
    /**
     * The method adds hl as a listener to hit events.
     * @param hl - the hl object that being added. */
    void addHitListener(HitListener hl);
    /**
     * The method removes hl from the list of listeners to hit events.
     * @param hl - the hl object that being removed. */
    void removeHitListener(HitListener hl);
}