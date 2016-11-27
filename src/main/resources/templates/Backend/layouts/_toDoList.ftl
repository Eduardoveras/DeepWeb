<ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu" style="width: 400px">
<div style="overflow: auto; max-height: 400px;">
<#list todoList as todo>
    <li>
        <a>
            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
            <span>
                          <span>${todo.title}</span>
                        </span>
            <span class="message">
            ${todo.description}
                        </span>
        </a>
    </li>
<#else>
    <li>
        <div class="text-center">
            <a>
                <strong><@spring.message "didIt" /></strong>
                <i class="fa fa-angle-right"></i>
            </a>
        </div>
    </li>
</#list>
</div>
    <li>
        <div class="text-center">
            <a>
                <strong><@spring.message "alerts" /></strong>
                <i class="fa fa-angle-right"></i>
            </a>
        </div>
    </li>
    <li>
        <div class="text-center">
            <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal"><@spring.message "create" />
            </button>
        </div>
    </li>
</ul>



<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">

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
                        <li><h4>Add new item</h4>
                        </li>
                    </ul>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><button type="button" class="close" data-dismiss="modal">&times;</button>
                        </li>
                    </ul>

                    <div class="clearfix"></div>

                </div>

                <div class="x_content">
                    <br/>
                    <form action="/newTask" METHOD="POST" class="form-horizontal form-label-left input_mask">

                        <div class="col-md-30 col-sm-30 col-xs-26 form-group has-feedback">
                            <input type="text" class="form-control has-feedback-left" id="title" name="title" placeholder="title">
                            <span class="fa fa-user form-control-feedback left"
                                  aria-hidden="title"></span>
                        </div>

                        <div class="col-md-30 col-sm-30 col-xs-26 form-group has-feedback">
                            Description
                            <textarea id="description" required="required" placeholder="Description"
                                      class="form-control" name="description"
                                      data-parsley-trigger="keyup" data-parsley-minlength="4"
                                      data-parsley-maxlength="20"
                                      data-parsley-validation-threshold="10">
                                                        </textarea>
                        </div>

                        <div>
                            <div class="form-group" style="display: inline-block;">
                                <label for="sel1">Select type:</label>
                                <select class="form-control" id="type" name="type">
                                    <option>REMINDER</option>
                                    <option>URGENT</option>
                                </select>
                            </div>
                            <div class="form-group"style="display: inline-block;">
                                <label for="sel1">Repeat:</label>
                                <select class="form-control" id="repeat" name="repeat">
                                    <option>EVERY_DAY</option>
                                    <option>MONDAY</option>
                                    <option>TUESDAY</option>
                                    <option>WEDNESDAY</option>
                                    <option>THURSDAY</option>
                                    <option>FRIDAY</option>
                                    <option>SATURDAY</option>
                                    <option>MONTHLY</option>
                                    <option>YEARLY</option>
                                </select>
                            </div>
                        </div>
                        <input type="submit" value="CREATE" class="btn btn-success" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
