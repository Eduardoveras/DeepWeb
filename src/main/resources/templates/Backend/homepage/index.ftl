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
                <div class="row">

                    <#if userRole == "ASSISTANT">

                    <#else>

                    </#if>

                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/templates/Backend/layouts/Copyright.ftl">
    </div>
</div>

<#include "/templates/Backend/layouts/footer.ftl">
<#include "_scripts.ftl">
<#include "/templates/Backend/layouts/pageCloser.ftl">



