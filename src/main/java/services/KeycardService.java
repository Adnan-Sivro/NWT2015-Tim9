package services;

import com.sun.jersey.spi.resource.Singleton;
import dbclasses.Keycard;

/**
 * Created by Enes on 31.3.2015..
 */
@Singleton
public class KeycardService {
    public Keycard updateKeycard(int cardid) {
        Keycard card = new Keycard();
        card.setIdkeycard(cardid);
        return card;
    }

    public Keycard createKeycard(Keycard card) {

        return card;
    }
}
