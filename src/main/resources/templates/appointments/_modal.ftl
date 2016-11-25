<!-- Modal -->
<div class="modal fade" id="appointmentModal" role="dialog">

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
                        <li><h4><@spring.message "reApp" /></h4>
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
                    <form action="/changeDateAndTime" METHOD="POST" enctype="multipart/form-data" id="reScheduleForm"
                          data-parsley-validate class="form-horizontal form-label-left">
                        <div class="form-group">
                            <label class="text-left" class="control-label col-md-6 col-sm-6 col-xs-12"
                                   class="date-picker" for="appointmentTime"> <@spring.message "newTime" />: <span class="required">*</span>
                            </label>
                            <div class='input-group date' id='datetimepicker2'>
                                <input type='text' class="form-control" id="appointmentTime" name="appointmentTime"
                                       required="required" class="form-control col-md-7 col-xs-12"/>
                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                            </div>
                        </div>

                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                <button type="submit" class="btn btn-success"><@spring.message "changeTime" /></button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
