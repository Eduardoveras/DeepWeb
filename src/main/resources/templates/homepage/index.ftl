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
                 <#include "_topBoxes.ftl">
                <div class="row">

                    <#if userRole == "ASSISTANT">
                        <#include "assistant/_appointments.ftl">
                        <#include "assistant/_calendar.ftl">
                        <#include "/appointments/_modal.ftl">
                    <#else>
                        <#include "doctor/_calendar.ftl">


                    </#if>

                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/layouts/Copyright.ftl">
    </div>
</div>

<#include "/layouts/footer.ftl">
<#include "_scripts.ftl">
<#include "/layouts/pageCloser.ftl">



