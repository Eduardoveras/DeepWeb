<div id="step-2">
    <form class="form-horizontal form-label-left">

        <div class="form-group item">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Patient: </label>
            <div class="col-md-9 col-sm-9 col-xs-12">
                <select name="patient" id="patient" class="select2_single form-control" tabindex="-1" required>
                    <option></option>
                <#list userList as patient>
                    <option value="${patient.getPatientId()}">${patient.getPatientFullName()}</option>
                </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supplier">Visit Objective
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <textarea id="message" required="required" class="form-control" name="message" data-parsley-trigger="keyup" data-parsley-minlength="3" data-parsley-maxlength="100" data-parsley-minlength-message="Come on! You need to enter at least a 3 caracters long comment.." data-parsley-validation-threshold="10"></textarea>

            </div>
        </div>
        <div class="form-group">
            <label for="plan" class="control-label col-md-3 col-sm-3 col-xs-12">Observations </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            <textarea id="message" required="required" class="form-control" name="message" data-parsley-trigger="keyup" data-parsley-minlength="3" data-parsley-maxlength="100" data-parsley-minlength-message="Come on! You need to enter at least a 3 caracters long comment.." data-parsley-validation-threshold="10"></textarea>

             </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="insuranceCode">Special conditions
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <textarea id="message" required="required" class="form-control" name="message" data-parsley-trigger="keyup" data-parsley-minlength="3" data-parsley-maxlength="100" data-parsley-minlength-message="Come on! You need to enter at least a 3 caracters long comment.." data-parsley-validation-threshold="10"></textarea>

            </div>
        </div>

        <div class="form-group item">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Surgery type </label>
            <div class="col-md-9 col-sm-9 col-xs-12">
                <select name="patient" id="patient" class="select2_single form-control" tabindex="-1" required>
                    <option th:each="surgeryType : ${T(surgeryType).values()}"
                            th:value="${surgeryType}"
                            th:text="${surgeryType}">
                    </option>
                </select>
            </div>
        </div>

    </form>
</div>