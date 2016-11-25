<div class="col-md-3 menu_fixed left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="/" class="site_title"><i class="fa fa-plus-circle"></i> <span>${user.getClinic().getClinicPrefix()}</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile">
            <div class="profile_pic">
                <img src="/images/img.jpg" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
                <span><@spring.message "welcome" />,</span>
                <h2>${user.getFullName()}</h2>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <br>
                <h3><@spring.message "menu" /></h3>
                <ul class="nav side-menu">

                    <li><a href="/"><i  class="fa fa-plus-square-o"></i> <@spring.message "dashboard" /> <span ></span></a></li>
                    <li><a href="/patients" ><i class="fa fa-user-md"></i> <@spring.message "patients" />  <span ></span></a></li>
                    <li><a href="/appointments"><i  class="fa fa-desktop"></i> <@spring.message "appointments" />  <span ></span></a></li>
                    <#if isAdmin><li><a  href="/users"><i class="fa fa-users"></i> <@spring.message "users" /><span></span></a></li></#if>
                    <li><a><i class="fa fa-comments-o"></i> <@spring.message "team" /> <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/contacts"><@spring.message "contacts" /></a></li>
                            <li><a href="/meetings"><@spring.message "meetings" /></a></li>
                        </ul>
                    </li>
                    <li><a href="/Inventory"><i  class="fa fa-calculator"></i> <@spring.message "inventory" /> <span ></span></a></li>
                    <li><a  href="/Stats"><i class="fa fa-bar-chart-o"></i> <@spring.message "statistics" /><span></span></a></li>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="<@spring.message "settings" />">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a href="/logout" data-toggle="tooltip" data-placement="top" title="<@spring.message "logout" />">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>