/**
 * Created by Djidjelly Siclait on 12/3/2016.
 */
package com.evapps.Service.Auxiliary;

import com.evapps.Entity.History;
import com.evapps.Entity.Product;
import com.evapps.Entity.Receipt;
import com.evapps.Repository.HistoryRepository;
import com.evapps.Repository.ProductRepository;
import com.evapps.Repository.ReceiptRepository;
import com.evapps.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    // History related Statistics
    public Product productViewStatistics(boolean option){

        Map<Integer, Integer> statistic = fetchProductLegend();

        try {
            for (History history: historyRepository.findAll())
                for (Product product: history.getBrowsingHistory())
                    statistic.replace(product.getProductId(), statistic.get(product.getProductId()) + 1);

            if (option) // Max
                return productRepository.findByProductId(getMaxValue((Integer[]) statistic.values().toArray()));
            else // Min
                return productRepository.findByProductId(getMinValue((Integer[]) statistic.values().toArray()));

        } catch (Exception exp) {
            //
        }

        return null;
    }

    public Product productPurchaseStatistics(boolean option){

        Map<Integer, Integer> statistic = fetchProductLegend();

        try {
            for (Receipt receipt: receiptRepository.findAll())
                for (Integer p: receipt.getProductList())
                    statistic.replace(p, statistic.get(p) + 1);

            if (option) // Max
                return productRepository.findByProductId(getMaxValue((Integer[]) statistic.values().toArray()));
            else // Min
                return productRepository.findByProductId(getMinValue((Integer[]) statistic.values().toArray()));

        } catch (Exception exp) {
            //
        }

        return null;
    }

    public Map<String, Integer> productSupplierStatistics(boolean option){

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

        for (Product p:
                productRepository.findAll()) {
                legend.putIfAbsent(p.getSupplier(), 0);
        }

        return legend;
    }

    private Integer getMaxValue(Integer[] list){
        Arrays.sort(list);

        return list[list.length - 1];
    }

    private Integer getMinValue(Integer[] list){
        Arrays.sort(list);

        return list[0];
    }


}
