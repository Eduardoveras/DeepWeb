<div class="form-group">

    <label class="control-label col-md-6 col-sm-6 col-xs-12" for="insurancecode"><@spring.message "iCode" />

    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="insurancecode" name="insurancecode" required="required"
               class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-6 col-sm-6 col-xs-12" for="supplier"><@spring.message "iCompany" />
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="supplier" name="supplier" required="required" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label for="plan" class="control-label col-md-6 col-sm-6 col-xs-12"><@spring.message "iPlan" /></label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input id="plan" class="form-control col-md-7 col-xs-12" type="text" name="plan">
        <input type="hidden" id="height" name="height" value="0">
        <input type="hidden" id="weight" name="weight" value="0">
    </div>
</div>