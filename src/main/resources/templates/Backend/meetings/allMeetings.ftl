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
                        <h3><@spring.message "meetingFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "meetingFrag2" /></h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <!--ADD CONTENT HERE-->
                <div class="row">
                <#--include "/patients/_patientsForm.ftl"-->
                <#include "_meetingsTable.ftl">
                <#include "_meetingsModal.ftl">



                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/templates/Backend/layouts/Copyright.ftl">


    </div>
</div>
<#include "/templates/Backend/layouts/footer.ftl">
<#include "_meetingsScripts.ftl">
<#include "/templates/Backend/layouts/pageCloser.ftl">



