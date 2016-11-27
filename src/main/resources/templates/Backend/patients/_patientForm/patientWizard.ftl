<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2><@spring.message "formFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "formFrag2" /></h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">


            <div class="row">
                <form method="post" action="/newPatient">
                <div class="col-md-6">
                    <#include "_step1.ftl">
                    <#include "_step2.ftl">
                </div>
                <div class="col-md-6">
                    <#include "_step3.ftl">
                    <#include "_step4.ftl">
                    <#include "_step5.ftl">
                </div>
                    <input type="submit" value="AGREGAR">
                </form>
            </div>

        </div>
    </div>
</div>