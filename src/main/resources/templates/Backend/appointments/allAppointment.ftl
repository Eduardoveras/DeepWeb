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
                        <h3><@spring.message "appFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "appFrag2" /></h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <!--ADD CONTENT HERE-->
                <div class="row">
                <!--<if !isAdmin>--><#include "/Backend/appointments/_appointmentForm.ftl"><!--</if>-->
                <#include "/Backend/appointments/_appointmentsTable.ftl">
                    <#include "_modal.ftl">


                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/Backend/layouts/Copyright.ftl">


    </div>
</div>
<#include "/Backend/layouts/footer.ftl">
<#include "_appointmentScripts.ftl">
<#include "/Backend/layouts/pageCloser.ftl">



