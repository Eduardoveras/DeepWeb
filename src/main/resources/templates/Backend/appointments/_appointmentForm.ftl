<div class="col-md-4 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2><@spring.message "registerApp" /></h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <br/>
            <form action="/newAppointment" METHOD="POST" enctype="multipart/form-data" id="demo-form2"
                  data-parsley-validate class="form-horizontal form-label-left">

                <div class="form-group item">
                    <label class="text-left control-label col-md-6 col-sm-6 col-xs-12 date-picker"
                           for="appointmentTime"> <@spring.message "appDate" />: <span class="required">*</span>
                    </label>
                    <div class='input-group date' id='datetimepicker1'>
                        <input type='text' class="form-control" id="appointmentTime" name="appointmentTime"
                               required="required" class="form-control col-md-7 col-xs-12"/>
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><@spring.message "patient" />: <span class="required">*</span></label>
                    <div class="col-md-9 col-sm-9 col-xs-12">
                        <select name="patient" id="patient" class="select2_single form-control" tabindex="-1" required>
                            <option></option>
                        <#list userList as patient>
                            <option value="${patient.getPatientId()}">${patient.getPatientFullName()}</option>
                        </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group item">
                    <label class="text-left" class="control-label col-md-6 col-sm-6 col-xs-12" for="description"><@spring.message "description" />:
                        <span class="required">*</span>
                    </label>
                    <div class="col-md-10 col-sm-10 col-xs-16">
                        <input type="text" id="description" name="description" required="required"
                               class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button type="submit" class="btn btn-success"><@spring.message "submit" /></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
