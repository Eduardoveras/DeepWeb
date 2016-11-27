<!-- Modal -->
<div class="modal fade" id="equipment" role="dialog">

    <div class="modal-dialog modal-lg">


        <!-- Modal content-->
        <div class=" x_panel modal-content">

            <div class="modal-body">
                <div class="x_title">
                    <ul class="nav navbar-left panel_toolbox">
                        <li><h4><@spring.message "add" /> <@spring.message "newEquip" /></h4>
                        </li>
                    </ul>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><button type="button" class="close" data-dismiss="modal">&times;</button>
                        </li>
                    </ul>

                    <div class="clearfix"></div>

                </div>

                <div class="x_content">
                    <br/>
                    <#include "/templates/Backend/inventory/modalForms/_equipmentForm.ftl">
                </div>
            </div>
        </div>
    </div>
</div>
