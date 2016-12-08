package com.evapps.Service.Auxiliary;

import com.stripe.net.RequestOptions;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;

/**
 * Created by Eduardo veras on 12/7/2016.
 */

@Service
public class StripeService {


    public static boolean makeTransacction(Double amount,String cardNumber,Integer exp_month,Integer exp_year)
    {
        String key = System.getenv("TEST_SECRET_KEY");
        RequestOptions requestOptions = (new RequestOptions.RequestOptionsBuilder()).setApiKey(key).build();
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", amount);
        chargeMap.put("currency", "usd");
        Map<String, Object> cardMap = new HashMap<String, Object>();
        cardMap.put("number", cardNumber);
        cardMap.put("exp_month", exp_month);
        cardMap.put("exp_year", exp_year);
        chargeMap.put("card", cardMap);
        try {
            Charge charge = Charge.create(chargeMap, requestOptions);
            System.out.println(charge);
            return true;
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return false;

    }


}
