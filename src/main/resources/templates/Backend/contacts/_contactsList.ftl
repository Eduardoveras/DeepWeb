<div class="col-md-9">
    <div class="x_panel">
        <div class="x_title">
            <h2>
                <#if isAdmin>
                    <a href="#" data-toggle="modal" data-target="#contactModal" class="btn btn-success"><@spring.message "addNew" /> ${user.clinic.clinicPrefix} <@spring.message "teamMember" /></a>
                <#else>
                    <@spring.message "teamFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "teamFrag2" />
                </#if>
            </h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <div class="row" style="overflow: auto; max-height: 500px;">

                <#list contactList?sort_by("lastName") as contact>

                    <div class="col-md-6 col-sm-6 col-xs-12 profile_details">
                        <div class="well profile_view">
                            <div class="col-sm-12">
                                <h4 class="brief"><i><@spring.message "cFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "cFrag2" /></i></h4>
                                <div class="left col-xs-7">
                                    <h2>${contact.getFullName()}</h2>
                                    <p><strong><@spring.message "email" />: </strong>${contact.getEmail()}</p>
                                    <p><strong><@spring.message "hasAccount" />: </strong><#if contact.hasAccount><@spring.message "yes" /><#else><@spring.message "no" /></#if></p>
                                </div>
                                <div class="right col-xs-5 text-center">
                                    <img src="images/img.jpg" alt="" class="img-circle img-responsive">
                                </div>
                            </div>
                            <div class="col-xs-12 bottom text-center">
                                <#if isAdmin>
                                <div class="col-xs-12 col-sm-12 emphasis">
                                    <button data-toggle="dropdown" class="btn btn-default dropdown-toggle btn-sm btn-round" type="button" aria-expanded="false"><@spring.message "options" /> <span class="caret"></span>
                                    </button>
                                    <ul role="menu" class="dropdown-menu">
                                        <li>
                                            <form action="/delete_contact" METHOD="POST" enctype="multipart/form-data">
                                                <input type="hidden" value="${contact.getContactId()}" id="contactId" name="contactId">
                                                <input type="submit" value="<@spring.message "deleteContact" />" class="btn btn-link">
                                            </form>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#"><@spring.message "editProfile" /></a></li>
                                    </ul>
                                </div>
                                </#if>
                                <button type="button" class="btn btn-primary btn-sm btn-round" >
                                    <i class="fa fa-user"> </i> <@spring.message "viewProfile" />
                                </button>
                                <button type="button" class="btn btn-primary btn-sm btn-round" >
                                    <i class="fa fa-user"> </i> <@spring.message "sendMessage" />
                                </button>
                            </div>
                        </div>
                    </div>
                <#else>
                    <p><h4><@spring.message "emptyContact" /></h4></p>
                </#list>
            </div>
        </div>
    </div>
</div>