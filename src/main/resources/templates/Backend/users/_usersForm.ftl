<div class="col-md-4 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2><@spring.message "uform" /></h2>
            <div class="clearfix"></div>
        </div>

        <div class="x_content">
            <br />
            <form action="/newUser" METHOD="POST" enctype="multipart/form-data" id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName"><@spring.message "first" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="firstName" name="firstName" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName"><@spring.message "last" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="lastName" name="lastName" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><@spring.message "sex" /></label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="radio">
                            <label><input type="radio" name="gender" id="gender1" value="M" required checked><@spring.message "male" /></label><br>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="gender" id="gender2" value="F" required><@spring.message "female" /></label>
                        </div>
                    </div>
                </div>
                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><@spring.message "bday" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input id="dateOfBirth" name="dateOfBirth" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email"><@spring.message "email" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="email" id="email" name="email" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="occupation"><@spring.message "password" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="password" id="password" name="password" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password2"><@spring.message "confirm" /> <@spring.message "password" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="password" id="password2" name="password2" data-validate-linked="password" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><@spring.message "role" /> <span class="required">*</span></label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="radio">
                            <label><input type="radio" name="role" id="role1" value="M" required checked><@spring.message "medic" /></label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="role" id="role2"  value="A"><@spring.message "assistant" /></label>
                        </div>
                    </div>
                </div>

                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button id="send" type="submit" class="btn btn-success"><@spring.message "submit" /></button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
