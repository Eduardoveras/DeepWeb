<div class="col-md-8 col-sm-6 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2><@spring.message "uList" /></h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <table id="datatable-responsive" class="table table-hover table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><span style="text-transform: uppercase;"><@spring.message "idFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "idFrag2" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "name" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "email" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "role" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "bday" /></span></th>
                </tr>
                </thead>
                <tbody>
                <#list userList?sort_by("email") as user>
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.fullName}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>${user.birthDate}</td>
                </tr>
                <#else>
                <tr>
                    <th scope="row"><@spring.message "emptyUsers" /></th>
                </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>
</div>