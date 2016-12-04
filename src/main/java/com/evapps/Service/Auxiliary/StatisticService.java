/**
 * Created by Djidjelly Siclait on 12/3/2016.
 */
package com.evapps.Service.Auxiliary;

import com.evapps.Repository.HistoryRepository;
import com.evapps.Repository.ReceiptRepository;
import com.evapps.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    // Repositories
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private UserRepository userRepository;

    // Functions
}
