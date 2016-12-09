/**
 * Created by Djidjelly Siclait on 12/3/2016.
 */
package com.evapps.Service.Auxiliary;

import com.evapps.Entity.History;
import com.evapps.Entity.Product;
import com.evapps.Entity.Receipt;
import com.evapps.Entity.User;
import com.evapps.Repository.HistoryRepository;
import com.evapps.Repository.ProductRepository;
import com.evapps.Repository.ReceiptRepository;
import com.evapps.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class StatisticService {

    // Repositories
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private UserRepository userRepository;

    // Functions
    // Product related Statistics
    public ArrayList<String> productViewStatistics(){

        Map<Integer, Integer> statistic = fetchProductLegend();
        ArrayList<String> buffer = new ArrayList<>();

        try {
            for (History history: historyRepository.findAll())
                for (Product product: history.getBrowsingHistory())
                    statistic.replace(product.getProductId(), statistic.get(product.getProductId()) + 1);

            for (Integer i:
                 statistic.keySet())
                buffer.add("'" + i.toString() + "--" + productRepository.findByProductId(i).getProductName() + "', " + statistic.get(i).toString() + ", '#b87333'");

            return buffer;
        } catch (Exception exp) {
            System.out.println();
        }

        return null;
    }

    public Map<Integer, Integer> productPurchaseStatistics(){

        Map<Integer, Integer> statistic = fetchProductLegend();

        try {
            for (Receipt receipt: receiptRepository.findAll())
                for (Integer p: receipt.getProductList())
                    statistic.replace(p, statistic.get(p) + 1);

            return statistic;
        } catch (Exception exp) {
            //
        }

        return null;
    }

    public Map<String, Integer> productSupplierStatistics(){

        try {
            Map<String, Integer> statistic = fetchSupplierLegend();

            for (Product product: productRepository.findAll())
                statistic.replace(product.getSupplier(), statistic.get(product.getSupplier()) + 1);

            return statistic;

        } catch (Exception exp) {
            //
        }

        return null;
    }

    // Transaction Related Functions
    public Map<String, Float> userAveragePurchaseByDollar(){

        try {
            Map<String, Float> statistics = fetchUserLegend();

            for (String email: statistics.keySet()) {
                int count = 0;
                for (Receipt receipt : receiptRepository.findByUser(email)) {
                    statistics.replace(email, statistics.get(email) + receipt.getTotal());
                    count++;
                }

                statistics.replace(email, statistics.get(email)/count);
            }

            return statistics;
        } catch (Exception exp) {
            //
        }

        return null;
    }

    public Map<String, Float> userAverageNumberOfItemPurchase(){

        try {
            Map<String, Float> statistics = fetchUserLegend();

            for (String email: statistics.keySet()) {
                int count = 0;
                for (Receipt receipt : receiptRepository.findByUser(email)) {
                    statistics.replace(email, statistics.get(email) + receipt.getProductList().size());
                    count++;
                }

                statistics.replace(email, statistics.get(email)/count);
            }

            return statistics;
        } catch (Exception exp) {
            //
        }

        return null;
    }


    // Auxiliary Functions
    private Map<Integer, Integer> fetchProductLegend(){
        Map<Integer, Integer> legend = new HashMap<>();

        for (Product p:
             productRepository.findAll()) {
            legend.put(p.getProductId(), 0);
        }

        return legend;
    }

    private Map<String, Integer> fetchSupplierLegend(){
        Map<String, Integer> legend = new HashMap<>();

        for (Product p: productRepository.findAll())
            legend.putIfAbsent(p.getSupplier(), 0);

        return legend;
    }

    private Map<String, Float> fetchUserLegend(){
        Map<String, Float> legend = new HashMap<>();

        for (User user: userRepository.findAll())
            legend.putIfAbsent(user.getEmail(), 0.00f);

        return legend;
    }

}
