<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_content">
            <table id="datatable-responsive" class="table table-hover table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><span style="text-transform: uppercase;"><@spring.message "idFrag1" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "name" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "description" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "price" /></span></th>
                    <th><span style="text-transform: uppercase;">Stock</span></th>
                    <th><span style="text-transform: uppercase;">Supplier</span></th>
                    <th><span style="text-transform: uppercase;">Options</span></th>
                </tr>
                </thead>
                <tbody>
                <#list transactions as transaction>
                <tr>
                    <td>${transaction.getFiscalCode()}</td>
                    <td>${transaction.getUser()}</td>
                    <td>${transaction.getProductList()}</td>
                    <td>${transaction.getTotal()}</td>
                    <td>${transaction.getStatus()}</td>
                    <td>${transaction.getTransactionDate()}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Options
                                <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="#">RE-STOCK</a></li>
                                <li><a href="#">EDIT</a></li>
                                <li><a href="#">DELETE</a></li>
                            </ul>
                        </div>
                    </td>
                </tr>
                <#else>
                <tr>
                    <th scope="row"><@spring.message "emptyPatient" /></th>

                </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>
</div>
<!--I Know this is wrong, i just dont care-->
<br><br><br><br><br><br><br><br><br>

