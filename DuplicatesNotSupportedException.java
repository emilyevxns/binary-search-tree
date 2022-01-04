
/** Indicates that an attempt was made to insert a duplicate value
 * <p>DuplicatesNotSupportedException is not expected to be thrown during 
 * normal use of a list. As such, it is declared as a RuntimeException, 
 * which is not checked at compile time.
 */
public class DuplicatesNotSupportedException extends RuntimeException { 
    private static final long serialVersionUID = 0L; // Serialization requirement

    /** Generate instance
     */
    public DuplicatesNotSupportedException() {
        super("Attempt made to add a duplicate entry.");
    }
}
