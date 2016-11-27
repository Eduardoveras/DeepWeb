<#include "/templates/Backend/layouts/header.ftl">

<body class="nav-md">
<#include  "/templates/Backend/layouts/_loader.ftl">
<div class="container body">
    <div class="main_container">
    <#include "/templates/Backend/layouts/sidebar.ftl">
    <#include "/templates/Backend/layouts/navbar.ftl">



        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3><@spring.message "report" />: ${patient.patientId}</h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2><@spring.message "pProfileFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "pProfileFrag2" /></h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
                                    <div class="profile_img">
                                        <div id="crop-avatar">
                                            <!-- Current avatar -->
                                            <img class="img-responsive avatar-view" src="/images/user.png" alt="Avatar" title="Change the avatar">
                                        </div>
                                    </div>

                                    <div>
                                        <form action="/uploadPhoto" METHOD="POST" enctype="multipart/form-data">
                                            <div class="mdl-card__supporting-text">
                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                    <input class="mdl-textfield__input" type="file" id="photo" name="photo">
                                                </div>
                                            </div>
                                            <div class="mdl-card__actions mdl-card--border">
                                                <input type="hidden" name="id" value="${patient.patientId}">
                                                <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Edit Profile Picture">
                                            </div>
                                        </form>
                                    </div>

                                    <h3>${patient.patientFullName}</h3>

                                    <ul class="list-unstyled user_data">
                                        <li><i class="fa fa-map-marker user-profile-icon"></i> ${patient.patientAddress},${patient.patientCity},${patient.patientCountry}
                                        </li>

                                        <li>
                                            <i class="fa fa-briefcase user-profile-icon"></i> ${patient.occupation}
                                        </li>

                                        <li class="m-top-xs">
                                            <i class="fa fa-external-link user-profile-icon"></i>
                                            <a href="mailto:${patient.patientEmail}?subject=SweetWords" target="_blank">${patient.patientEmail}</a>
                                        </li>
                                    </ul>

                                    <a class="btn btn-success"><i class="fa fa-edit m-right-xs"></i><@spring.message "editProfile" /></a>
                                    <br>

                                    <!-- start skills
                                    <h4>Skills</h4>
                                    <ul class="list-unstyled user_data">
                                        <li>
                                            <p>Web Applications</p>
                                            <div class="progress progress_sm">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="50" aria-valuenow="49" style="width: 50%;"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <p>Website Design</p>
                                            <div class="progress progress_sm">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="70" aria-valuenow="70" style="width: 70%;"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <p>Automation &amp; Testing</p>
                                            <div class="progress progress_sm">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="30" aria-valuenow="29" style="width: 30%;"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <p>UI / UX</p>
                                            <div class="progress progress_sm">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="50" aria-valuenow="49" style="width: 50%;"></div>
                                            </div>
                                        </li>
                                    </ul>
                                    <!-- end of skills -->

                                </div>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <h1><@spring.message "basic" /></h1><br>
                                    <h4><@spring.message "idFrag1" />${user.clinic.clinicPrefix} <@spring.message "idFrag2" />:</h4><h3>${patient.patientId}</h3><br>
                                    <h4><@spring.message "first" />:</h4><h3>${patient.patientFirstName}</h3><br>
                                    <h4><@spring.message "last" />:</h4><h3>${patient.patientLastName}</h3><br>
                                    <h4><@spring.message "id" />:</h4><h3>${patient.patientIdCard}</h3><br>
                                    <h4><@spring.message "mainPhone" />:</h4><h3>${patient.patientTelephoneNumber}</h3><br>
                                    <h4><@spring.message "sPhone" />t:</h4><h3>${patient.patientContactTelephoneNumber}</h3><br>
                                    <h4><@spring.message "email" />:</h4><h3>${patient.patientEmail}</h3><br>
                                    <h4><@spring.message "bday" />:</h4><h3>${patient.patientBirthDate}</h3><br>
                                    <h4><@spring.message "sex" />:</h4><h3>${patient.patientGender}</h3><br>
                                    <h4><@spring.message "rDay" />:</h4><h3>${patient.patientRegisteredDate}</h3><br>
                                    <h4><@spring.message "job" />:</h4><h3>${patient.occupation}</h3><br>
                                    <h4><@spring.message "nationality" />:</h4><h3>${patient.patientNationality}</h3><br>
                                    <h4><@spring.message "address" />:</h4><h3>${patient.patientAddress}</h3><br>
                                    <h4><@spring.message "city" />:</h4><h3>${patient.patientCity}</h3><br>
                                    <h4><@spring.message "country" />:</h4><h3>${patient.patientCountry}</h3><br>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/templates/Backend/layouts/Copyright.ftl">


    </div>
</div>

<#include "/templates/Backend/layouts/footer.ftl">
<#include "/templates/Backend/layouts/pageCloser.ftl">



