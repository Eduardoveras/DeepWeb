package com.evapps.Entity;

import com.evapps.Tools.Enums.SurgeryType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by eva_c on 11/6/2016.
 */
@Entity
@Table(name="history")
public class History implements Serializable {
    // Attributes
    @Id
    private String historyId;
    @NotNull
    private String visitObjective;
    @NotNull
    private String observations;
    private String specialConditions;
    private SurgeryType surgeryType;
    private ArrayList<byte[]> photos;
    private ArrayList<String> medicalData;
    @Column(unique = true)
    private String consultationReference;

    // Constructors
    public History(){

    }

    public History(Patient patient, String visitObjective, String observations, String specialConditions, ArrayList<byte[]> photos, SurgeryType surgeryType, ArrayList<String> medicalData, String consultationReference) {
        this.setHistoryId(patient.getPatientId() + "-H-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setPatient(patient);
        this.setVisitObjective(visitObjective);
        this.setObservations(observations);
        this.setSpecialConditions(specialConditions);
        this.setPhotos(photos);
        this.setSurgeryType(surgeryType);
        this.setMedicalData(medicalData);
        this.setConsultationReference(consultationReference);
    }

    // Getters and Setters
    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getVisitObjective() {
        return visitObjective;
    }

    public void setVisitObjective(String visitObjective) {
        this.visitObjective = visitObjective;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getSpecialConditions() {
        return specialConditions;
    }

    public void setSpecialConditions(String specialConditions) {
        this.specialConditions = specialConditions;
    }

    public SurgeryType getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(SurgeryType surgeryType) {
        this.surgeryType = surgeryType;
    }

    public ArrayList<byte[]> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<byte[]> photos) {
        this.photos = photos;
    }

    public ArrayList<String> getMedicalData() {
        return medicalData;
    }

    public void setMedicalData(ArrayList<String> medicalData) {
        this.medicalData = medicalData;
    }

    public String getConsultationReference() {
        return consultationReference;
    }

    public void setConsultationReference(String consultationReference) {
        this.consultationReference = consultationReference;
    }
}
