
package assisgnment1;

import java.io.Serializable;

/**
 *
 * @author zShanCS
 */
public abstract class Payment implements Serializable {
    String Status;
 //   abstract  void Pay(Integer p);
    abstract void getPaymentDetails();
}
