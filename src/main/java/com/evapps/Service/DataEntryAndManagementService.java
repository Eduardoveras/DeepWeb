/**
 * Created by Djidjelly Siclait on 10/8/2016.
 */
package com.evapps.Service;

import com.evapps.Entity.*;
import com.evapps.Repository.*;
import com.evapps.Tools.Enums.*;
import freemarker.template.utility.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

@Service
public class DataEntryAndManagementService {
    // Auxiliary tools
    private final static long MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;

    // Repositories

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  HistoryRepository historyRepository;
    @Autowired
    private EncryptionService EncriptService;

    // Creation functions
    public Appointment createNewAppointment(String clinicId, Timestamp appointmentTime, String patientId, String appointmentDescription) throws Exception {

        if(!doesClinicIdExist(clinicId))
            throw new IllegalArgumentException("\n\nThis is an invalid clinic id");

        if (!doesPatientIdExist(patientId))
            throw new IllegalArgumentException("\n\nThis is an invalid patient Id");

        if (!isGivenDateInTheFuture(appointmentTime))
            throw new IllegalArgumentException("The date of an appointment must be a future date");

        try {
            Appointment appointment = appointmentRepository.save(new Appointment(clinicRepository.findByClinicId(clinicId), appointmentTime, patientRepository.findByPatientId(patientId), appointmentDescription, AppointmentType.CONSULTATION));
            // Consultation is automatically created with every appointment
            consultationRepository.save(new Consultation(appointmentTime, appointmentDescription, appointment));
            return appointment;
        } catch (PersistenceException exp){
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            exp.printStackTrace();
            throw new PersistenceException("\n\nThis appointment was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            exp.printStackTrace();
            throw new NullPointerException("\n\nAN object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            exp.printStackTrace();
            throw new Exception("\n\nAn error occurred when trying to create an appointment -> " + exp.getMessage());
        }
    }




    public Chore createNewCustomTask(String userId, String title, Task type, String description, ArrayList<Repeat> reminders) throws Exception{

        if (!doesUserIdExist(userId))
            throw new IllegalArgumentException("\n\nThis is an invalid user id");

        try {
            return choreRepository.save(new Chore(userRepository.findByUserId(userId), title, type, description, reminders));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis consultation was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create a consultation -> " + exp.getMessage());
        }
    }




    public Equipment createNewEquipment(String clinicId, String equipmentName, String equipmentUse, String equipmentDescription, Integer stock) throws Exception {

        if (!doesClinicIdExist(clinicId))
            throw new IllegalArgumentException("\n\nThis is an invalid clinic id");

        try {
            return equipmentRepository.save(new Equipment(clinicRepository.findByClinicId(clinicId), equipmentName, equipmentUse, equipmentDescription, stock));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis equipment was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAN object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create a equipment -> " + exp.getMessage());
        }
    }





    public Insurance createNewInsurance(String ownerId, String insuranceSerialCode, String supplier, String insurancePlan) throws Exception{

        if (!doesPatientIdExist(ownerId))
            throw new IllegalArgumentException("\n\nThis is an invalid patient jascId");

        try {
            return insuranceRepository.save(new Insurance(patientRepository.findByPatientId(ownerId), insuranceSerialCode, supplier, insurancePlan));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis insurance was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create an insurance -> " + exp.getMessage());
        }
    }




    public Medication createNewMedication(String clinicId, String medicationName, String supplier, String medicationDescription, Float medicationPrice, Integer stock) throws Exception{

        if (!doesClinicIdExist(clinicId))
            throw new IllegalArgumentException("\n\nThis is an invalid clinic id");

        if (medicationPrice < 0.00f)
            throw new IllegalArgumentException("\n\nThe price must be a positive number bigger than 0.00");

        if (stock < 1)
            throw new IllegalArgumentException("\n\nYou cannot register ZERO or less medication");

        try {
            return medicationRepository.save(new Medication(clinicRepository.findByClinicId(clinicId), medicationName, supplier, medicationDescription, medicationPrice, stock));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis medication was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create an medication -> " + exp.getMessage());
        }
    }





    public Meeting createNewMeeting(String clinicId, String title, String objective, Timestamp time, String place, Set<Contact> attendees) throws Exception {

        if (!doesClinicIdExist(clinicId))
            throw new IllegalArgumentException("\n\nThis is an invalid clinic id");

        if (attendees.isEmpty())
            throw new NullArgumentException("\n\nYou can not schedule a meeting without any staff attending. Please choose who will attend");

        if (!isGivenDateInTheFuture(time))
            throw new IllegalArgumentException("The meeting date must be a future date");

        try {
            return meetingRepository.save(new Meeting(clinicRepository.findByClinicId(clinicId), title, objective, time, place, attendees));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis insurance was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAN object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create an insurance -> " + exp.getMessage());
        }
    }




    public Patient createNewPatient(String clinicId, String patientFirstName, String patientLastName, String patientIdCard,
                                    String patientTelephoneNumber, String patientWorkphone ,String patientCellphone,
                                    String patientContactName, String patientContactLastName, String patientContactAddress,
                                    String patientContactCellphone, String patientContactTelephoneNumber,String occupation,
                                    Gender patientGender, String patientEmail, Date patientBirthDate, String patientNationality,
                                    String patientAddress, String patientCity, String patientCountry, ArrayList<String> patientAllergies,
                                    String patientReligion, String PatientHeight, String PatientWeight, String patientBloodType,
                                    ArrayList<String> patientConditions, String insuranceSerialCode, String insuranceSupplier,
                                    String insurancePlan) throws Exception {

        if (!doesClinicIdExist(clinicId))
            throw new IllegalArgumentException("\n\nThis is an invalid clinic id");

        if (differenceInDays(patientBirthDate, new Date(Calendar.getInstance().getTime().getTime())) <= 0)
            throw new IllegalArgumentException("The birth date must be a past date");

        try {
            Patient patient = patientRepository.save(new Patient(clinicRepository.findByClinicId(clinicId), patientFirstName, patientLastName, patientIdCard,
                    patientTelephoneNumber, patientWorkphone,patientCellphone, patientContactName, patientContactLastName, patientContactAddress, patientContactCellphone,
                    patientContactTelephoneNumber, occupation, patientGender, patientEmail.toLowerCase(), patientBirthDate, patientNationality,
                    patientAddress, patientCity, patientCountry, patientAllergies, patientReligion, PatientHeight, PatientWeight,
                    patientBloodType, patientConditions));

            // The patient's medical record is created automatically
            if (patient.getClinic().getAccountType() != AccountType.BASIC)
                recordRepository.save(new Record(patient));

            // Adding insurance information if exist
            if (insuranceSerialCode != null)
                insuranceRepository.save(new Insurance(patient, insuranceSerialCode, insuranceSupplier, insurancePlan));

            return patient;
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis patient was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create a patient -> " + exp.getMessage());
        }
    }



    public Product createNewProduct(String clinicId, String productName, String supplier, String productDescription, Float productPrice, Integer stock) throws Exception{
        if (!doesClinicIdExist(clinicId))
            throw new IllegalArgumentException("\n\n\nThis clinic id is not valid");

        if (productPrice < 0.00f)
            throw new IllegalArgumentException("\n\nThe price must be a positive number bigger than 0.00");

        if (stock < 1)
            throw new IllegalArgumentException("\n\nYou cannot register ZERO or less medication");

        try {
            return productRepository.save(new Product(clinicRepository.findByClinicId(clinicId), productName, supplier, productDescription, productPrice, stock));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis product was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create a product -> " + exp.getMessage());
        }
    }

    public History createNewHistory(Patient patient, String visitObjective, String observations, String specialConditions, ArrayList<byte[]> photos, SurgeryType surgeryType, ArrayList<String> medicalData, String consultationId) throws Exception {

        if (!doesPatientIdExist(patient.getPatientId()))
            throw new IllegalArgumentException("\n\nThis is an invalid patient id");

        if (!doesConsultationIdExist(consultationId))
            throw new IllegalArgumentException("This is not a valid consultation id");

        try {
            return historyRepository.save(new History(patient, visitObjective,  observations, specialConditions, photos, surgeryType,  medicalData, consultationId));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis record was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create a record -> " + exp.getMessage());
        }
    }




    public Contact createNewStaffMember(String clinicId, String staffFirstName, String staffLastName, Date staffBirthDate, String staffEmail) throws Exception {

        if (!doesClinicIdExist(clinicId))
            throw new IllegalArgumentException("\n\nThis is an invalid clinic id");

        try{
            return contactRepository.save(new Contact(clinicRepository.findByClinicId(clinicId), staffFirstName, staffLastName, staffBirthDate, staffEmail.toLowerCase(), false));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis patient was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create a patient -> " + exp.getMessage());
        }
    }





    public Surgery createNewSurgery(String name, String description, String patientId, Timestamp time) throws Exception {

        if (!doesPatientIdExist(patientId))
            throw new IllegalArgumentException("\n\nThis is an invalid patient id");

        try {
            Appointment appointment = appointmentRepository.save(new Appointment( patientRepository.findByPatientId(patientId).getClinic(), time, patientRepository.findByPatientId(patientId), description, AppointmentType.SURGERY));
            return surgeryRepository.save(new Surgery(name, description, patientRepository.findByPatientId(patientId), time, appointment));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis surgery was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create a surgery -> " + exp.getMessage());
        }
    }





    public User createNewUserAccount(String clinicId, String email, String firstName, String lastName, Date birthDate, Gender gender, String password, Permission role) throws Exception {

        if (isEmailAlreadyTaken(email.toLowerCase(), clinicId))
            throw new IllegalArgumentException("\n\nThis email is already taken. Please choose another one!");

        try {
            // Add new user automatically in contact list
            contactRepository.save(new Contact(clinicRepository.findByClinicId(clinicId), firstName, lastName, birthDate, email.toLowerCase(), true));
            return userRepository.save(new User(clinicRepository.findByClinicId(clinicId), email.toLowerCase(), firstName, lastName, birthDate, gender, EncriptService.encryptPassword(password), role));
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis user was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to create a user -> " + exp.getMessage());
        }
    }





    // Elimination Functions
    public void deleteRegisteredAppointment(String appointmentId) throws Exception {

        if (!doesAppointmentIdExist(appointmentId))
            throw new IllegalArgumentException("\n\nThis appointment jasc id is not valid");

        try {
            // Fetching patients records
            //Record record = recordRepository.findByPatientId(appointmentRepository.findByAppointmentId(appointmentId).getPatient().getPatientId());

            // Applying cascade to any existing Consultation
            Consultation consultation = consultationRepository.findByAppointmentId(appointmentId);
            if (consultation != null) {
                //Set<Consultation> consultations = record.getConsultations();
                //consultations.remove(consultation);
                //record.setConsultations(consultations);
                consultationRepository.delete(consultation);
            }

            // Applying cascade to any existing Surgery
            Surgery surgery = surgeryRepository.findByAppointmentId(appointmentId);
            if (surgery != null) {
                //Set<Surgery> surgeries = record.getSurgeries();
                //surgeries.remove(surgery);
                //record.setSurgeries(surgeries);
                surgeryRepository.delete(surgery);
            }

            //recordRepository.save(record);

            appointmentRepository.delete(appointmentId);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAN object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting an appointment -> " + exp.getMessage());
        }
    }




    public void deleteCustomTask(String taskId) throws Exception{

        if (!doesCustomTaskIdExist(taskId))
            throw new IllegalArgumentException("This Task jasc id is invalid");

        try{
            choreRepository.delete(taskId);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAN object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting a custom task -> " + exp.getMessage());
        }
    }




    public void deleteRegisteredEquipment(String equipmentId) throws Exception {

        if (!doesEquipmentIdExist(equipmentId))
            throw new IllegalArgumentException("\n\nThis equipment jasc id is not valid");

        try {
            equipmentRepository.delete(equipmentId);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAN object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting an equipment -> " + exp.getMessage());
        }
    }




    public void deleteRegisteredInsurance(String insuranceId) throws Exception {

        if (!doesInsuranceIdExist(insuranceId))
            throw new IllegalArgumentException("\n\nThis insurance jasc Id is invalid,! Please try again.");

        try {
            insuranceRepository.delete(insuranceId);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting an insurance -> " + exp.getMessage());
        }
    }




    public void deleteRegisteredMedication(String medicationId) throws Exception{
        if (!doesMedicationIdExist(medicationId))
            throw new IllegalArgumentException("\n\nThis is an invalid medication id");

        try {
            medicationRepository.delete(medicationId);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting a medication -> " + exp.getMessage());
        }
    }




    public void deleteRegisteredMeeting(String meetingId) throws Exception {

        if (!doesMeetingIdExist(meetingId))
            throw new IllegalArgumentException("\n\nThis meeting id is invalid");

        try {
            meetingRepository.delete(meetingId);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting a meeting -> " + exp.getMessage());
        }
    }




    public void deleteRegisteredStaff(String staffId) throws Exception {

        if (!doesStaffIdExist(staffId))
            throw new IllegalArgumentException("\n\nThis staff id is not valid");

        if (staffId.equals("JASC-STAFF-ADMIN"))
            throw new IllegalArgumentException("\n\nDANGER: YOU CAN NOT ERASE ADMIN ACCOUNT!");

        try {
            Contact target = contactRepository.findByContactId(staffId);

            // Applying cascade to meetings
            for (Meeting m:
                 meetingRepository.findByClinicId(target.getClinic().getClinicId())) {

                Set<Contact> attendees = m.getAttendees();

                attendees.remove(target);
            }

            // TODO: Apply Cascade to Surgeries

            contactRepository.delete(target);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting a staff member -> " + exp.getMessage());
        }
    }



    public void deleteRegisteredProduct(String productId) throws Exception{
        if (!doesProductIdExist(productId))
            throw new IllegalArgumentException("\n\nThis is an invalid productId");

        try {
            productRepository.delete(productId);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting a product -> " + exp.getMessage());
        }
    }



    public void deleteRegisteredUserAccount(String userId) throws Exception {

        if (!doesUserIdExist(userId))
            throw new IllegalArgumentException("\n\nThis user account does not exist");

        if (userRepository.findByUserId(userId).getRole().equals(Permission.ADMIN))
            throw new IllegalArgumentException("\n\nDANGER: YOU CAN NOT ERASE ADMIN ACCOUNT!");

        try {
            List<Chore> chores = choreRepository.findByUserId(userId);

            for (Chore c:
                 chores) {
                choreRepository.delete(c); // Erasing any chore data created by the user
            }

            userRepository.delete(userId);
        } catch (NullPointerException exp) {
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAN object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred while deleting a user -> " + exp.getMessage());
        }
    }




    // Editing Functions
    public void editAppointment(Appointment appointment) throws Exception {

        if (appointment == null)
            throw new NullArgumentException("\n\nThis appoint was sent with a value of NULL");

        try {
            appointmentRepository.save(appointment);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis appointment was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit an appointment -> " + exp.getMessage());
        }
    }




    public void editEquipment(Equipment equipment) throws Exception {

        if (equipment == null)
            throw new NullArgumentException("\n\nThis equipment object is NULL");

        try {
            equipmentRepository.save(equipment);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis equipment was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit an equipment -> " + exp.getMessage());
        }
    }




    public void editInsurance(Insurance insurance) throws Exception {

        if (insurance == null)
            throw new NullArgumentException("\n\nThis insurance has a NULL value");

        try {
            insuranceRepository.save(insurance);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis insurance was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit an insurance -> " + exp.getMessage());
        }
    }



    public void editMedication(Medication medication) throws Exception{
        if (medication == null)
            throw new NullArgumentException("\n\nThis medication has a NULL value");

        try {
            medicationRepository.save(medication);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis medication was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit a medication -> " + exp.getMessage());
        }
    }



    public void editMeeting(Meeting meeting) throws Exception {

        if (meeting == null)
            throw new NullArgumentException("\n\nthe meeting object was sent with a NULL value");

        try {
            meetingRepository.save(meeting);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis meeting was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit a meeting -> " + exp.getMessage());
        }
    }




    public void editPatient(Patient patient) throws Exception {

        if (patient == null)
            throw new NullArgumentException("\n\nThe patient object is NULL");

        try {
            patientRepository.save(patient);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis patient was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit a patient -> " + exp.getMessage());
        }
    }



    public void editProduct(Product product) throws Exception{
        if (product == null)
            throw new NullArgumentException("\n\nThis product has a NULL value");

        try {
            productRepository.save(product);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis product was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit a product -> " + exp.getMessage());
        }
    }



    public void editRecord(Record record) throws Exception{
        if (record == null)
            throw new NullArgumentException("\n\nThis record has a NULL value");

        try {
            recordRepository.save(record);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis record was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit a record -> " + exp.getMessage());
        }
    }



    public void editUserAccountCredentials(String email, String clinicId, String password, Permission role) throws Exception{

        try {
            User user = userRepository.findUserAccountWithUsernameAndPassword(email.toLowerCase(), clinicId);
            user.setPassword(EncriptService.encryptPassword(password));
            user.setRole(role);
            userRepository.save(user);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis username was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit username-> " + exp.getMessage());
        }
    }




    public void editUserPhoto(String email, String clinic, Byte[] photo) throws Exception{

        try {
            User user = userRepository.findUserAccountWithUsernameAndPassword(email.toLowerCase(), clinic);
            user.setPhoto(photo);
            userRepository.save(user);
        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis username was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAn object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit username-> " + exp.getMessage());
        }
    }

    public void editStaff(Contact contact) throws Exception{

        try {
            contactRepository.save(contact);

        } catch (PersistenceException exp){
            exp.printStackTrace();
            System.out.println("\n\nPersistence Error! -> " + exp.getMessage());
            throw new PersistenceException("\n\nThis staff was not able to persist -> " + exp.getMessage());
        } catch (NullPointerException exp) {
            exp.printStackTrace();
            System.out.println("\n\nNull Pointer Error! -> " + exp.getMessage());
            throw new NullPointerException("\n\nAN object or process has risen a null value -> " + exp.getMessage());
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("\n\nGeneral Error! -> " + exp.getMessage());
            throw new Exception("\n\nAn error occurred when trying to edit a staff -> " + exp.getMessage());
        }
    }


    // Auxiliary Functions
    private boolean doesAppointmentIdExist(String appointmentId) {
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId);

        return (appointment != null);
    }

    private boolean doesClinicIdExist(String clinicId){
        Clinic clinic = clinicRepository.findByClinicId(clinicId);

        return (clinic != null);
    }

    private boolean doesConsultationIdExist(String consultationId){
        Consultation consultation = consultationRepository.findByConsultationId(consultationId);

        return (consultation != null);
    }

    private boolean doesCustomTaskIdExist(String taskId){
        Chore chore = choreRepository.findByChoreId(taskId);

        return (chore != null);
    }

    private boolean doesEquipmentIdExist(String equipmentId){
        Equipment equipment = equipmentRepository.findByEquipmentId(equipmentId);

        return (equipment != null);
    }

    private boolean doesInsuranceIdExist(String insuranceId){
        Insurance insurance = insuranceRepository.findByInsuranceId(insuranceId);

        return (insurance != null);
    }

    private boolean doesMedicationIdExist(String medicationId){
        Medication medication = medicationRepository.findByMedicationId(medicationId);

        return (medication != null);
    }

    private boolean doesMeetingIdExist(String meetingId){
        Meeting meeting = meetingRepository.findByMeetingId(meetingId);

        return (meeting != null);
    }

    private boolean doesPatientIdExist(String patientId){
        Patient patient = patientRepository.findByPatientId(patientId);

        return (patient != null);
    }

    private boolean doesStaffIdExist(String staffId){
        Contact contact = contactRepository.findByContactId(staffId);

        return (contact != null);
    }

    private boolean doesProductIdExist(String productId){
        Product product = productRepository.findByProductId(productId);

        return (product != null);
    }

    private boolean isEmailAlreadyTaken(String email, String clinicId){
        User user = userRepository.findUserAccountWithUsernameAndPassword(email.toLowerCase(), clinicId);

        return (user != null);
    }

    private boolean doesUserIdExist(String userId){
        User user = userRepository.findByUserId(userId);

        return (user != null);
    }

    private boolean isRequestedDateExpired(Date requestedDate){
        Date today = new Date(Calendar.getInstance().getTime().getTime()); // getting today's date;
        return !(differenceInDays(today, requestedDate) >= 0); // checking if requested date is valid
    }

    private int differenceInDays(Date start, Date end){
        return (int)((end.getTime() - start.getTime()) / MILLISECONDS_IN_A_DAY);
    }

    private boolean isGivenDateInTheFuture(Timestamp date){
        Calendar today = Calendar.getInstance();
        today.setTime(new Date(Calendar.getInstance().getTime().getTime()));

        Calendar givenDate = Calendar.getInstance();
        givenDate.setTime(new Date(date.getTime()));

        if ((givenDate.get(Calendar.YEAR) - today.get(Calendar.YEAR)) < 0)
            return false;

        if ((givenDate.get(Calendar.MONTH) - today.get(Calendar.MONTH)) < 0)
            return false;

        if ((givenDate.get(Calendar.DAY_OF_MONTH) - today.get(Calendar.DAY_OF_MONTH)) < 0)
            return false;

        return true;
    }
}
