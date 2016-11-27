<div class="col-md-7">
    <h2><@spring.message "todayApp" /></h2>
    <div class="x_content">
        <div class="row" style="overflow: auto;  min-height: 400px; max-height: 400px;">
        <#list todays_appointments as appointment>
            <div class="col-md-12 col-sm-12 col-xs-12 profile_details">
                <div class="well profile_view col-md-12">
                    <div class="col-sm-12">
                        <h4 class="brief"><i>${appointment.getAppointmentType()}
                            <@spring.message "at" /> ${appointment.getSimplifiedTime()} </i></h4>
                        <div class="left col-xs-7">
                            <h2>${appointment.patient.getPatientFullName()}</h2>
                            <p><strong><@spring.message "description" />: </strong>${appointment.appointmentDescription} </p>
                            <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> <@spring.message "address" />:</li>
                                <li><i class="fa fa-phone"></i> <@spring.message "mainPhone" />:${appointment.patient.getPatientTelephoneNumber()}</li>
                            </ul>
                        </div>
                        <div class="right col-xs-5 text-center">
                            <img src="images/user.png" alt="" style="max-width: 55%;" class="img-circle img-responsive">
                        </div>
                    </div>
                    <div class="col-xs-12 bottom text-center">

                        <div class="col-xs-12 col-sm-6 emphasis">
                            <form action="/cancelAppointment" METHOD="POST" enctype="multipart/form-data" data-parsley-validate>
                                <input type="hidden" id="appointment_id" name="appointment_id" value="${appointment.getAppointmentId()}">
                                <input type="submit" class="btn btn-danger btn-sm btn-round" onclick="return confirm('Are you sure you want to delete this item?');" value="<@spring.message "cancel" />">
                            </form>
                        </div>
                        <div class="col-xs-12 col-sm-6 emphasis">
                            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle btn-sm btn-round" type="button" aria-expanded="false"><@spring.message "options" /> <span class="caret"></span>
                            </button>
                            <ul role="menu" class="dropdown-menu">
                                <li><a href="#">Mark as HERE</a></li>
                                <li><a href="#">Mark as READY</a></li>
                                <li><a href="#">Mark as Didn't show up</a></li>
                                <li>
                                    <input type="hidden" form="reScheduleForm" name="id" value="${appointment.getAppointmentId()}">
                                    <a href="#" data-toggle="modal" data-target="#appointmentModal"> <@spring.message "reschedule" /></a>
                                </li>
                                <li><a href="#"><@spring.message "sendReminder" /></a></li>
                                <li class="divider"></li>
                                <li><a href="#"><@spring.message "collectPayment" /></a></li>
                            </ul>

                            <button onclick="window.location.href='/patient/${appointment.patient.patientId}'" type="button" class="btn btn-primary btn-sm btn-round" >
                                <i class="fa fa-user"> </i> <@spring.message "viewProfile" />
                            </button>

                        </div>
                    </div>
                </div>
            </div>
        <#else>
            <p><h4><@spring.message "emptyTodayApp" /></h4></p>
        </#list>
        </div>
    </div>
</div>