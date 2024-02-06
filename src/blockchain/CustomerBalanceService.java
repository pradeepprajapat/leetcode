package blockchain;


/*
The idea of this coding challenge, is to implement CustomerBalanceService and it must be able to:
- subscribe to upstream balance change notifications from the LedgerService
- keep an accumulated running balance for each customer
- accept subsription from multiple instances of the Customer service
- send downstream balance update notifications to subscribed customers.
Steps:
1. Subscribe to balance changes for all customers by providing a LedgerServiceUpdateCallback
   to the LedgerService instance received on the constructor.
2. Update internal data-structure to hold balances for each customer when the
   LedgerServiceUpdateCallback::onBalanceUpdate method is called.
3. If that customer has a registered callback provided via the CustomerBalanceService::subscribe
   method, call the CustomerBalanceUpdateCallback::onBalanceUpdate method with an instance of
   CustomerBalanceUpdate.
Instructions:
- Assume that the LedgerService and Customer interfaces will be implemented by someone else;
- these services communicates via callbacks for simplicity.
- Your implementaion Has to be thread-safe, memory efficient, GC friendly and cpu friendly.
- Use the language you prefer, you can read documentation
- Starting balance of a user is 0
- share your screen while coding, and share your code at the end.
- If you want to change the API contracts discuss it with your interviewer
- Send your code to the interviewer at the end of the interview.
+-----------+                                    +-------------------------+                            +---------------+
| Customer  |                                    | CustomerBalanceService  |                            | LedgerService |
+-----------+                                    +-------------------------+                            +---------------+
      |                                                       |                                                     |
      |                                                       | subscribe(LedgerServiceUpdateCallback)              |
      |                                                       |---------------------------------------------------->|
      |                                                       |                                                     |
      | subscribe(CustomerBalanceUpdateCallback)              |                                                     |
      |------------------------------------------------------>|                                                     |
      |                                                       |                                                     |
      |                                                       |                                                     |
      |                                                       |                                                     |
      |                                                       |                                        -----------\ |
      |                                                       |                                        | customer |-|
      |                                                       |                                        | buy/sell | |
      |                                                       |                                        | crypto   | |
      |                                                       |                                        |----------| |
      |                                                       |                                                     |
      |                                                       |                        LedgerServiceUpdateCallback  |
      |                                                       |             ::onBalanceUpdate(LedgerServiceUpdate)  |
      |                                                       |<----------------------------------------------------|
      |                                                       | ------------------\                                 |
      |                                                       |-| update internal |                                 |
      |                                                       | | balances data   |                                 |
      |                                                       | | structure       |                                 |
      |                                                       | |-----------------|                                 |
      |                                                       |                                                     |
      |                         CustomerBalanceUpdateCallback |                                                     |
      |              ::onBalanceUpdate(CustomerBalanceUpdate) |                                                     |
      |<------------------------------------------------------|                                                     |
      |                                                       |                                                     |
*/

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

enum Token {
    USD, EUR, BTC, ETH;
}

/**
 * Message/Event received from the upstream LedgerService,
 * for any change in the balance of any token for any customer
 * Balance Increases if getChange() > 0
 * Balance Decreases if getChange() < 0
 */
interface LedgerServiceUpdate {
    long getCustomerId();

    Token getToken();

    double getChange();
}

/**
 * A callback provided to the LedgerService; LedgerService call this to notify CustomerBalanceService
 * whenever there is a change in the balance of a customer for any token
 * <p>
 * TODO implement this
 */
interface LedgerServiceUpdateCallback {
    // Ledger call this method whenever it need to notify CustomerBalanceService
    void onBalanceUpdate(LedgerServiceUpdate update);
}

class LedgerServiceUpdateCallbackImpl implements LedgerServiceUpdateCallback {
    // Ledger call this method whenever it need to notify CustomerBalanceService
    // internal data-structure to hold balances for each customer when the
    //customerId[long], token[EUR,BTC], balanceUpdates[double]-> Map{[customerId,[token,updateBalance]}
    private final Double ZERO_VALUE = 0.0;
    private final Map<Long, Map<Token, Double>> customerBalances = new ConcurrentHashMap<>();

    private Map<Long, CustomerBalanceUpdateCallback> customerBalanceSubscribers;

    public LedgerServiceUpdateCallbackImpl( Map<Long, CustomerBalanceUpdateCallback> customerBalanceSubscribers ) {
        this.customerBalanceSubscribers = customerBalanceSubscribers;
    }

    public void onBalanceUpdate(LedgerServiceUpdate update) {
        // get balance and then update it
        Map<Token, Double> customerBalance = customerBalances.get(update.getCustomerId());
        if (null == customerBalance) {
            customerBalance = new HashMap<>();
            customerBalance.put(update.getToken(), ZERO_VALUE);
        }
        final double accumulatedBalance = customerBalance.get(update.getToken()) + update.getChange();
        customerBalance.put(update.getToken(), accumulatedBalance);
        notify(update);
    }

    private void notify(LedgerServiceUpdate update){
      /* if(null != customerBalanceSubscribers.get(update.getCustomerId())){
           //prepare payload

           customerBalanceSubscribers.get(update.getCustomerId()).onBalanceUpdate();
       }*/
    }

}

/**
 * Service to subscribe for updates in the balances of all customers
 * (provided)
 */
interface LedgerService {
    void subscribe(LedgerServiceUpdateCallback callback);
}

/**
 * A callback provided to the CustomerBalanceService, to be called
 * whenever there is a change in the balance of a token for the subscribed customer
 */
interface CustomerBalanceUpdateCallback {
    // Call this method to notify a specific customer
    void onBalanceUpdate(CustomerBalanceUpdate update);
}

/**
 * Message/Event sent to the downstream customer balance subscription, whenever
 * the balance for a token for that customer changes
 */
class CustomerBalanceUpdate {

    private final Token token;
    private double balance;
    private double change;

    public CustomerBalanceUpdate(Token token, double balance, double change) {
        this.token = token;
        this.balance = balance;
        this.change = change;
    }

    public Token getToken() {
        return token;
    }

    public double getBalance() {
        return balance;
    }

    public double getChange() {
        return change;
    }
}

/**
 * A Service used by customers to get notifications of changes
 * to their own specific balances, for each {@link Token}
 * (implement)
 */
class CustomerBalanceService {

    private final Map<Long, CustomerBalanceUpdateCallback> customerBalanceSubscribers = new ConcurrentHashMap<>();
    private final LedgerServiceUpdateCallback ledgerServiceUpdateCallback = new LedgerServiceUpdateCallbackImpl(customerBalanceSubscribers);

    public CustomerBalanceService(LedgerService LedgerService) {
        // TODO: subscribe to LedgerService to get notifications later
        LedgerService.subscribe(ledgerServiceUpdateCallback);
    }

    // Each Customer call this method to subscribe
    public void subscribe(long customerId, CustomerBalanceUpdateCallback callback) {
        // TODO: store the callback provided by customers, so they can be nofified when a change in balance is received\
        if (checkIfCustomerSubscribed(customerId)) {
            throw new RuntimeException("Customer: " + customerId + " has already subscribed to CustomerBalanceService");
        }
        customerBalanceSubscribers.put(customerId, callback);
    }

    public boolean checkIfCustomerSubscribed(Long customerId) {
        return customerBalanceSubscribers.get(customerId) != null;
    }
}
