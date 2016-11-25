<div class="col-md-8 col-sm-6 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2><@spring.message "registeredApp" /></h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <table id="datatable-responsive" class="table table-hover table-striped table-bordered dt-responsive nowrap"
                   cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><span style="text-transform: uppercase;"><@spring.message "appDate" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "patient" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "type" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "action" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "description" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "status" /></span></th>
                </tr>
                </thead>
                <tbody>
                <#list appointmentList?sort_by("appointmentTime")?reverse as appointment>
                <tr>
                    <td>${appointment.getAppointmentTime()}</td>
                    <td><a href="/patient/${appointment.patient.patientId}">${appointment.patient.patientFullName}</a>
                    </td>
                    <td>${appointment.getAppointmentType()}</td>
                    <td>
                        <div class="btn-group">
                            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle" type="button"><@spring.message "options" /> <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="#" data-toggle="modal" data-target="#appointmentModal"><@spring.message "reschedule" /></a>
                                    <input type="hidden" form="reScheduleForm" id="id" name="id" value="${appointment.getAppointmentId()}">
                                </li>
                                <li>
                                    <form action="/cancelAppointment" METHOD="POST" enctype="multipart/form-data">
                                        <input type="hidden" value="${appointment.getAppointmentId()}" id="appointment_id" name="appointment_id">
                                        <input type="submit" value="<@spring.message "cancel" />" class="btn btn-link" onclick="return confirm('<@spring.message "confirmMessage" />');">
                                    </form>
                                </li>
                            </ul>
                        </div>
                    </td>
                    <td>${appointment.appointmentDescription}</td>
                    <td>${appointment.appointmentStatus}</td>
                </tr>
                <#else>
                <tr>
                    <th scope="row"><@spring.message "emptyApp" /></th>
                </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>
</div>