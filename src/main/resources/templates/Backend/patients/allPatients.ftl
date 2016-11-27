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
                        <h3><@spring.message "patientFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "patientFrag2" /></h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <!--ADD CONTENT HERE-->
                <div class="row">
                <#--include "/patients/_patientsForm.ftl"-->
                <#include "/Backend/patients/_patientsTable.ftl">



                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/Backend/layouts/Copyright.ftl">


    </div>
</div>
<#include "/Backend/layouts/footer.ftl">
<#include "/Backend/patients/_patientsScripts.ftl">
<!-- /Datatables -->
<#include "/Backend/layouts/pageCloser.ftl">



