/**
 * Created by Djidjelly Siclait on 11/26/2016.
 */
package com.evapps.Repository;

import com.evapps.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, String> {

    History findByHistoryId(String historyId);

    @Query("select h from History h where h.patient.patientId = :id and h.consultationReference = :reference")
    History findByPatientIdAndConsultationReference(@Param("id") String patientId, @Param("reference") String consultationReference);

    @Query("select h from History h where h.patient.patientId = :id" )
    List<History> findByPatientId(@Param("id") String patientId);

    @Query("select h from History h where h.surgeryType = :surgeryType" )
    List<History> findBySurgeryType(@Param("surgeryType") String surgeryType);

}
