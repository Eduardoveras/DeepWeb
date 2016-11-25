<#include "/layouts/header.ftl">

<body class="nav-md">
<#include  "/layouts/_loader.ftl">
<div class="container body">
    <div class="main_container">
    <#include "/layouts/sidebar.ftl">
    <#include "/layouts/navbar.ftl">



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
                <!--<if !isAdmin>--><#include "/appointments/_appointmentForm.ftl"><!--</if>-->
                <#include "/appointments/_appointmentsTable.ftl">
                    <#include "_modal.ftl">


                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/layouts/Copyright.ftl">


    </div>
</div>
<#include "/layouts/footer.ftl">
<#include "_appointmentScripts.ftl">
<#include "/layouts/pageCloser.ftl">



