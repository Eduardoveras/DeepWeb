<!-- Modal -->
<div class="modal fade" id="contactModal" role="dialog">

    <div class="modal-dialog modal-lg">


        <!-- Modal content-->

        <div class=" x_panel modal-content">

            <!--<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create task</h4>
            </div>-->
            <div class="modal-body">
                <div class="x_title">
                    <ul class="nav navbar-left panel_toolbox">
                        <li><h4><@spring.message "addNew" /> ${user.clinic.clinicPrefix} <@spring.message "teamMember" /></h4>
                        </li>
                    </ul>
                    <ul class="nav navbar-right panel_toolbox">
                        <li>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </li>
                    </ul>
                    <div class="clearfix"></div>

                </div>

                <div class="x_content">
                    <br/>
                    <form action="/new_contact" METHOD="POST" enctype="multipart/form-data" id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

                        <div class="form-group item">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName"><@spring.message "first" /> <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="firstName" name="firstName" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>

                        <div class="form-group item">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName"><@spring.message "last" /> <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="lastName" name="lastName" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>

                        <div class="form-group item">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12"><@spring.message "bday" /> <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="dateOfBirth" name="dateOfBirth" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" placeholder="<@spring.message "mdy" />">
                            </div>
                        </div>

                        <div class="form-group item">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email"><@spring.message "email" /> <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="email" id="email" name="email" required="required" class="form-control col-md-7 col-xs-12">
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
    </div>
</div>
