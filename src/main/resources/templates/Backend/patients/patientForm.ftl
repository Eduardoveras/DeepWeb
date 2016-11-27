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
                        <h3><@spring.message "patientReg" /></h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <!--ADD CONTENT HERE-->
                <div class="row">
                <#include "/templates/Backend/patients/_patientForm/patientWizard.ftl">

                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/templates/Backend/layouts/Copyright.ftl">


    </div>
</div>
<#include "/templates/Backend/layouts/footer.ftl">
<#include "_patientsScripts.ftl">
<#include "/templates/Backend/layouts/pageCloser.ftl">



