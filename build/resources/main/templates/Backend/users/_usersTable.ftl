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
                    <th><span style="text-transform: uppercase;"><@spring.message "ID" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "name" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "role" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "country" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "city" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "address" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "status" /></span></th>
                </tr>
                </thead>
                <tbody>
                <#list userList?sort_by("email") as user>
                <tr>
                    <td>${user.getEmail()}</td>
                    <td>${user.getFullName()}</td>
                    <td>${user.getRole()}</td>
                    <td>${user.getCountry()}</td>
                    <td>${user.getCity()}</td>
                    <td>${user.getShippingAddress()}</td>
                    <td>${user.getStatus()}</td>
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