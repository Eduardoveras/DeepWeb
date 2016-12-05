<div class="col-md-4 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2><@spring.message "uform" /></h2>
            <div class="clearfix"></div>
        </div>

        <div class="x_content">
            <br />
            <form action="/register" METHOD="POST" enctype="multipart/form-data" id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email"><@spring.message "email" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="email" name="email" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first"><@spring.message "first" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="first" name="first" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last"><@spring.message "last" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="last" name="last" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="country"><@spring.message "country" /> <span
                            class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <select id="country" name="country" required="required" class="form-control col-md-7 col-xs-12"></select>

                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="state"><@spring.message "city" /> <span
                            class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <select id="state" name="state" required="required" class="form-control col-md-7 col-xs-12"></select>
                    </div>
                </div>

                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address"><@spring.message "address" /> <span class="required">*</span>
                    </label><br>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="address" name="address" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>



                <div class="form-group item">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password"><@spring.message "password" /> <span class="required">*</span>
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
                            <label><input type="radio" name="role" id="role1" value="ADMIN" required checked>ADMIN</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="role" id="role2"  value="USER">USER</label>
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
