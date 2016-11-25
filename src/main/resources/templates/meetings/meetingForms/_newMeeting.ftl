<div class="x_panel">
    <div class="x_title">
        <h2>Form Design <small>different form elements</small></h2>
        <ul class="nav navbar-right panel_toolbox">
            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Settings 1</a>
                    </li>
                    <li><a href="#">Settings 2</a>
                    </li>
                </ul>
            </li>
            <li><a class="close-link"><i class="fa fa-close"></i></a>
            </li>
        </ul>
        <div class="clearfix"></div>
    </div>
    <div class="x_content">
        <br>
        <form action="/new_meeting" METHOD="POST" id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">

            <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="title">Title <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="title" required="required" name="title" class="form-control col-md-7 col-xs-12">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="objective">Objective
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <textarea id="objective" required="required" class="form-control" name="objective" data-parsley-trigger="keyup" data-parsley-minlength="3" data-parsley-maxlength="100" data-parsley-minlength-message="Come on! You need to enter at least a 3 caracters long comment.." data-parsley-validation-threshold="10"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="place">Place <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="place" required="required" name="place" class="form-control col-md-7 col-xs-12">
                </div>
            </div>

            <div class="form-group item">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" id="time" name="time"
                           required="required" class="form-control col-md-7 col-xs-12"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>



            <div class="control-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12">Attendees </label>
                <div>
                <select name="attendees" id="attendees" class="selectpicker" data-live-search="true" multiple>
                    <option></option>
                <#list contactList as contact>
                    <option value="${contact.getContactId()}">${contact.getFullName()}</option>
                </#list>
                </select>
                </div>

            </div>


            <div class="ln_solid"></div>
            <div class="form-group">
                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </div>

        </form>
    </div>
</div>