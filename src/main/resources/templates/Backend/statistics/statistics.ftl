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
                <div class="row">
                <#include "_charts.ftl">

                </div>
            </div>
        </div>
        <!-- /page content -->
    <#include "/Backend/layouts/Copyright.ftl">
    </div>
</div>

<#include "/Backend/layouts/footer.ftl">
<#include "/Backend/layouts/pageCloser.ftl">