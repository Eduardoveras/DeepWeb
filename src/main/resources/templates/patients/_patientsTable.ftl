<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2>
                <!--<if canUse>--><a href="/new_patient" role="button" class="btn btn-primary"><@spring.message "newPatient" /></a><!--<else><strong>Only ASSISTANT accounts can register new patients</strong></if>-->
            </h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <table id="datatable-responsive" class="table table-hover table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><span style="text-transform: uppercase;"><@spring.message "name" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "id" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "mainPhone" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "sPhone" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "email" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "bday" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "sex" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "rDay" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "job" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "nationality" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "address" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "city" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "country" /></span></th>
                </tr>
                </thead>
                <tbody>
                <#list patientList?sort_by("patientLastName") as patient>
                <tr>
                    <td><a href="/patient/${patient.patientId}">${patient.patientFullName}</a></td>
                    <td>${patient.patientIdCard}</td>
                    <td>${patient.patientTelephoneNumber}</td>
                    <td>${patient.patientContactTelephoneNumber}</td>
                    <td>${patient.patientEmail}</td>
                    <td>${patient.patientBirthDate}</td>
                    <td>${patient.patientGender}</td>
                    <td>${patient.patientRegisteredDate}</td>
                    <td>${patient.occupation}</td>
                    <td>${patient.patientNationality}</td>
                    <td>${patient.patientAddress}</td>
                    <td>${patient.patientCity}</td>
                    <td>${patient.patientCountry}</td>
                </tr>
                <#else>
                <tr>
                    <th scope="row"><@spring.message "emptyPatient" /></th>

                </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>
</div>
<!--I Know this is wrong, i just dont care-->
<br><br><br><br><br><br><br><br><br>

