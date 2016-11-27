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
                        <h3><@spring.message "appFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "appFrag2" /></h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <!--ADD CONTENT HERE-->
                <div class="row">
                <!--<if !isAdmin>--><#include "/templates/Backend/appointments/_appointmentForm.ftl"><!--</if>-->
                <#include "/templates/Backend/appointments/_appointmentsTable.ftl">
                    <#include "_modal.ftl">


                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/templates/Backend/layouts/Copyright.ftl">


    </div>
</div>
<#include "/templates/Backend/layouts/footer.ftl">
<#include "_appointmentScripts.ftl">
<#include "/templates/Backend/layouts/pageCloser.ftl">



