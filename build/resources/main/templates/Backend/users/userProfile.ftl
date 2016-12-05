<#include "/Backend/layouts/header.ftl">

<body class="nav-md">
<#include  "/Backend/layouts/_loader.ftl">
<div class="container body">
    <div class="main_container">
    <#include "/Backend/layouts/sidebar.ftl">
    <#include "/Backend/layouts/navbar.ftl">

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>${user.getFullName()}</h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2><spring:message code="userParam" arguments="${user.clinic.clinicPrefix}" htmlEscape="false" />: ${user.userId}</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
                                    <div class="profile_img">
                                        <div id="crop-avatar">
                                            <!-- Current avatar -->
                                            <img class="img-responsive avatar-view" src="/images/user.png" alt="Avatar" title="<@spring.message "change" />">
                                        </div>
                                    </div>
                                    <h3>${user.getFullName()}</h3>

                                    <ul class="list-unstyled user_data">
                                        <li>
                                            <i class="fa fa-briefcase user-profile-icon"></i> ${user.getRole()}
                                        </li>

                                        <li class="m-top-xs">
                                            <i class="fa fa-external-link user-profile-icon"></i>
                                            ${user.email}
                                        </li>
                                    </ul>

                                    <a class="btn btn-success"><i class="fa fa-edit m-right-xs"></i><@spring.message "editProfile" /></a>
                                    <br>

                                </div>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <div style="display: inline-block;">
                                        <h4><@spring.message "idFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "ID" />:</h4><h3>${user.getUserId()} </h3><br>
                                        <h4><@spring.message "first" />:</h4><h3 style="text-transform: uppercase;">${user.getFirstName()} </h3><br>
                                        <h4><@spring.message "last" />:</h4><h3>${user.getLastName()}</h3><br>
                                        <h4><@spring.message "bday" />:</h4><h3>${user.getBirthDate()}</h3><br>
                                    </div>
                                    <div style="display: inline-block;">
                                        <h4><@spring.message "sex" />:</h4><h3>${user.getGender()}</h3><br>
                                        <h4><@spring.message "role" />:</h4><h3>${user.getRole()}</h3><br>
                                        <h4><@spring.message "email" />:</h4><h3>${user.getEmail()}</h3><br>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/Backend/layouts/Copyright.ftl">


    </div>
</div>

<#include "/Backend/layouts/footer.ftl">
<#include "/Backend/layouts/pageCloser.ftl">



